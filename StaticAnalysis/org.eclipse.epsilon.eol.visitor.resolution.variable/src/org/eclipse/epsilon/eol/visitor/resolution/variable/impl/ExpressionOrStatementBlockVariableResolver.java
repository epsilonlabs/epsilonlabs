package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ExpressionOrStatementBlockVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class ExpressionOrStatementBlockVariableResolver extends ExpressionOrStatementBlockVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(ExpressionOrStatementBlock expressionOrStatementBlock,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().push(expressionOrStatementBlock, true);
		Block block = expressionOrStatementBlock.getBlock();
		Expression expr = expressionOrStatementBlock.getExpression();
		if (block != null) {
			controller.visit(block, context);
		}
		
		if (expr != null) {
			controller.visit(expr, context);
		}
		context.getStack().pop();
		return null;
	}

}
