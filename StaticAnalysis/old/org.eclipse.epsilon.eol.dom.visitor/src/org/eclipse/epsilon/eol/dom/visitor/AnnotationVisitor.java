package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class AnnotationVisitor<T, R> {
	
	public boolean appliesTo(Annotation annotation, T context) {
		return true;
	}
	
	public abstract R visit (Annotation annotation, T context, EolVisitorController<T, R> controller);
	
}
