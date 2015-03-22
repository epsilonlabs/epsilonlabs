package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class LiteralExpressionVisitor<T, R> {
	
	public boolean appliesTo(LiteralExpression literalExpression, T context) {
		return true;
	}
	
	public abstract R visit (LiteralExpression literalExpression, T context, EolVisitorController<T, R> controller);
	
}
