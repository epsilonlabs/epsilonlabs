package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class OperationArgTypeCreator extends PseudoTypeCreator{
	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createOperationArgType();
	}

	@Override
	public String getType() {
		return "OperationArgType";
	}
}
