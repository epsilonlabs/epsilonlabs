package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class PseudoTypeCreator extends TypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createPseudoType();
	}

	@Override
	public String getType() {
		return "PseudoType";
	}
}
