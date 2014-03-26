package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class BagTypeVisitor<T, R> {
	
	public boolean appliesTo(BagType bagType, T context) {
		return true;
	}
	
	public abstract R visit (BagType bagType, T context, EolVisitorController<T, R> controller);
	
}
