package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class MapExpressionVisitor<T, R> {
	
	public boolean appliesTo(MapExpression mapExpression, T context) {
		return true;
	}
	
	public abstract R visit (MapExpression mapExpression, T context, EolVisitorController<T, R> controller);
	
}
