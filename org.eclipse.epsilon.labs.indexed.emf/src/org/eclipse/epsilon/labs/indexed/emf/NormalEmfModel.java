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

public class NormalEmfModel extends EmfModel{

	protected boolean indexed = false;
	//eclass, feature, value, eobjects
	protected HashMap<EClass, HashMap<String, SmartMultiMap<Object, EObject>>> index = new HashMap<EClass, HashMap<String,SmartMultiMap<Object,EObject>>>();
	
	protected boolean allOfKind = false;
	
	protected HashMap<EClass, OptimisableCollection> allOfKindCache = new HashMap<EClass, OptimisableCollection>();
	protected HashMap<EClass, OptimisableCollection> allOfTypeCache = new HashMap<EClass, OptimisableCollection>();

	protected ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
	protected ArrayList<EClass> allOfTypes = new ArrayList<EClass>();

	protected ArrayList<EffectiveMetamodel> effectiveMetamodels = new ArrayList<EffectiveMetamodel>();	//protected ModelContainer modelContainer;
	
	
	@Override
	protected Collection<EObject> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		System.err.println("getAllOfKindFromModel is called");
		final EClass eClass = classForName(kind);
		OptimisableCollection result = allOfKindCache.get(eClass);
		if (result != null) {
			return result;
		}
		else {
			return super.getAllOfKindFromModel(kind);
		}
	}
	
	@Override
	protected Collection<EObject> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
