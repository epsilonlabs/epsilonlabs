/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.bibtex.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.emc.bibtex.BibtexModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class BibtexModelConfigurationDialogue extends AbstractCachedModelConfigurationDialog {

	private static final String PROPERTY_MODEL_URI = BibtexModel.PROPERTY_MODEL_URI;

	private Text modelFileText;
	
	
	@Override
	protected String getModelName() {
		return "Bibtex model";
	}
	
	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	@Override
	protected String getModelType() {
		return "Bibtex";
	}
	
	@Override
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;

		// Restore values from legacy launch configuration
		modelFileText.setText(properties.getProperty(PROPERTY_MODEL_URI));
	}
	
	@Override
	protected void storeProperties(){
		super.storeProperties();

		properties.put(PROPERTY_MODEL_URI, modelFileText.getText());
	}

	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
		((GridData)groupContent.getParent().getLayoutData()).grabExcessVerticalSpace = true;

		final Label modelFileLabel = new Label(groupContent, SWT.NONE);
		modelFileLabel.setText("Model file: ");
		
		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection,
			new BrowseWorkspaceForModelsListener(modelFileText, "Bibtex models in the workspace", "Select a bibtex model") {
			});

		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}	
}