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
import org.eclipse.epsilon.eol.metamodel.visitor.CollectionExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class CollectionExpressionTypeResolver extends CollectionExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(CollectionExpression collectionExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the init value
		CollectionInitialisationExpression initValue = collectionExpression.getParameterList();
		
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
			
			if (start.getResolvedType() != null) {
				if (!(start.getResolvedType() instanceof IntegerType)) {
					LogBook.getInstance().addError(start, IMessage_TypeResolution.EXPRESSION_MUST_BE_INTEGER);
				}	
			}
			else {
				LogBook.getInstance().addError(start, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			}
			if (end.getResolvedType() != null) {
				if (!(end.getResolvedType() instanceof IntegerType)) {
					LogBook.getInstance().addError(end, IMessage_TypeResolution.EXPRESSION_MUST_BE_INTEGER);
				}	
			}
			else {
				LogBook.getInstance().addError(end, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			}
		}
		//if initvalue is exprlist
		if (initValue instanceof ExpressionList) {
			
			ExpressionList list = (ExpressionList) initValue;
			CollectionType collType = (CollectionType) collectionExpression.getResolvedType();
			
			if (allBoolean(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(EolFactory.eINSTANCE.createBooleanType()));
			}
			else if (allInteger(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(EolFactory.eINSTANCE.createIntegerType()));
			}
			else if (allReal(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(EolFactory.eINSTANCE.createRealType()));
			}
			else if (allString(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(EolFactory.eINSTANCE.createStringType()));
			}
			else {
				AnyType anyType = EolFactory.eINSTANCE.createAnyType();
				for(Expression expr : list.getExpressions())
				{
					controller.visit(expr, context);
					if (!(expr.getResolvedType() instanceof CollectionType)) {
						anyType.getDynamicTypes().add(expr.getResolvedType());	
					}
					else {
						LogBook.getInstance().addError(expr, IMessage_TypeResolution.EXPRESSION_INIT_CANNOT_CONTAIN_COLLECTION);
					}
				}
				collType.setContentType(anyType);
				context.setAssets(anyType, collType);
			}
		}
		
		return null;
	}
	
	public boolean containsBoolean(ExpressionList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
	{
		boolean result = false;
		for(Expression expr: list.getExpressions())
		{
			controller.visit(expr, context);
			if (expr.getResolvedType() instanceof BooleanType) {
				result = true;
				break;
			}
		}
		return result;
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
			if (expr.getResolvedType() instanceof IntegerType) {
			}
			else {
				result = false;
				break;
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
			if (expr.getResolvedType() instanceof RealType) {
			}
			else {
				result = false;
				break;
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
			if (expr.getResolvedType() instanceof StringType) {
			}
			else {
				result = false;
				break;
			}
		}
		return result;
	}

}
