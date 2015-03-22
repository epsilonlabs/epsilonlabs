package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class ModelExpressionVisitor<T, R> {
	
	public boolean appliesTo(ModelExpression modelExpression, T context) {
		return true;
	}
	
	public abstract R visit (ModelExpression modelExpression, T context, EolVisitorController<T, R> controller);
	
}
