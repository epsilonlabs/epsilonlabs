package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.SwitchCaseStatement;
import org.eclipse.epsilon.eol.metamodel.SwitchStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class SwitchStatementTypeResolver_T2 extends SwitchStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(SwitchStatement switchStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		//push to stack
		context.getStack().push(switchStatement, true);
		//visit the expression
		controller.visit(switchStatement.getExpression(), context);
		//visit the switch cases
		for(SwitchCaseStatement switchCase : switchStatement.getCases())
		{
			controller.visit(switchCase, context);
		}
		//visit the default
		if (switchStatement.getDefault() != null) {
			controller.visit(switchStatement.getDefault(), context);			
		}
		//pop from the frame
		context.getStack().pop(); 
		return null;
	}

}
