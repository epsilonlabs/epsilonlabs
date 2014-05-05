package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ThrowStatementVisitor<T, R> {
	
	public boolean appliesTo(ThrowStatement throwStatement, T context) {
		return true;
	}
	
	public abstract R visit (ThrowStatement throwStatement, T context, EolVisitorController<T, R> controller);
	
}
