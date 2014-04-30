package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MinusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class MinusOperatorExpressionTypeResolver extends MinusOperatorExpressionVisitor<TypeResolutionContext, Object>{
	

	@Override
	public Object visit(MinusOperatorExpression minusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(minusOperatorExpression, context); //visit contents first
		
		Type type = context.getEolFactory().createIntegerType(); //create an integer type
		
		if(minusOperatorExpression.getLhs().getResolvedType() == null)
		{
			context.getLogBook().addError(minusOperatorExpression.getLhs(), "Cannot resolve type");
		}
		
		if(minusOperatorExpression.getRhs().getResolvedType() == null)
		{
			context.getLogBook().addError(minusOperatorExpression.getRhs(), "Cannot resolve type");
		}
		
		if(!(minusOperatorExpression.getLhs().getResolvedType() instanceof PrimitiveType))
		{
			context.getLogBook().addError(minusOperatorExpression.getLhs(), "Expression is not of primitive type");
		}
		
		if(!(minusOperatorExpression.getRhs().getResolvedType() instanceof PrimitiveType))
		{
			context.getLogBook().addError(minusOperatorExpression.getRhs(), "Expression is not of primitive type");
		}

		
		if(minusOperatorExpression.getLhs().getResolvedType() instanceof StringType)
		{
			context.getLogBook().addError(minusOperatorExpression.getLhs(), "Expression cannot be of type String");
		}
		
		if(minusOperatorExpression.getRhs().getResolvedType() instanceof StringType)
		{
			context.getLogBook().addError(minusOperatorExpression.getRhs(), "Expression cannot be of type String");
		}


		
		if(minusOperatorExpression.getLhs().getResolvedType() instanceof BooleanType)
		{
			context.getLogBook().addError(minusOperatorExpression.getLhs(), "Expression is of type Boolean");

			//handle lhs boolean
		}
		
		if(minusOperatorExpression.getRhs().getResolvedType() instanceof BooleanType)
		{
			context.getLogBook().addError(minusOperatorExpression.getRhs(), "Expression is of type Boolean");

			//handle rhs boolean
		}
		
		if (minusOperatorExpression.getLhs().getResolvedType() instanceof RealType ||
				minusOperatorExpression.getRhs().getResolvedType() instanceof RealType) {
			 type = context.getEolFactory().createRealType(); //if any is real, create a real type
		}
				
		context.setAssets(type, minusOperatorExpression); //set assets for the type
		minusOperatorExpression.setResolvedType(type);
		return null;
	}

}
