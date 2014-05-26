package org.eclipse.epsilon.etl.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.GuardVisitor;

public class GuardVariableResolver extends GuardVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(Guard guard, VariableResolutionContext context,
			EtlVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().push(guard, true);
		
		ExpressionOrStatementBlock condition = guard.getCondition();
		
		if (condition.getBlock() != null) {
			controller.visit(condition.getBlock(), context);
		}
		else if (condition.getExpression() != null) {
			controller.visit(condition.getExpression(), context);
		}
		else {
			context.getLogBook().addError(condition, "guard should have either a single expression or a block of statements");
		}
		
		context.getStack().pop();

		return null;

	}

}
