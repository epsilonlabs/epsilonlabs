package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class EolProgramVisitor<T, R> {
	
	public boolean appliesTo(EolProgram eolProgram, T context) {
		return true;
	}
	
	public abstract R visit (EolProgram eolProgram, T context, EolVisitorController<T, R> controller);
	
}
