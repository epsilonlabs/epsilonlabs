package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ExecutableAnnotationVisitor<T, R> {
	
	public boolean appliesTo(ExecutableAnnotation executableAnnotation, T context) {
		return true;
	}
	
	public abstract R visit (ExecutableAnnotation executableAnnotation, T context, EolVisitorController<T, R> controller);
	
}
