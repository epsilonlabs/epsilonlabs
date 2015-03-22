package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class ExprListVisitor<T, R> {
	
	public boolean appliesTo(ExprList exprList, T context) {
		return true;
	}
	
	public abstract R visit (ExprList exprList, T context, EolVisitorController<T, R> controller);
	
}
