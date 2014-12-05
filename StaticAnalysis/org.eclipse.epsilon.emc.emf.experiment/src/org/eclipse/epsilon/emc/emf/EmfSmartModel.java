package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.epsilon.eol.metamodel.EType;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.breakAllStatement_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.ifStatement_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl.TypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class EmfSmartModel extends EmfModel{

	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>();	//protected ModelContainer modelContainer;
	
	protected ArrayList<EClass> visitedClasses = new ArrayList<EClass>();
	
	protected HashMap<String, ArrayList<String>> objectsToLoad = new HashMap<String, ArrayList<String>>();
	protected HashMap<String, ArrayList<String>> emptyObjectsToLoad = new HashMap<String, ArrayList<String>>();

	protected boolean smartLoading = false;
	
	public void setSmartLoading(boolean smartLoading) {
		this.smartLoading = smartLoading;
	}

	public void addModelContainer(ModelContainer modelContainer)
	{
		modelContainers.add(modelContainer);
	}
	
	public void setModelContainers(ArrayList<ModelContainer> modelContainers) {
		this.modelContainers = modelContainers;
	}
	
	public void preProcess() throws EolModelLoadingException
	{
		ResourceSet resourceSet = createResourceSet();
		
        // Check if global package registry contains the EcorePackage
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		determinePackagesFrom(resourceSet);
		populateEmptyObjects();

	}
	
	
	public void loadModelFromUri() throws EolModelLoadingException {
		ResourceSet resourceSet = createResourceSet();
		
        // Check if global package registry contains the EcorePackage
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		determinePackagesFrom(resourceSet);
//		long init = System.nanoTime();
//		populateEmptyObjects();
//		System.out.println((System.nanoTime()-init)/1000000);
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
	
	public void populateEmptyObjects()
	{
		for(EPackage ePackage: packages)
		{
			for(EClassifier eClassifier: ePackage.getEClassifiers())
			{
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (emptyObject(ePackage, eClass)) {
						insertHollowOjbects(ePackage, eClass);
					}
				}
			}
		}
		
		for(EPackage ePackage: packages)
		{
			for(EClassifier eClassifier: ePackage.getEClassifiers())
			{
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					visitedClasses.clear();
					visitEClass(eClass);
				}
			}
		}

		
//		for(ModelContainer mc: modelContainers)
//		{	
//			System.out.println("for package:" + mc.getModelName());
//			System.out.println("all of Kind");
//			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
//			{
//				System.out.println("	"+mec.getElementName());
//			}
//			System.out.println("all of Type");
//			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
//			{
//				System.out.println("	"+mec.getElementName());
//			}
//			System.out.println("Empty objects");
//			for(String s: mc.getEmptyElements())
//			{
//				System.out.println("	"+s);
//			}
//		}
		generateHashMaps();
	}
	
	public void generateHashMaps()
	{
		for(EPackage ePackage: packages)
		{
			if (objectsToLoad.get(ePackage.getName()) == null) {
				objectsToLoad.put(ePackage.getName(), new ArrayList<String>());
			}
			if (emptyObjectsToLoad.get(ePackage.getName()) == null) {
				emptyObjectsToLoad.put(ePackage.getName(), new ArrayList<String>());
			}
			
			for(EClassifier eClassifier: ePackage.getEClassifiers())
			{
				if (eClassifier instanceof EClass) {
					for(ModelContainer mc: modelContainers)
					{
						if (mc.getModelName().equalsIgnoreCase(ePackage.getName())) {
							loop1:
							for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
							{
								String eClassName = eClassifier.getName();
								String elementName = mec.getElementName();
								if (eClassName.equals(elementName)) {
									String packageName = ePackage.getName();
									if (!objectsToLoad.get(packageName).contains(eClassName)) {
										objectsToLoad.get(packageName).add(eClassName);
									}
									break loop1;
								}
								
								EClass kind = (EClass) ePackage.getEClassifier(elementName);
								for(EClass superClass: ((EClass) eClassifier).getEAllSuperTypes())
								{
									if (superClass.getName().equals(kind.getName())) {
										String packageName = ePackage.getName();
										if (!objectsToLoad.get(packageName).contains(eClassifier.getName())) {
											objectsToLoad.get(packageName).add(eClassifier.getName());
										}
										break loop1;
									}
								}
							}
							
							loop2:
							for(ModelElementContainer mec: mc.getModelElementsAllOfType())
							{
								String eClassName = eClassifier.getName();
								String elementName = mec.getElementName();
								if (eClassName.equals(elementName)) {
									String packageName = ePackage.getName();
									if (!objectsToLoad.get(packageName).contains(elementName)) {
										objectsToLoad.get(packageName).add(elementName);
									}
									break loop2;
								}
							}
							
							loop3:
							for(String hollowElement: mc.getEmptyElements())
							{

								if (hollowElement.equals(eClassifier.getName())) {
									String packageName = ePackage.getName();
									if (!emptyObjectsToLoad.get(packageName).contains(hollowElement) && !objectsToLoad.get(packageName).contains(hollowElement)) {
										emptyObjectsToLoad.get(packageName).add(hollowElement);
									}
									break loop3;

								}
								
								EClass kind = (EClass) ePackage.getEClassifier(hollowElement);
								if((((EClass) eClassifier).getEAllSuperTypes().contains(kind))||
										kind.getEAllSuperTypes().contains(eClassifier))
								{
									String packageName = ePackage.getName();
									if (!emptyObjectsToLoad.get(packageName).contains(eClassifier.getName()) && !objectsToLoad.get(packageName).contains(eClassifier.getName())) {
										emptyObjectsToLoad.get(packageName).add(eClassifier.getName());
									}

								}
							}
						}
					}
				}
			}
		
		}
	}
	
	
	public void insertHollowOjbects(EPackage ePackage, EClass eClass)
	{
		boolean inserted = false;
		for(ModelContainer mc: modelContainers)
		{
			if (mc.getModelName().equalsIgnoreCase(ePackage.getName())) {
				for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
				{
					if (mec.getElementName().equals(eClass.getName())) {
						inserted = true;
						return;
					}
					EClass kind = (EClass) ePackage.getEClassifier(mec.getElementName());
					for(EClass superClass: eClass.getEAllSuperTypes())
					{
						if (kind.getName().equals(superClass.getName())) {
							inserted = true;
							return;
						}
					}

				}
				for(ModelElementContainer mec: mc.getModelElementsAllOfType())
				{
					if (mec.getElementName().equals(eClass.getName())) {
						inserted = true;
						return;
					}
				}
				if (!inserted) {
					inserted = true;
					mc.addEmptyElement(eClass.getName());
					break;
				}
			}
		}
		if (!inserted) {
			ModelContainer newContainer = new ModelContainer(ePackage.getName());
			newContainer.addEmptyElement(eClass.getName());
			modelContainers.add(newContainer);
			
		}
	}
	
	
	public void visitEClass(EClass eClass)
	{
		visitedClasses.add(EcoreUtil.copy(eClass));
		for(EReference eReference: eClass.getEReferences())
		{
			if (!visitedEClass((EClass) eReference.getEType())) {
				visitEClass((EClass) eReference.getEType());
			}
			
			if (liveReference(eReference)) {
				insertHollowOjbects(eClass.getEPackage(), eClass);
			}
		}
	}
	
	public boolean visitedEClass(EClass eClass)
	{
		for(EClass clazz: visitedClasses)
		{
			if (clazz.getName().equals(eClass.getName())) {
				return true;
			}
		}
		return false;
	}

	
	public boolean liveReference(EReference eReference)
	{
		//get the etype
//		if (eReference.isContainment()) {
			EClassifier eClassifier = eReference.getEType();
			EClass etype = (EClass) eClassifier;
			if (liveClass(etype.getEPackage(), etype.getName())) {
				return true;
//			}
		}
		
		return false;
	}
	
	public boolean emptyObject(EPackage ePackage, EClass eClass)
	{
		for(ModelContainer mc: modelContainers)
		{
			if (mc.getModelName().equalsIgnoreCase(ePackage.getName())) {
				for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
				{
					String elementName = mec.getElementName();
					
					EClass kind = (EClass) ePackage.getEClassifier(elementName);
					if(kind.getEAllSuperTypes().contains(eClass))
					{
						return true;
					}
				}
				
				for(ModelElementContainer mec: mc.getModelElementsAllOfType())
				{
					String elementName = mec.getElementName();
					EClass kind = (EClass) ePackage.getEClassifier(elementName);
					if(kind.getEAllSuperTypes().contains(eClass))
					{
						return true;
					}
				}
			}
		}
		return false;

	}
	
	public boolean liveClass(EPackage ePackage, String className)
	{
		for(ModelContainer mc: modelContainers)
		{
			if (mc.getModelName().equalsIgnoreCase(ePackage.getName())) {
				for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
				{
					String elementName = mec.getElementName();
					if (className.equals(elementName)) {
						return true;
					}
					
					EClass kind = (EClass) ePackage.getEClassifier(elementName);
					EClass actual = (EClass) ePackage.getEClassifier(className);
					if(actual.getEAllSuperTypes().contains(kind))
					{
						return true;
					}
//					if (kind.getEAllSuperTypes().contains(actual)) 
//					{
//						return true;
//					}
				}
				
				for(ModelElementContainer mec: mc.getModelElementsAllOfType())
				{
					String elementName = mec.getElementName();
					if (className.equals(elementName)) {
						return true;
					}
				}
				
				for(String hollowElement: mc.getEmptyElements())
				{

					if (hollowElement.equals(className)) {
						return true;
					}
//					EClass kind = (EClass) ePackage.getEClassifier(hollowElement);
//					EClass actual = (EClass) ePackage.getEClassifier(className);
//					if (actual.getEAllSuperTypes().contains(kind)) {
//						return true;
//					}

				}
			}
		}
		return false;
	}
	
	@Override
	public void disposeModel() {
		//modelImpl.unload();
		//resourceMap.remove("platform:/resource" + relativeModelFile);
		if (smartLoading) {
			registry = null;
			if (modelImpl != null) {
				//modelImpl.unload();
				SmartEmfModelResourceFactory.getInstance().removeCachedResource(modelImpl.getURI());
				modelImpl = null;
			}

			eClassCache.clear();
		}
		else {
			super.disposeModel();
		}

	}
	
	@Override
	protected ResourceSet createResourceSet() {
		if (smartLoading) {
			ResourceSet resourceSet = new EmfModelResourceSet();
			SmartEmfModelResourceFactory factory = SmartEmfModelResourceFactory.getInstance(); // <----------------------- point of change
			//factory.setModelContainers(modelContainers); // <----------------------- point of change
			factory.setObjectsToLoad(objectsToLoad);
			factory.setEmptyObjectsToLoad(emptyObjectsToLoad);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", factory);   // <----------------------- point of change
			return resourceSet;
		}
		else {
			return super.createResourceSet();
		}
		
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
			eolModule.parse(new File("test/set2_100percent.eol"));
			
			EmfSmartModel smartModel = new EmfSmartModel();
			smartModel.setName("oo");
			smartModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
			smartModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
			
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
			smartModel.preProcess();
			smartModel.setSmartLoading(true);
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
