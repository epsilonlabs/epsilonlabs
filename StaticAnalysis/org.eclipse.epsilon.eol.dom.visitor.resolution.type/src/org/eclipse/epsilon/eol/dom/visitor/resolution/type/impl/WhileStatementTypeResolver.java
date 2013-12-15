package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.WhileStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class WhileStatementTypeResolver extends WhileStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(WhileStatement whileStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		controller.visit(whileStatement.getCondition(), context);
		controller.visit(whileStatement.getBody(), context);
		return null;
	}

}
