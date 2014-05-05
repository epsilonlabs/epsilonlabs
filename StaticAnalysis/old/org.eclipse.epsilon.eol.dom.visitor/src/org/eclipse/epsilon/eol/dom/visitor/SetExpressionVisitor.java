package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SetExpressionVisitor<T, R> {
	
	public boolean appliesTo(SetExpression setExpression, T context) {
		return true;
	}
	
	public abstract R visit (SetExpression setExpression, T context, EolVisitorController<T, R> controller);
	
}
