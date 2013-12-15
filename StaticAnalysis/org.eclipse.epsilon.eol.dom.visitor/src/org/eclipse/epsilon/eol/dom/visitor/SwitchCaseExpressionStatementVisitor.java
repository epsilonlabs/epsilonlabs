package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SwitchCaseExpressionStatementVisitor<T, R> {
	
	public boolean appliesTo(SwitchCaseExpressionStatement switchCaseExpressionStatement, T context) {
		return true;
	}
	
	public abstract R visit (SwitchCaseExpressionStatement switchCaseExpressionStatement, T context, EolVisitorController<T, R> controller);
	
}
