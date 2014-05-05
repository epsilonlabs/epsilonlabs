package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class ProgramVisitor<T, R> {
	
	public boolean appliesTo(Program program, T context) {
		return true;
	}
	
	public abstract R visit (Program program, T context, EolVisitorController<T, R> controller);
	
}
