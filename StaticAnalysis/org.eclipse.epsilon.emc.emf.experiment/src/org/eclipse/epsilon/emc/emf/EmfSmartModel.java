package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

	protected ModelContainer modelContainer;

	public void setModelContainer(ModelContainer modelContainer) {
		this.modelContainer = modelContainer;
	}
	
	public void loadModelFromUri() throws EolModelLoadingException {
		super.loadModelFromUri();
		if (modelContainer != null) {
			try {
				populateCaches_v2();
			} catch (EolModelElementTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
//	public void setupContainmentChangeListeners() {
//		// Add a notification adapter to all objects in the model
//		// so that they get moved when their containment changes
//		ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
//		ArrayList<EClass> allOfTypes = new ArrayList<EClass>();
//
//		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfKind())
//		{
//			EClass eClass = null;
//			try {
//				eClass = classForName(mec.getElementName());
//			} catch (EolModelElementTypeNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			allOfKinds.add(eClass);
//			cachedKinds.add(eClass);
//		}
//		
//		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfType())
//		{
//			EClass eClass = null;
//			try {
//				eClass = classForName(mec.getElementName());
//			} catch (EolModelElementTypeNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			allOfTypes.add(eClass);
//			cachedTypes.add(eClass);
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
	public void populateCaches() throws EolModelElementTypeNotFoundException
	{
		HashMap<EClass, List<EObject>> allOfKinds = new HashMap<EClass, List<EObject>>();
		HashMap<EClass, List<EObject>> allOfTypes = new HashMap<EClass, List<EObject>>();
		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfKind())
		{
			EClass eClass = classForName(mec.getElementName());
			allOfKinds.put(eClass, new ArrayList<EObject>());
		}
		
		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfType())
		{
			EClass eClass = classForName(mec.getElementName());
			allOfTypes.put(eClass, new ArrayList<EObject>());
		}
		
		
		for (EObject eObject : (Collection<EObject>)allContents()) {
			for(EClass eClass : allOfKinds.keySet())
			{
				if (eClass.isInstance(eObject)) {
					allOfKinds.get(eClass).add(eObject);
				}
			}
			for(EClass eClass : allOfTypes.keySet())
			{
				if (eObject.eClass() == eClass){
					allOfTypes.get(eClass).add(eObject);
				}
			}
		}
		
		for(EClass eClass : allOfKinds.keySet())
		{
			kindCache.replaceValues(eClass, allOfKinds.get(eClass));
			cachedKinds.add(eClass);
		}
		
		for(EClass eClass : allOfTypes.keySet())
		{
			typeCache.replaceValues(eClass, allOfTypes.get(eClass));
			cachedTypes.add(eClass);
		}
		
	}
	
	public void populateCaches_v2() throws EolModelElementTypeNotFoundException
	{
		ArrayList<EClass> allOfKinds = new ArrayList<EClass>();
		ArrayList<EClass> allOfTypes = new ArrayList<EClass>();
		
		
		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfKind())
		{
			EClass eClass = classForName(mec.getElementName());
			allOfKinds.add(eClass);
			cachedKinds.add(eClass);
		}
		
		for(ModelElementContainer mec: modelContainer.getModelElementsAllOfType())
		{
			EClass eClass = classForName(mec.getElementName());
			allOfTypes.add(eClass);
			cachedTypes.add(eClass);
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
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/grabats.eol"));
		
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
		
		smartModel.setModelContainer(loaContext.getModelContainers().get(0));
		
		long init = System.nanoTime();

		smartModel.load();
		
		eolModule.getContext().getModelRepository().addModel(smartModel);
		eolModule.execute();
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");
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
