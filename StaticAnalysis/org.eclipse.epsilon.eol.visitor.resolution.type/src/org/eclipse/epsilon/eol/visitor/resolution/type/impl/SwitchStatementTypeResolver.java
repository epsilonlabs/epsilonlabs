package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class SwitchStatementTypeResolver extends SwitchStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SwitchStatement switchStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
//		if (context.getPessimistic()) {
//			context.getStack().push(switchStatement, true);
//		}

		controller.visit(switchStatement.getExpression(), context);
		for(SwitchCaseExpressionStatement stmt: switchStatement.getCases())
		{
			controller.visit(stmt, context);
		}
		controller.visit(switchStatement.getDefault(), context);
		
//		if (context.getPessimistic()) {
//			context.getStack().pop();
//		}

		return null;
	}

}
