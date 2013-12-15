package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class BooleanTypeCreator extends PrimitiveTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createBooleanType();
	}

	@Override
	public String getType() {
		return "Boolean";
	}

}
