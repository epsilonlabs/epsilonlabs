package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseDefaultStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class SwitchCaseDefaultStatementTypeResolver_T2 extends SwitchCaseDefaultStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(SwitchCaseDefaultStatement switchCaseDefaultStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		
		//push to stack
		context.getStack().push(switchCaseDefaultStatement, true);
		//visit the body
		controller.visit(switchCaseDefaultStatement.getBody(), context);
		//pop from stack
		context.getStack().pop();
		
		return null;
	}

}
