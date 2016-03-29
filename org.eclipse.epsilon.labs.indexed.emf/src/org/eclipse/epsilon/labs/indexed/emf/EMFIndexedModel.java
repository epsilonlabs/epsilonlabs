package org.eclipse.epsilon.labs.indexed.emf;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.effective.metamodel.impl.EffectiveFeature;
import org.eclipse.epsilon.effective.metamodel.impl.EffectiveMetamodel;
import org.eclipse.epsilon.effective.metamodel.impl.EffectiveType;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.effective.metamodel.extraction.context.EffectiveMetamodelExtractionContext;
import org.eclipse.epsilon.eol.effective.metamodel.extraction.impl.EffectiveMetamodelExtractor;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.impl.nonImportant.EOLTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.EOLVariableResolver;

public class EMFIndexedModel extends IndexedEmfModel {

	protected boolean indexed = false;
	// eclass, feature, value, eobjects
	protected HashMap<EClass, HashMap<String, SmartMultiMap<Object, EObject>>> index = new HashMap<EClass, HashMap<String, SmartMultiMap<Object, EObject>>>();

	protected boolean allOfKind = false;

	protected HashMap<EClass, OptimisableCollection> allOfKindCache = new HashMap<EClass, OptimisableCollection>();
	protected HashMap<EClass, OptimisableCollection> allOfTypeCache = new HashMap<EClass, OptimisableCollection>();

	protected ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
	protected ArrayList<EClass> allOfTypes = new ArrayList<EClass>();

	protected ArrayList<EffectiveMetamodel> effectiveMetamodels = new ArrayList<EffectiveMetamodel>(); // protected
																										// ModelContainer
																										// modelContainer;
	private SmartMultiMap<EClass, EStructuralFeature> effectivemetamodelcache = new SmartMultiMap<>();

