package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.EolLibraryModule;
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
				populateCaches();
			} catch (EolModelElementTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
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
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/grabats.eol"));
		
		EmfSmartModel smartModel = new EmfSmartModel();
		smartModel.setName("smartModel");
		smartModel.setModelFile(new File("test/set0.xmi").getAbsolutePath());
		smartModel.setMetamodelUri("org.amma.dsl.jdt.dom");
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
		
		smartModel.load();
		
		
		eolModule.getContext().getModelRepository().addModel(smartModel);
		eolModule.execute();
	}

}
