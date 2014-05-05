package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.metamodel.*;

public class SelfInnerMostTypeCreator extends PseudoTypeCreator{
	@Override
	public Type create(Ast2EolContext context) {
		return context.getEolFactory().createSelfInnermostType();
	}

	@Override
	public String getType() {
		return "SelfInnerMostType";
	}
}
