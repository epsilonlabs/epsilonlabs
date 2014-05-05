package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class KeyValueVisitor<T, R> {
	
	public boolean appliesTo(KeyValue keyValue, T context) {
		return true;
	}
	
	public abstract R visit (KeyValue keyValue, T context, EolVisitorController<T, R> controller);
	
}
