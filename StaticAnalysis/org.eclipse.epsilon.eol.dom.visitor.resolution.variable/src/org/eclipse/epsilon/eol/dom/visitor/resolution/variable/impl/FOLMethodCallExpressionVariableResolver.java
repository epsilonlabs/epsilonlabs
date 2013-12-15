package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.dom.FormalParameterExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class FOLMethodCallExpressionVariableResolver extends FOLMethodCallExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		controller.visit(fOLMethodCallExpression.getTarget(), context);
		context.getStack().push(fOLMethodCallExpression, true);
		for(FormalParameterExpression iterator: fOLMethodCallExpression.getIterators())
		{
			controller.visit(iterator, context);
		}
		for(Expression expr: fOLMethodCallExpression.getConditions())
		{
			controller.visit(expr, context);
		}
		context.getStack().pop();
		return null;
	}

}
