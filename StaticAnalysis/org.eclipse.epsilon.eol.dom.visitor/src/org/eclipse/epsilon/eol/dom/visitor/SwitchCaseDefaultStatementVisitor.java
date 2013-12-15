package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SwitchCaseDefaultStatementVisitor<T, R> {
	
	public boolean appliesTo(SwitchCaseDefaultStatement switchCaseDefaultStatement, T context) {
		return true;
	}
	
	public abstract R visit (SwitchCaseDefaultStatement switchCaseDefaultStatement, T context, EolVisitorController<T, R> controller);
	
}
