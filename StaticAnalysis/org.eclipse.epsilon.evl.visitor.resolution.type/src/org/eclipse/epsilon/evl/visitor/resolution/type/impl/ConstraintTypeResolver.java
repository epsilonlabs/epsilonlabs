package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

import org.eclipse.epsilon.evl.metamodel.Constraint;
import org.eclipse.epsilon.evl.metamodel.Fix;
import org.eclipse.epsilon.evl.metamodel.visitor.ConstraintVisitor;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;

public class ConstraintTypeResolver extends ConstraintVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Constraint constraint, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {
		
		ExpressionOrStatementBlock guard = constraint.getGuard();
		ExpressionOrStatementBlock check = constraint.getCheck();
		ExpressionOrStatementBlock message = constraint.getMessage();
		
		if (guard != null) {
			controller.visit(guard, context);
		}
		
		if (check != null) {
			controller.visit(check, context);
		}
		
		if (message != null) {
			controller.visit(message, context);
		}
		
		for(Fix fix: constraint.getFixes())
		{
			controller.visit(fix, context);
		}
		
		return null;
	}

}
