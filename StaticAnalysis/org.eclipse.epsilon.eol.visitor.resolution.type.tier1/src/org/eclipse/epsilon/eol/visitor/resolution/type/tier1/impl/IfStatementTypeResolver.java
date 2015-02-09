package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IfStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class IfStatementTypeResolver extends IfStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(IfStatement ifStatement, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit condition
		controller.visit(ifStatement.getCondition(), context);
		
		//visit if body
		controller.visit(ifStatement.getIfBody(), context);
		
		//visit else body if there is one
		if (ifStatement.getElseBody() != null) {
			controller.visit(ifStatement.getElseBody(), context);

		}
		return null;
	}

}
