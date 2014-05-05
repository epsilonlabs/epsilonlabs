package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ModelTypeVisitor<T, R> {
	
	public boolean appliesTo(ModelType modelType, T context) {
		return true;
	}
	
	public abstract R visit (ModelType modelType, T context, EolVisitorController<T, R> controller);
	
}
