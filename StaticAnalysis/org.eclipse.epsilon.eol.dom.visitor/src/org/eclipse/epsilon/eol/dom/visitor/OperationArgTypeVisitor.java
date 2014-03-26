package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class OperationArgTypeVisitor<T, R> {
	
	public boolean appliesTo(OperationArgType operationArgType, T context) {
		return true;
	}
	
	public abstract R visit (OperationArgType operationArgType, T context, EolVisitorController<T, R> controller);
	
}
