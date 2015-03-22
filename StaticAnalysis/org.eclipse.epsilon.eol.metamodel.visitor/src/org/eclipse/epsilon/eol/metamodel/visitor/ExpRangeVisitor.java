package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class ExpRangeVisitor<T, R> {
	
	public boolean appliesTo(ExpRange expRange, T context) {
		return true;
	}
	
	public abstract R visit (ExpRange expRange, T context, EolVisitorController<T, R> controller);
	
}
