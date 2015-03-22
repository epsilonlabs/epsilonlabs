package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class SpecialNameExpressionVisitor<T, R> {
	
	public boolean appliesTo(SpecialNameExpression specialNameExpression, T context) {
		return true;
	}
	
	public abstract R visit (SpecialNameExpression specialNameExpression, T context, EolVisitorController<T, R> controller);
	
}
