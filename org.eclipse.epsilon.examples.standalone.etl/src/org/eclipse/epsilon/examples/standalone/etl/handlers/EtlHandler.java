package org.eclipse.epsilon.examples.standalone.etl.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.epsilon.examples.standalone.etl.Activator;
import org.eclipse.epsilon.standalone.handlers.AbstractTransformationHandler;

public class EtlHandler extends AbstractTransformationHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		return null;
	}

	@Override
	public String getPluginID() {
		return Activator.PLUGIN_ID;
	}

}
