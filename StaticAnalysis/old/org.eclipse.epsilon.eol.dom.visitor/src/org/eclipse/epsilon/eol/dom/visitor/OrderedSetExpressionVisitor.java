package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class OrderedSetExpressionVisitor<T, R> {
	
	public boolean appliesTo(OrderedSetExpression orderedSetExpression, T context) {
		return true;
	}
	
	public abstract R visit (OrderedSetExpression orderedSetExpression, T context, EolVisitorController<T, R> controller);
	
}