//		System.err.println("getAllOfTypeFromModel is called");
		final EClass eClass = classForName(type);
		OptimisableCollection result = allOfTypeCache.get(eClass);
		if (result != null) {
			return result;
		}
		else {
			return super.getAllOfKindFromModel(type);
		}
	}
	
	public boolean isIndexed() {
		return indexed;
	}
	
	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}
	
	
	public void createIndex(EObject eObject, String featureName, Object value)
	{
		EClass eClass = eObject.eClass();
		HashMap<String, SmartMultiMap<Object, EObject>> layer1Map = index.get(eClass);
		if (layer1Map != null) {
			SmartMultiMap<Object, EObject> layer2Map = layer1Map.get(featureName);
			if (layer2Map != null) {
				layer2Map.put(value, eObject);
			}
			else {
				layer2Map = new SmartMultiMap<Object, EObject>();
				layer2Map.put(value, eObject);
				layer1Map.put(featureName, layer2Map);
			}
		}
		else {
			layer1Map = new HashMap<String, SmartMultiMap<Object,EObject>>();
			SmartMultiMap<Object, EObject> layer2Map = new SmartMultiMap<Object, EObject>();
			layer2Map.put(value, eObject);
			layer1Map.put(featureName, layer2Map);
			index.put(eClass, layer1Map);
		}
	}
	
	public ArrayList<String> featuresToIndex(EObject eObject) throws EolModelElementTypeNotFoundException
	{
		ArrayList<String> result = new ArrayList<String>();
		
		EClass eClass = eObject.eClass();
		
		EffectiveMetamodel em = getEffectiveMetamodel(eClass);
		
		if (em == null) {
			return null;
		}
		
		for(EffectiveType et: em.getAllOfKind())
		{
			EClass effectiveEClass = classForName(et.getName());
			if (effectiveEClass.isInstance(eObject)) {
				for(EffectiveFeature ef: et.getAllFeatures())
				{
					if (ef.getUsage() > 1) {
						result.add(ef.getName());
					}
				}
			}
		}
		
		for(EffectiveType et: em.getAllOfType())
		{
			if (et.getName().equals(eClass.getName())) {
				for(EffectiveFeature ef: et.getAllFeatures())
				{
					if (ef.getUsage() > 1) {
						result.add(ef.getName());
					}
				}
			}
		}
		
		for(EffectiveType et: em.getTypes())
		{
			EClass effectiveEClass = classForName(et.getName());
			if (effectiveEClass.isInstance(eObject)) {
				for(EffectiveFeature ef: et.getAllFeatures())
				{
					if (ef.getUsage() > 1) {
						result.add(ef.getName());
					}
				}
			}
		}
		return result;
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
	
	
	public void populateCaches() throws EolModelElementTypeNotFoundException
	{		
		for(EffectiveMetamodel mc: effectiveMetamodels)
		{
			for(EffectiveType mec: mc.getAllOfKind())
			{
				EClass eClass = classForName(mec.getName());
				if (eClass != null) {
					allOfKinds.add(eClass);
					//cachedKinds.add(eClass);	
				}
				else {
					System.out.println("eclass is null!");
				}
			}
			
			for(EffectiveType mec: mc.getAllOfType())
			{
				EClass eClass = classForName(mec.getName());
				allOfTypes.add(eClass);
				//cachedTypes.add(eClass);
			}
		}
		
		for (EObject eObject : allContents()) {
			for(EClass eClass : allOfKinds)
			{
				if (eClass.isInstance(eObject)) {
					
					//kindCache.put(eClass, eObject);
					OptimisableCollection collection = allOfKindCache.get(eClass);
					if (collection == null) {
						OptimisableCollection collection2 = new OptimisableCollection(this, eClass);
						collection2.add(eObject);
						allOfKindCache.put(eClass, collection2);
					}
					else {
						collection.add(eObject);
					}
					
				}
			}
			for(EClass eClass : allOfTypes)
			{
				if (eObject.eClass() == eClass){
					//typeCache.put(eClass, eObject);
					OptimisableCollection collection = allOfTypeCache.get(eClass);
					if (collection == null) {
						OptimisableCollection collection2 = new OptimisableCollection(this, eClass);
						collection2.add(eObject);
						allOfTypeCache.put(eClass, collection2);
					}
					else {
						collection.add(eObject);
					}
				}
			}
			ArrayList<String> featuresToIndex = featuresToIndex(eObject);
			if (featuresToIndex != null) {
				for(String feature: featuresToIndex)
				{
					EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature(feature); 
					if(eStructuralFeature != null) 
					{
						Object value = eObject.eGet(eStructuralFeature);
						if(value != null)
						{
							createIndex(eObject, feature, value);
						}
					}
				}
			}
		}
		System.out.println(allOfKindCache.values().size());
	}
	
	
	public EffectiveMetamodel getEffectiveMetamodel(EClass eClass)
	{
		for(EffectiveMetamodel em: effectiveMetamodels)
		{
			if (em.getName().equals(eClass.getEPackage().getName())) {
				return em;
			}
		}
		return null;
	}
	
	public void setEffectiveMetamodels(
			ArrayList<EffectiveMetamodel> effectiveMetamodels) {
		this.effectiveMetamodels = effectiveMetamodels;
	}
		
	public void printIndexSize()
	{
		for(EClass eClass: index.keySet())
		{
			HashMap<String, SmartMultiMap<Object, EObject>> layer1Map = index.get(eClass);
			for(String s: layer1Map.keySet())
			{
				SmartMultiMap<Object, EObject> layer2Map = layer1Map.get(s);
				System.out.println(layer2Map.toString());
			}
		}
	}
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		
		for(int i = 0; i < 1; i++)
		{
			long init = System.nanoTime();
			
			EolModule eolModule = new EolModule();
			eolModule.parse(new File("test/grabats_looped.eol"));
			
			NormalEmfModel indexedModel = new NormalEmfModel();
			indexedModel.setIndexed(false);
			
			indexedModel.setName("DOM");
			indexedModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
			indexedModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
			
			loadEPackageFromFile("test/JDTAST.ecore");
					

			indexedModel.load();
			System.out.println("(took ~" + (System.nanoTime() - init) / 1000000 + "ms to load)");
			init = System.nanoTime();
			
			eolModule.getContext().getModelRepository().addModel(indexedModel);
			eolModule.execute();
			System.out.println("(took ~" + (System.nanoTime() - init)
					/ 1000000 + "ms to run)");
			eolModule.getContext().getModelRepository().dispose();
			
//			indexedModel.printIndexSize();
		}

	}
	
	

	public static EPackage loadEPackageFromFile(String fileName)
	{
		EPackage result = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		URI uri = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		for(EObject obj: resource.getContents())
		{
			if(obj instanceof EPackage)
			{
				EPackage.Registry.INSTANCE.put(((EPackage) obj).getNsURI(), obj);
				result = (EPackage) obj;
				//break;
			}
		}
		return result;
	}
}
