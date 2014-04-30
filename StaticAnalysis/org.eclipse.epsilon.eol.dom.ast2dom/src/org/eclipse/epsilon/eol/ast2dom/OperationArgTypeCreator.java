package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

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
