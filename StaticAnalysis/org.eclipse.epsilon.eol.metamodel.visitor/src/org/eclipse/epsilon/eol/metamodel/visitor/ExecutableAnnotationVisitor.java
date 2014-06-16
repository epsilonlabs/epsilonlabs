package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class ExecutableAnnotationVisitor<T, R> {
	
	public boolean appliesTo(ExecutableAnnotation executableAnnotation, T context) {
		return true;
	}
	
	public abstract R visit (ExecutableAnnotation executableAnnotation, T context, EolVisitorController<T, R> controller);
	
}
