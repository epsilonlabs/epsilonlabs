package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.MinusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MinusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class MinusOperatorExpressionTypeResolver extends MinusOperatorExpressionVisitor<TypeResolutionContext_T2, Object>{
	

	@Override
	public Object visit(MinusOperatorExpression minusOperatorExpression,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		controller.visitContents(minusOperatorExpression, context); //visit contents first
		
		Expression lhs = minusOperatorExpression.getLhs();
		Expression rhs = minusOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = context.getEolFactory().createIntegerType(); //create an integer type
		
		if(lhsType == null){
			context.getLogBook().addError(lhs, "type is not properly resolved");
		}
		
		if(rhsType == null)
		{
			context.getLogBook().addError(rhs, "Cannot resolve type");
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
				context.getLogBook().addError(lhs, "Expression cannot be of type String");
			}
			
			if(rhsType instanceof StringType)
			{
				context.getLogBook().addError(rhs, "Expression cannot be of type String");
			}
			
			if(lhsType instanceof BooleanType)
			{
				context.getLogBook().addError(lhs, "Expression is of type Boolean");

				//handle lhs boolean
			}
			
			if(rhsType instanceof BooleanType)
			{
				context.getLogBook().addError(rhs, "Expression is of type Boolean");

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
				context.getLogBook().addError(lhs, "Expression is not of primitive type");
				
			}
			
			if(!(rhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(rhs, "Expression is not of primitive type");
			}
		}
				
		context.setAssets(type, minusOperatorExpression); //set assets for the type
		minusOperatorExpression.setResolvedType(type);
		return null;
	}

}
