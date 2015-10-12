package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.IfStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IfStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class IfStatementTypeResolver extends IfStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(IfStatement ifStatement, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		context.getTypeRegistry().pushContainer(ifStatement.getIfBody());//////////
		
		controller.visit(ifStatement.getCondition(), context);
		
		controller.visit(ifStatement.getIfBody(), context);
		context.getTypeRegistry().popContainer();//////////
		
		if (ifStatement.getElseBody() != null) {
			context.getTypeRegistry().pushContainer(ifStatement.getElseBody());
			controller.visit(ifStatement.getElseBody(), context);
			context.getTypeRegistry().popContainer();
		}
		return null;
	}

}
