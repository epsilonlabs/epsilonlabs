package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.SwitchCaseDefaultStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class SwitchCaseDefaultStatementVariableResolver extends SwitchCaseDefaultStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(SwitchCaseDefaultStatement switchCaseDefaultStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().push(switchCaseDefaultStatement, true);
		controller.visit(switchCaseDefaultStatement.getBody(), context);
		context.getStack().pop();
		return null;
	}

}
