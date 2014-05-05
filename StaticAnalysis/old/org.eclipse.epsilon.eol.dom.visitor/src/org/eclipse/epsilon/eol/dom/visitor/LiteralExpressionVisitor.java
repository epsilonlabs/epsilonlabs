package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class LiteralExpressionVisitor<T, R> {
	
	public boolean appliesTo(LiteralExpression literalExpression, T context) {
		return true;
	}
	
	public abstract R visit (LiteralExpression literalExpression, T context, EolVisitorController<T, R> controller);
	
}
