package org.eclipse.epsilon.etl.metamodel.visitor;

import org.eclipse.epsilon.etl.metamodel.*;

public abstract class EtlElementVisitor<T, R> {
	
	public boolean appliesTo(EtlElement etlElement, T context) {
		return true;
	}
	
	public abstract R visit (EtlElement etlElement, T context, EtlVisitorController<T, R> controller);
	
}
