package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.*;

public class SelfInnerMostContentTypeCreator extends PseudoTypeCreator{
	@Override
	public Type create(Ast2EolContext context) {
		return context.getEolFactory().createSelfInnermostContentType();
	}

	@Override
	public String getType() {
		return "SelfInnerMostContentType";
	}
}
