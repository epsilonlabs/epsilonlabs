package org.eclipse.epsilon.evl.metamodel.visitor;

import org.eclipse.epsilon.evl.metamodel.*;

public abstract class PostBlockVisitor<T, R> {
	
	public boolean appliesTo(PostBlock postBlock, T context) {
		return true;
	}
	
	public abstract R visit (PostBlock postBlock, T context, EvlVisitorController<T, R> controller);
	
}
