package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class VariableDeclarationExpressionVisitor<T, R> {
	
	public boolean appliesTo(VariableDeclarationExpression variableDeclarationExpression, T context) {
		return true;
	}
	
	public abstract R visit (VariableDeclarationExpression variableDeclarationExpression, T context, EolVisitorController<T, R> controller);
	
}
