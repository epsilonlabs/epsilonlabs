package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class MultiplyOperatorExpressionTypeResolver extends BinaryOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public boolean appliesTo(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context) {
		return binaryOperatorExpression instanceof MultiplyOperatorExpression ||
				binaryOperatorExpression instanceof DivideOperatorExpression;
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
		
		
		if(lhsType == null){
			context.getLogBook().addError(binaryOperatorExpression.getLhs(), "type is not properly resolved");
		}
		
		if(rhsType == null)
		{
			context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Cannot resolve type");
		}
		
		if (lhsType instanceof AnyType) {
			if (rhsType instanceof IntegerType || rhsType instanceof RealType) {
				type = EcoreUtil.copy(rhsType);
			}
			else {
				context.getLogBook().addError(rhs, "Expression should be numeral");
			}
		}
		
		if (rhsType instanceof AnyType) {
			if (lhsType instanceof IntegerType || lhsType instanceof RealType) {
				type = EcoreUtil.copy(lhsType);
			}
			else {
				context.getLogBook().addError(lhs, "Expression should be numeral");
			}
		}
		
		if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
			if(lhsType instanceof StringType)
			{
				context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression cannot be of type String");
			}
			
			if(rhsType instanceof StringType)
			{
				context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression cannot be of type String");
			}
			
			if(lhsType instanceof BooleanType)
			{
				context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression is of type Boolean");

				//handle lhs boolean
			}
			
			if(rhsType instanceof BooleanType)
			{
				context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression is of type Boolean");

				//handle rhs boolean
			}
			
			if (lhsType instanceof IntegerType && rhsType instanceof RealType) {
				type = context.getEolFactory().createRealType(); //if any is real, create a real type
			}
			
			if (rhsType instanceof RealType && rhsType instanceof IntegerType) {
				type = context.getEolFactory().createRealType(); //if any is real, create a real type
			}

		}
		else {
			if(!(lhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(binaryOperatorExpression.getLhs(), "Expression is not of primitive type");
				
			}
			
			if(!(rhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(binaryOperatorExpression.getRhs(), "Expression is not of primitive type");
			}
		}

		
		context.setAssets(type, binaryOperatorExpression);
		binaryOperatorExpression.setResolvedType(type);
		return null;
	}

}
