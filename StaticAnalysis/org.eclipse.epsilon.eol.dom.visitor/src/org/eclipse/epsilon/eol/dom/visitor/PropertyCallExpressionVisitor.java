package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class PropertyCallExpressionVisitor<T, R> {
	
	public boolean appliesTo(PropertyCallExpression propertyCallExpression, T context) {
		return true;
	}
	
	public abstract R visit (PropertyCallExpression propertyCallExpression, T context, EolVisitorController<T, R> controller);
	
}
