package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class StringTypeCreator extends PrimitiveTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createStringType();
	}

	@Override
	public String getType() {
		return "String";
	}

}
