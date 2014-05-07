package org.eclipse.epsilon.etl.metamodel.visitor;

import org.eclipse.epsilon.etl.metamodel.*;

public abstract class GuardVisitor<T, R> {
	
	public boolean appliesTo(Guard guard, T context) {
		return true;
	}
	
	public abstract R visit (Guard guard, T context, EtlVisitorController<T, R> controller);
	
}
