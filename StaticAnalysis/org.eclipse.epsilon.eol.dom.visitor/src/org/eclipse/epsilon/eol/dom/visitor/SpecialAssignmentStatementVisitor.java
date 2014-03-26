package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SpecialAssignmentStatementVisitor<T, R> {
	
	public boolean appliesTo(SpecialAssignmentStatement specialAssignmentStatement, T context) {
		return true;
	}
	
	public abstract R visit (SpecialAssignmentStatement specialAssignmentStatement, T context, EolVisitorController<T, R> controller);
	
}
