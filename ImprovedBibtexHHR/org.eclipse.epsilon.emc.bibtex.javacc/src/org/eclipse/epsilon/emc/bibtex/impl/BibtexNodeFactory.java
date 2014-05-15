/*******************************************************************************
 * Copyright (c) 2013 Horacio Hoyos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.bibtex.impl;

import org.eclipse.epsilon.emc.bibtex.BibtexFactory;
import org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexFactory;
import org.eclipse.epsilon.emc.bibtex.parser.BibtexParserTreeConstants;
import org.eclipse.epsilon.emc.bibtex.parser.Node;

public class BibtexNodeFactory implements BibtexParserTreeConstants {
	
	
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
		case JJTAUTHORTAG:
			node = factory.createAuthorTag();
			break;
		case JJTVOID:
			break;
		
		}
		return node;
	}

}
