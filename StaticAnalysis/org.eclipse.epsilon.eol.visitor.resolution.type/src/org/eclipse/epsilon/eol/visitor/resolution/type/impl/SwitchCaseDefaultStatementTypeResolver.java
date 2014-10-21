package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseDefaultStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class SwitchCaseDefaultStatementTypeResolver extends SwitchCaseDefaultStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SwitchCaseDefaultStatement switchCaseDefaultStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
//		if (context.getPessimistic()) {
//			context.getStack().push(switchCaseDefaultStatement, true);
//		}
		controller.visit(switchCaseDefaultStatement.getBody(), context);
//		if (context.getPessimistic()) {
//			context.getStack().pop();
//		}

		return null;
	}

}
