package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class RealTypeCreator extends PrimitiveTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createRealType();
	}
	@Override
	public String getType() {
		return "Real";
	}

}
