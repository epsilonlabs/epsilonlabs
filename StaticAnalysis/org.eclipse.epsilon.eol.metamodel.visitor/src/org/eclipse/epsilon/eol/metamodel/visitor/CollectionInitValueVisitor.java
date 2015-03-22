package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class CollectionInitValueVisitor<T, R> {
	
	public boolean appliesTo(CollectionInitValue collectionInitValue, T context) {
		return true;
	}
	
	public abstract R visit (CollectionInitValue collectionInitValue, T context, EolVisitorController<T, R> controller);
	
}
