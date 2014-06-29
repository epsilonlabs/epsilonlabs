package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.WhileStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class WhileStatementTypeResolver extends WhileStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(WhileStatement whileStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		if (context.getPessimistic()) {
			context.getStack().push(whileStatement, true);
		}

		controller.visit(whileStatement.getCondition(), context);
		controller.visit(whileStatement.getBody(), context);
		
		if (context.getPessimistic()) {
			context.getStack().pop();
		}

		return null;
	}

}
