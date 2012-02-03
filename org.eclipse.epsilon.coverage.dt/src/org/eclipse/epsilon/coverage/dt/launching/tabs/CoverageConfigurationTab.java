/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     James Williams - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.coverage.dt.launching.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.coverage.dt.CoverageAnalysisDtPlugin;
import org.eclipse.epsilon.coverage.dt.launching.CoverageConfigurationAttributes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class CoverageConfigurationTab extends AbstractLaunchConfigurationTab{
	
	private Button enableCoverageListenerButton = null;
	
	private Button ruleCoverageButton = null;
	private Button statementCoverageButton = null;
	private Button operationCoverageButton = null;
	private Button decisionCoverageButton = null;
	private Button conditionCoverageButton = null;
	
	private Button printSummaryButton = null;
	private Button printDetailButton = null;
	
	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		control.setLayout(new GridLayout(1, false));		
		
		createCoverageSwitch(control);
		createCoverageAnalysisComponent(control);
		createLoggingComponent(control);
		
		control.pack();
		control.layout();
		
		canSave();
	}
	
	private void createCoverageSwitch(Composite parent) {
		enableCoverageListenerButton = createCheckbox(parent, "Enable coverage analysis", null);
	}
	
	private void createCoverageAnalysisComponent(Composite parent) {
		Group group = new Group(parent, SWT.FILL);
		group.setLayout(new GridLayout(1, false));	
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText("Analysis");
		
		Composite comp = new Composite(group, SWT.FILL);
		comp.setLayout(new GridLayout(1, false));	
		
		ruleCoverageButton = createCheckbox(comp, "Rule coverage", enableCoverageListenerButton);
		statementCoverageButton = createCheckbox(comp, "Statement coverage", enableCoverageListenerButton);
		operationCoverageButton = createCheckbox(comp, "Operation coverage", enableCoverageListenerButton);
		decisionCoverageButton = createCheckbox(comp, "Decision coverage", enableCoverageListenerButton);
		conditionCoverageButton = createCheckbox(comp, "Condition coverage", enableCoverageListenerButton);
		
		ruleCoverageButton.setEnabled(false);
		statementCoverageButton.setEnabled(false);
		operationCoverageButton.setEnabled(false);
		decisionCoverageButton.setEnabled(false);
		conditionCoverageButton.setEnabled(false);
	}
	
	private void createLoggingComponent(Composite parent) {
		Group group = new Group(parent, SWT.FILL);
		group.setLayout(new GridLayout(1, false));	
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setText("Logging");
		
		Composite comp = new Composite(group, SWT.FILL);
		comp.setLayout(new GridLayout(1, false));	
		
		printSummaryButton = createCheckbox(comp, "Print summary coverage report", enableCoverageListenerButton);
		printDetailButton = createCheckbox(comp, "Print detailed coverage report", enableCoverageListenerButton);
		printSummaryButton.setEnabled(false);
		printDetailButton.setEnabled(false);
	}

	
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		
	}
	
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			boolean coverageEnabled = configuration.getAttribute(CoverageConfigurationAttributes.COVERAGE_ENABLED, false);
			enableCoverageListenerButton.setSelection(coverageEnabled);
			
			ruleCoverageButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.COVER_RULES, true));
			statementCoverageButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.COVER_STATEMENTS, true));
			operationCoverageButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.COVER_OPERATIONS, true));
			decisionCoverageButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.COVER_DECISIONS, true));
			conditionCoverageButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.COVER_CONDITIONS, true));
			printSummaryButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.PRINT_COVERAGE_SUMMARY, true));
			printDetailButton.setSelection(configuration.getAttribute(CoverageConfigurationAttributes.PRINT_COVERAGE_DETAILED, true));
			
			ruleCoverageButton.setEnabled(coverageEnabled);
			statementCoverageButton.setEnabled(coverageEnabled);
			decisionCoverageButton.setEnabled(coverageEnabled);
			operationCoverageButton.setEnabled(coverageEnabled);
			conditionCoverageButton.setEnabled(coverageEnabled);
			printSummaryButton.setEnabled(coverageEnabled);
			printDetailButton.setEnabled(coverageEnabled);
			
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		boolean coverageEnabled = enableCoverageListenerButton.getSelection();
		configuration.setAttribute(CoverageConfigurationAttributes.COVERAGE_ENABLED, coverageEnabled);
		
		if (coverageEnabled) {
			configuration.setAttribute(CoverageConfigurationAttributes.COVER_RULES, ruleCoverageButton.getSelection());
			configuration.setAttribute(CoverageConfigurationAttributes.COVER_STATEMENTS, statementCoverageButton.getSelection());
			configuration.setAttribute(CoverageConfigurationAttributes.COVER_OPERATIONS, operationCoverageButton.getSelection());
			configuration.setAttribute(CoverageConfigurationAttributes.COVER_DECISIONS, decisionCoverageButton.getSelection());
			configuration.setAttribute(CoverageConfigurationAttributes.COVER_CONDITIONS, conditionCoverageButton.getSelection());
			configuration.setAttribute(CoverageConfigurationAttributes.PRINT_COVERAGE_SUMMARY, printSummaryButton.getSelection());
			configuration.setAttribute(CoverageConfigurationAttributes.PRINT_COVERAGE_DETAILED, printDetailButton.getSelection());
		}
	}

	public String getName() {
		return "Coverage";
	}
	
	@Override
	public Image getImage() {
		return CoverageAnalysisDtPlugin.createImage("icons/profiling.png");
	}
	
	@Override
	public boolean canSave(){
		setErrorMessage(null);
		return true;
	}
	
	private Button createCheckbox(Composite parent, String text, final Button parentCheckBox) {
		final Button button = new Button(parent, SWT.CHECK);
		button.setText(text);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		if (parentCheckBox != null) {
			gridData.horizontalIndent = 8;
			parentCheckBox.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					button.setSelection(parentCheckBox.getSelection());
					button.setEnabled(parentCheckBox.getSelection());
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}
			});
		}
		
		button.setLayoutData(gridData);
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		return button;
	}
	
}
