package org.eclipse.epsilon.labs.indexed.emf;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.effective.metamodel.extraction.context.EffectiveMetamodelExtractionContext;
import org.eclipse.epsilon.eol.effective.metamodel.extraction.impl.EffectiveMetamodelExtractor;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.impl.nonImportant.EOLTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.EOLVariableResolver;

public class EmfNaivePrecachedIndexedModel extends EmfModel{

	protected HashMap<String, Map<Object, Set<EObject>>> index = new HashMap<String, Map<Object, Set<EObject>>>();

	protected ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
	protected ArrayList<EClass> allOfTypes = new ArrayList<EClass>();

	protected ArrayList<EffectiveMetamodel> effectiveMetamodels = new ArrayList<EffectiveMetamodel>(); 
	
	protected boolean smartLoading = true;

	public void addValue(String feature, EObject eObject, Object value) {

		Map<Object, Set<EObject>> valueMap = index.get(feature);
		
		Set<EObject> eObjects = valueMap.get(value);

		if (eObjects == null) {
			eObjects = new HashSet<EObject>();
			eObjects.add(eObject);
			valueMap.put(value, eObjects);
		}
		else {
			eObjects.add(eObject);
		}
	}

	public boolean isNumeric(Object obj) {
		if (obj instanceof Integer || obj instanceof Double
				|| obj instanceof Float || obj instanceof Long) {
			return true;
		}
		return false;
	}

	public ArrayList<String> featuresToIndex(EClass eClass)
			throws EolModelElementTypeNotFoundException {
		
		ArrayList<String> result = new ArrayList<String>();

		EffectiveMetamodel em = getEffectiveMetamodel(eClass);

		if (em == null) {
			return null;
		}

		for (EffectiveType et : em.getAllOfType()) {
			if (et.getName().equals(eClass.getName())) {
				for (EffectiveFeature ef : et.getAllFeatures()) {
					if (ef.getUsage() > 1) {
						result.add(eClass.getEPackage().getNsURI() + "::"
								+ eClass.getName() + "::" + ef.getName());
					}
				}
			}
		}

		for (EffectiveType et : em.getAllOfKind()) {
			EClass effectiveEClass = classForName(et.getName());
			if (effectiveEClass.equals(eClass)
					|| effectiveEClass.getEAllSuperTypes().contains(eClass)) {
				for (EffectiveFeature ef : et.getAllFeatures()) {
					if (ef.getUsage() > 1) {
						result.add(eClass.getEPackage().getNsURI() + "::"
								+ effectiveEClass.getName() + "::"
								+ ef.getName());
					}
				}
			}
		}

		for (EffectiveType et : em.getTypes()) {
			EClass effectiveEClass = classForName(et.getName());
			if (effectiveEClass.equals(eClass)
					|| effectiveEClass.getEAllSuperTypes().contains(eClass)) {
				for (EffectiveFeature ef : et.getAllFeatures()) {
					if (ef.getUsage() > 1) {
						result.add(eClass.getEPackage().getNsURI() + "::"
								+ effectiveEClass.getName() + "::"
								+ ef.getName());
					}
				}
			}
		}
		return result;
	}

	public EffectiveMetamodel getEffectiveMetamodel(EClass eClass) {
		for (EffectiveMetamodel em : effectiveMetamodels) {
			if (em.getName().equals(eClass.getEPackage().getName())) {
				return em;
			}
		}
		return null;
	}

	public void setEffectiveMetamodels(
			ArrayList<EffectiveMetamodel> effectiveMetamodels)
			throws EolModelElementTypeNotFoundException {
		this.effectiveMetamodels = effectiveMetamodels;
	}

	public void setSmartLoading(boolean smartLoading) {
		this.smartLoading = smartLoading;
	}

	public boolean isSmartLoading() {
		return smartLoading;
	}

