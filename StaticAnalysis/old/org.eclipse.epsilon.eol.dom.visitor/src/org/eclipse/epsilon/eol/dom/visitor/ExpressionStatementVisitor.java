package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ExpressionStatementVisitor<T, R> {
	
	public boolean appliesTo(ExpressionStatement expressionStatement, T context) {
		return true;
	}
	
	public abstract R visit (ExpressionStatement expressionStatement, T context, EolVisitorController<T, R> controller);
	
}
