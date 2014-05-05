package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ImportVisitor<T, R> {
	
	public boolean appliesTo(Import _import, T context) {
		return true;
	}
	
	public abstract R visit (Import _import, T context, EolVisitorController<T, R> controller);
	
}
