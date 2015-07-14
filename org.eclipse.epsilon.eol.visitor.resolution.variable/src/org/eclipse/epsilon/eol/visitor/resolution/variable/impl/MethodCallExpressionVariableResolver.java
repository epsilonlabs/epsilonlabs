package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class MethodCallExpressionVariableResolver extends MethodCallExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		controller.visit(methodCallExpression.getTarget(), context);
		for(Expression expression : methodCallExpression.getArguments())
		{
			controller.visit(expression, context);
		}
		return null;
	}

}
