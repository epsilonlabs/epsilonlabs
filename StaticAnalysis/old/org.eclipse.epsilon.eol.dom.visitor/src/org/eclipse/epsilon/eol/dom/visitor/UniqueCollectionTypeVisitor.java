package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class UniqueCollectionTypeVisitor<T, R> {
	
	public boolean appliesTo(UniqueCollectionType uniqueCollectionType, T context) {
		return true;
	}
	
	public abstract R visit (UniqueCollectionType uniqueCollectionType, T context, EolVisitorController<T, R> controller);
	
}
