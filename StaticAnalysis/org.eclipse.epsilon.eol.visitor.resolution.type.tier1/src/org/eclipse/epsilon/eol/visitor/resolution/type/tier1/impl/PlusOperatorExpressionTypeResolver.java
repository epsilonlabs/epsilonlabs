package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class PlusOperatorExpressionTypeResolver extends PlusOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(plusOperatorExpression, context); //visit contents first
		
		Expression lhs = plusOperatorExpression.getLhs();
		Expression rhs = plusOperatorExpression.getRhs();
		
		controller.visit(lhs, context);
		controller.visit(rhs, context);
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		
		Type type = context.getEolFactory().createIntegerType(); //create an integer type
		
		
		if(lhsType == null)
		{
			context.getLogBook().addError(lhs, "Cannot resolve type");
		}
		
		if(rhsType == null)
		{
			context.getLogBook().addError(rhs, "Cannot resolve type");
		}
		
		if (lhsType instanceof AnyType) {
			if (rhsType instanceof IntegerType || rhsType instanceof RealType || rhsType instanceof StringType) {
				type = EcoreUtil.copy(rhsType);
			}
			else {
				if (rhsType instanceof AnyType) {
					context.getLogBook().addWarning(plusOperatorExpression, "potential type mismatch");
				}
				else {
					context.getLogBook().addError(rhs, "Expression should be numeral");	
				}
				
			}
		}
		
		else if (rhsType instanceof AnyType) {
			if (lhsType instanceof IntegerType || lhsType instanceof RealType || lhsType instanceof StringType) {
				type = EcoreUtil.copy(lhsType);
			}
			else {
				if (rhsType instanceof AnyType) {
					context.getLogBook().addWarning(plusOperatorExpression, "potential type mismatch");
				}
				context.getLogBook().addError(lhs, "Expression should be numeral");
			}
		}

		else if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
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
			
			if (lhsType instanceof StringType || rhsType instanceof StringType) {
				type = context.getEolFactory().createStringType();
			}

		}
		else if (lhsType instanceof CollectionType && rhsType instanceof CollectionType) {
			if (context.getTypeUtil().isEqualOrGeneric(lhsType, rhsType)) {
				type = EcoreUtil.copy(lhsType);
			}
			else {
				context.getLogBook().addError(plusOperatorExpression, "Operands types are not compatible");
			}
		}
		else {
			if(!(lhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(lhs, "Expression type not applicable");
				
			}
			
			if(!(rhsType instanceof PrimitiveType))
			{
				context.getLogBook().addError(rhs, "Expression type not applicable");
			}
		}
		context.setAssets(type, plusOperatorExpression);
		plusOperatorExpression.setResolvedType(type);

		return null;
	}
	
	


}
