package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class IntegerExpressionVisitor<T, R> {
	
	public boolean appliesTo(IntegerExpression integerExpression, T context) {
		return true;
	}
	
	public abstract R visit (IntegerExpression integerExpression, T context, EolVisitorController<T, R> controller);
	
}
