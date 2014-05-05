package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class PseudoTypeVisitor<T, R> {
	
	public boolean appliesTo(PseudoType pseudoType, T context) {
		return true;
	}
	
	public abstract R visit (PseudoType pseudoType, T context, EolVisitorController<T, R> controller);
	
}
