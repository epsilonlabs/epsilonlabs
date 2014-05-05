package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class PrimitiveExpressionVisitor<T, R> {
	
	public boolean appliesTo(PrimitiveExpression primitiveExpression, T context) {
		return true;
	}
	
	public abstract R visit (PrimitiveExpression primitiveExpression, T context, EolVisitorController<T, R> controller);
	
}
