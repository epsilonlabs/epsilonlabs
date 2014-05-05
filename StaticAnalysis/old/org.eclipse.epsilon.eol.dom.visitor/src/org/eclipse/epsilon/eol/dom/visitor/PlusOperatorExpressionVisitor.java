package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class PlusOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(PlusOperatorExpression plusOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (PlusOperatorExpression plusOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
