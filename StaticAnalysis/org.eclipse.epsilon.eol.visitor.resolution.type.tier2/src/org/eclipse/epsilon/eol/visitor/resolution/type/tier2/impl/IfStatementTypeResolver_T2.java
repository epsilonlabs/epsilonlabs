package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.IfStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IfStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class IfStatementTypeResolver_T2 extends IfStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(IfStatement ifStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		//visit the condition first
		controller.visit(ifStatement.getCondition(), context);
		//put to stack
		context.getStack().push(ifStatement.getIfBody(), true);
		//visit the if branch
		controller.visit(ifStatement.getIfBody(), context);
		//pop from stack
		context.getStack().pop();
		
		//if there is an else body
		if (ifStatement.getElseBody() != null) {
			//push to stack
			context.getStack().push(ifStatement.getElseBody(), true);
			//visit the else branch
			controller.visit(ifStatement.getElseBody(), context);
			//pop from the stack
			context.getStack().pop();
		}
		return null;
	}

}
