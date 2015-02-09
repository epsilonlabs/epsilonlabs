package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.DivideOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.DivideOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class DivideOperatorExpressionTypeResolver extends DivideOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(DivideOperatorExpression divideOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(divideOperatorExpression, context);
		
		Expression lhs = divideOperatorExpression.getLhs();
		Expression rhs = divideOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = context.getEolFactory().createAnyType();
		divideOperatorExpression.setResolvedType(type);
		context.setAssets(type, divideOperatorExpression);
		
		
		if(lhsType == null){
			context.getLogBook().addError(divideOperatorExpression.getLhs(), "Expression does not have a type");
			return null;
		}
		
		if(rhsType == null){
			context.getLogBook().addError(divideOperatorExpression.getRhs(), "Expression does not have a type");
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
				if (rhs instanceof IntegerExpression) {
					IntegerExpression val = (IntegerExpression) rhs;
					if (val.getVal() == 0) {
						context.getLogBook().addError(divideOperatorExpression.getLhs(), "Dividing by 0");
					}
				}
				type = context.getEolFactory().createIntegerType();
				divideOperatorExpression.setResolvedType(type);
				context.setAssets(type, divideOperatorExpression);
				return null;
			}
			else {
				if (lhsType instanceof StringType || rhsType instanceof StringType) {
					if(lhsType instanceof StringType)
					{
						context.getLogBook().addError(divideOperatorExpression.getLhs(), "Expression should be numeral");
					}
					
					if(rhsType instanceof StringType)
					{
						context.getLogBook().addError(divideOperatorExpression.getRhs(), "Expression should be numeral");
					}
					return null;
				}
				
				else if (lhsType instanceof BooleanType || rhsType instanceof BooleanType) {
					if(lhsType instanceof BooleanType)
					{
						context.getLogBook().addError(divideOperatorExpression.getLhs(), "Expression should be numeral");
					}
					
					if(rhsType instanceof BooleanType)
					{
						context.getLogBook().addError(divideOperatorExpression.getRhs(), "Expression should be numeral");
					}
					return null;
				}
				
				if (lhsType instanceof IntegerType && rhsType instanceof RealType) {
					if (rhs instanceof RealExpression) {
						RealExpression val = (RealExpression) rhs;
						if (val.getVal() == 0.0) {
							context.getLogBook().addError(divideOperatorExpression.getLhs(), "Dividing by 0");
						}
					}
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				if (rhsType instanceof RealType && rhsType instanceof IntegerType) {
					if (rhs instanceof IntegerExpression) {
						IntegerExpression val = (IntegerExpression) rhs;
						if (val.getVal() == 0) {
							context.getLogBook().addError(divideOperatorExpression.getLhs(), "Dividing by 0");
						}
					}
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				if (rhsType instanceof RealType && rhsType instanceof RealType) {
					if (rhs instanceof RealExpression) {
						RealExpression val = (RealExpression) rhs;
						if (val.getVal() == 0.0) {
							context.getLogBook().addError(divideOperatorExpression.getLhs(), "Dividing by 0");
						}
					}
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				context.setAssets(type, divideOperatorExpression);
				divideOperatorExpression.setResolvedType(type);
				return null;
			}
		}
		else {
			if(!(lhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(divideOperatorExpression.getLhs(), "Expression should be numeral");
			}
			
			if(!(rhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(divideOperatorExpression.getRhs(), "Expression should be numeral");
			}
		}
		
		context.setAssets(type, divideOperatorExpression);
		divideOperatorExpression.setResolvedType(type);
		return null;
	}

}
