package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class NativeExpressionVisitor<T, R> {
	
	public boolean appliesTo(NativeExpression nativeExpression, T context) {
		return true;
	}
	
	public abstract R visit (NativeExpression nativeExpression, T context, EolVisitorController<T, R> controller);
	
}
