package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class EnumerationLiteralExpressionVisitor<T, R> {
	
	public boolean appliesTo(EnumerationLiteralExpression enumerationLiteralExpression, T context) {
		return true;
	}
	
	public abstract R visit (EnumerationLiteralExpression enumerationLiteralExpression, T context, EolVisitorController<T, R> controller);
	
}
