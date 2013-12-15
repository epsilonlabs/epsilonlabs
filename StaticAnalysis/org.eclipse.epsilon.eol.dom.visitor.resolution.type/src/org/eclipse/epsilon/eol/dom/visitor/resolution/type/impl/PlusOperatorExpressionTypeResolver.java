package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.BooleanType;
import org.eclipse.epsilon.eol.dom.PlusOperatorExpression;
import org.eclipse.epsilon.eol.dom.PrimitiveType;
import org.eclipse.epsilon.eol.dom.RealType;
import org.eclipse.epsilon.eol.dom.StringType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class PlusOperatorExpressionTypeResolver extends PlusOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(plusOperatorExpression, context);
		
		Type type = context.getEolFactory().createIntegerType();
		
		
		
		if(plusOperatorExpression.getLhs().getResolvedType() == null)
		{
			context.getLogBook().addError(plusOperatorExpression.getLhs(), "Cannot resolve type");
		}
		
		if(plusOperatorExpression.getRhs().getResolvedType() == null)
		{
			context.getLogBook().addError(plusOperatorExpression.getRhs(), "Cannot resolve type");
		}
		
		if(!(plusOperatorExpression.getLhs().getResolvedType() instanceof PrimitiveType))
		{
			context.getLogBook().addError(plusOperatorExpression.getLhs(), "Expression is not of primitive type");
		}
		
		if(!(plusOperatorExpression.getRhs().getResolvedType() instanceof PrimitiveType))
		{
			context.getLogBook().addError(plusOperatorExpression.getRhs(), "Expression is not of primitive type");
		}

		if(plusOperatorExpression.getLhs().getResolvedType() instanceof BooleanType)
		{
			context.getLogBook().addError(plusOperatorExpression.getLhs(), "Expression is of type Boolean");
			//handle lhs boolean
		}
		
		if(plusOperatorExpression.getRhs().getResolvedType() instanceof BooleanType)
		{
			context.getLogBook().addError(plusOperatorExpression.getRhs(), "Expression is of type Boolean");
			//handle rhs boolean
		}
		
		if (plusOperatorExpression.getLhs().getResolvedType() instanceof RealType ||
				plusOperatorExpression.getRhs().getResolvedType() instanceof RealType) {
			 type = context.getEolFactory().createRealType();
		}
		
		if(plusOperatorExpression.getLhs().getResolvedType() instanceof StringType ||
				plusOperatorExpression.getRhs().getResolvedType() instanceof StringType)
		{
			 type = context.getEolFactory().createStringType();
		}		
		
		context.setAssets(type, plusOperatorExpression);
		plusOperatorExpression.setResolvedType(type);

		return null;
	}
	


}
