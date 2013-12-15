package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class AnyTypeVisitor<T, R> {
	
	public boolean appliesTo(AnyType anyType, T context) {
		return true;
	}
	
	public abstract R visit (AnyType anyType, T context, EolVisitorController<T, R> controller);
	
}
