package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.MinusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MinusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class MinusOperatorExpressionTypeResolver extends MinusOperatorExpressionVisitor<TypeResolutionContext, Object>{
	

	@Override
	public Object visit(MinusOperatorExpression minusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(minusOperatorExpression, context);
		
		//get lhs and rhs
		Expression lhs = minusOperatorExpression.getLhs();
		Expression rhs = minusOperatorExpression.getRhs();
 
		//get lhstype and rhstype
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		//create Real for return type first
		Type type = EolFactory.eINSTANCE.createRealType();
		minusOperatorExpression.setResolvedType(type);
		context.setAssets(type, minusOperatorExpression);
		
		//if lhstype is null
		if(lhsType == null){
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		//if rhstype is null
		if(rhsType == null){
			LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		//get type util
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		if (!(lhsType instanceof RealType) && (!typeUtil.isInstanceofAnyType(lhsType))) {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
		}
		
		if (!(rhsType instanceof RealType) && (!typeUtil.isInstanceofAnyType(rhsType))) {
			LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
		}
		
		//if lhstype is real
		if (lhsType instanceof IntegerType) {
			if (rhsType instanceof IntegerType) {
				type = EolFactory.eINSTANCE.createIntegerType();
				minusOperatorExpression.setResolvedType(type);
				context.setAssets(type, minusOperatorExpression);
				return null;
			}
			else if (rhsType instanceof RealType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getIntegerType())) {
					type = EolFactory.eINSTANCE.createIntegerType();
					minusOperatorExpression.setResolvedType(type);
					context.setAssets(type, minusOperatorExpression);
					return null;
				}
				else if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
			}
			return null;
		}
		
		if (lhsType instanceof RealType) {
			if (rhsType instanceof RealType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
			}
			return null;
		}
		
		if (typeUtil.isInstanceofAnyType(lhsType)) {
			if (rhsType instanceof IntegerType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getIntegerType())) {
					type = EolFactory.eINSTANCE.createIntegerType();
					minusOperatorExpression.setResolvedType(type);
					context.setAssets(type, minusOperatorExpression);
					return null;
				}
				else if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getName()));
				}
			}
			else if (rhsType instanceof RealType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getName()));
				}
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				ArrayList<Type> types = TypeInferenceManager.getInstance().getCommonTypesForTwoAnys((AnyType)lhsType, (AnyType)rhsType);
				boolean foundReal = false;
				if (types.size() == 0) {
					if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
						LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
					}
					if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
					}
					return null;
				}
				for(Type t: types)
				{
					if (t instanceof IntegerType) {
						type = EolFactory.eINSTANCE.createIntegerType();
						minusOperatorExpression.setResolvedType(type);
						context.setAssets(type, minusOperatorExpression);
						return null;
					}
					else if (t instanceof RealType) {
						foundReal = true;
					}
					else {
						if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
							LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
						}
						if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
							LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
						}
					}
				}
				if (foundReal) {
					return null;
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
			}
			return null;
		}
		
		if (rhsType instanceof IntegerType) {
			if (lhsType instanceof IntegerType) {
				type = EolFactory.eINSTANCE.createIntegerType();
				minusOperatorExpression.setResolvedType(type);
				context.setAssets(type, minusOperatorExpression);
				return null;
			}
			else if (lhsType instanceof RealType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getIntegerType())) {
					type = EolFactory.eINSTANCE.createIntegerType();
					minusOperatorExpression.setResolvedType(type);
					context.setAssets(type, minusOperatorExpression);
					return null;
				}
				else if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getName()));
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getName()));
			}
			return null;
		}
		
		if (rhsType instanceof RealType) {
			if (lhsType instanceof RealType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getName()));
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getName()));
			}
			return null;
		}
		
		if (typeUtil.isInstanceofAnyType(rhsType)) {
			if (lhsType instanceof IntegerType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getIntegerType())) {
					type = EolFactory.eINSTANCE.createIntegerType();
					minusOperatorExpression.setResolvedType(type);
					context.setAssets(type, minusOperatorExpression);
					return null;
				}
				else if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				}
			}
			else if (lhsType instanceof RealType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				}
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				ArrayList<Type> types = TypeInferenceManager.getInstance().getCommonTypesForTwoAnys((AnyType)lhsType, (AnyType)rhsType);
				boolean foundReal = false;
				if (types.size() == 0) {
					if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
						LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
					}
					if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
					}
					return null;
				}
				for(Type t: types)
				{
					if (t instanceof IntegerType) {
						type = EolFactory.eINSTANCE.createIntegerType();
						minusOperatorExpression.setResolvedType(type);
						context.setAssets(type, minusOperatorExpression);
						return null;
					}
					else if (t instanceof RealType) {
						foundReal = true;
					}
					else {
						if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
							LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
						}
						if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
							LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
						}
					}
				}
				if (foundReal) {
					return null;
				}
			}
			else {
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
			}
		}
		
		return null;
	}

}
