package org.eclipse.epsilon.emc.metaedit.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.metaedit.MetaEditModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MetaEditModelConfigurationDialog extends AbstractModelConfigurationDialog {
	
	protected Label graphTypeNameLabel;
	protected Text graphTypeNameText;
	protected Label graphNameLabel;
	protected Text graphNameText;
	
	@Override
	protected String getModelName() {
		return "MetaEdit+ model";
	}

	@Override
	protected String getModelType() {
		return "MetaEdit";
	}
	
	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createMetaEditGroup(control);
	}
	
	protected void createMetaEditGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "MetaEdit+", 2);
		
		graphTypeNameLabel = new Label(groupContent, SWT.NONE);
		graphTypeNameLabel.setText("Graph type: ");
		
		graphTypeNameText = new Text(groupContent, SWT.BORDER);
		graphTypeNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		graphNameLabel = new Label(groupContent, SWT.NONE);
		graphNameLabel.setText("Graph name: ");
		
		graphNameText = new Text(groupContent, SWT.BORDER);
		graphNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		groupContent.layout();
		groupContent.pack();
	}

	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		graphNameText.setText(properties.getProperty(MetaEditModel.PROPERTY_GRAPH_NAME));
		graphTypeNameText.setText(properties.getProperty(MetaEditModel.PROPERTY_GRAPH_TYPE_NAME));
	}
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(MetaEditModel.PROPERTY_GRAPH_NAME, graphNameText.getText());
		properties.put(MetaEditModel.PROPERTY_GRAPH_TYPE_NAME, graphTypeNameText.getText());
	}
}
