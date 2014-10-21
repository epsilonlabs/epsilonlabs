package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.WhileStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class WhileStatementTypeResolver extends WhileStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(WhileStatement whileStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		controller.visit(whileStatement.getCondition(), context);
		controller.visit(whileStatement.getBody(), context);

		return null;
	}

}
