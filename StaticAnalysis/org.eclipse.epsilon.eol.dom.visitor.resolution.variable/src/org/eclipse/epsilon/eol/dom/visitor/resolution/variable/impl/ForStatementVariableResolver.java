package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class ForStatementVariableResolver extends ForStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {

		context.getStack().push(forStatement, true);
		controller.visit(forStatement.getIterator(), context);
		controller.visit(forStatement.getIterated(), context);
		context.getStack().push(forStatement.getBody(), true);
		controller.visit(forStatement.getBody(), context);
		context.getStack().pop();
		context.getStack().pop();
		return null;
	}

}
