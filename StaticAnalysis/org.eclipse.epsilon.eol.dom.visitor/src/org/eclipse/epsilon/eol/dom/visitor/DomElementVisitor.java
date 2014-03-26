package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class DomElementVisitor<T, R> {
	
	public boolean appliesTo(DomElement domElement, T context) {
		return true;
	}
	
	public abstract R visit (DomElement domElement, T context, EolVisitorController<T, R> controller);
	
}
