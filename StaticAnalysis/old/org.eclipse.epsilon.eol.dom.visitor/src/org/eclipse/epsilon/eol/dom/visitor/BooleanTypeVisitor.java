package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class BooleanTypeVisitor<T, R> {
	
	public boolean appliesTo(BooleanType booleanType, T context) {
		return true;
	}
	
	public abstract R visit (BooleanType booleanType, T context, EolVisitorController<T, R> controller);
	
}
