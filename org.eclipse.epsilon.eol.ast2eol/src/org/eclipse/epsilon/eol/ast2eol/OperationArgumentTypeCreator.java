package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.*;

public class OperationArgumentTypeCreator extends PseudoTypeCreator{
	@Override
	public Type create(Ast2EolContext context) {
		return context.getEolFactory().createOperationArgumentType();
	}

	@Override
	public String getType() {
		return "OperationArgumentType";
	}
}
