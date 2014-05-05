package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class DeleteStatementVisitor<T, R> {
	
	public boolean appliesTo(DeleteStatement deleteStatement, T context) {
		return true;
	}
	
	public abstract R visit (DeleteStatement deleteStatement, T context, EolVisitorController<T, R> controller);
	
}
