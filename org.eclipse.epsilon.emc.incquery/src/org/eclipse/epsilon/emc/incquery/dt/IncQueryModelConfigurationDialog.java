package org.eclipse.epsilon.emc.incquery.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.incquery.IncQueryModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class IncQueryModelConfigurationDialog extends AbstractModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "IncQuery Model";
	}

	@Override
	protected String getModelType() {
		return "IncQuery";
	}

	protected Label modelFileTextLabel;
	protected Text modelFileText;
	protected Label patternsFileTextLabel;
	protected Text patternsFileText;
	protected Button browseModelFile;
	protected Button browsePatternsFile;
	
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
	
		modelFileTextLabel = new Label(groupContent, SWT.NONE);
		modelFileTextLabel.setText("Model file: ");
		
		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(modelFileText, "EMF models in the workspace", "Select an EMF model"));

		patternsFileTextLabel = new Label(groupContent, SWT.NONE);
		patternsFileTextLabel.setText("Patterns: ");
		
		patternsFileText = new Text(groupContent, SWT.BORDER);
		patternsFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browsePatternsFile = new Button(groupContent, SWT.NONE);
		browsePatternsFile.setText("Browse Workspace...");
		browsePatternsFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(patternsFileText, "IncQuery patterns in the workspace", "Select an IncQuery pattern file"));

		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}

	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		modelFileText.setText(properties.getProperty(IncQueryModel.PROPERTY_MODEL_FILE));
		patternsFileText.setText(properties.getProperty(IncQueryModel.PROPERTY_PATTERNS_FILE));
	}
	
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(IncQueryModel.PROPERTY_PATTERNS_FILE, patternsFileText.getText());
		properties.put(IncQueryModel.PROPERTY_MODEL_FILE, modelFileText.getText());
	}
}
