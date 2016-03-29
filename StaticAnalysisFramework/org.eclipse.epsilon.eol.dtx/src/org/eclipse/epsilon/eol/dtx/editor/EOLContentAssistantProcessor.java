package org.eclipse.epsilon.eol.dtx.editor;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.content.assist.context.EOLContentAssistContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class EOLContentAssistantProcessor implements IContentAssistProcessor{

	EOLContentAssistContext context = new EOLContentAssistContext();
	
	protected String extractPrefix(ITextViewer viewer, int offset) {
		int i= offset;
		IDocument document= viewer.getDocument();
		if (i > document.getLength())
			return ""; //$NON-NLS-1$

		try {
			while (i > 0) {
				char ch= document.getChar(i - 1);
				if (!Character.isJavaIdentifierPart(ch))
					break;
				i--;
			}

			return document.get(i, offset - i);
		} catch (BadLocationException e) {
			return ""; //$NON-NLS-1$
		}
	}
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		
		String prefix = extractPrefix(viewer, offset);
		
		
		ArrayList<String> proposals = context.getKeywordsBy(prefix);
		ICompletionProposal[] result= new ICompletionProposal[proposals.size()];
		for (int i= 0; i < proposals.size(); i++) {
			//IContextInformation info = new ContextInformation(proposals.get(i), "") ;
			result[i] = new CompletionProposal(proposals.get(i), offset-prefix.length(), prefix.length(), proposals.get(i).length());
		}
		return result;
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return new char[] { '.', '"' };
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}


}
