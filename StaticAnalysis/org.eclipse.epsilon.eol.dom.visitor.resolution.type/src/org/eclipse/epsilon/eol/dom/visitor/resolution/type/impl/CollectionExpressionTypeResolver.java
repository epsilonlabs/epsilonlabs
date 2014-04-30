package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.BooleanType;
import org.eclipse.epsilon.eol.dom.CollectionExpression;
import org.eclipse.epsilon.eol.dom.CollectionInitValue;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.ExpRange;
import org.eclipse.epsilon.eol.dom.ExprList;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.IntegerType;
import org.eclipse.epsilon.eol.dom.RealType;
import org.eclipse.epsilon.eol.dom.StringType;
import org.eclipse.epsilon.eol.dom.visitor.CollectionExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class CollectionExpressionTypeResolver extends CollectionExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(CollectionExpression collectionExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		
		CollectionInitValue initValue = collectionExpression.getParameterList();
		
		if (initValue instanceof ExpRange) {
			IntegerType type = context.getEolFactory().createIntegerType();
			CollectionType collType = (CollectionType) collectionExpression.getResolvedType();
			collType.setContentType(EcoreUtil.copy(type));
			ExpRange range = (ExpRange) initValue;
			Expression start = range.getStart();
			Expression end = range.getEnd();
			controller.visit(start, context);
			controller.visit(end, context);
			if (!(start.getResolvedType() instanceof IntegerType)) {
				context.getLogBook().addError(start, "Expression should be integer type");
			}
			if (!(end.getResolvedType() instanceof IntegerType)) {
				context.getLogBook().addError(end, "Expression should be integer type");
			}
		}
		if (initValue instanceof ExprList) {
			ExprList list = (ExprList) initValue;
			CollectionType collType = (CollectionType) collectionExpression.getResolvedType();
			
			if (allBoolean(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(context.getEolFactory().createBooleanType()));
			}
			else if (allInteger(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(context.getEolFactory().createIntegerType()));
			}
			else if (allReal(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(context.getEolFactory().createRealType()));
			}
			else if (allString(list, controller, context)) {
				collType.setContentType(EcoreUtil.copy(context.getEolFactory().createStringType()));
			}
		}
		
		return null;
	}
	
	public boolean containsBoolean(ExprList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
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
	
	public boolean allBoolean(ExprList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
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
	
	public boolean containsInteger(ExprList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
	{
		boolean result = false;
		for(Expression expr: list.getExpressions())
		{
			controller.visit(expr, context);
			if (expr.getResolvedType() instanceof IntegerType) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public boolean allInteger(ExprList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
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
	
	public boolean allReal(ExprList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
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
	
	public boolean allString(ExprList list, EolVisitorController<TypeResolutionContext, Object> controller, TypeResolutionContext context)
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
