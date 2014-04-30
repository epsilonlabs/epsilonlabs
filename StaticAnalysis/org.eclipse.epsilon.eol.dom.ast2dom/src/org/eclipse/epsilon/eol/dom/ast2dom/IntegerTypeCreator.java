package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;


public class IntegerTypeCreator extends PrimitiveTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createIntegerType();
	}

	@Override
	public String getType() {
		return "Integer";
	}


}
