package org.eclipse.epsilon.evl.metamodel.visitor;

import org.eclipse.epsilon.evl.metamodel.*;

public abstract class PreBlockVisitor<T, R> {
	
	public boolean appliesTo(PreBlock preBlock, T context) {
		return true;
	}
	
	public abstract R visit (PreBlock preBlock, T context, EvlVisitorController<T, R> controller);
	
}
