package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class BreakAllStatementVisitor<T, R> {
	
	public boolean appliesTo(BreakAllStatement breakAllStatement, T context) {
		return true;
	}
	
	public abstract R visit (BreakAllStatement breakAllStatement, T context, EolVisitorController<T, R> controller);
	
}
