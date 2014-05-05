package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SetTypeVisitor<T, R> {
	
	public boolean appliesTo(SetType setType, T context) {
		return true;
	}
	
	public abstract R visit (SetType setType, T context, EolVisitorController<T, R> controller);
	
}
