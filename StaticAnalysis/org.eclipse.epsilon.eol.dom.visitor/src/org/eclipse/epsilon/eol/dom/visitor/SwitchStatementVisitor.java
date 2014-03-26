package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SwitchStatementVisitor<T, R> {
	
	public boolean appliesTo(SwitchStatement switchStatement, T context) {
		return true;
	}
	
	public abstract R visit (SwitchStatement switchStatement, T context, EolVisitorController<T, R> controller);
	
}
