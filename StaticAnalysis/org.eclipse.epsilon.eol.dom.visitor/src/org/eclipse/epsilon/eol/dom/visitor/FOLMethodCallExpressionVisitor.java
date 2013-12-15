package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class FOLMethodCallExpressionVisitor<T, R> {
	
	public boolean appliesTo(FOLMethodCallExpression fOLMethodCallExpression, T context) {
		return true;
	}
	
	public abstract R visit (FOLMethodCallExpression fOLMethodCallExpression, T context, EolVisitorController<T, R> controller);
	
}
