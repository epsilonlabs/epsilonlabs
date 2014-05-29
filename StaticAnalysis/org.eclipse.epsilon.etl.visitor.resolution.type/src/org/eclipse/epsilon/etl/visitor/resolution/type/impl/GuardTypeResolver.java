package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.GuardVisitor;

public class GuardTypeResolver extends GuardVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Guard guard, TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		
		ExpressionOrStatementBlock condition = guard.getCondition();
		if (condition != null) {
			controller.visit(condition, context);
		}
		
		return null;
	}

}
