package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.metamodel.*;

public class SelfContentTypeCreator extends PseudoTypeCreator{

	@Override
	public Type create(Ast2EolContext context) {
		return context.getEolFactory().createSelfContentType();
	}

	@Override
	public String getType() {
		return "SelfContentType";
	}
}
