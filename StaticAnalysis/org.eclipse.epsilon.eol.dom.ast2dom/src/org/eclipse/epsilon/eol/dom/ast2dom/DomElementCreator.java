package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;

public abstract class DomElementCreator {

	public abstract DomElement create(AST ast, DomElement container, Ast2DomContext context);
}
