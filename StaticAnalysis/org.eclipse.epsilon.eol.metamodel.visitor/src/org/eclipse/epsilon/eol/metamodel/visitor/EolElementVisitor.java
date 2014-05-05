package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class EolElementVisitor<T, R> {
	
	public boolean appliesTo(EolElement eolElement, T context) {
		return true;
	}
	
	public abstract R visit (EolElement eolElement, T context, EolVisitorController<T, R> controller);
	
}
