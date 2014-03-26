package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class NewExpressionVisitor<T, R> {
	
	public boolean appliesTo(NewExpression newExpression, T context) {
		return true;
	}
	
	public abstract R visit (NewExpression newExpression, T context, EolVisitorController<T, R> controller);
	
}
