package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class FOLMethodCallExpressionVariableResolver extends FOLMethodCallExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		//visit the target first
		controller.visit(fOLMethodCallExpression.getTarget(), context);
		//push to stack
		context.getStack().push(fOLMethodCallExpression, true);
		//visit the iterator
		controller.visit(fOLMethodCallExpression.getIterator(), context);
		//visit the condition
		controller.visit(fOLMethodCallExpression.getCondition(), context);
		//pop from stack
		context.getStack().pop();
		return null;
	}

}
