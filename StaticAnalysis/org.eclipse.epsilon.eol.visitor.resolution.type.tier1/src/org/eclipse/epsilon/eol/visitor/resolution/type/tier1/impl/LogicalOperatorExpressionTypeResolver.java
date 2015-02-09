package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.LogicalOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class LogicalOperatorExpressionTypeResolver extends LogicalOperatorExpressionVisitor<TypeResolutionContext, Object>{	
	
	public boolean isLogicalOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof AndOperatorExpression ||
				op instanceof OrOperatorExpression ||
				op instanceof ImpliesOperatorExpression ||
				op instanceof XorOperatorExpression) {
			result = true;
		}
		return result;
	}
	
	public boolean isComparativeOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof GreaterThanOperatorExpression ||
				op instanceof GreaterThanOrEqualToOperatorExpression ||
				//op instanceof EqualsOperatorExpression ||
				//op instanceof NotEqualsOperatorExpression ||
				op instanceof LessThanOperatorExpression ||
				op instanceof LessThanOrEqualToOperatorExpression) {
			result = true;
		}
		return result;
	}
	
	public boolean isEqualityComparisonOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof EqualsOperatorExpression ||
				op instanceof NotEqualsOperatorExpression) {
			result = true;
		}
		return result;
	}


	@Override
	public Object visit(LogicalOperatorExpression logicalOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(logicalOperatorExpression.getLhs(), context);
		controller.visit(logicalOperatorExpression.getRhs(), context);
		
		//set type first, this allows minor-error in expressions and statements
		BooleanType type = context.getEolFactory().createBooleanType(); 
		
		//set the resolved type first
		logicalOperatorExpression.setResolvedType(type);
		
		//get lhs expr
		Expression lhs = logicalOperatorExpression.getLhs();
		//get rhs expr
		Expression rhs = logicalOperatorExpression.getRhs();
		
		//get lhs type
		Type lhsType = lhs.getResolvedType();
		//get rhs type
		Type rhsType = rhs.getResolvedType();
		
		
		if (lhsType == null) {
			context.getLogBook().addError(lhs, "Expression does not have a type");
			return null;
		}
		
		if (rhsType == null) {
			context.getLogBook().addError(rhs, "Expression does not have a type");
			return null;
		}
		
		if (isLogicalOperator(logicalOperatorExpression)) {
			if (lhs.getResolvedType() instanceof AnyType || rhs.getResolvedType() instanceof AnyType) {
				
			}
			else {
				if(logicalOperatorExpression.getLhs().getResolvedType() instanceof BooleanType)
				{
					if (logicalOperatorExpression.getRhs().getResolvedType() instanceof BooleanType) {
						
					}
					else {
						context.getLogBook().addError(logicalOperatorExpression.getRhs(), "Expression is not of type Boolean");
					}
				}
				else {
					context.getLogBook().addError(logicalOperatorExpression.getLhs(), "Expression is not of type Boolean");
				}
			}
		}
		else if (isComparativeOperator(logicalOperatorExpression)) {
			if (lhsType instanceof AnyType || rhsType instanceof AnyType) {
				
			}
			else if (lhsType instanceof IntegerType || lhsType instanceof RealType) {
				if (rhsType instanceof IntegerType || rhsType instanceof RealType) {
					
				}
				else {
					context.getLogBook().addError(rhs, "Expected type: " + lhsType.getClass().getSimpleName());
				}
			}
			else if (lhsType instanceof StringType) {
				if (rhsType instanceof StringType) {
					
				}
				else {
					context.getLogBook().addError(rhsType, "Expected type: String");
				}
			}
			else {
				context.getLogBook().addError(lhs, "Expression should be of type Integer, Real or String");
			}
		}
		else if(isEqualityComparisonOperator(logicalOperatorExpression))
		{
		
			if (lhsType instanceof AnyType || rhsType instanceof AnyType) {
				
			}
			else if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
				if (lhsType instanceof BooleanType) {
					if (rhsType instanceof BooleanType) {
						
					}
					else {
						context.getLogBook().addError(rhsType, "Expected boolean type, actual type is: " + rhsType.getClass().getSimpleName());
					}
				}
				else if (lhsType instanceof StringType) {
					if (rhsType instanceof StringType) {
						
					}
					else {
						context.getLogBook().addError(rhsType, "Expected String type, actual type is: " + rhsType.getClass().getSimpleName());
					}
				}
				else if (lhsType instanceof IntegerType || lhsType instanceof RealType)
				{
					if (rhsType instanceof IntegerType || rhsType instanceof RealType) {
						
					}
					else {
						context.getLogBook().addError(rhs, "Expression should be of either type Integer or type Real");
					}				
				}
				else {
					context.getLogBook().addError(lhs, "Expression should be of either type Integer or type Real");
				}
			}
		}
		
		context.setAssets(type, logicalOperatorExpression);
		return null;
	}

}
