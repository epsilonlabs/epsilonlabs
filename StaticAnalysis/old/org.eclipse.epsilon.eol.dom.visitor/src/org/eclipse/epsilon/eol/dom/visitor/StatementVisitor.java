package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class StatementVisitor<T, R> {
	
	public boolean appliesTo(Statement statement, T context) {
		return true;
	}
	
	public abstract R visit (Statement statement, T context, EolVisitorController<T, R> controller);
	
}
