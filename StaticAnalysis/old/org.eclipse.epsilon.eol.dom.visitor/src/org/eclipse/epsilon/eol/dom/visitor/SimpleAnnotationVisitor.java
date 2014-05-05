package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SimpleAnnotationVisitor<T, R> {
	
	public boolean appliesTo(SimpleAnnotation simpleAnnotation, T context) {
		return true;
	}
	
	public abstract R visit (SimpleAnnotation simpleAnnotation, T context, EolVisitorController<T, R> controller);
	
}
