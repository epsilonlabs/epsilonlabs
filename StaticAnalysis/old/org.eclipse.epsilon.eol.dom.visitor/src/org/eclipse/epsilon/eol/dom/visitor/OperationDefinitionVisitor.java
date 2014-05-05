package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class OperationDefinitionVisitor<T, R> {
	
	public boolean appliesTo(OperationDefinition operationDefinition, T context) {
		return true;
	}
	
	public abstract R visit (OperationDefinition operationDefinition, T context, EolVisitorController<T, R> controller);
	
}
