package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class UnaryOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(UnaryOperatorExpression unaryOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (UnaryOperatorExpression unaryOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
