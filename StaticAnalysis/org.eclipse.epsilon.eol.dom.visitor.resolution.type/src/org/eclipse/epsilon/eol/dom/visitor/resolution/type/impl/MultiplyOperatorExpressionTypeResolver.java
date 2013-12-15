package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.dom.BooleanType;
import org.eclipse.epsilon.eol.dom.DivideOperatorExpression;
import org.eclipse.epsilon.eol.dom.MultiplyOperatorExpression;
import org.eclipse.epsilon.eol.dom.RealType;
import org.eclipse.epsilon.eol.dom.StringType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

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
		
		Type type = context.getEolFactory().createIntegerType();
		
		if(binaryOperatorExpression.getLhs().getResolvedType() instanceof BooleanType)
		{
			//handle lhs boolean
		}
		
		if(binaryOperatorExpression.getRhs().getResolvedType() instanceof BooleanType)
		{
			//handle rhs boolean
		}
		
		if(binaryOperatorExpression.getLhs().getResolvedType() instanceof StringType)
		{
			//handle lhs string
		}
		
		if(binaryOperatorExpression.getRhs().getResolvedType() instanceof StringType)
		{
			//handle lhs string
		}
		
		if (binaryOperatorExpression.getLhs().getResolvedType() instanceof RealType ||
				binaryOperatorExpression.getLhs().getResolvedType() instanceof RealType) {
			 type = context.getEolFactory().createRealType();
		}
		
		context.setAssets(type, binaryOperatorExpression);
		return null;
	}

}
