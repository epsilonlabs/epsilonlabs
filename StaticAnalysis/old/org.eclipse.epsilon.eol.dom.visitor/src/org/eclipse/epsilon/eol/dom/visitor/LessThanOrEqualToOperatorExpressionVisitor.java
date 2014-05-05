package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class LessThanOrEqualToOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(LessThanOrEqualToOperatorExpression lessThanOrEqualToOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (LessThanOrEqualToOperatorExpression lessThanOrEqualToOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
