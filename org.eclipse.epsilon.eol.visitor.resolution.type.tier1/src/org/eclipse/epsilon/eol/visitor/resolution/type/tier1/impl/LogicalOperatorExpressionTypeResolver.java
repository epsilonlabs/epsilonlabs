package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AndOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.ImpliesOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.LessThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.OrOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.XorOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class LogicalOperatorExpressionTypeResolver extends BinaryOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public boolean appliesTo(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context) {
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
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(binaryOperatorExpression.getLhs(), context);
		controller.visit(binaryOperatorExpression.getRhs(), context);
		
		BooleanType type = EolFactory.eINSTANCE.createBooleanType(); //set type first, this allows minor-error in expressions n statements
		binaryOperatorExpression.setResolvedType(type);
		
		if (isLogicalOperator(binaryOperatorExpression)) {
			if(binaryOperatorExpression.getLhs().getResolvedType() instanceof BooleanType)
			{
				if (binaryOperatorExpression.getRhs().getResolvedType() instanceof BooleanType) {
					
				}
				else {
					context.getLogBook().addError(binaryOperatorExpression.getRhs(), IMessage_TypeResolution.EXPRESSION_NOT_BOOLEAN_TYPE);
				}
			}
			else {
				context.getLogBook().addError(binaryOperatorExpression.getLhs(), IMessage_TypeResolution.EXPRESSION_NOT_BOOLEAN_TYPE);
			}
		}
		else if (isComparativeOperator(binaryOperatorExpression)) {
			Expression lhs = binaryOperatorExpression.getLhs();
			Expression rhs = binaryOperatorExpression.getRhs();
			
			Type lhsType = lhs.getResolvedType();
			Type rhsType = rhs.getResolvedType();
			
			if (lhsType instanceof RealType) {
				if (rhsType instanceof RealType) {
					context.setAssets(type, binaryOperatorExpression);
					return null;
				}
				else {
					context.getLogBook().addError(rhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
			}
			else {
				context.getLogBook().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
			}
		}
		else if(isEqualityComparisonOperator(binaryOperatorExpression))
		{
			Expression lhs = binaryOperatorExpression.getLhs();
			Expression rhs = binaryOperatorExpression.getRhs();
			
			Type lhsType = lhs.getResolvedType();
			Type rhsType = rhs.getResolvedType();
			
			if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
				if (lhsType instanceof BooleanType) {
					if (rhsType instanceof BooleanType) {
						
					}
					else {
						context.getLogBook().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPRESSION_EXPECTED_BOOLEAN, rhsType.getClass().getSimpleName()));
					}
				}
				else if (lhsType instanceof StringType) {
					if (rhsType instanceof StringType) {
						
					}
					else {
						context.getLogBook().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPRESSION_EXPECTED_STRING, rhsType.getClass().getSimpleName()));
					}
				}
				else if (lhsType instanceof RealType)
				{
					if (rhsType instanceof RealType) {
						
					}
					else {
						context.getLogBook().addError(rhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
					}				
				}
				else {
					context.getLogBook().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
			}
			else if (lhsType.getClass().getSimpleName().equals("AnyTypeImpl")) {
				if (rhsType.getClass().getSimpleName().equals("AnyTypeImpl")) {
					
				}
				else {
					context.getLogBook().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
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
