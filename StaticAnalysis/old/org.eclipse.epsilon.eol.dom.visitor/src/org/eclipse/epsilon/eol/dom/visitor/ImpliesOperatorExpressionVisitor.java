package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ImpliesOperatorExpressionVisitor<T, R> {
	
	public boolean appliesTo(ImpliesOperatorExpression impliesOperatorExpression, T context) {
		return true;
	}
	
	public abstract R visit (ImpliesOperatorExpression impliesOperatorExpression, T context, EolVisitorController<T, R> controller);
	
}
