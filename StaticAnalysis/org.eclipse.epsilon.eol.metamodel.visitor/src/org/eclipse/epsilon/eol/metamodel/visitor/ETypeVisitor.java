package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class ETypeVisitor<T, R> {
	
	public boolean appliesTo(EType eType, T context) {
		return true;
	}
	
	public abstract R visit (EType eType, T context, EolVisitorController<T, R> controller);
	
}
