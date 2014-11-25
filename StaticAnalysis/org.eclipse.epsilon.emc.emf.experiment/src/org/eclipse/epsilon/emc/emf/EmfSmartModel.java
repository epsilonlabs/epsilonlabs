package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelElementContainer;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.impl.LoadingOptimisationAnalyser;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl.TypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class EmfSmartModel extends EmfModel{

	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>();
	//protected ModelContainer modelContainer;

	public void addModelContainer(ModelContainer modelContainer)
	{
		modelContainers.add(modelContainer);
	}
	
	public void setModelContainers(ArrayList<ModelContainer> modelContainers) {
		this.modelContainers = modelContainers;
	}
	
	
	public void loadModelFromUri() throws EolModelLoadingException {
		ResourceSet resourceSet = createResourceSet();
		
        // Check if global package registry contains the EcorePackage
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		determinePackagesFrom(resourceSet);
		
		// Note that AbstractEmfModel#getPackageRegistry() is not usable yet, as modelImpl is not set
		for (EPackage ep : packages) {
			String nsUri = ep.getNsURI();
			if (nsUri == null || nsUri.trim().length() == 0) {
				nsUri = ep.getName();
			}
			resourceSet.getPackageRegistry().put(nsUri, ep);
		}
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		Resource model = resourceSet.createResource(modelUri);
		if (this.readOnLoad) {
			try {
				model.load(null);
				if (expand) {
					EcoreUtil.resolveAll(model);
				}
			} catch (IOException e) {
				// Unload the model, so it will not be wrongly cached as "loaded",
				// causing the intermittent errors produced in bug #386255
				model.unload();
				throw new EolModelLoadingException(e, this);
			}
		}
		modelImpl = model;

		if (modelContainers.size() != 0) {
			try {
				populateCaches_v2();
			} catch (EolModelElementTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	@Override
	public void disposeModel() {
		//modelImpl.unload();
		//resourceMap.remove("platform:/resource" + relativeModelFile);
		registry = null;
		if (modelImpl != null) {
			//modelImpl.unload();
			SmartEmfModelResourceFactory.getInstance().removeCachedResource(modelImpl.getURI());
			modelImpl = null;
		}

		eClassCache.clear();

	}
	
	@Override
	protected ResourceSet createResourceSet() {
		ResourceSet resourceSet = new EmfModelResourceSet();
		SmartEmfModelResourceFactory factory = SmartEmfModelResourceFactory.getInstance(); // <----------------------- point of change
		factory.setModelContainers(modelContainers); // <----------------------- point of change
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", factory);   // <----------------------- point of change
		return resourceSet;
	}
	
//	@Override
//	public void setupContainmentChangeListeners() {
//		// Add a notification adapter to all objects in the model
//		// so that they get moved when their containment changes
//		ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
//		ArrayList<EClass> allOfTypes = new ArrayList<EClass>();
//		
//		for(ModelContainer mc: modelContainers)
//		{
//			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
//			{
//				EClass eClass = null;
//				try {
//					eClass = classForName(mec.getElementName());
//				} catch (EolModelElementTypeNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if (eClass != null) {
//					allOfKinds.add(eClass);
//					cachedKinds.add(eClass);	
//				}
//				else {
//					System.out.println("eclass is null!");
//				}
//			}
//			
//			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
//			{
//				EClass eClass = null;
//				try {
//					eClass = classForName(mec.getElementName());
//				} catch (EolModelElementTypeNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				allOfTypes.add(eClass);
//				cachedTypes.add(eClass);
//			}
//		}
//
//		if (modelImpl != null) {
//			for (EObject eObject : allContents()) {
//				for(EClass eClass : allOfKinds)
//				{
//					if (eClass.isInstance(eObject)) {
//						kindCache.put(eClass, eObject);
//					}
//				}
//				for(EClass eClass : allOfTypes)
//				{
//					if (eObject.eClass() == eClass){
//						typeCache.put(eClass, eObject);
//					}
//				}
//
//				boolean isAdapted = false;
//				for (Adapter adapter : eObject.eAdapters()) {
//					if (adapter instanceof ContainmentChangeAdapter) {
//						isAdapted = true;
//					}
//				}
//				if (!isAdapted){
//					eObject.eAdapters().add(new ContainmentChangeAdapter(eObject, eObject.eResource()));
//				}
//			}
//		}
//	}	
	
//	public void populateCaches() throws EolModelElementTypeNotFoundException
//	{
//		HashMap<EClass, List<EObject>> allOfKinds = new HashMap<EClass, List<EObject>>();
//		HashMap<EClass, List<EObject>> allOfTypes = new HashMap<EClass, List<EObject>>();
//		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfKind())
//		{
//			EClass eClass = classForName(mec.getElementName());
//			allOfKinds.put(eClass, new ArrayList<EObject>());
//		}
//		
//		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfType())
//		{
//			EClass eClass = classForName(mec.getElementName());
//			allOfTypes.put(eClass, new ArrayList<EObject>());
//		}
//		
//		
//		for (EObject eObject : (Collection<EObject>)allContents()) {
//			for(EClass eClass : allOfKinds.keySet())
//			{
//				if (eClass.isInstance(eObject)) {
//					allOfKinds.get(eClass).add(eObject);
//				}
//			}
//			for(EClass eClass : allOfTypes.keySet())
//			{
//				if (eObject.eClass() == eClass){
//					allOfTypes.get(eClass).add(eObject);
//				}
//			}
//		}
//		
//		for(EClass eClass : allOfKinds.keySet())
//		{
//			kindCache.replaceValues(eClass, allOfKinds.get(eClass));
//			cachedKinds.add(eClass);
//		}
//		
//		for(EClass eClass : allOfTypes.keySet())
//		{
//			typeCache.replaceValues(eClass, allOfTypes.get(eClass));
//			cachedTypes.add(eClass);
//		}
//		
//	}
	
//	@Override
//	protected Collection<EObject> allContentsFromModel(){
//		
//		System.out.println("call too allContentsFromModel()");
//		
//		final List<EObject> allInstances = new ArrayList<EObject>();
//		
//		ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
//		ArrayList<EClass> allOfTypes = new ArrayList<EClass>();
//		
//		for(ModelContainer mc: modelContainers)
//		{
//			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
//			{
//				EClass eClass = null;
//				try {
//					eClass = classForName(mec.getElementName());
//				} catch (EolModelElementTypeNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if (eClass != null) {
//					allOfKinds.add(eClass);
//					cachedKinds.add(eClass);	
//				}
//				else {
//					System.out.println("eclass is null!");
//				}
//				
//			}
//			
//			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
//			{
//				EClass eClass = null;
//				try {
//					eClass = classForName(mec.getElementName());
//				} catch (EolModelElementTypeNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				allOfTypes.add(eClass);
//				cachedTypes.add(eClass);
//			}
//		}
//		
//		for (Resource resource : getResources()) {
//			Iterator<EObject> it = resource.getAllContents();
//			while (it.hasNext()){
//				EObject eObject = it.next();
//				for(EClass eClass : allOfKinds)
//				{
//					if (eClass.isInstance(eObject)) {
//						kindCache.put(eClass, eObject);
//					}
//				}
//				for(EClass eClass : allOfTypes)
//				{
//					if (eObject.eClass() == eClass){
//						typeCache.put(eClass, eObject);
//					}
//				}
//				
//
//				allInstances.add(eObject);
//			}
//		}
//		
//		/*
//		if (!expand) {
//			Iterator<EObject> it = modelImpl.getAllContents();
//			while (it.hasNext()){
//				allInstances.add(it.next());
//			}
//		
//		} else {
//			final List<Resource> resources;
//			
//			if (modelImpl.getResourceSet() == null) {
//				resources = new ArrayList<Resource>();
//				resources.add(modelImpl);
//			} else {
//				resources = modelImpl.getResourceSet().getResources();
//			}
//				
//			
//		}*/
//			
//		return allInstances;
//	}
//
//	
	public void populateCaches_v2() throws Exception
	{
		ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
		ArrayList<EClass> allOfTypes = new ArrayList<EClass>();
		
		for(ModelContainer mc: modelContainers)
		{
			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
			{
				EClass eClass = classForName(mec.getElementName());
				if (eClass != null) {
					allOfKinds.add(eClass);
					cachedKinds.add(eClass);	
				}
				else {
					System.out.println("eclass is null!");
				}
			}
			
			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
			{
				EClass eClass = classForName(mec.getElementName());
				allOfTypes.add(eClass);
				cachedTypes.add(eClass);
			}
		}
		
		for (EObject eObject : (Collection<EObject>)allContents()) {
			for(EClass eClass : allOfKinds)
			{
				if (eClass.isInstance(eObject)) {
					kindCache.put(eClass, eObject);
				}
			}
			for(EClass eClass : allOfTypes)
			{
				if (eObject.eClass() == eClass){
					typeCache.put(eClass, eObject);
				}
			}
		}
	}
	
	public void checkIntegrity() throws Exception
	{
		for(ModelContainer mc: modelContainers)
		{
			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
			{
				EClass eClass = classForName(mec.getElementName());
				if (cachedKinds.contains(eClass)) {
					if (kindCache.get(eClass) != null) {
						if (kindCache.get(eClass).size() == 0) {
							System.out.println("size is 0!");
							throw new Exception();
						}
					}
					else {
						
						System.out.println("returned null!");
						throw new Exception();
					}
				}
				else {
					System.out.println("Does not contain!" + eClass.getName());
					throw new Exception();
				}
			}
			
			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
			{
				EClass eClass = classForName(mec.getElementName());
				if (cachedTypes.contains(eClass)) {
					if (typeCache.get(eClass) != null) {
						if (typeCache.get(eClass).size() == 0) {
							System.out.println("size is 0!");
							throw new Exception();
						}
					}
					else {
						System.out.println("returned null!");
						throw new Exception();
					}
				}
				else {
					System.out.println("Does not contain!" + eClass.getName());
					throw new Exception();
				}
			}
		}
	}
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		for(int i = 0; i < 10; i++)
		{
			EolModule eolModule = new EolModule();
			eolModule.parse(new File("test/set2_60percent.eol"));
			
			EmfSmartModel smartModel = new EmfSmartModel();
			smartModel.setName("DOM");
			smartModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
			smartModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
			//smartModel.setMetamodelUri("org.amma.dsl.jdt.dom");
			
			loadEPackageFromFile("test/JDTAST.ecore");
			
			Ast2EolContext ast2EolContext = new Ast2EolContext();
			EolElement dom = ast2EolContext.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, ast2EolContext);
			
			VariableResolver vr = new VariableResolver();
			vr.run(dom);
			
			TypeResolver tr = new TypeResolver();
			tr.getTypeResolutionContext().setModule(eolModule);
			tr.run(dom);
			
			
			LoadingOptimisationAnalyser loa = new LoadingOptimisationAnalyser();
			loa.run(dom);
			
			LoadingOptimisationAnalysisContext loaContext = (LoadingOptimisationAnalysisContext) loa.getTypeResolutionContext();
			
			smartModel.setModelContainers(loaContext.getModelContainers());
			
			long init = System.nanoTime();

			smartModel.load();
			System.out.println("(took ~" + (System.nanoTime() - init) / 1000000 + "ms to load");
			init = System.nanoTime();
			
			eolModule.getContext().getModelRepository().addModel(smartModel);
			eolModule.execute();
			System.out.println("(took ~" + (System.nanoTime() - init)
					/ 1000000 + "ms to run)");
			eolModule.getContext().getModelRepository().dispose();
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
