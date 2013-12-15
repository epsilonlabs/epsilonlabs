package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ReturnStatementVisitor<T, R> {
	
	public boolean appliesTo(ReturnStatement returnStatement, T context) {
		return true;
	}
	
	public abstract R visit (ReturnStatement returnStatement, T context, EolVisitorController<T, R> controller);
	
}
