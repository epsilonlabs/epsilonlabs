package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class PrimitiveTypeVisitor<T, R> {
	
	public boolean appliesTo(PrimitiveType primitiveType, T context) {
		return true;
	}
	
	public abstract R visit (PrimitiveType primitiveType, T context, EolVisitorController<T, R> controller);
	
}
