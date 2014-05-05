package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class AbortStatementVisitor<T, R> {
	
	public boolean appliesTo(AbortStatement abortStatement, T context) {
		return true;
	}
	
	public abstract R visit (AbortStatement abortStatement, T context, EolVisitorController<T, R> controller);
	
}
