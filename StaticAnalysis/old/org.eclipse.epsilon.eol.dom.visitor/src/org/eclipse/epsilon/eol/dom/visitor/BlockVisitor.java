package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class BlockVisitor<T, R> {
	
	public boolean appliesTo(Block block, T context) {
		return true;
	}
	
	public abstract R visit (Block block, T context, EolVisitorController<T, R> controller);
	
}
