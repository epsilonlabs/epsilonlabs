package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ExprListVisitor<T, R> {
	
	public boolean appliesTo(ExprList exprList, T context) {
		return true;
	}
	
	public abstract R visit (ExprList exprList, T context, EolVisitorController<T, R> controller);
	
}
