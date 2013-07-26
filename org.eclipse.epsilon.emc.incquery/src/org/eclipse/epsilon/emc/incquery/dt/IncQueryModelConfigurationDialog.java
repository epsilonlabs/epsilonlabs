package org.eclipse.epsilon.emc.incquery.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;

public class IncQueryModelConfigurationDialog extends AbstractModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "IncQuery Model";
	}

	@Override
	protected String getModelType() {
		return "IncQuery";
	}

}
