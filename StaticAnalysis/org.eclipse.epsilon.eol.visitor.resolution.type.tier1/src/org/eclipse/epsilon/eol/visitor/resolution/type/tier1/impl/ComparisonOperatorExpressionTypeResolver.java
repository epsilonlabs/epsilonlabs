package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.ComparisonOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.LessThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.ComparisonOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ComparisonOperatorExpressionTypeResolver extends ComparisonOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			ComparisonOperatorExpression comparisonOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(comparisonOperatorExpression.getLhs(), context);
		controller.visit(comparisonOperatorExpression.getRhs(), context);
		
		BooleanType type = context.getEolFactory().createBooleanType(); 
		comparisonOperatorExpression.setResolvedType(type);
		context.setAssets(type, comparisonOperatorExpression);
		
		Expression lhs = comparisonOperatorExpression.getLhs();
		Expression rhs = comparisonOperatorExpression.getRhs();
		
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
		
		if (isComparativeOperator(comparisonOperatorExpression)) {
			if (lhsType instanceof AnyType || rhsType instanceof AnyType) {
				if (lhsType instanceof AnyType) {
					context.getLogBook().addError(lhs, "Expression is of type Any");
				}
				else if (rhsType instanceof AnyType) {
					context.getLogBook().addError(rhs, "Expression is of type Any");
				}
				return null;
			}
			else if (lhsType instanceof IntegerType || lhsType instanceof RealType) {
				if (rhsType instanceof IntegerType || rhsType instanceof RealType) {
					
				}
				else {
					context.getLogBook().addError(rhs, "Expected type: " + lhsType.getClass().getSimpleName());
				}
				return null;
			}
			else {
				if (!(lhsType instanceof IntegerType) || !(lhsType instanceof RealType)) {
					context.getLogBook().addError(lhs, "Expression should be of type Integer or Real");	
				}
				if (!(rhsType instanceof IntegerType) || !(rhsType instanceof RealType)) {
					context.getLogBook().addError(rhs, "Expression should be of type Integer or Real");
				}
				return null;
			}
		}
		else if(isEqualityComparisonOperator(comparisonOperatorExpression))
		{
		
			if (lhsType instanceof AnyType || rhsType instanceof AnyType) {
				if (lhsType instanceof AnyType) {
					context.getLogBook().addError(lhs, "Expression is of type Any");
				}
				else if (rhsType instanceof AnyType) {
					context.getLogBook().addError(rhs, "Expression is of type Any");
				}
				return null;
			}
			else if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
				if (lhsType instanceof BooleanType) {
					if (rhsType instanceof BooleanType) {
						
					}
					else {
						context.getLogBook().addError(rhsType, "Expected boolean type, actual type is: " + rhsType.getClass().getSimpleName());
					}
					return null;
				}
				else if (lhsType instanceof StringType) {
					if (rhsType instanceof StringType) {
						
					}
					else {
						context.getLogBook().addError(rhsType, "Expected String type, actual type is: " + rhsType.getClass().getSimpleName());
					}
					return null;
				}
				else if (lhsType instanceof IntegerType || lhsType instanceof RealType)
				{
					if (rhsType instanceof IntegerType || rhsType instanceof RealType) {
						
					}
					else {
						context.getLogBook().addError(rhs, "Expression should be of either type Integer or type Real");
					}	
					return null;
				}
			}
		}
		return null;
	}
	
	public boolean isComparativeOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof GreaterThanOperatorExpression ||
				op instanceof GreaterThanOrEqualToOperatorExpression ||
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
