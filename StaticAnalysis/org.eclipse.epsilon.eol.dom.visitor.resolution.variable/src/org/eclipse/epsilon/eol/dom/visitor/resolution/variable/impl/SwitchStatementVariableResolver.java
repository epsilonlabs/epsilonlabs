package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.SwitchCaseStatement;
import org.eclipse.epsilon.eol.dom.SwitchStatement;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.SwitchStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class SwitchStatementVariableResolver extends SwitchStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(SwitchStatement switchStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().push(switchStatement, true); //push a new frame
		controller.visit(switchStatement.getExpression(), context);
		for(SwitchCaseStatement switchCase : switchStatement.getCases())
		{
			controller.visit(switchCase, context);
		}
		controller.visit(switchStatement.getDefault(), context);
		context.getStack().pop(); //pop frame
		return null;
	}

}