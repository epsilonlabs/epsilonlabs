package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class MultiplyOperatorExpressionTypeResolver_old extends BinaryOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public boolean appliesTo(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context) {
		return binaryOperatorExpression instanceof MultiplyOperatorExpression;
	}
	
	@Override
	public Object visit(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(binaryOperatorExpression, context);
		
		Expression lhs = binaryOperatorExpression.getLhs();
		Expression rhs = binaryOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = context.getEolFactory().createIntegerType();
		binaryOperatorExpression.setResolvedType(type);
		context.setAssets(type, binaryOperatorExpression);
		
		
		if(lhsType == null){
			context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression does not have a type");
			return null;
		}
		
		if(rhsType == null)
		{
			context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression does not have a type");
			return null;
		}
		
		if (lhsType instanceof AnyType) {
			context.getLogBook().addError(rhs, "Expression is of type Any");
			return null;
		}
		
		if (rhsType instanceof AnyType) {
			context.getLogBook().addError(rhs, "Expression is of type Any");
			return null;
		}

		
		if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
			if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
				return null;
			}
			else {
				if (lhsType instanceof StringType || rhsType instanceof StringType) {
					if(lhsType instanceof StringType)
					{
						context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression should be numeral");
					}
					
					if(rhsType instanceof StringType)
					{
						context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression should be numeral");
					}
					return null;
				}
				
				else if (lhsType instanceof BooleanType || rhsType instanceof BooleanType) {
					if(lhsType instanceof BooleanType)
					{
						context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression should be numeral");
					}
					
					if(rhsType instanceof BooleanType)
					{
						context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression should be numeral");
					}
					return null;
				}
				
				if (lhsType instanceof IntegerType && rhsType instanceof RealType) {
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				if (rhsType instanceof RealType && rhsType instanceof IntegerType) {
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				if (rhsType instanceof RealType && rhsType instanceof RealType) {
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				context.setAssets(type, binaryOperatorExpression);
				binaryOperatorExpression.setResolvedType(type);
				return null;
			}
		}
		else {
			if (lhsType instanceof IntegerType || lhsType instanceof RealType) {
				context.getLogBook().addError(rhs, "Expression should be numeral");
				type = EcoreUtil.copy(lhsType);
				context.setAssets(type, binaryOperatorExpression);
				binaryOperatorExpression.setResolvedType(type);
				return null;
			}
			
			else if (rhsType instanceof IntegerType || rhsType instanceof RealType) {
				context.getLogBook().addError(lhs, "Expression should be numeral");
				type = EcoreUtil.copy(rhsType);
				context.setAssets(type, binaryOperatorExpression);
				binaryOperatorExpression.setResolvedType(type);
				return null;
			}
			
			if(!(lhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression should be numeral");
			}
			
			if(!(rhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression should be numeral");
			}
		}
		
		context.setAssets(type, binaryOperatorExpression);
		binaryOperatorExpression.setResolvedType(type);
		return null;
	}

}
