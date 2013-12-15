package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class CollectionInitValueVisitor<T, R> {
	
	public boolean appliesTo(CollectionInitValue collectionInitValue, T context) {
		return true;
	}
	
	public abstract R visit (CollectionInitValue collectionInitValue, T context, EolVisitorController<T, R> controller);
	
}
