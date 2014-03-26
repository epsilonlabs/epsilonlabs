package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class IfStatementVisitor<T, R> {
	
	public boolean appliesTo(IfStatement ifStatement, T context) {
		return true;
	}
	
	public abstract R visit (IfStatement ifStatement, T context, EolVisitorController<T, R> controller);
	
}
