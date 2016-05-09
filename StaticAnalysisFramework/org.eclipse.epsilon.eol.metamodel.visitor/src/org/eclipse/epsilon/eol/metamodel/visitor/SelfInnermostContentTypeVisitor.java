package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class SelfInnermostContentTypeVisitor<T, R> {
	
	public boolean appliesTo(SelfInnermostContentType selfInnermostContentType, T context) {
		return true;
	}
	
	public abstract R visit (SelfInnermostContentType selfInnermostContentType, T context, EolVisitorController<T, R> controller);
	
}