	public void loadModelFromUri() throws EolModelLoadingException {
		super.loadModelFromUri();

		if (effectiveMetamodels.size() != 0) {
			try {
				if (smartLoading) {

					Set<EffectiveType> ets = new HashSet<EffectiveType>();
					for (EffectiveMetamodel em : effectiveMetamodels) {
						ets.addAll(em.getAllOfKind());
						ets.addAll(em.getAllOfType());
						ets.addAll(em.getTypes());
					}

					for (EffectiveType et : ets) {
						EClass eClass = classForName(et.getName());

						ArrayList<String> featuresToIndex = featuresToIndex(eClass);

						for (String feature : featuresToIndex) {

							if (eClass.getEStructuralFeature(feature.split("::")[2]) != null) {

								Map<Object, Set<EObject>> valueMap = null;

								if (isNumeric(eClass.getEStructuralFeature(feature.split("::")[2]).getEType().getInstanceClass())) {
									
									Comparator<Object> comp = new Comparator<Object>() {
										@Override
										public int compare(Object o1, Object o2) {
											return ((Comparable) o1)
													.compareTo(o2);
										}
									};
									valueMap = new TreeMap<Object, Set<EObject>>(comp);
								} else {
									valueMap = new HashMap<Object, Set<EObject>>();
								}

								index.put(feature, valueMap);
							}
						}
					}
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
		for (EffectiveMetamodel mc : effectiveMetamodels) {
			for (EffectiveType mec : mc.getAllOfKind()) {
				EClass eClass = classForName(mec.getName());
				if (eClass != null) {
					allOfKinds.add(eClass);
					cachedKinds.add(eClass);
				} else {
					System.out.println("eclass is null!");
				}
			}

			for (EffectiveType mec : mc.getAllOfType()) {
				EClass eClass = classForName(mec.getName());
				allOfTypes.add(eClass);
				cachedTypes.add(eClass);
			}
		}

		Long start = System.nanoTime();

		for (EObject eObject : (Collection<EObject>) allContents()) {
			for (EClass eClass : allOfKinds) {
				if (eClass.isInstance(eObject)) {

					kindCache.put(eClass, eObject);
				}
			}
			for (EClass eClass : allOfTypes) {
				if (eObject.eClass() == eClass) {
					typeCache.put(eClass, eObject);
				}
			}

			for (String feature : index.keySet()) {

				String[] split = feature.split("::");
				EClass eClass = eObject.eClass();
				EPackage ePackage = eClass.getEPackage();
				if (ePackage.getNsURI().equals(split[0])) {
					if (eClass.getName().equals(split[1])) {
						eClass = (EClass) ePackage.getEClassifier(split[1]);
						EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(split[2]);

						if (eClass.isInstance(eObject)) {
							if (eClass.getEAllStructuralFeatures().contains(eStructuralFeature)
									&& eObject.eGet(eStructuralFeature) != null) {
								addValue(feature, eObject, eObject.eGet(eStructuralFeature));
							}
						}
					}
				}
			}
		}

		System.out.println("(populateCaches took ~"
				+ (System.nanoTime() - start) / 1000000 + "ms to run)");

	}

	public void printIndexSize() {
		for (String featureURI : index.keySet()) {
			Map<Object, Set<EObject>> layer1Map = index.get(featureURI);
			int count = 0;
			for (Object s : layer1Map.keySet()) {
				count++;
			}
			System.out.println(featureURI + ": " + 
					+ layer1Map.keySet().size() + " indexes");
		}
	}

	public static void main(String[] args) throws URISyntaxException, Exception {

		for (int i = 0; i < 5; i++) {
			EolModule eolModule = new EolModule();
			eolModule.parse(new File("test/grabats.eol"));

			EmfNaivePrecachedIndexedModel smartModel = new EmfNaivePrecachedIndexedModel();
			smartModel.setName("m");
			smartModel
					.setModelFile(new File("test/set0.xmi").getAbsolutePath());
			smartModel.setMetamodelFile(new File("test/JDTAST.ecore")
					.getAbsolutePath());

			loadEPackageFromFile("test/JDTAST.ecore");

			Ast2EolContext ast2EolContext = new Ast2EolContext();
			EOLElement dom = ast2EolContext.getEolElementCreatorFactory()
					.createEOLElement(eolModule.getAst(), null, ast2EolContext);

			EOLVariableResolver vr = new EOLVariableResolver();
			vr.run(dom);

			EOLTypeResolver tr = new EOLTypeResolver();
			tr.getTypeResolutionContext().setEolModule(eolModule);
			tr.run(dom);

			EffectiveMetamodelExtractor loa = new EffectiveMetamodelExtractor();
			loa.run(dom);
			loa.getEffectiveMetamodelExtractionContext().print();

			EffectiveMetamodelExtractionContext loaContext = (EffectiveMetamodelExtractionContext) loa.getEffectiveMetamodelExtractionContext();


			smartModel.setEffectiveMetamodels(loaContext
					.getEffectiveMetamodels());
			smartModel.setSmartLoading(true);
			long init = System.nanoTime();

			smartModel.load();
			System.out.println("(took ~" + (System.nanoTime() - init) / 1000000
					+ "ms to load)");
			init = System.nanoTime();

			eolModule.getContext().getModelRepository().addModel(smartModel);
			eolModule.execute();
			System.out.println("(took ~" + (System.nanoTime() - init) / 1000000
					+ "ms to run)");
			eolModule.getContext().getModelRepository().dispose();

			smartModel.printIndexSize();
		}

	}

	public static EPackage loadEPackageFromFile(String fileName) {
		EPackage result = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new EcoreResourceFactoryImpl());
		URI uri = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		for (EObject obj : resource.getContents()) {
			if (obj instanceof EPackage) {
				EPackage.Registry.INSTANCE
						.put(((EPackage) obj).getNsURI(), obj);
				result = (EPackage) obj;
				// break;
			}
		}
		return result;
	}



}
