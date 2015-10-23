package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.AndOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.ImpliesOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.LessThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.OrOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.XorOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class LogicalOperatorExpressionTypeResolver extends BinaryOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public boolean appliesTo(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context) {
		return binaryOperatorExpression instanceof AndOperatorExpression ||
				binaryOperatorExpression instanceof OrOperatorExpression ||
				binaryOperatorExpression instanceof ImpliesOperatorExpression ||
				binaryOperatorExpression instanceof XorOperatorExpression ||
				binaryOperatorExpression instanceof GreaterThanOperatorExpression ||
				binaryOperatorExpression instanceof GreaterThanOrEqualToOperatorExpression ||
				binaryOperatorExpression instanceof EqualsOperatorExpression ||
				binaryOperatorExpression instanceof NotEqualsOperatorExpression ||
				binaryOperatorExpression instanceof LessThanOperatorExpression ||
				binaryOperatorExpression instanceof LessThanOrEqualToOperatorExpression;				
	} 

	@Override
	public Object visit(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		//visit lhs and rhs first
		controller.visit(binaryOperatorExpression.getLhs(), context);
		controller.visit(binaryOperatorExpression.getRhs(), context);
		
		//set the type first
		BooleanType type = EolFactory.eINSTANCE.createBooleanType(); 
		binaryOperatorExpression.setResolvedType(type);
		context.setAssets(type, binaryOperatorExpression);
		
		//get the lhs and rhs
		Expression lhs = binaryOperatorExpression.getLhs();
		Expression rhs = binaryOperatorExpression.getRhs();
		
		//get the lhsType and rhsType
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		//get typeUtil
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		//report if type is null
		if (lhsType == null) {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if (rhsType == null) {
			LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		//if is logical operator
		if (isLogicalOperator(binaryOperatorExpression)) {
			
			if (lhsType instanceof BooleanType) {
				
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getBooleanType())) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_BOOLEAN);
				}
			}
			else {
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_BOOLEAN);
			}
			
			if (rhsType instanceof BooleanType) {
				
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getBooleanType())) {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_BOOLEAN);
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_BOOLEAN);
			}
			
			return null;

		}

		
		//if is comparativeOperator
		else if (isComparativeOperator(binaryOperatorExpression)) {
			
			if (!(lhsType instanceof RealType) && (!typeUtil.isInstanceofAnyType(lhsType))) {
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
			}
			
			if (!(rhsType instanceof RealType) && (!typeUtil.isInstanceofAnyType(rhsType))) {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
			}
			
			//if lhstype is real
			if (lhsType instanceof IntegerType) {
				if (rhsType instanceof IntegerType) {
					return null;
				}
				else if (rhsType instanceof RealType) {
					return null;
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getIntegerType())) {
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
						if (t instanceof RealType) {
							foundReal = true;
							return null;
						}
						
					}
					if (foundReal) {
						return null;
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
				else {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
				}
				return null;
			}
			
			if (rhsType instanceof IntegerType) {
				if (lhsType instanceof IntegerType) {
					return null;
				}
				else if (lhsType instanceof RealType) {
					return null;
				}
				else if (typeUtil.isInstanceofAnyType(lhsType)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getIntegerType())) {
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
						if (t instanceof RealType) {
							foundReal = true;
						}
						
					}
					if (foundReal) {
						return null;
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
				else {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_NUMERAL);
				}
				return null;
			}
			
			return null;

		}
		else if(isEqualityComparisonOperator(binaryOperatorExpression))
		{
			
			if (lhsType instanceof BooleanType) {
				if (rhsType instanceof BooleanType) {
					return null;
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getBooleanType())) {
						return null;
					}
					else {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
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
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			
			if (lhsType instanceof StringType) {
				if (rhsType instanceof StringType) {
					return null;
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getStringType())) {
						return null;
					}
					else {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			
			if (lhsType instanceof CollectionType) {
				if (rhsType instanceof CollectionType) {
					if (!typeUtil.isTypeEqual(lhsType, rhsType)) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					boolean found = false;
					for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) rhsType, lhsType.eClass()))
					{
						if (typeUtil.isTypeEqual(t, lhsType)) {
							found = true;
							break;
						}
					}
					if (!found) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				return null;
			}
			
			
			if (lhsType instanceof ModelElementType) {
				if (rhsType instanceof ModelElementType) {
					if (!typeUtil.isTypeEqual(lhsType, rhsType)) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					boolean found = false;
					for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) rhsType, lhsType.eClass()))
					{
						if (typeUtil.isTypeEqual(t, lhsType)) {
							found = true;
							break;
						}
					}
					if (!found) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
			}
			
			if (typeUtil.isInstanceofAnyType(lhsType)) {
				if (rhsType instanceof BooleanType) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getBooleanType())) {
						return null;
					}
					else {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else if (rhsType instanceof RealType) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getRealType())) {
						return null;
					}
					else {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else if (rhsType instanceof StringType) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getStringType())) {
						return null;
					}
					else {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else if (rhsType instanceof CollectionType) {
					boolean found = false;
					for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) lhsType, rhsType.eClass()))
					{
						if (typeUtil.isTypeEqual(t, lhsType)) {
							found = true;
							break;
						}
					}
					if (!found) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
					return null;
				}
				else if (rhsType instanceof ModelElementType) {
					boolean found = false;
					for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) lhsType, EolPackage.eINSTANCE.getModelElementType()))
					{
						if (t instanceof ModelElementType) {
							ModelElementType met = (ModelElementType) t;
							if (typeUtil.isTypeEqual(met, rhsType)) {
								found = true;
								break;
							}
						}
						else {
							System.err.println("This is wrong!!!!!!!!!!!!!!!!!!!!");
						}
					}
					if (!found) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					ArrayList<Type> types = TypeInferenceManager.getInstance().getCommonTypesForTwoAnys((AnyType)lhsType, (AnyType)rhsType);
					if (types.size() == 0) {
						LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						return null;
					}
					else {
						return null;
					}
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
		}
			
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if (rhsType instanceof BooleanType) {
			if (lhsType instanceof BooleanType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getBooleanType())) {
					return null;
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else {
				LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				return null;
			}
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
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else {
				LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				return null;
			}
		}
		
		if (rhsType instanceof StringType) {
			if (lhsType instanceof StringType) {
				return null;
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, EolPackage.eINSTANCE.getStringType())) {
					return null;
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else {
				LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				return null;
			}
		}
		
		if (rhsType instanceof CollectionType) {
			if (lhsType instanceof CollectionType) {
				if (!typeUtil.isTypeEqual(lhsType, rhsType)) {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				boolean found = false;
				for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) lhsType, rhsType.eClass()))
				{
					if (typeUtil.isTypeEqual(t, rhsType)) {
						found = true;
						break;
					}
				}
				if (!found) {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			return null;
		}
		
		
		if (rhsType instanceof ModelElementType) {
			if (lhsType instanceof ModelElementType) {
				if (!typeUtil.isTypeEqual(lhsType, rhsType)) {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				boolean found = false;
				for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) lhsType, rhsType.eClass()))
				{
					if (typeUtil.isTypeEqual(t, rhsType)) {
						found = true;
						break;
					}
				}
				if (!found) {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
		}
		
		if (typeUtil.isInstanceofAnyType(rhsType)) {
			if (lhsType instanceof BooleanType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getBooleanType())) {
					return null;
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (lhsType instanceof RealType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getRealType())) {
					return null;
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (lhsType instanceof StringType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, EolPackage.eINSTANCE.getStringType())) {
					return null;
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (lhsType instanceof CollectionType) {
				if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, lhsType.eClass())) {
					return null;
				}
				else {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (lhsType instanceof ModelElementType) {
				boolean found = false;
				for(Type t: TypeInferenceManager.getInstance().getDynamicTypes((AnyType) rhsType, EolPackage.eINSTANCE.getModelElementType()))
				{
					if (t instanceof ModelElementType) {
						ModelElementType met = (ModelElementType) t;
						if (typeUtil.isTypeEqual(met, lhsType)) {
							found = true;
							break;
						}
					}
					else {
						System.err.println("This is wrong!!!!!!!!!!!!!!!!!!!!");
					}
				}
				if (!found) {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
			}
			else if (typeUtil.isInstanceofAnyType(lhsType)) {
				ArrayList<Type> types = TypeInferenceManager.getInstance().getCommonTypesForTwoAnys((AnyType)lhsType, (AnyType)rhsType);
				if (types.size() == 0) {
					LogBook.getInstance().addWarning(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					return null;
				}
				else {
					return null;
				}
			
			}
		}
	
		
		return null;
	}	
	
	public boolean isLogicalOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof AndOperatorExpression ||
				op instanceof OrOperatorExpression ||
				op instanceof ImpliesOperatorExpression ||
				op instanceof XorOperatorExpression) {
			result = true;
		}
		return result;
	}
	
	public boolean isComparativeOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof GreaterThanOperatorExpression ||
				op instanceof GreaterThanOrEqualToOperatorExpression ||
				op instanceof LessThanOperatorExpression ||
				op instanceof LessThanOrEqualToOperatorExpression) {
			result = true;
		}
		return result;
	}
	
	public boolean isEqualityComparisonOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof EqualsOperatorExpression ||
				op instanceof NotEqualsOperatorExpression) {
			result = true;
		}
		return result;
	}

}
