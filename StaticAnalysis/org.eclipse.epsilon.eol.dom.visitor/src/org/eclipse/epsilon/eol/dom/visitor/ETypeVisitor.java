package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ETypeVisitor<T, R> {
	
	public boolean appliesTo(EType eType, T context) {
		return true;
	}
	
	public abstract R visit (EType eType, T context, EolVisitorController<T, R> controller);
	
}
