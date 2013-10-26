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
import org.eclipse.swt.widgets.Label;
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
	protected Label profileWorkspaceDirectoriesLabel;
	protected Text profileWorkspaceDirectoriesText;
	protected Button browseModelFile;
	protected Button ignoreArgoUmlProfiles;
	
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createProfilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	protected Composite createProfilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Profiles", 3);
		
		ignoreArgoUmlProfiles = new Button(groupContent, SWT.CHECK);
		GridData filebasedButtonGridData = new GridData(GridData.FILL_HORIZONTAL);
		filebasedButtonGridData.horizontalSpan = 3;
		ignoreArgoUmlProfiles.setSelection(false);
		ignoreArgoUmlProfiles.setText("Ignore ArgoUML's profile directories");
		ignoreArgoUmlProfiles.setToolTipText("Ignores ArgoUML's configured profile directories");
		ignoreArgoUmlProfiles.setLayoutData(filebasedButtonGridData);
		
		profileDirectoriesLabel = new Label(groupContent, SWT.NONE);
		profileDirectoriesLabel.setText("Filesystem profile directories: ");
		profileDirectoriesLabel.setToolTipText("Filesystem directories in which the driver should search for available profiles. Split multiple directories with ;");
		
		profileDirectoriesText = new Text(groupContent, SWT.BORDER);
		GridData uriTextGridData = new GridData(GridData.FILL_HORIZONTAL);
		uriTextGridData.horizontalSpan = 2;
		profileDirectoriesText.setLayoutData(uriTextGridData);
		
		profileWorkspaceDirectoriesLabel = new Label(groupContent, SWT.NONE);
		profileWorkspaceDirectoriesLabel.setText("Workspace profile directories: ");
		profileWorkspaceDirectoriesLabel.setToolTipText("Workspace directories in which the driver should search for available profiles. Split multiple directories with ;");
		
		profileWorkspaceDirectoriesText = new Text(groupContent, SWT.BORDER);
		uriTextGridData.horizontalSpan = 2;
		profileWorkspaceDirectoriesText.setLayoutData(uriTextGridData);
		
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
		profileWorkspaceDirectoriesText.setText(properties.getProperty(ArgoUMLModel.PROPERTY_PROFILE_WORKSPACE_DIRECTORIES));
		ignoreArgoUmlProfiles.setSelection(properties.getBooleanProperty(ArgoUMLModel.PROPERTY_IGNORE_ARGOUML_PROFILE_DIRECTORIES, false));
	}
	
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(ArgoUMLModel.PROPERTY_PROFILE_DIRECTORIES, profileDirectoriesText.getText());
		properties.put(ArgoUMLModel.PROPERTY_PROFILE_WORKSPACE_DIRECTORIES, profileWorkspaceDirectoriesText.getText());
		properties.put(ArgoUMLModel.PROPERTY_MODEL_FILE, fileText.getText());
		properties.put(ArgoUMLModel.PROPERTY_IGNORE_ARGOUML_PROFILE_DIRECTORIES, ignoreArgoUmlProfiles.getSelection() + "");
	}
}
