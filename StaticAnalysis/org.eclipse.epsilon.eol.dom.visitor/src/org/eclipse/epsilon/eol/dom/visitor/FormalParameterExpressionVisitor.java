package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class FormalParameterExpressionVisitor<T, R> {
	
	public boolean appliesTo(FormalParameterExpression formalParameterExpression, T context) {
		return true;
	}
	
	public abstract R visit (FormalParameterExpression formalParameterExpression, T context, EolVisitorController<T, R> controller);
	
}
