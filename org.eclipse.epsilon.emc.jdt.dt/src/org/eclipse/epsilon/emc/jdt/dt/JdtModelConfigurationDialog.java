package org.eclipse.epsilon.emc.jdt.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.jdt.JdtModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class JdtModelConfigurationDialog extends AbstractModelConfigurationDialog {

	protected Label projectNameLabel;
	protected Text projectNameText;
	
	@Override
	protected String getModelName() {
		return "Java Model";
	}

	@Override
	protected String getModelType() {
		return "JDT";
	}
	
	
	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createMetaEditGroup(control);
	}
	
	protected void createMetaEditGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "JDT", 2);
		
		projectNameLabel = new Label(groupContent, SWT.NONE);
		projectNameLabel.setText("Project name: ");
		
		projectNameText = new Text(groupContent, SWT.BORDER);
		projectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		groupContent.layout();
		groupContent.pack();
	}

	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		projectNameText.setText(properties.getProperty(JdtModel.PROPERTY_PROJECT_NAME));
	}
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(JdtModel.PROPERTY_PROJECT_NAME, projectNameText.getText());
	}
}
