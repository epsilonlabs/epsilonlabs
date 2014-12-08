package org.eclipse.epsilon.emc.emf.dimitris;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.emc.emf.EmfSmartModel;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;

public class EmfSmartModelWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		EmfSmartModel model = new EmfSmartModel();
		
		model.setName("M");
		model.setReadOnLoad(true);
		model.setModelFileUri(URI.createURI(EmfSmartModelWorkbench.class.getResource("filesystem.ecore").toString()));
		
		ModelContainer container = new ModelContainer("M");
		container.addToModelElementsAllOfKind("EPackage");
		ArrayList<ModelContainer> containers = new ArrayList<ModelContainer>();
		containers.add(container);
		
		model.setModelContainers(containers);
		model.setSmartLoading(true);
		model.load();
		
		System.out.println(model.allContents().size()); 
		// I'd expect this to return 1 (only load the filesystem EPackage)
		// but it seems to be loading everything instead
		
	}
	
}
