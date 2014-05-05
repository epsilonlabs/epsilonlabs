package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class SelfContentTypeVisitor<T, R> {
	
	public boolean appliesTo(SelfContentType selfContentType, T context) {
		return true;
	}
	
	public abstract R visit (SelfContentType selfContentType, T context, EolVisitorController<T, R> controller);
	
}
