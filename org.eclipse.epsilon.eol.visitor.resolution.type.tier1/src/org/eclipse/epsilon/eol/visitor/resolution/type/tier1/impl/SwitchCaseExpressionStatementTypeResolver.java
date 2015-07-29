package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.SwitchCaseExpressionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseExpressionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class SwitchCaseExpressionStatementTypeResolver extends SwitchCaseExpressionStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			SwitchCaseExpressionStatement switchCaseExpressionStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(switchCaseExpressionStatement.getExpression(), context);
		controller.visit(switchCaseExpressionStatement.getBody(), context);
		return null;
	}

}
