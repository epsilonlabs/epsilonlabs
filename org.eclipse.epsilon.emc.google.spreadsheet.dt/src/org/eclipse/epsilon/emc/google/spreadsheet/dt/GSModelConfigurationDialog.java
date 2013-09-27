/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martins Francis - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.google.spreadsheet.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.google.spreadsheet.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;

public class GSModelConfigurationDialog extends AbstractModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "Google Spreadsheet";
	}

	@Override
	protected String getModelType() {
		return "GoogleSpreadsheet";
	}
		
	protected Label usernameLabel;
	protected Text usernameText;
	protected Label passwordLabel;
	protected Text passwordText;
	protected Label spreadsheetNameLabel;
	protected Text spreadsheetNameText;
	protected Label configFileTextLabel;
	protected Text configFileText;
	protected Button browseConfigFile;
	
	@Override
	protected void createGroups(Composite control) {
		createNameAliasGroup(control);
		createConnectionGroup(control);
		createSpreadsheetGroup(control);
		createConfigurationFileGroup(control);
	}
	
	protected void createConnectionGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Connection Parameters", 2);
		
		usernameLabel = new Label(groupContent, SWT.NONE);
		usernameLabel.setText("Username: ");
		
		usernameText = new Text(groupContent, SWT.BORDER);
		usernameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		passwordLabel = new Label(groupContent, SWT.NONE);
		passwordLabel.setText("Password: ");
		
		passwordText = new Text(groupContent, SWT.PASSWORD | SWT.BORDER);
		passwordText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		groupContent.layout();
		groupContent.pack();
	}
	
	protected void createSpreadsheetGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Spreadsheet Details", 2);
		
		spreadsheetNameLabel = new Label(groupContent, SWT.NONE);
		spreadsheetNameLabel.setText("Name: ");
		
		spreadsheetNameText = new Text(groupContent, SWT.BORDER);
		spreadsheetNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		groupContent.layout();
		groupContent.pack();
	}
	
	protected void createConfigurationFileGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "ORM Meta-data", 3);
		
		configFileTextLabel = new Label(groupContent, SWT.NONE);
		configFileTextLabel.setText("File: ");
		
		configFileText = new Text(groupContent, SWT.BORDER);
		configFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseConfigFile = new Button(groupContent, SWT.NONE);
		browseConfigFile.setText("Browse Workspace...");
		browseConfigFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(configFileText, "XML meta-data file in the workspace", "Select an XML Meta-data File"));
		
		groupContent.layout();
		groupContent.pack();
	}
	
	@Override
	protected void loadProperties() {
		super.loadProperties();
		
		if (properties != null) {
			this.usernameText.setText(properties.getProperty(GSModel.USERNAME));
			
			// Get password from the vault
			SecureGSModel secModel = new SecureGSModel();
			try {
				this.passwordText.setText(secModel.loadPassword(properties));
			} catch (StorageException e) {
				throw new RuntimeException("Unable to retrieve the password from Equinox Security vault.");
			}
			
	        this.spreadsheetNameText.setText(properties.getProperty(SpreadsheetModel.SPREADSHEET_NAME));
			this.configFileText.setText(properties.getProperty(GSModel.CONFIGURATION_FILE));
		}
	}
	
	@Override
	protected void storeProperties() {
		super.storeProperties();
		super.properties.put(GSModel.USERNAME, this.usernameText.getText());
		
		// Store the password in vault
		ISecurePreferences preferences = SecurePreferencesFactory.getDefault();
        ISecurePreferences node = preferences.node(this.usernameText.getText()); // Password associated with the username
        try {
            node.put(GSModel.PASSWORD, this.passwordText.getText(), true);
        } catch (StorageException e1) {
            e1.printStackTrace();
            throw new RuntimeException("Equinox Security was unable to store the Google account password.");
        }
		
        super.properties.put(SpreadsheetModel.SPREADSHEET_NAME, this.spreadsheetNameText.getText());
		super.properties.put(GSModel.CONFIGURATION_FILE, this.configFileText.getText());
	}
	
}
