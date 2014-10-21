package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class LogicalOperatorExpressionTypeResolver extends BinaryOperatorExpressionVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public boolean appliesTo(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext_T2 context) {
		return binaryOperatorExpression instanceof AndOperatorExpression ||
				binaryOperatorExpression instanceof OrOperatorExpression ||
				binaryOperatorExpression instanceof ImpliesOperatorExpression ||
				binaryOperatorExpression instanceof XorOperatorExpression ||
				binaryOperatorExpression instanceof GreaterThanOperatorExpression ||
				binaryOperatorExpression instanceof GreaterThanOrEqualToOperatorExpression ||
				binaryOperatorExpression instanceof EqualsOperatorExpression ||
				binaryOperatorExpression instanceof NotEqualsOperatorExpression ||
				binaryOperatorExpression instanceof LessThanOperatorExpression ||
				binaryOperatorExpression instanceof LessThanOrEqualToOperatorExpression;				
	}

	@Override
	public Object visit(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		controller.visit(binaryOperatorExpression.getLhs(), context);
		controller.visit(binaryOperatorExpression.getRhs(), context);
		
		BooleanType type = context.getEolFactory().createBooleanType(); //set type first, this allows minor-error in expressions n statements
		binaryOperatorExpression.setResolvedType(type);
		
		Expression lhs = binaryOperatorExpression.getLhs();
		Expression rhs = binaryOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		if (isLogicalOperator(binaryOperatorExpression)) {
			if (lhs.getResolvedType() instanceof AnyType || rhs.getResolvedType() instanceof AnyType) {
				
			}
			else {
				if(binaryOperatorExpression.getLhs().getResolvedType() instanceof BooleanType)
				{
					if (binaryOperatorExpression.getRhs().getResolvedType() instanceof BooleanType) {
						
					}
					else {
						context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression is not of type Boolean");
					}
				}
				else {
					context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression is not of type Boolean");
				}
			}
		}
		else if (isComparativeOperator(binaryOperatorExpression)) {
			
			
			
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
		else if(isEqualityComparisonOperator(binaryOperatorExpression))
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
		
		context.setAssets(type, binaryOperatorExpression);
		return null;
	}
	
	
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

}
