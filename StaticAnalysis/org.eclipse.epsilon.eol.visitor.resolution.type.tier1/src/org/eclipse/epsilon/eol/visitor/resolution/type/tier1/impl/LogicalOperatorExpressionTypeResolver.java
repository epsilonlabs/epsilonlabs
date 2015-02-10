package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.LogicalOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class LogicalOperatorExpressionTypeResolver extends LogicalOperatorExpressionVisitor<TypeResolutionContext, Object>{	
	
	@Override
	public Object visit(LogicalOperatorExpression logicalOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(logicalOperatorExpression.getLhs(), context);
		controller.visit(logicalOperatorExpression.getRhs(), context);
		
		BooleanType type = context.getEolFactory().createBooleanType(); 
		logicalOperatorExpression.setResolvedType(type);
		context.setAssets(type, logicalOperatorExpression);
		
		Expression lhs = logicalOperatorExpression.getLhs();
		Expression rhs = logicalOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		if (lhsType == null) {
			context.getLogBook().addError(lhs, "Expression does not have a type");
			return null;
		}
		
		if (rhsType == null) {
			context.getLogBook().addError(rhs, "Expression does not have a type");
			return null;
		}
		

		if (lhsType instanceof AnyType || rhsType instanceof AnyType) {
			if (lhsType instanceof AnyType) {
				context.getLogBook().addError(lhs, "Operator applies only to operands of type Boolean");
			}
			else if (rhsType instanceof AnyType) {
				context.getLogBook().addError(rhs, "Operator applies only to operands of type Boolean");
			}
			return null;
		}
		else {
			if (lhsType instanceof BooleanType) {
				if (rhsType instanceof BooleanType) {
					
				}
				else {
					context.getLogBook().addError(rhs, "Operator applies only to operands of type Boolean");
				}
			}
			else {
				context.getLogBook().addError(lhs, "Operator applies only to operands of type Boolean");
			}
		}
	
		return null;
	}

}
