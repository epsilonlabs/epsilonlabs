package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class GreaterThanOrEqualToOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(GreaterThanOrEqualToOperatorExpression greaterThanOrEqualToOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (GreaterThanOrEqualToOperatorExpression greaterThanOrEqualToOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
