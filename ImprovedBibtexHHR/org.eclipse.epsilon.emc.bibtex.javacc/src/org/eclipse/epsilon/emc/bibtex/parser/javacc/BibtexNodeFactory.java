package org.eclipse.epsilon.emc.bibtex.parser.javacc;

import org.eclipse.epsilon.emc.bibtex.BibtexFactory;
import org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexFactory;

public class BibtexNodeFactory implements BibtexTreeConstants {
	
	
	public static Node jjtCreate(int id) {
		
		Node node = null;
		BibtexFactory factory = BibtexBibtexFactory.eINSTANCE;
		switch(id) {
		case JJTBIBLIOGRAPHY:
			node = factory.createBibliography();
			break;
		case JJTCOMMENT:
			node = factory.createComment();
			break;
		case JJTPREAMBLE:
			node = factory.createPreamble();
			break;
		case JJTSTRINGENTRY:
			node = factory.createStringEntry();
			break;
		case JJTPUBLICATIONENTRY:
			node = factory.createPublicationEntry();
			break;
		case JJTTAG:
			node = factory.createTag();
			break;
		case JJTVOID:
			break;
		
		}
		return node;
	}

}
