package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.CollectionExpression;
import org.eclipse.epsilon.eol.metamodel.CollectionInitialisationExpression;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionList;
import org.eclipse.epsilon.eol.metamodel.ExpressionRange;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.CollectionExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class CollectionExpressionTypeResolver extends CollectionExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(CollectionExpression collectionExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the init value
		CollectionInitialisationExpression initValue = collectionExpression.getParameterList();
		
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		//if the init value is expRange
		if (initValue instanceof ExpressionRange) {
			IntegerType type = EolFactory.eINSTANCE.createIntegerType();
			
			CollectionType collType = (CollectionType) collectionExpression.getResolvedType();
			collType.setContentType(EcoreUtil.copy(type));
			
			ExpressionRange range = (ExpressionRange) initValue;
			Expression start = range.getStart();
			Expression end = range.getEnd();
			
			controller.visit(start, context);
			controller.visit(end, context);
			
			Type startType = start.getResolvedType();
			Type endType = end.getResolvedType();
			
			if (startType == null) {
				LogBook.getInstance().addError(start, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				return null;
			}

			if(endType == null){
				LogBook.getInstance().addError(end, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				return null;
			}
			
			if (typeUtil.isInstanceofAnyType(startType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) startType, EolFactory.eINSTANCE.createIntegerType().eClass())) {
					LogBook.getInstance().addError(start, IMessage_TypeResolution.EXPRESSION_MUST_BE_INTEGER);
				}
			}
			else if (!(startType instanceof IntegerType)) {
				LogBook.getInstance().addError(start, IMessage_TypeResolution.EXPRESSION_MUST_BE_INTEGER);
			}
			
			
			if (typeUtil.isInstanceofAnyType(endType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) endType, EolFactory.eINSTANCE.createIntegerType().eClass())) {
					LogBook.getInstance().addError(end, IMessage_TypeResolution.EXPRESSION_MUST_BE_INTEGER);
				}
			}
			else if (!(endType instanceof IntegerType)) {
				LogBook.getInstance().addError(end, IMessage_TypeResolution.EXPRESSION_MUST_BE_INTEGER);
			}	
			
		}
		//if initvalue is exprlist
		if (initValue instanceof ExpressionList) {
			
			ExpressionList list = (ExpressionList) initValue;
			CollectionType collType = (CollectionType) collectionExpression.getResolvedType();
			Type contentType = null;
			
			if (allBoolean(list, controller, context)) {
				contentType = EcoreUtil.copy(EolFactory.eINSTANCE.createBooleanType());
			}
			else if (allInteger(list, controller, context)) {
				contentType = EcoreUtil.copy(EolFactory.eINSTANCE.createIntegerType());
			}
			else if (allReal(list, controller, context)) {
				contentType = EcoreUtil.copy(EolFactory.eINSTANCE.createRealType());
			}
			else if (allString(list, controller, context)) {
				contentType = EcoreUtil.copy(EolFactory.eINSTANCE.createStringType());
			}
			else {
				contentType = EolFactory.eINSTANCE.createAnyType();
				for(Expression expr : list.getExpressions())
				{
					controller.visit(expr, context);
					if (!(expr.getResolvedType() instanceof CollectionType)) {
						((AnyType)contentType).getDynamicTypes().add(expr.getResolvedType());	
					}
					else {
						LogBook.getInstance().addError(expr, IMessage_TypeResolution.EXPRESSION_INIT_CANNOT_CONTAIN_COLLECTION);
					}
				}
				collType.setContentType(contentType);
				context.setAssets(contentType, collType);
			}
		}
		
		return null;
	}
	
	public boolean allBoolean(ExpressionList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
	{
		boolean result = true;
		for(Expression expr: list.getExpressions())
		{
			controller.visit(expr, context);
			if (expr.getResolvedType() instanceof BooleanType) {
			}
			else {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean allInteger(ExpressionList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
	{
		boolean result = true;
		for(Expression expr: list.getExpressions())
		{
			controller.visit(expr, context);
			Type t = expr.getResolvedType();
			if (t instanceof IntegerType) {
				continue;
			}
			else {
				if (TypeUtil.getInstance().isInstanceofAnyType(t)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) t, EolFactory.eINSTANCE.createIntegerType().eClass())) {
						continue;
					}
					else {
						return false;
					}
				}
				else {
					return false;	
				}
				
			}
		}
		return result;
	}
	
	public boolean allReal(ExpressionList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
	{
		boolean result = true;
		for(Expression expr: list.getExpressions())
		{
			controller.visit(expr, context);
			Type t = expr.getResolvedType();

			if (t instanceof RealType) {
				continue;
			}
			else {
				if (TypeUtil.getInstance().isInstanceofAnyType(t)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) t, EolFactory.eINSTANCE.createRealType().eClass())) {
						continue;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return result;
	}
	
	public boolean allString(ExpressionList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
	{
		boolean result = true;
		for(Expression expr: list.getExpressions())
		{
			controller.visit(expr, context);
			Type t = expr.getResolvedType();

			if (t instanceof StringType) {
				continue;
			}
			else {
				if (TypeUtil.getInstance().isInstanceofAnyType(t)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) t, EolFactory.eINSTANCE.createStringType().eClass())) {
						continue;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return result;
	}

}
