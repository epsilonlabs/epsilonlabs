package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class MapTypeVisitor<T, R> {
	
	public boolean appliesTo(MapType mapType, T context) {
		return true;
	}
	
	public abstract R visit (MapType mapType, T context, EolVisitorController<T, R> controller);
	
}
