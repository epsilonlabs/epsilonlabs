package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class SwitchStatementTypeResolver extends SwitchStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SwitchStatement switchStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(switchStatement.getExpression(), context);
		for(SwitchCaseExpressionStatement stmt: switchStatement.getCases())
		{
			controller.visit(stmt, context);
		}
		controller.visit(switchStatement.getDefault(), context);
		return null;
	}

}
