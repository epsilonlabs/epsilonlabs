package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ExpressionVisitor<T, R> {
	
	public boolean appliesTo(Expression expression, T context) {
		return true;
	}
	
	public abstract R visit (Expression expression, T context, EolVisitorController<T, R> controller);
	
}
