package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class RealExpressionVisitor<T, R> {
	
	public boolean appliesTo(RealExpression realExpression, T context) {
		return true;
	}
	
	public abstract R visit (RealExpression realExpression, T context, EolVisitorController<T, R> controller);
	
}
