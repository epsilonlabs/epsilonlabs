package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class AnyTypeCreator extends TypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createAnyType();
	}

	@Override
	public String getType() {
		return "Any";
	}

}
