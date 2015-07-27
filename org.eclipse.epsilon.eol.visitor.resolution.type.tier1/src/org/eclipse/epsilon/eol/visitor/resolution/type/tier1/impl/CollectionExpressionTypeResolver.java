package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.CollectionExpression;
import org.eclipse.epsilon.eol.metamodel.CollectionInitialisationExpression;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionRange;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.visitor.CollectionExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
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
					context.getLogBook().addError(start, "Expression should be integer type");
				}	
			}
			else {
				context.getLogBook().addError(start, "Expression does not have a type");
			}
			if (end.getResolvedType() != null) {
				if (!(end.getResolvedType() instanceof IntegerType)) {
					context.getLogBook().addError(end, "Expression should be integer type");
				}	
			}
			else {
				context.getLogBook().addError(end, "Expression does not have a type");
			}
		}
		//if initvalue is exprlist
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
			else {
				collType.setContentType(context.getEolFactory().createAnyType());
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
