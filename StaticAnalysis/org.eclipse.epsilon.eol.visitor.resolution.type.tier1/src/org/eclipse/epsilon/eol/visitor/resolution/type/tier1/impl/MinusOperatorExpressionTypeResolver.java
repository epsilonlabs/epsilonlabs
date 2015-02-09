package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
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

public class MinusOperatorExpressionTypeResolver extends MinusOperatorExpressionVisitor<TypeResolutionContext, Object>{
	

	@Override
	public Object visit(MinusOperatorExpression minusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(minusOperatorExpression, context); //visit contents first
		
		Expression lhs = minusOperatorExpression.getLhs();
		Expression rhs = minusOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = context.getEolFactory().createAnyType(); //create an integer type
		minusOperatorExpression.setResolvedType(type);
		context.setAssets(type, minusOperatorExpression);
		
		if(lhsType == null)
		{
			context.getLogBook().addError(lhs, "Expression does not have a type");
			return null;
		}
		
		if(rhsType == null)
		{
			context.getLogBook().addError(rhs, "Expression does not have a type");
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
				type = context.getEolFactory().createIntegerType(); //create an integer type
				minusOperatorExpression.setResolvedType(type);
				context.setAssets(type, minusOperatorExpression);
				return null;
			}
			else {
				if (lhsType instanceof StringType || rhsType instanceof StringType) {
					if(lhsType instanceof StringType)
					{
						context.getLogBook().addError(lhs, "Expression should be numeral");
						return null;
					}
					
					if(rhsType instanceof StringType)
					{
						context.getLogBook().addError(rhs, "Expression should be numeral");
					}
					return null;
				}
				if (lhsType instanceof BooleanType || rhsType instanceof BooleanType) {
					if(lhsType instanceof BooleanType)
					{
						context.getLogBook().addError(lhs, "Expression should be numeral");
					}
					
					if(rhsType instanceof BooleanType)
					{
						context.getLogBook().addError(rhs, "Expression should be numeral");
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
				return null;
			}

		}
		else if (lhsType instanceof CollectionType && rhsType instanceof CollectionType) {
			type = EcoreUtil.copy(lhsType);
			minusOperatorExpression.setResolvedType(type);
			context.setAssets(type, minusOperatorExpression);
			return null;
		}
		else {
			if(!(lhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(lhs, "Expression should be numeral");
			}
			
			if(!(rhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(rhs, "Expression should be numeral");
			}
		}
				
		return null;
	}

}
