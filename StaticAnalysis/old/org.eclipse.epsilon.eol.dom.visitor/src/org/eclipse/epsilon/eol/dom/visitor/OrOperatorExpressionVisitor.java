package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class OrOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(OrOperatorExpression orOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (OrOperatorExpression orOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
