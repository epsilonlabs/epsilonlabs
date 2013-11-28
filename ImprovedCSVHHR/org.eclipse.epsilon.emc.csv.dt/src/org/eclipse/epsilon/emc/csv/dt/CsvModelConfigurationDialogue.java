/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.csv.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.emc.csv.CsvModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CsvModelConfigurationDialogue extends AbstractCachedModelConfigurationDialog {

	private Text fileText;
	private Text fieldSeparatorText;
	private Button knownHeadersBtn;
	private Button varargsHeadersBtn;
	
	@Override
	protected String getModelName() {
		return "CSV model";
	}

	@Override
	protected String getModelType() {
		return "CSV";
	}

	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFileGroup(control);
	}

	private void createFileGroup(Composite parent) {
		final Composite group = createGroupContainer(parent, "Files", 3);
		
		final Label modelFileLabel = new Label(group, SWT.NONE);
		modelFileLabel.setText("Model file: ");
		
		fileText = new Text(group, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		final Button browseFile = new Button(group, SWT.NONE);
		browseFile.setText("Browse Workspace...");
		browseFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(fileText, "CSV files in the workspace", "Select a CSV file"));
		
		final Label modelFieldSeparatorLabel = new Label(group, SWT.NONE);
		modelFieldSeparatorLabel.setText("Field Separator: ");
		
		fieldSeparatorText = new Text(group, SWT.BORDER);
		fieldSeparatorText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		
		knownHeadersBtn = new Button(group, SWT.CHECK);
		knownHeadersBtn.setText("Known Headers");
		varargsHeadersBtn = new Button(group, SWT.CHECK);
		varargsHeadersBtn.setText("Vararg Headers");
	}

	@Override
	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		fileText.setText(properties.getProperty(CsvModel.PROPERTY_FILE));
		fieldSeparatorText.setText(properties.getProperty(CsvModel.PROPERTY_FIELD_SEPARATOR));
		knownHeadersBtn.setSelection(properties.getBooleanProperty(CsvModel.PROPERTY_HAS_KNOWN_HEADERS, true));
		varargsHeadersBtn.setSelection(properties.getBooleanProperty(CsvModel.PROPERTY_HAS_VARARGS_HEADERS, false));
	}

	@Override
	protected void storeProperties() {
		super.storeProperties();
		properties.setProperty(CsvModel.PROPERTY_FILE, fileText.getText());
		properties.setProperty(CsvModel.PROPERTY_FIELD_SEPARATOR, fieldSeparatorText.getText());
		properties.setProperty(CsvModel.PROPERTY_HAS_KNOWN_HEADERS, String.valueOf(knownHeadersBtn.getSelection()));
		properties.setProperty(CsvModel.PROPERTY_HAS_VARARGS_HEADERS, String.valueOf(varargsHeadersBtn.getSelection()));
	}
}
