package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class MethodCallExpressionVisitor<T, R> {
	
	public boolean appliesTo(MethodCallExpression methodCallExpression, T context) {
		return true;
	}
	
	public abstract R visit (MethodCallExpression methodCallExpression, T context, EolVisitorController<T, R> controller);
	
}
