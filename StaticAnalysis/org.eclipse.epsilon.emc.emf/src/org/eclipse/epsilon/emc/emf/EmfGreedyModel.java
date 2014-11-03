package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class EmfGreedyModel extends EmfModel{

	public void loadModelFromUri() throws EolModelLoadingException {
		super.loadModelFromUri();
		
		populateCaches();
	}
	
	
	public void populateCaches()
	{
		HashMap<EClass, List<EObject>> allOfKinds = new HashMap<EClass, List<EObject>>();
		HashMap<EClass, List<EObject>> allOfTypes = new HashMap<EClass, List<EObject>>();
		for(EPackage epack: packages)
		{
			for(EClassifier eClass: epack.getEClassifiers())
			{
				if (eClass instanceof EClass) {
					allOfKinds.put((EClass) eClass, new ArrayList<EObject>());
					allOfTypes.put((EClass) eClass, new ArrayList<EObject>());
				}
			}
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
		
		EmfGreedyModel greedyModel = new EmfGreedyModel();
		greedyModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
		greedyModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		greedyModel.setName("DOM");
		
		long init = System.nanoTime();

		//greedyModel.setMetamodelUri("org.amma.dsl.jdt.dom");
		//greedyModel.setMetamodelUri("http://www.eclipse.org/emf/2002/Ecore");
		greedyModel.load();
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");

		
		eolModule.getContext().getModelRepository().addModel(greedyModel);
		eolModule.execute();
	}



}
