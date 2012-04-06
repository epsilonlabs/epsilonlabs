package org.eclipse.epsilon.examples.standalone.service.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.epsilon.examples.standalone.service.Activator;
import org.eclipse.epsilon.standalone.service.handlers.AbstractTransformationHandler;
import org.eclipse.epsilon.standalone.service.transform.EtlTransformParameters;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class TransformHandler extends AbstractTransformationHandler {

	public TransformHandler() {
	}

	public Object executes(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Epsilong Exmaple Transformation Service",
				"Hello, Eclipse world");
		return null;
	}

	@Override
	public EtlTransformParameters createTransformParameters(
			EtlTransformParameters etlTransformParameters) {
		etlTransformParameters.setPluginID(Activator.PLUGIN_ID);
		etlTransformParameters.setEtlTransform("epsilon/Tree2Graph.etl");
		etlTransformParameters.setSourceMetaModelURI("http://tree/1.0");
		etlTransformParameters.setSourceName("Tree");
		etlTransformParameters.setSourceReadOnLoad(true);
		etlTransformParameters.setSourceStoreOnDisposal(false);
		etlTransformParameters.setTargetMetaModelURI("http://graph/1.0");
		etlTransformParameters.setTargetName("Graph");
		etlTransformParameters.setTargetReadOnLoad(false);
		etlTransformParameters.setTargetStoreOnDisposal(true);
		return etlTransformParameters;
	}
}
