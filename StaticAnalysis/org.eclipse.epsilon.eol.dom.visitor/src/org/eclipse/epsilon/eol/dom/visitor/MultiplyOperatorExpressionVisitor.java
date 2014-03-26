package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class MultiplyOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(MultiplyOperatorExpression multiplyOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (MultiplyOperatorExpression multiplyOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
