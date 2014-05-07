package org.eclipse.epsilon.etl.metamodel.visitor;

import org.eclipse.epsilon.etl.metamodel.*;

public abstract class PreBlockVisitor<T, R> {
	
	public boolean appliesTo(PreBlock preBlock, T context) {
		return true;
	}
	
	public abstract R visit (PreBlock preBlock, T context, EtlVisitorController<T, R> controller);
	
}
