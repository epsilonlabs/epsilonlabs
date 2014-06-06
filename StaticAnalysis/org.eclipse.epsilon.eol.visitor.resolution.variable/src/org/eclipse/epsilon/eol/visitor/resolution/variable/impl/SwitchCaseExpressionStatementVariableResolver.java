package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseExpressionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class SwitchCaseExpressionStatementVariableResolver extends SwitchCaseExpressionStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(
			SwitchCaseExpressionStatement switchCaseExpressionStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		
		context.getStack().push(switchCaseExpressionStatement, true);
		controller.visit(switchCaseExpressionStatement.getExpression(), context);
		controller.visit(switchCaseExpressionStatement.getBody(), context);
		context.getStack().pop();
		
		return null;
	}

}
