package org.eclipse.epsilon.eol.dtx.editor;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.eol.dtx.EolXPlugin;
import org.eclipse.epsilon.eol.dtx.editor.outline.EolXOutlinePage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.TextOperationAction;

public class EolxEditor extends EolEditor {
	
	@Override
	public SourceViewerConfiguration createSourceViewerConfiguration() {
		return new EOLSourceViewerConfiguration(this);
	}


	private static final String CONTENTASSIST_PROPOSAL_ID = 
			   "org.eclipse.epsilon.eol.dtx.EolxEditor.ContentAssistProposal"; 
		
	@Override
	protected void createActions() {
		// TODO Auto-generated method stub
		super.createActions();
		IAction action = 
			      new TextOperationAction(new ResourceBundle(){

					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						return null;
					}},
			      "ContentAssistProposal1", this, SourceViewer.CONTENTASSIST_PROPOSALS);
			   action.setActionDefinitionId(CONTENTASSIST_PROPOSAL_ID);

			   // Tell the editor about this new action
			   setAction(CONTENTASSIST_PROPOSAL_ID, action);

			   // Tell the editor to execute this action 
			   // when Ctrl+Spacebar is pressed
			   setActionActivationCode(CONTENTASSIST_PROPOSAL_ID,' ', -1, SWT.SHIFT);
	}
	
	@Override
	public ModuleContentOutlinePage createOutlinePage() {
		EolXOutlinePage outlinePage = new EolXOutlinePage(this.getDocumentProvider(), this, createModuleElementLabelProvider());
		
		addModuleParsedListener(outlinePage);
		
		return outlinePage;
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new ModuleElementLabelProvider() {
			
			@Override
			public String getText(Object element) {
				return element.toString();
			}
			
			@Override
			public Image getImage(Object element) {
				return EolXPlugin.getDefault().createImage("icons/element.gif");
			}
		};
	}
	
	
	
	

}
