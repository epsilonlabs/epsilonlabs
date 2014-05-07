package org.eclipse.epsilon.etl.metamodel.visitor;

import org.eclipse.epsilon.etl.metamodel.*;

public abstract class EtlProgramVisitor<T, R> {
	
	public boolean appliesTo(EtlProgram etlProgram, T context) {
		return true;
	}
	
	public abstract R visit (EtlProgram etlProgram, T context, EtlVisitorController<T, R> controller);
	
}
