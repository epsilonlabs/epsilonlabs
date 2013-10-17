/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.mdr.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.launching.dialogs.BrowseWorkspaceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class MdrModelConfigurationDialog extends AbstractModelConfigurationDialog {
	
	private Text extentText;
	private Button isMetaModelButton;
	private Button browseModelFile;
	private Text metaModelFileText;
	private Button browseMetaModelFile;
	private Text modelFileText;
	private Label metaModelFileLabel;
	private Label modelFileLabel;
	private Label extentLabel;
	
	public MdrModelConfigurationDialog(){
		super();
	}

	@Override
	protected void setShellStyle(int newShellStyle) {
		super.setShellStyle(newShellStyle | SWT.RESIZE);
	}
	
	@Override
	protected String getModelName() {
		return "MDR model";
	}
	
	@Override
	protected void createGroups(Composite control) {
		createNameAliasGroup(control);
		createMdrGroup(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	
	protected void createMdrGroup(Composite parent) {
		Group group = new Group(parent, SWT.FILL);
		
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText("MDR");
		group.setLayout(new GridLayout(1,false));
		
		Composite groupContent = new Composite(group, SWT.FILL);
		groupContent.setLayout(new GridLayout(3, false));
		groupContent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		extentLabel = new Label(groupContent, SWT.NONE);
		extentLabel.setText("Extent:");
		extentLabel.setLayoutData(new GridData());
		
		extentText = new Text(groupContent, SWT.BORDER);
		extentText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		isMetaModelButton = new Button(groupContent, SWT.CHECK);
		isMetaModelButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		isMetaModelButton.setText("Is Meta-model");
		isMetaModelButton.addListener(SWT.Selection, new IsMetaModelListener());
		
		GridData isMetaModelButtonData = new GridData();
		isMetaModelButtonData.horizontalSpan = 2;
		isMetaModelButton.setLayoutData(isMetaModelButtonData);
		
		groupContent.layout();
		groupContent.pack();
				
	}
	
	protected void createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files", 3);
		
		modelFileLabel = new Label(groupContent, SWT.NONE);
		modelFileLabel.setText("Model : ");
		
		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(modelFileText));
		
		metaModelFileLabel = new Label(groupContent, SWT.NONE);
		metaModelFileLabel.setText("Meta-model : ");
		
		metaModelFileText = new Text(groupContent, SWT.BORDER);
		metaModelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseMetaModelFile = new Button(groupContent, SWT.NONE);
		browseMetaModelFile.setText("Browse Workspace...");
		browseMetaModelFile.addListener(SWT.Selection, new BrowseWorkspaceForMetaModelsListener(metaModelFileText));
		
	}
	
	class IsMetaModelListener implements Listener{

		public void handleEvent(Event event) {
			toggleEnabledFields();
		}
		
	}
	
	class BrowseWorkspaceForModelsListener implements Listener{
		
		private Text text = null;
		
		public BrowseWorkspaceForModelsListener(Text text){
			this.text = text;
		}
		
		public void handleEvent(Event event) {
			String file = BrowseWorkspaceUtil.browseFilePath(getShell(), 
					"MDR models in the workspace", "Select an MDR model", "xmi", null);
			if (file != null){
				text.setText(file);
			}
		}
	}

	class BrowseWorkspaceForMetaModelsListener implements Listener{
		
		private Text text = null;
		
		public BrowseWorkspaceForMetaModelsListener(Text text){
			this.text = text;
		}
		
		public void handleEvent(Event event) {
			String file = BrowseWorkspaceUtil.browseFilePath(getShell(), 
					"MDR meta-models in the workspace", "Select an MDR meta-model", "xmi", null);
			if (file != null){
				text.setText(file);
			}
		}
	}
	
	@Override
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		modelFileText.setText(properties.getProperty("modelFile"));
		metaModelFileText.setText(properties.getProperty("metamodelFile"));
		isMetaModelButton.setSelection(new Boolean(properties.getProperty("isMetamodel")).booleanValue());
		extentText.setText(properties.getProperty("extent"));
		toggleEnabledFields();
	}
	
	@Override
	protected void storeProperties(){
		super.storeProperties();
		properties.put("modelFile", modelFileText.getText());
		properties.put("metamodelFile", metaModelFileText.getText());
		properties.put("isMetamodel", isMetaModelButton.getSelection() + "");
		properties.put("extent", extentText.getText());
		properties.put("isModelFileRelative", "true");
		properties.put("isMetamodelFileRelative", "true");
	}
	
	protected void toggleEnabledFields(){
		boolean enabled = !isMetaModelButton.getSelection();
		modelFileText.setEnabled(enabled);
		modelFileLabel.setEnabled(enabled);
		browseModelFile.setEnabled(enabled);
		extentText.setEnabled(enabled);
		extentLabel.setEnabled(enabled);
	}
	
	@Override
	protected String getModelType() {
		return "MDR";
	}
}
