package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SelfTypeVisitor<T, R> {
	
	public boolean appliesTo(SelfType selfType, T context) {
		return true;
	}
	
	public abstract R visit (SelfType selfType, T context, EolVisitorController<T, R> controller);
	
}
