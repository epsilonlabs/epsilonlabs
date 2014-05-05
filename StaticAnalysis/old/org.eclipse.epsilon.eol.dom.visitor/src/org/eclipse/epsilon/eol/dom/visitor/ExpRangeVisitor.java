package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ExpRangeVisitor<T, R> {
	
	public boolean appliesTo(ExpRange expRange, T context) {
		return true;
	}
	
	public abstract R visit (ExpRange expRange, T context, EolVisitorController<T, R> controller);
	
}
