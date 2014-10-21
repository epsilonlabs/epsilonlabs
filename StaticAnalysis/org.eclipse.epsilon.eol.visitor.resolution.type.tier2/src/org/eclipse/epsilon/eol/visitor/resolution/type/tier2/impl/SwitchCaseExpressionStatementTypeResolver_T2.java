package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseExpressionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class SwitchCaseExpressionStatementTypeResolver_T2 extends SwitchCaseExpressionStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(
			SwitchCaseExpressionStatement switchCaseExpressionStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		//push to stack
		context.getStack().push(switchCaseExpressionStatement, true);
		//visit the expression
		controller.visit(switchCaseExpressionStatement.getExpression(), context);
		//visit the body
		controller.visit(switchCaseExpressionStatement.getBody(), context);
		//pop from stack
		context.getStack().pop();
		
		return null;
	}


}
