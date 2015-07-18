package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class IModelVisitor<T, R> {
	
	public boolean appliesTo(IModel iModel, T context) {
		return true;
	}
	
	public abstract R visit (IModel iModel, T context, EolVisitorController<T, R> controller);
	
}
