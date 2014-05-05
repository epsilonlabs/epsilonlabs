package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class OrderedCollectionTypeVisitor<T, R> {
	
	public boolean appliesTo(OrderedCollectionType orderedCollectionType, T context) {
		return true;
	}
	
	public abstract R visit (OrderedCollectionType orderedCollectionType, T context, EolVisitorController<T, R> controller);
	
}
