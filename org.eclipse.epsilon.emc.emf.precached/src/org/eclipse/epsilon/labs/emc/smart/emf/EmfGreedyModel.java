package org.eclipse.epsilon.labs.emc.smart.emf;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class EmfGreedyModel extends EmfModel{

	public void loadModelFromUri() throws EolModelLoadingException {
		super.loadModelFromUri();
		
		populateCaches();
	}
	
	public void populateCaches()
	{
		ArrayList<EClass> all = new ArrayList<EClass>();
		
		for(EPackage epack: packages)
		{
			for(EClassifier eClass: epack.getEClassifiers())
			{
				if (eClass instanceof EClass) {
					all.add((EClass) eClass);
					cachedKinds.add(eClass);
					cachedTypes.add(eClass);
				}
			}
		}
				
		
		for (EObject eObject : (Collection<EObject>)allContents()) {
			for(EClass eClass: all)
			{
				if (eClass.isInstance(eObject)) {
					kindCache.put(eClass, eObject);
				}
				if (eObject.eClass() == eClass) {
					typeCache.put(eClass, eObject);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/grabats.eol"));
		
		EmfGreedyModel greedyModel = new EmfGreedyModel();
		greedyModel.setModelFile(new File("test/set4.xmi").getAbsolutePath());
		greedyModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		greedyModel.setName("DOM");
		
		long init = System.nanoTime();

		greedyModel.load();
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to load)");
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(greedyModel);
		eolModule.execute();
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");

	}



}
