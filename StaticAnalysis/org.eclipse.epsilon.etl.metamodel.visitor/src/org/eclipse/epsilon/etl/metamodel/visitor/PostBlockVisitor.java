package org.eclipse.epsilon.etl.metamodel.visitor;

import org.eclipse.epsilon.etl.metamodel.*;

public abstract class PostBlockVisitor<T, R> {
	
	public boolean appliesTo(PostBlock postBlock, T context) {
		return true;
	}
	
	public abstract R visit (PostBlock postBlock, T context, EtlVisitorController<T, R> controller);
	
}
