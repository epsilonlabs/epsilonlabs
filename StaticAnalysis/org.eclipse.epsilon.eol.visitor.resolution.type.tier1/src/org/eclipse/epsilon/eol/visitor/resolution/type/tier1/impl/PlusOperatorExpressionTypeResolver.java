package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.PlusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class PlusOperatorExpressionTypeResolver extends PlusOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(plusOperatorExpression, context); //visit contents first
		
		//get lhs and rhs
		Expression lhs = plusOperatorExpression.getLhs();
		Expression rhs = plusOperatorExpression.getRhs();
		
		//visit lhs and rhs
		controller.visit(lhs, context);
		controller.visit(rhs, context);
		
		//get the typs of lhs and rhs
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		//create an integer type and assign it to the expression
		Type type = context.getEolFactory().createStringType(); 
		plusOperatorExpression.setResolvedType(type);
		context.setAssets(type, plusOperatorExpression);

		if (lhsType == null || rhsType == null) {
			if(lhsType == null)
			{
				context.getLogBook().addError(lhs, "Expression does not have a type");
			}
			
			else if(rhsType == null)
			{
				context.getLogBook().addError(lhs, "Expression does not have a type");
			}
			type = context.getEolFactory().createStringType();
			plusOperatorExpression.setResolvedType(type);
			context.setAssets(type, plusOperatorExpression);
			return null;
		}
		else if (lhsType instanceof AnyType || rhsType instanceof AnyType) {
			if (lhsType instanceof AnyType) {
				context.getLogBook().addWarning(lhs, "Expression is of type Any");
				context.getLogBook().addWarning(plusOperatorExpression, "potential type mismatch");
			}
			
			else if (rhsType instanceof AnyType) {
				context.getLogBook().addWarning(rhs, "Expression is of type Any");
				context.getLogBook().addWarning(plusOperatorExpression, "potential type mismatch");
			}
			type = context.getEolFactory().createStringType();
			plusOperatorExpression.setResolvedType(type);
			context.setAssets(type, plusOperatorExpression);
			return null;
		}
		else if((lhsType instanceof CollectionType && !(rhs instanceof CollectionType)) ||
				(rhsType instanceof CollectionType && !(lhs instanceof CollectionType)) )
		{
			type = context.getEolFactory().createStringType();
			plusOperatorExpression.setResolvedType(type);
			context.setAssets(type, plusOperatorExpression);
		}
		else if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
			if (lhsType instanceof BooleanType || rhsType instanceof BooleanType) {
				type = context.getEolFactory().createStringType();
				plusOperatorExpression.setResolvedType(type);
				context.setAssets(type, plusOperatorExpression);
				return null;
			}
			else {
				if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
					type = context.getEolFactory().createIntegerType(); 
				}
				
				else if (lhsType instanceof IntegerType && rhsType instanceof RealType) {
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				else if (lhsType instanceof IntegerType && rhsType instanceof StringType) {
					type = context.getEolFactory().createStringType();
				}

				else if (rhsType instanceof RealType && rhsType instanceof IntegerType) {
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				else if (rhsType instanceof RealType && rhsType instanceof RealType) {
					type = context.getEolFactory().createRealType(); //if any is real, create a real type
				}
				
				else if (lhsType instanceof RealType && rhsType instanceof StringType) {
					type = context.getEolFactory().createStringType();
				}
				
				else if (lhsType instanceof StringType && rhsType instanceof IntegerType) {
					type = context.getEolFactory().createStringType();
				}
				
				else if (lhsType instanceof StringType && rhsType instanceof RealType) {
					type = context.getEolFactory().createStringType();
				}
				
				else if (lhsType instanceof StringType && rhsType instanceof StringType) {
					type = context.getEolFactory().createStringType();
				}

				plusOperatorExpression.setResolvedType(type);
				context.setAssets(type, plusOperatorExpression);
				return null;
			}
		}
		else if (lhsType instanceof CollectionType && rhsType instanceof CollectionType) {
			plusOperatorExpression.setResolvedType(EcoreUtil.copy(lhsType));
			context.setAssets(type, plusOperatorExpression);
			return null;
		}
		plusOperatorExpression.setResolvedType(type);
		context.setAssets(type, plusOperatorExpression);
		return null;
	}
}
