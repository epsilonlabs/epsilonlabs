package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class BagExpressionVisitor<T, R> {
	
	public boolean appliesTo(BagExpression bagExpression, T context) {
		return true;
	}
	
	public abstract R visit (BagExpression bagExpression, T context, EolVisitorController<T, R> controller);
	
}
