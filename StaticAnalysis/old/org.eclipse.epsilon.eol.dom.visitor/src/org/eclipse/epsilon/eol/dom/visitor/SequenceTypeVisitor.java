package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class SequenceTypeVisitor<T, R> {
	
	public boolean appliesTo(SequenceType sequenceType, T context) {
		return true;
	}
	
	public abstract R visit (SequenceType sequenceType, T context, EolVisitorController<T, R> controller);
	
}
