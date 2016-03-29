package org.eclipse.epsilon.eol.dtx.editor;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditorSourceViewerConfiguration;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;

public class EOLSourceViewerConfiguration extends AbstractModuleEditorSourceViewerConfiguration{

	public EOLSourceViewerConfiguration(AbstractModuleEditor editor) {
		super(editor);
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant assistant = new ContentAssistant();
		
		assistant.setContentAssistProcessor(new EOLContentAssistantProcessor(), IDocument.DEFAULT_CONTENT_TYPE);
		
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);
		assistant.setProposalPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);
		assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);
		return assistant;	
	}
	
	
}
