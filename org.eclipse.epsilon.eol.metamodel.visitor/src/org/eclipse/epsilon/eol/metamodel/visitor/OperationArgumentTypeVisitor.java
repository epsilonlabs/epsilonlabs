package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class OperationArgumentTypeVisitor<T, R> {
	
	public boolean appliesTo(OperationArgumentType operationArgumentType, T context) {
		return true;
	}
	
	public abstract R visit (OperationArgumentType operationArgumentType, T context, EolVisitorController<T, R> controller);
	
}
