package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.ExpressionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ExpressionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ExpressionStatementTypeResolver extends ExpressionStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ExpressionStatement expressionStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		if (expressionStatement.getExpression() != null) {
			controller.visit(expressionStatement.getExpression(), context);
		}
		return null;
	}

}
