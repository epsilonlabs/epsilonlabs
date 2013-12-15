package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class EqualsOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(EqualsOperatorExpression equalsOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (EqualsOperatorExpression equalsOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
