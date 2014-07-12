package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import java.beans.Statement;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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
			if (ecoreType instanceof EClass) {
				EClass eClass = (EClass) ecoreType;
				EStructuralFeature feature = eClass.getEStructuralFeature(propertyName);
				if (feature != null && feature instanceof EReference) {
					EReference ref = (EReference) feature;
					EReference opposite = ref.getEOpposite();
					if (opposite != null) {
						EClass containingClass = opposite.getEContainingClass();
						context.add(containingClass, opposite.getName(), true);
						for(EClass superClass : getSuperClassContainingProperty(containingClass, opposite.getName()))
						{
							if (superClass.isAbstract() || superClass.isInterface()) {
								
							}
							else {
								context.add(superClass, opposite.getName(), true);	
							}
							 
						}
					}
				}
			}
			context.add((EClass) ecoreType, propertyName, false);
			for(EClass superClass : getSuperClassContainingProperty((EClass) ecoreType, propertyName))
			{
				if (superClass.isAbstract() || superClass.isInterface()) {
					
				}
				else {
					context.add(superClass, propertyName, false);	
				}
			}
		}
		return null;
	}
	
	public ArrayList<EClass> getSuperClassContainingProperty(EClass eClass, String propertyName)
	{
		ArrayList<EClass> result = new ArrayList<EClass>();
		for(EClass superClass: eClass.getESuperTypes())
		{
			for(EStructuralFeature feature: superClass.getEAllStructuralFeatures())
			{
				if (feature.getName().equals(propertyName)) {
					result.add(superClass);
					break;
				}
			}
		}
		return result;
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
