package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.tinkerpop.blueprints.Parameter;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBEdge;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBElement;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBGraph;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBVertex;
import com.tinkerpop.blueprints.impls.arangodb.client.ArangoDBException;

/**
 * 
 * @author rw
 * inspired by the work of kb
 * 
 */
public class ArangoParseResource {

	// cannot enable transactions as nodes wont get a final id till commit,
	// breaking the code!
	private boolean enableTx = false;
	private long maxTransactionSize = Runtime.getRuntime().maxMemory() / 10000;
	// integer array containing the current number of added elements:
	// (element,((ofType)M->MM)reference,((ofKind)M->MM)reference,(unset(M->M))reference)
	private int[] objectCount = { 0, 0, 0, 0 };
	private int unset;

	private enum ParseOptions {
		METAMODELELEMENTS, MODELELEMENTS, MODELREFERENCES
	};

	// metatracker collection to be referenced any time we parse a resource
	//private MetatrackerCollection metatrackers = new MetatrackerCollection();

	private ArangoDBGraph graph;
	
	

	private Hashtable<EObject, Object> hash; // temporary link between resource
											// uri and graph node for model
											// elements

	long startTime;
	
	public ArangoParseResource(ArangoDBGraph graph,
			HashSet<File> metamodelFiles, Resource modelResource,
			ResourceSet modelResourceSet) {

		this.hash = new Hashtable<EObject, Object>(8192);
		this.graph = graph;

		try {

			// graph.getLevel1Cache().setEnable(false);
			// graph.getLevel2Cache().setEnable(false);
			startTime = System.nanoTime();
			Resource metamodelResource;
			// add metamodel nodes
			for (File metamodelFile : metamodelFiles) {

				startTime = System.nanoTime();
				metamodelResource = modelResourceSet.getResource(
						URI.createFileURI(metamodelFile.getAbsolutePath()),
						true);

				System.out.print("ADDING: ");
				System.out.println(parseResource(
						ParseOptions.METAMODELELEMENTS, metamodelResource)[0]
						+ " METAMODEL NODES! (took ~"
						+ (System.nanoTime() - startTime) / 1000000000 + "sec)");

			}

			// add model elements
			startTime = System.nanoTime();
			// System.out.println(r);
			System.out.print("ADDING: ");
			int[] addedElements = parseResource(ParseOptions.MODELELEMENTS,
					modelResource);
			System.out.println(addedElements[0] + " NODES AND "
					+ addedElements[1] + " + " + addedElements[2]
					+ " M->MM REFERENCES! (took ~" + (System.nanoTime() - startTime)
					/ 1000000000 + "sec)");

			// graph.getLevel1Cache().setEnable(true);
			// graph.getLevel1Cache().

			startTime = System.nanoTime();

			// add references
			System.out.print("ADDING: ");
			addedElements = parseResource(ParseOptions.MODELREFERENCES,
					modelResource);
			setUnset(getUnset() + addedElements[3]);
			System.out.println(addedElements[0] + " REFERENCES! (took ~"
					+ (System.nanoTime() - startTime) / 1000000000 + "sec)");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds the resource to the graph according to whether it is a model or a
	 * metamodel resource
	 * 
	 * @param parseOption
	 * @param resource
	 * @param graph
	 * @return
	 */
	private int[] parseResource(ParseOptions parseOption, Resource resource) {

		objectCount[0] = 0;
		objectCount[1] = 0;
		objectCount[2] = 0;
		objectCount[3] = 0;

		long init = System.nanoTime();

		int lastcommit = 0;
		int lastprint = 0;

		TreeIterator<EObject> children = resource.getAllContents();
		while (children.hasNext()) {

			EObject child = children.next();

			if (child.eIsProxy()) {
				System.err.println("FAILED. PROXY UNRESOLVED: "
						+ ((InternalEObject) child).eProxyURI().fragment());
				System.exit(1);
				// throw new Exception("FAILED. PROXY UNRESOLVED: "
				// + ((InternalEObject) child).eProxyURI().fragment());
			}
			boolean ref = true;
			boolean clas = true;
			// add the element
			switch (parseOption) {

			case METAMODELELEMENTS:
				clas = addMetaClass(child);
				break;
			case MODELELEMENTS:
				addEObject(child);
				break;
			case MODELREFERENCES:
				ref = addEReference(child);
				break;
			default:
				System.err.println("parse option: " + parseOption
						+ " not recognised! ending program!");
				System.exit(1);

			}

			if ((objectCount[0] % 50000 == 0 && ref && clas)
					|| lastprint < objectCount[0] - 50000) {
				lastprint = objectCount[0];
				System.out.println(objectCount[0] + " - "
						+ (System.nanoTime() - init) / 1000000000 + "sec ("+(System.nanoTime() - startTime) / 1000000000+")");
				init = System.nanoTime();
			}

		}
		return objectCount;
	}

	/**
	 * 
	 * @param eObject
	 * @return the URI ID of an eObject
	 */
	private String getEObjectId(EObject eObject) {
		Resource resource = eObject.eResource();
		return resource.getURI() + "/" + resource.getURIFragment(eObject);
	}

	/**
	 * 
	 * @param eClass
	 * @return the URI ID of an eClass
	 */
	private String getEObjectId(EClass eClass) {
		return eClass.getEPackage().getNsURI() + "/" + eClass.getName();
	}
	
	/**
	 * Creates a node in the graph database with the given eObject's attributes
	 * in it. Also indexes it in the 'dictionary' index.
	 * 
	 * @param eObject
	 * @return the Node
	 */
	private ArangoDBVertex createEObjectNode(EObject eObject) {
		ArangoDBVertex node = (ArangoDBVertex) graph.addVertex(null);
		
		hash.put(eObject, node.getId());

		String eObjectId = getEObjectId(eObject);
		node.setProperty("eid", eObjectId);

		for (final EAttribute e : eObject.eClass().getEAllAttributes()) {

			// attributes
			if (eObject.eIsSet(e)) {
				node.setProperty(e.getName(), eObject.eGet(e).toString());
			} else {
				// depracatedTODO currently unset items are not included to may crash eol etc
				// node.field(e.getName(), "UNSET");
			}
		}

		//node.setProperty("INTERNALofType", getEClassId(eObject));
		//node.setProperty("INTERNALofKind", getESuperClassIds(eObject));
		try {
			node.save();
		} catch (ArangoDBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return node;
	}

	/**
	 * Creates a node in the graph database with the given eClass's attributes
	 * in it.
	 * 
	 * @param eObject
	 * @param id
	 * @return the Node
	 */
	private ArangoDBVertex createEClassNode(EObject eObject, String id) {

		ArangoDBVertex node = (ArangoDBVertex) graph.addVertex(null);
		
		node.setProperty("eid", id);

		hash.put(eObject, node.getId());
		Object h = null;
		node.setProperty("class", "");
		node.setProperty("superclass", "");
		node.setProperty(getEObjectId(eObject), getEObjectId(eObject));
		// n.field("nUri", ((EClass)child).getEPackage()
		// .getNsURI());

		try {
			node.save();
		} catch (ArangoDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return node;
	}

	/**
	 * 
	 * @param eClass
	 * @return the ORID of the eClass
	 */
	private Object getEClassId(EClass eClass) {
		Object id = null;
		Iterable<Vertex> vcol = graph.getVertices(getEObjectId(eClass), getEObjectId(eClass));
		Iterator<Vertex> iter = vcol.iterator();
		if (iter.hasNext()) {
			id = iter.next().getId();
		}
		return id;
	}

	/**
	 * 
	 * @param eObject
	 * @return the ORID of the eClass which this eObject is typeOf
	 */
	private Object getEClassId(EObject eObject) {
		return getEClassId(eObject.eClass());
	}

	private Set<Object> getESuperClassIds(EObject eObject) {

		HashSet<Object> superclasses = new HashSet<Object>();

		for (EClass e : eObject.eClass().getESuperTypes()) {
			if (getEClassId(e) != null) {
				superclasses.add(getEClassId(e));
			}
		}

		return superclasses;

	}

	/**
	 * Creates a node with the eObject, adds it to the hash and adds it the the
	 * appropriate eClass in the metatracker collection
	 * 
	 * @param eObject
	 */
	private void addEObject(EObject eObject) {

		ArangoDBVertex node = createEObjectNode(eObject);

		hash.put(eObject, node.getId());

		Object eClassId = getEClassId(eObject);

		//metatrackers.addEObjectTypeOf(eClassId, node.getIdentity());

		// objectCount[1]++;

		// use metamodel to infer all supertypes for fast search
		// and log em
		for (EClass superType : eObject.eClass().getESuperTypes()) {

			eClassId = getEClassId(superType);

			//metatrackers.addEObjectKindOf(eClassId, node.getIdentity());

			// objectCount[2]++;

		}

		objectCount[0]++;
		// System.out.println(child.eClass().getEStructuralFeatures().size()+" ");

	}

	/**
	 * Creates an edge with the parameters given and links it to the appropriate
	 * nodes
	 * 
	 * @param from
	 * @param to
	 * @param edgelabel
	 */
	private void addEdge(EReference reference, EObject from, EObject to, String edgelabel) {

		Object source = null;
		Object destination = null;
		// System.err.println(o);
		try {
			source = hash.get(from);
			destination = hash.get(to);

			Vertex vFrom = graph.getVertex(getEObjectId(from));
			Vertex vTo = graph.getVertex(getEObjectId(to));
			ArangoDBEdge edge = (ArangoDBEdge) graph.addEdge(reference.eClass().getName(), vFrom, vTo, edgelabel);

			edge.setProperty("label", edgelabel);
			edge.save();

			objectCount[0]++;
		} catch (Throwable ee) {
			System.err
					.println(source + " - " + edgelabel + " - " + destination);
			ee.printStackTrace();

		}
		// System.err.print(edgelabel+".");

	}

	/**
	 * Iterates through all of the references the eObject has and inserts them
	 * into the graph
	 * 
	 * @param eObject
	 * @return
	 */
	private boolean addEReference(EObject eObject) {

		boolean atLeastOneSetReference = false;

		for (final EReference eReference : eObject.eClass().getEAllReferences()) {

			// now references
			if (eObject.eIsSet(eReference)) {

				// String edgelabel = (((EReference) e)
				// .isContainer()) ? "nContainer:"
				String edgelabel = eReference.getName();
				// System.out.println(edgelabel);

				EObject otherEObject = (EObject) eObject.eGet(eReference);
				// System.out.println(util.ToString.toString(o));

				if (otherEObject instanceof Iterable<?>) {
					for (Object ob : ((Iterable<?>) otherEObject)) {
						addEdge(eReference, eObject, (EObject) ob, edgelabel);
					}
					// System.out.println();
				} else {
					addEdge(eReference, eObject, otherEObject, edgelabel);
				}
				// System.out.println();
				atLeastOneSetReference = true;
			} else {
				objectCount[3]++;

				// System.out
				// .println("Unset reference, handle to be implemented...");
				// depracatedTODO handle no reference; point to default constructs
			}

		}
		return atLeastOneSetReference;
	}

	/**
	 * Creates a node with the eClass parameters, adds it to the metatracker and
	 * to the metacdictionary index
	 * 
	 * @param eClass
	 * @return
	 */
	private boolean addMetaClass(EObject eClass) {

		Parameter<String, String> type   = new Parameter<String, String>("type", "metamodel");
		Parameter<String, Boolean> unique = new Parameter<String, Boolean>("unique", true);

		graph.createKeyIndex(getEObjectId(eClass), Vertex.class, type, unique);

		if (eClass instanceof EClass) {
			// System.out.println(child);

			String id = getEObjectId((EClass)eClass);
			
			ArangoDBVertex n = createEClassNode(eClass, id);
			

			//metatrackers.addMetatracker(n.getIdentity());

			try {
				n.save();
			} catch (ArangoDBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objectCount[0]++;
			return true;
		} else
			return false;
	}

	public int getUnset() {
		return unset;
	}

	private void setUnset(int unset) {
		this.unset = unset;
	}

}
