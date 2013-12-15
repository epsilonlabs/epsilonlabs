package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class NegativeOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(NegativeOperatorExpression negativeOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (NegativeOperatorExpression negativeOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
