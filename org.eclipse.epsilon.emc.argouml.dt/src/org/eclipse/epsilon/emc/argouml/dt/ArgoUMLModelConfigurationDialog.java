/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.argouml.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.emc.argouml.ArgoUMLModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ArgoUMLModelConfigurationDialog extends AbstractCachedModelConfigurationDialog {

	
	protected String getModelName() {
		return "ArgoUML Model";
	}

	
	protected String getModelType() {
		return "ArgoUML";
	}
	
	protected Label fileTextLabel;
	protected Text fileText;
	protected Label profileDirectoriesLabel;
	protected Text profileDirectoriesText;
	protected Button browseModelFile;
	protected Button overrideProfilesButton;
	
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createProfilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	protected Composite createProfilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Profiles", 3);
		
		overrideProfilesButton = new Button(groupContent, SWT.CHECK);
		GridData filebasedButtonGridData = new GridData(GridData.FILL_HORIZONTAL);
		filebasedButtonGridData.horizontalSpan = 3;
		overrideProfilesButton.setSelection(false);
		overrideProfilesButton.setText("Override ArgoUML's profile directories");
		overrideProfilesButton.setToolTipText("Overrides ArgoUML's configured profile directories");
		overrideProfilesButton.setLayoutData(filebasedButtonGridData);
		
		profileDirectoriesLabel = new Label(groupContent, SWT.NONE);
		profileDirectoriesLabel.setText("Profile directories: ");
		profileDirectoriesLabel.setToolTipText("Directories in which the driver should search for available profiles. Split multiple directories with ;");
		
		profileDirectoriesText = new Text(groupContent, SWT.BORDER);
		GridData uriTextGridData = new GridData(GridData.FILL_HORIZONTAL);
		uriTextGridData.horizontalSpan = 2;
		profileDirectoriesText.setLayoutData(uriTextGridData);
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
		
		fileTextLabel = new Label(groupContent, SWT.NONE);
		fileTextLabel.setText("File: ");
		
		fileText = new Text(groupContent, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(fileText, "XML Documents in the workspace", "Select an XML document"));
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}

	
	
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		fileText.setText(properties.getProperty(ArgoUMLModel.PROPERTY_MODEL_FILE));
		profileDirectoriesText.setText(properties.getProperty(ArgoUMLModel.PROPERTY_PROFILE_DIRECTORIES));
		overrideProfilesButton.setSelection(properties.getBooleanProperty(ArgoUMLModel.PROPERTY_OVERRIDE_PROFILE_DIRECTORIES, false));
		//toggleEnabledFields();
	}
	
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(ArgoUMLModel.PROPERTY_PROFILE_DIRECTORIES, profileDirectoriesText.getText());
		properties.put(ArgoUMLModel.PROPERTY_MODEL_FILE, fileText.getText());
		properties.put(ArgoUMLModel.PROPERTY_OVERRIDE_PROFILE_DIRECTORIES, overrideProfilesButton.getSelection() + "");
	}
}
