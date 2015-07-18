package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class EOLProgramVisitor<T, R> {
	
	public boolean appliesTo(EOLProgram eOLProgram, T context) {
		return true;
	}
	
	public abstract R visit (EOLProgram eOLProgram, T context, EolVisitorController<T, R> controller);
	
}
