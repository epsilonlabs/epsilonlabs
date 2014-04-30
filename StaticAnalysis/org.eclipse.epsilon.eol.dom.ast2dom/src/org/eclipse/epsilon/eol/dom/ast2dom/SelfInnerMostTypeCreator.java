package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class SelfInnerMostTypeCreator extends PseudoTypeCreator{
	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createSelfInnermostType();
	}

	@Override
	public String getType() {
		return "SelfInnerMostType";
	}
}
