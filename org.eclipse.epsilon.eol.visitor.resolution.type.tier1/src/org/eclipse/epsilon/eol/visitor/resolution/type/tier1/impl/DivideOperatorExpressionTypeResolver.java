package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.DivideOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.RealExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.DivideOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class DivideOperatorExpressionTypeResolver extends DivideOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(DivideOperatorExpression divideOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit contents first
		controller.visitContents(divideOperatorExpression, context);
		
		//get lhs and rhs
		Expression lhs = divideOperatorExpression.getLhs();
		Expression rhs = divideOperatorExpression.getRhs();
		
		//get lhstype and rhstype
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		//create a real type and store it first
		Type type = EolFactory.eINSTANCE.createRealType();
		divideOperatorExpression.setResolvedType(type);
		context.setAssets(type, divideOperatorExpression);
		
		//if lhs does not have a type
		if(lhsType == null){
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		//if rhs does not have a type
		if(rhsType == null){
			LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		//get the type util
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		//check deivision by zero
		if (rhs instanceof RealExpression) {
			if (((RealExpression) rhs).getValue() == 0.0) {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.DIVISION_BY_ZERO);
				return null;
			}
		}
		
		//check division be zero
		if (rhs instanceof IntegerExpression) {
			if (((IntegerExpression) rhs).getValue() == 0) {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.DIVISION_BY_ZERO);
				return null;
			}
		}
		
		//if type is bounded by integer type
		if (lhsType instanceof IntegerType) {
			if (rhsType instanceof IntegerType) {
				type = EolFactory.eINSTANCE.createIntegerType();
				divideOperatorExpression.setResolvedType(type);
				context.setAssets(type, divideOperatorExpression);
				return null;
			}
			else if (rhsType instanceof RealType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				//if anytype is compatible with integer, then it is good
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, lhsType.eClass())) {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
					return null;
				}
				else {
					type = EolFactory.eINSTANCE.createIntegerType();
					divideOperatorExpression.setResolvedType(type);
					context.setAssets(type, divideOperatorExpression);
					return null;
				}
			}
			else {
				//else it is not good
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				return null;
			}
		}
		
		//if lhstype is bounded by real type
		else if (lhsType instanceof RealType) {
			if (rhsType instanceof RealType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				//if anytype is compatible with real, then it is good
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, lhsType.eClass())) {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
					return null;
				}
				else {
					return null;
				}
			}
			else {
				//else it is not good
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				return null;
			}
		}
		
		//if lhsType is any
		else if (typeUtil.isInstanceofAnyType(lhsType)) {
			
			//if rhs is integer
			if (rhsType instanceof IntegerType) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, rhsType.eClass())) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
				else {
					type = EolFactory.eINSTANCE.createIntegerType();
					divideOperatorExpression.setResolvedType(type);
					context.setAssets(type, divideOperatorExpression);
				}
				return null;
			}
			//if rhs is real
			else if (rhsType instanceof RealType) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, rhsType.eClass())) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
				return null;
			}
			
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				
				Type lhsTempType = null;

				if (lhs instanceof NameExpression) {
					ArrayList<Type> lhsTypes = TypeInferenceManager.getInstance().getTypesForName((NameExpression) lhs);
					for(Type t: lhsTypes)
					{
						if (t instanceof IntegerType) {
							lhsTempType = t;
							break;
						}
						else if (t instanceof RealType) {
							lhsTempType = t;
						}
					}
				}
				
				if (lhsTempType == null) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
					return null;
				}
				
				boolean match = false;
				
				for(Type t2: ((AnyType)rhsType).getDynamicTypes())
				{
					if(t2 instanceof IntegerType)
					{
//						if (TypeUtil.getInstance().isTypeEqual(t2, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsTempType, t2.eClass()))) {
							//LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
							match = true;
							type = EolFactory.eINSTANCE.createIntegerType();
							divideOperatorExpression.setResolvedType(type);
							context.setAssets(type, divideOperatorExpression);
							return null;
//						}
					}
					else if (t2 instanceof RealType) {
						//try if there exists a type in lhs that is equal to t
//						if (TypeUtil.getInstance().isTypeEqual(t2, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsTempType, t2.eClass()))) {
							//LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
							match = true;
							return null;
//						}
					}
				}
				
				if (!match) {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
					return null;
				}
			}
			else {
				LogBook.getInstance().addError(divideOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				return null;
			}
		}
		else {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
			return null;
		}
		
		return null;
	}

}
