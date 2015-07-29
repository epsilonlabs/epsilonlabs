package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseDefaultStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class SwitchCaseDefaultStatementTypeResolver extends SwitchCaseDefaultStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SwitchCaseDefaultStatement switchCaseDefaultStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(switchCaseDefaultStatement.getBody(), context);

		return null;
	}

}
