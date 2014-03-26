package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class NotEqualsOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(NotEqualsOperatorExpression notEqualsOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (NotEqualsOperatorExpression notEqualsOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
