package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ProgramVisitor<T, R> {
	
	public boolean appliesTo(Program program, T context) {
		return true;
	}
	
	public abstract R visit (Program program, T context, EolVisitorController<T, R> controller);
	
}
