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

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.emc.bibtex.BibtexModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;


public class BibtexModelConfigurationDialogue extends AbstractCachedModelConfigurationDialog {

	private static final String PROPERTY_MODEL_URI = BibtexModel.PROPERTY_MODEL_URI;
	private static final String CAPITALIZED_TYPE = BibtexModel.CAPITALIZED_TYPE;
	private static final String SORT_BY_KEY = BibtexModel.SORT_BY_KEY;
	private static final String PREFERRED_ACCENT = BibtexModel.PREFERRED_ACCENT;

	protected Text modelFileText;

	protected Button capitalizedTypeNameBtn;

	private Button sortByKeyBtn;

	private Button preferredAccentsBtn;
	
	private Composite bibtexGroup;
	
	
	@Override
	protected String getModelName() {
		return "Bibtex model";
	}
	
	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
		createFormatingGroup(control);
		bibtexGroup.setEnabled(false);
		for (Control c : bibtexGroup.getChildren())
	         c.setEnabled(false);
		
		// TODO Hook storeOnDisposalCheckbox to enable formatting options
		storeOnDisposalCheckbox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean selection = storeOnDisposalCheckbox.getSelection();
				bibtexGroup.setEnabled(selection);
				for (Control c : bibtexGroup.getChildren())
			         c.setEnabled(selection);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		String stringURI = properties.getProperty(PROPERTY_MODEL_URI);
		URI platformURI = URI.createURI(stringURI);
		String fileText = "";
		if (platformURI.isPlatform())
			fileText =  platformURI.toPlatformString(false);
		modelFileText.setText(fileText);
		capitalizedTypeNameBtn.setSelection(properties.getBooleanProperty(CAPITALIZED_TYPE, false));
		sortByKeyBtn.setSelection(properties.getBooleanProperty(SORT_BY_KEY, false));
		preferredAccentsBtn.setSelection(properties.getBooleanProperty(PREFERRED_ACCENT, false));
	}
	
	@Override
	protected void storeProperties(){
		super.storeProperties();
		properties.put(PROPERTY_MODEL_URI, URI.createPlatformResourceURI(modelFileText.getText(), false));
		properties.put(CAPITALIZED_TYPE, capitalizedTypeNameBtn.getSelection());
		properties.put(SORT_BY_KEY, sortByKeyBtn.getSelection());
		properties.put(PREFERRED_ACCENT, preferredAccentsBtn.getSelection());
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
	
	protected void createFormatingGroup(Composite parent) {
		bibtexGroup = createGroupContainer(parent, "Bibtex Format", 4);
		capitalizedTypeNameBtn = new Button(bibtexGroup, SWT.CHECK);
		capitalizedTypeNameBtn.setText("Use Capitals for Publication type");
		sortByKeyBtn = new Button(bibtexGroup, SWT.CHECK);
		sortByKeyBtn.setText("Sort entries by key");
		preferredAccentsBtn = new Button(bibtexGroup, SWT.CHECK);
		preferredAccentsBtn.setText("Use preferred accent mode");
		preferredAccentsBtn.setToolTipText("Use the preferred \\'{o} instead of \\'o for accents.");
		
	}
}