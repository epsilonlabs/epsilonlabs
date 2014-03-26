package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ContinueStatementVisitor<T, R> {
	
	public boolean appliesTo(ContinueStatement continueStatement, T context) {
		return true;
	}
	
	public abstract R visit (ContinueStatement continueStatement, T context, EolVisitorController<T, R> controller);
	
}
