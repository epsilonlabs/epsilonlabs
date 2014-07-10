package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import java.beans.Statement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class PropertyCallExpressionCoverageAnalyser extends PropertyCallExpressionVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		controller.visit(propertyCallExpression.getTarget(), context);
		Type tempType = propertyCallExpression.getTarget().getResolvedType();
		if (tempType instanceof ModelElementType) {
			ModelElementType targetTypde = (ModelElementType) tempType;
			EClassifier ecoreType = targetTypde.getEcoreType();
			String propertyName = propertyCallExpression.getProperty().getName();
			context.add((EClass) ecoreType, propertyName);
		}
		return null;
	}
	
	public boolean isWrite(PropertyCallExpression propertyCallExpression)
	{
		if (isLhsOfAssignment(propertyCallExpression) || isWriteOperation(propertyCallExpression)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isLhsOfAssignment(PropertyCallExpression propertyCallExpression)
	{
		EolElement container = propertyCallExpression;
		while(!(container.getContainer() instanceof AssignmentStatement))
		{
			container = container.getContainer();
		}
		AssignmentStatement assign = (AssignmentStatement) container.getContainer();
		if (container.equals(assign.getLhs())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isWriteOperation(PropertyCallExpression propertyCallExpression)
	{
		EolElement container = propertyCallExpression;
		while(!(container.getContainer() instanceof Statement))
		{
			if (container instanceof MethodCallExpression) {
				MethodCallExpression methodCallExpression = (MethodCallExpression) container;
				if (isModifyingMethod(methodCallExpression.getMethod().getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isModifyingMethod(String method)
	{
		if (method.equals("add") ||
				method.equals("addAll") ||
				method.equals("remove") ||
				method.equals("removeAll") ||
				method.equals("clear") ||
				method.equals("including") ||
				method.equals("excluding") ||
				method.equals("includingAll") ||
				method.equals("excludingAll") ||
				method.equals("concat") ||
				method.equals("removeAt")) {
			return true;
		}
		else {
			return false;
		}
	}

}
