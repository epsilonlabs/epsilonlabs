package org.eclipse.epsilon.emc.emf.test;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.EmfSmartModel;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.EffectiveMetamodel;

public class EmfSmartModelWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		EmfSmartModel model = new EmfSmartModel();
		
		model.setName("M");
		model.setReadOnLoad(true);
		String metamodel = new File("src/org/eclipse/epsilon/emc/emf/test/filesystem.ecore").getAbsolutePath();
		model.setMetamodelFile(metamodel);
		
		URI modelPath = URI.createURI(TestParcialLoading.class.getResource("test_model.model").toString());
		model.setModelFileUri(modelPath);
		
		EffectiveMetamodel container = new EffectiveMetamodel("filesystem");
		container.addToAllOfKind("File");
//		container.addToModelElementsAllOfKind("Filesystem");
//		container.addAttributeToModelElement("Filesystem", "files");

		
		ArrayList<EffectiveMetamodel> containers = new ArrayList<EffectiveMetamodel>();
		containers.add(container);
		
		model.setModelContainers(containers);
		model.setSmartLoading(true);
		model.setPartialLoading(true);
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