	@Override
	protected Collection<EObject> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		System.err.println("getAllOfKindFromModel is called");
		final EClass eClass = classForName(kind);
		OptimisableCollection result = allOfKindCache.get(eClass);
		if (result != null) {
			return result;
		} else {
			throw new EolModelElementTypeNotFoundException(this.getName(),
					"Internal error in EMFIndexedModel, getAllOfKindFromModel, allOfTypeCache.get(" + kind
							+ ") == null");
		}
	}

	@Override
	protected Collection<EObject> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		// System.err.println("getAllOfTypeFromModel is called");
		final EClass eClass = classForName(type);
		OptimisableCollection result = allOfTypeCache.get(eClass);
		if (result != null) {
			return result;
		} else {
			throw new EolModelElementTypeNotFoundException(this.getName(),
					"Internal error in EMFIndexedModel, getAllOfTypeFromModel, allOfTypeCache.get(" + type
							+ ") == null");
		}
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	public void createIndex(EObject eObject, String featureName, Object value) {
		EClass eClass = eObject.eClass();
		HashMap<String, SmartMultiMap<Object, EObject>> layer1Map = index.get(eClass);
		if (layer1Map != null) {
			SmartMultiMap<Object, EObject> layer2Map = layer1Map.get(featureName);
			if (layer2Map != null) {
				layer2Map.put(value, eObject);
			} else {
				layer2Map = new SmartMultiMap<Object, EObject>();
				layer2Map.put(value, eObject);
				layer1Map.put(featureName, layer2Map);
			}
		} else {
			layer1Map = new HashMap<String, SmartMultiMap<Object, EObject>>();
			SmartMultiMap<Object, EObject> layer2Map = new SmartMultiMap<Object, EObject>();
			layer2Map.put(value, eObject);
			layer1Map.put(featureName, layer2Map);
			index.put(eClass, layer1Map);
		}
	}

	public Collection<EStructuralFeature> featuresToIndex(EObject eObject) throws EolModelElementTypeNotFoundException {

		EClass eClass = eObject.eClass();

		return effectivemetamodelcache.get(eClass);

	}

	public void loadModelFromUri() throws EolModelLoadingException {
		super.loadModelFromUri();

		if (effectiveMetamodels.size() != 0) {
			try {
				if (isIndexed()) {
					populateCaches();
				}
			} catch (EolModelElementTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void populateCaches() throws EolModelElementTypeNotFoundException {
		long start = System.nanoTime();

		long init = System.nanoTime();
		// discover effective metamodel
		for (EffectiveMetamodel mc : effectiveMetamodels) {
			for (EffectiveType mec : mc.getAllOfKind()) {
				EClass eClass = classForName(mec.getName());
				if (eClass != null) {
					allOfKinds.add(eClass);
					for (EClass e : eClass.getEAllSuperTypes())
						allOfKinds.add(e);
					for (EffectiveFeature f : mec.getAttributes())
						if (f.getUsage() > 1) {
							EStructuralFeature ff = eClass.getEStructuralFeature(f.getName());
							effectivemetamodelcache.put(eClass, ff);
						}
					// cachedKinds.add(eClass);
				} else {
					System.out.println("eclass is null!");
				}
			}

			for (EffectiveType mec : mc.getAllOfType()) {
				EClass eClass = classForName(mec.getName());
				allOfTypes.add(eClass);
				for (EffectiveFeature f : mec.getAttributes())
					if (f.getUsage() > 1) {
						EStructuralFeature ff = eClass.getEStructuralFeature(f.getName());
						effectivemetamodelcache.put(eClass, ff);
					}
				// cachedTypes.add(eClass);
			}
		}
		System.out.println("(took ~" + (System.nanoTime() - init) / 1000000 + "ms to determine effective metamodel)");

		init = System.nanoTime();

		long indexcreationtime = 0;
		long cachecreationtime = 0;

		// populate contents cache
		Collection<EObject> allContents = allContentsFromModel();

		System.out.println("(took ~" + (System.nanoTime() - init) / 1000000 + "ms to cache allcontents)");

		// populate type caches and feature indexes
		for (EObject eObject : allContents) {
			init = System.nanoTime();
			EClass eClass = eObject.eClass();

			if (allOfKinds.contains(eClass)) {

				// kindCache.put(eClass, eObject);
				OptimisableCollection collection = allOfKindCache.get(eClass);
				if (collection == null) {
					OptimisableCollection collection2 = new OptimisableCollection(this, eClass);
					collection2.add(eObject);
					allOfKindCache.put(eClass, collection2);
				} else {
					collection.add(eObject);
				}

			}

			if (allOfTypes.contains(eClass)) {
				// typeCache.put(eClass, eObject);
				OptimisableCollection collection = allOfTypeCache.get(eClass);
				if (collection == null) {
					OptimisableCollection collection2 = new OptimisableCollection(this, eClass);
					collection2.add(eObject);
					allOfTypeCache.put(eClass, collection2);
				} else {
					collection.add(eObject);
				}
			}

			cachecreationtime += System.nanoTime() - init;

			init = System.nanoTime();
			Collection<EStructuralFeature> featuresToIndex = featuresToIndex(eObject);
			if (featuresToIndex != null) {
				for (EStructuralFeature feature : featuresToIndex) {
					// EStructuralFeature eStructuralFeature =
					// eObject.eClass().getEStructuralFeature(feature);
					// if (eStructuralFeature != null) {
					Object value = eObject.eGet(feature);
					if (value != null) {
						createIndex(eObject, feature.getName(), value);
					}
					// }
				}
			}
			indexcreationtime += System.nanoTime() - init;
		}
		System.out.println("indexes: " + index.values().size());

		System.out.println("(took ~" + cachecreationtime / 1000000 + "ms to create caches)");
		System.out.println("(took ~" + indexcreationtime / 1000000 + "ms to create indexes)");

		System.out.println("(took ~" + (System.nanoTime() - start) / 1000000 + "ms total)");

	}

	public EffectiveMetamodel getEffectiveMetamodel(EClass eClass) {
		for (EffectiveMetamodel em : effectiveMetamodels) {
			if (em.getName().equals(eClass.getEPackage().getName())) {
				return em;
			}
		}
		return null;
	}

	public void setEffectiveMetamodels(ArrayList<EffectiveMetamodel> effectiveMetamodels) {
		this.effectiveMetamodels = effectiveMetamodels;
	}

	public void printIndexSize() {
		for (EClass eClass : index.keySet()) {
			HashMap<String, SmartMultiMap<Object, EObject>> layer1Map = index.get(eClass);
			for (String s : layer1Map.keySet()) {
				SmartMultiMap<Object, EObject> layer2Map = layer1Map.get(s);
				System.out.println(layer2Map.toString());
			}
		}
	}

	public static void main(String[] args) throws URISyntaxException, Exception {

		for (int i = 0; i < 5; i++) {
			long init = System.nanoTime();

			EolModule eolModule = new EolModule();
			eolModule.parse(new File("test/grabats_looped.eol"));

			EMFIndexedModel indexedModel = new EMFIndexedModel();
			indexedModel.setIndexed(true);

			indexedModel.setName("DOM");
			indexedModel.aliases.add("Core");
			indexedModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
			indexedModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());

			loadEPackageFromFile("test/JDTAST.ecore");

			Ast2EolContext ast2EolContext = new Ast2EolContext();
			EOLElement dom = ast2EolContext.getEolElementCreatorFactory().createEOLElement(eolModule.getAst(), null,
					ast2EolContext);

			EOLVariableResolver vr = new EOLVariableResolver();
			vr.run(dom);

			EOLTypeResolver tr = new EOLTypeResolver();
			tr.getTypeResolutionContext().setEolModule(eolModule);
			tr.run(dom);

			EffectiveMetamodelExtractor loa = new EffectiveMetamodelExtractor();
			loa.run(dom);
			loa.getEffectiveMetamodelExtractionContext().print();

			EffectiveMetamodelExtractionContext loaContext = (EffectiveMetamodelExtractionContext) loa
					.getEffectiveMetamodelExtractionContext();

			indexedModel.setEffectiveMetamodels(loaContext.getEffectiveMetamodels());

			indexedModel.load();
			System.out.println("(took ~" + (System.nanoTime() - init) / 1000000 + "ms to load)");
			init = System.nanoTime();

			eolModule.getContext().getModelRepository().addModel(indexedModel);
			eolModule.execute();
			System.out.println("(took ~" + (System.nanoTime() - init) / 1000000 + "ms to run)");
			eolModule.getContext().getModelRepository().dispose();

			// indexedModel.printIndexSize();
		}

	}

	public static EPackage loadEPackageFromFile(String fileName) {
		EPackage result = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
				new EcoreResourceFactoryImpl());
		URI uri = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		for (EObject obj : resource.getContents()) {
			if (obj instanceof EPackage) {
				EPackage.Registry.INSTANCE.put(((EPackage) obj).getNsURI(), obj);
				result = (EPackage) obj;
				// break;
			}
		}
		return result;
	}
}
