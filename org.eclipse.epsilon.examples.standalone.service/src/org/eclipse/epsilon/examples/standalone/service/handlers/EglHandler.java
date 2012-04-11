package org.eclipse.epsilon.examples.standalone.service.handlers;

import org.eclipse.epsilon.examples.standalone.service.Activator;
import org.eclipse.epsilon.standalone.service.handlers.AbstractEglTransformationHandler;
import org.eclipse.epsilon.standalone.service.transform.EglTransformParameters;

public class EglHandler extends AbstractEglTransformationHandler {

	@Override
	public EglTransformParameters createTransformParameters(
			EglTransformParameters parameters) {
		
		parameters.setEglTransform("epsilon/box.egl");
		parameters.setOutputRoot(null);
		parameters.setPluginID(Activator.PLUGIN_ID);
		parameters.setSourceMetaModelURI("http://box/1.0");
		parameters.setSourceName("Source");
		parameters.setSourceModelFilePath(null);
		parameters.setSourceReadOnLoad(true);
		parameters.setSourceStoreOnDisposal(false);
		
		return parameters;
	}

}
