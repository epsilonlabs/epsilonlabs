package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IfStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class IfStatementTypeResolver extends IfStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(IfStatement ifStatement, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		controller.visit(ifStatement.getCondition(), context);

		if (context.getPessimistic()) {
			context.getStack().push(ifStatement, true);
		}
		controller.visit(ifStatement.getIfBody(), context);
		if (context.getPessimistic()) {
			context.getStack().pop();
		}
		
		if (ifStatement.getElseBody() != null) {
			if (context.getPessimistic()) {
				context.getStack().push(ifStatement, true);
			}
			controller.visit(ifStatement.getElseBody(), context);
			if (context.getPessimistic()) {
				context.getStack().pop();
			}

		}
		if (context.getPessimistic()) {
			context.getStack().pop();
		}
		return null;
	}

}
