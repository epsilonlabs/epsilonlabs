package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SwitchCaseStatementVisitor<T, R> {
	
	public boolean appliesTo(SwitchCaseStatement switchCaseStatement, T context) {
		return true;
	}
	
	public abstract R visit (SwitchCaseStatement switchCaseStatement, T context, EolVisitorController<T, R> controller);
	
}
