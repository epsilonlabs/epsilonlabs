package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class AndOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(AndOperatorExpression andOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (AndOperatorExpression andOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
