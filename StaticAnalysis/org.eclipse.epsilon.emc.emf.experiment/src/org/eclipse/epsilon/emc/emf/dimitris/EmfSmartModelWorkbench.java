package org.eclipse.epsilon.emc.emf.dimitris;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.EmfSmartModel;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;

public class EmfSmartModelWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		EmfSmartModel model = new EmfSmartModel();
		
		model.setName("M");
		model.setReadOnLoad(true);
		model.setMetamodelUri(EcorePackage.eNS_URI);
		model.setModelFileUri(URI.createURI(EmfSmartModelWorkbench.class.getResource("filesystem.ecore").toString()));
		
		ModelContainer container = new ModelContainer("ecore");
//		container.addToModelElementsAllOfKind("EPackage");
		container.addToModelElementsAllOfKind("EClassifier");
//		container.addReferenceToModelElement("EClassifier", "eStructuralFeatures");
		container.addToModelElementsAllOfKind("EStructuralFeature");
		container.addReferenceToModelElement("EStructuralFeature", "eType");
		
//		container.addToModelElementsAllOfKind("EAttribute");
		ArrayList<ModelContainer> containers = new ArrayList<ModelContainer>();
		containers.add(container);
		
		model.setModelContainers(containers);
		model.setSmartLoading(true);
		model.preProcess();
		model.load();
		
		System.out.println(model.allContents().size()); 
		for(EObject obj: model.allContents())
		{
			System.out.println(obj + " -> " + obj.eContents());
		}
		// I'd expect this to print 1 (only load the filesystem EPackage)
		// but it prints 3 instead (seems to be loading everything)
		
	}
	
}
