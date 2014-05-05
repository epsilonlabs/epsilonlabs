package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class SelfInnermostTypeVisitor<T, R> {
	
	public boolean appliesTo(SelfInnermostType selfInnermostType, T context) {
		return true;
	}
	
	public abstract R visit (SelfInnermostType selfInnermostType, T context, EolVisitorController<T, R> controller);
	
}
