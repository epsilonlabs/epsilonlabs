package org.eclipse.epsilon.evl.metamodel.visitor;

import org.eclipse.epsilon.evl.metamodel.*;

public abstract class EvlProgramVisitor<T, R> {
	
	public boolean appliesTo(EvlProgram evlProgram, T context) {
		return true;
	}
	
	public abstract R visit (EvlProgram evlProgram, T context, EvlVisitorController<T, R> controller);
	
}
