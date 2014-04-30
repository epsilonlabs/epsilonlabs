package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class SelfContentTypeCreator extends PseudoTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createSelfContentType();
	}

	@Override
	public String getType() {
		return "SelfContentType";
	}
}
