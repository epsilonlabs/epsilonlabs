package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class BooleanExpressionVisitor<T, R> {
	
	public boolean appliesTo(BooleanExpression booleanExpression, T context) {
		return true;
	}
	
	public abstract R visit (BooleanExpression booleanExpression, T context, EolVisitorController<T, R> controller);
	
}
