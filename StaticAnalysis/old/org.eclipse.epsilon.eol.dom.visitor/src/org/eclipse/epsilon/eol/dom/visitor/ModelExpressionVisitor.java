package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ModelExpressionVisitor<T, R> {
	
	public boolean appliesTo(ModelExpression modelExpression, T context) {
		return true;
	}
	
	public abstract R visit (ModelExpression modelExpression, T context, EolVisitorController<T, R> controller);
	
}
