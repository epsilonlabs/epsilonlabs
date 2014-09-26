package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.evl.metamodel.Critique;
import org.eclipse.epsilon.evl.metamodel.Fix;
import org.eclipse.epsilon.evl.metamodel.visitor.CritiqueVisitor;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;

public class CritiqueTypeResolver extends CritiqueVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Critique critique, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {
		
		EvlTypeResolutionContext leContext = (EvlTypeResolutionContext) context;
		leContext.setCurrentInvariant(critique);
		
		ExpressionOrStatementBlock guard = critique.getGuard();
		ExpressionOrStatementBlock check = critique.getCheck();
		ExpressionOrStatementBlock message = critique.getMessage();
		
		if (guard != null) {
			controller.visit(guard, context);
		}
		
		if (check != null) {
			controller.visit(check, context);
		}
		
		if (message != null) {
			controller.visit(message, context);
		}
		
		for(Fix fix: critique.getFixes())
		{
			controller.visit(fix, context);
		}
		
		return null;
	}

}
