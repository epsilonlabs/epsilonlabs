package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IfStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class IfStatementVariableResolver extends IfStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(IfStatement ifStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		controller.visit(ifStatement.getCondition(), context);
		
		context.getStack().push(ifStatement.getIfBody(), true);
		controller.visit(ifStatement.getIfBody(), context);
		context.getStack().pop();
		
		if (ifStatement.getElseBody() != null) {
			context.getStack().push(ifStatement.getElseBody(), true);
			controller.visit(ifStatement.getElseBody(), context);
			context.getStack().pop();

		}
		return null;
	}

}
