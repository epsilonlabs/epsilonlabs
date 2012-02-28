package org.eclipse.epsilon.coverage.test.unit;

import org.eclipse.epsilon.emc.emf.EmfModel;

public abstract class AbstractTest {
	protected static EmfModel loadModel(String name, String modelFile, String metamodelUri, boolean read, boolean store) throws Exception {
		EmfModel model = new EmfModel();
		model.setName(name);
		model.setModelFile(modelFile);
		model.setMetamodelUri(metamodelUri);
		model.setReadOnLoad(read);
		model.setStoredOnDisposal(store);
		model.load();
		return model;
	}
}
