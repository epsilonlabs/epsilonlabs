package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class AnnotationBlockVisitor<T, R> {
	
	public boolean appliesTo(AnnotationBlock annotationBlock, T context) {
		return true;
	}
	
	public abstract R visit (AnnotationBlock annotationBlock, T context, EolVisitorController<T, R> controller);
	
}
