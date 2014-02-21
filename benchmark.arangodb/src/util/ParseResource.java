package util;

import java.io.File;
import java.util.HashSet;
import java.util.Hashtable;
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


import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBGraph;

public class ParseResource {

	private int[] objectCount = { 0, 0, 0, 0 };
	private enum ParseOptions {
		METAMODELELEMENTS, MODELELEMENTS, MODELREFERENCES
	};
	
	private boolean enableTx = false;
	private long maxTransactionSize = Runtime.getRuntime().maxMemory() / 10000;
	// integer array containing the current number of added elements:
	// (element,((ofType)M->MM)reference,((ofKind)M->MM)reference,(unset(M->M))reference)
	private int unset;

	private ArangoDBGraph graph;

	private Hashtable<EObject, Object> hash; // temporary link between resource
											// uri and graph node for model
											// elements

	long startTime;

	
	public ParseResource(ArangoDBGraph graph,
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
	
	private int[] parseResource(ParseOptions parseOption, Resource resource) {

		objectCount[0] = 0;
		objectCount[1] = 0;
		objectCount[2] = 0;
		objectCount[3] = 0;

		long init = System.nanoTime();


		int lastcommit = 0;
		int lastprint = 0;

		TreeIterator<EObject> children = resource.getAllContents();
		//int i = 0;
		while (children.hasNext()) {
			//if (i%5000 == 0) {
				//graph.save();
				//graph.commit();
			//}
			//i++;
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

			if (enableTx)
				if ((objectCount[0] % maxTransactionSize == 0 && ref && clas)
						|| lastcommit < objectCount[0] - maxTransactionSize) {
					System.out.println(objectCount[0]);
					lastcommit = objectCount[0];
					graph.save();
				}

			if ((objectCount[0] % 50000 == 0 && ref && clas)
					|| lastprint < objectCount[0] - 50000) {
				lastprint = objectCount[0];
				System.out.println(objectCount[0] + " - "
						+ (System.nanoTime() - init) / 1000000000 + "sec ("+(System.nanoTime() - startTime) / 1000000000+")");
				init = System.nanoTime();
			}

		}

		if (enableTx) {
			graph.save();
		}

		if (enableTx)
			graph.save();

		return objectCount;
	}

	
	private String getEObjectId(EClass eClass) {
		return eClass.getEPackage().getNsURI() + "/" + eClass.getName();
	}
	
	private Vertex getEClassId(EClass eClass) {
		String eObjectId = getEObjectId(eClass);
		/*
		Index<Vertex> index = graph.getIndex(eObjectId, Vertex.class);

		for(Vertex v: index.get("eObjectID", eObjectId))
		{
			if(v.getProperty("isMetaClass"))
			{
				return v;
			}
		}*/
		return null;
	}
	
	private Set<Vertex> getESuperClassIds(EObject eObject) {

		HashSet<Vertex> superclasses = new HashSet<Vertex>();

		for (EClass e : eObject.eClass().getESuperTypes()) {
			Vertex v = getEClassId(e);
			if (v != null) {
				superclasses.add(v);
			}
		}

		return superclasses;

	}

	private void addEdge(EObject from, Object to, String edgelabel) {

		Object source = null;
		Object destination = null;
		// System.err.println(o);
		try {
			source = hash.get(from);
			destination = hash.get(to);
			
			Vertex vFrom = graph.getVertex(source);
			Vertex vTo = graph.getVertex(destination);
			
			if (vTo != null) {
				Edge edge = graph.addEdge(null, vFrom, vTo, edgelabel);
			}

			objectCount[0]++;
		} catch (Throwable ee) {
			System.err
					.println(source + " - " + edgelabel + " - " + destination);
			ee.printStackTrace();

		}
	}

	
	private boolean addEReference(EObject eObject) {

		boolean atLeastOneSetReference = false;

		for (final EReference eReference : eObject.eClass().getEAllReferences()) {

			if (eObject.eIsSet(eReference)) {

				String edgelabel = eReference.getName();

				Object otherEObject = eObject.eGet(eReference);
				// System.out.println(util.ToString.toString(o));

				if (otherEObject instanceof Iterable<?>) {
					for (Object ob : ((Iterable<?>) otherEObject)) {
						addEdge(eObject, ob, edgelabel);
					}
					// System.out.println();
				} else {
					addEdge(eObject, otherEObject, edgelabel);
				}
				// System.out.println();
				atLeastOneSetReference = true;
			} else {
				objectCount[3]++;
			}

		}
		return atLeastOneSetReference;
	}


	private Vertex createEObjectNode(EObject eObject) {
		String eObjectId = getEObjectId(eObject.eClass());
		//Index<Vertex> index = graph.getIndex(eObjectId, Vertex.class);
		
		Vertex node =  graph.addVertex(null);
		node.setProperty("eObjectID", eObjectId);
	
		for (final EAttribute e : eObject.eClass().getEAllAttributes()) {

			// attributes
			if (eObject.eIsSet(e)) {
				node.setProperty(e.getName(), eObject.eGet(e).toString());
			} else {
				// depracatedTODO currently unset items are not included to may crash eol etc
				// node.field(e.getName(), "UNSET");
			}
		}

		//node.setProperty("INTERNALofType", getEClassId(eObject.eClass()));
		//node.setProperty("INTERNALofKind", getESuperClassIds(eObject));
		
		//index.put("eObjectID", eObjectId, node);
		
		return node;
	}

	
	private void addEObject(EObject eObject) {

		Vertex v = createEObjectNode(eObject);
		hash.put(eObject, v.getId());

		objectCount[0]++;
		// System.out.println(child.eClass().getEStructuralFeatures().size()+" ");

	}

	
	private Vertex createEClassNode(EObject eObject, String id) {


		Vertex node = graph.addVertex(null);
		node.setProperty("eid", id);
		node.setProperty("name", eObject.eClass().getName());
		node.setProperty("isMetaClass", true);
		
		//hash.put(eObject, node);
		//hash.put(eObject, node.getId());
		// n.field("nUri", ((EClass)child).getEPackage()
		// .getNsURI());

		
		return node;
	}

	private boolean addMetaClass(EObject eClass) {

		if (eClass instanceof EClass) {

			String id = getEObjectId((EClass)eClass);
			
			Vertex n = createEClassNode(eClass, id);
			//Index<Vertex> indexNode = graph.createIndex(id, Vertex.class, new Parameter<String, Object>(id, n.getId()));
			//indexNode.put("EObjectID", id, n);

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
