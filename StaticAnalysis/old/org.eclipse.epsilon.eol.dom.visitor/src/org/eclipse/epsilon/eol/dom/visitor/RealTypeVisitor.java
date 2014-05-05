package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class RealTypeVisitor<T, R> {
	
	public boolean appliesTo(RealType realType, T context) {
		return true;
	}
	
	public abstract R visit (RealType realType, T context, EolVisitorController<T, R> controller);
	
}
