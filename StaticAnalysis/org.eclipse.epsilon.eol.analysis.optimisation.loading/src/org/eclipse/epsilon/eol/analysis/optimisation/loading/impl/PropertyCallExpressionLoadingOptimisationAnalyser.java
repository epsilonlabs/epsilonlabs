package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;


import metamodel.connectivity.abstractmodel.EMetamodelDriver;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class PropertyCallExpressionLoadingOptimisationAnalyser extends PropertyCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			PropertyCallExpression propertyCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(propertyCallExpression, context);
		
		String propertyString = propertyCallExpression.getProperty().getName();
		Expression target = propertyCallExpression.getTarget();
		if (isKeyword(propertyString)) {
			if (target instanceof NameExpression) {
				String targetString = ((NameExpression) target).getName();
				if (target.getResolvedType() instanceof ModelElementType) {
					ModelElementType targetType = (ModelElementType) target.getResolvedType();
					
					String modelString = targetType.getModelName();
					String elementString = targetType.getElementName();
					
					EMetamodelDriver driver = context.getMetaModel(modelString);
					
					if (targetString.contains("!")) {
						targetString = targetString.substring(targetString.indexOf("!")+1, targetString.length());
					}
					
					if (driver.containsMetaClass(elementString)) {
						LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;
						leContext.addToModelAllOfKind(modelString, targetString);
					}
				}
			}
		}
		
		return null;
		
	}
	
	public boolean isKeyword(String s)
	{
		if (s.equals("all") ||
				s.equals("allInstances")) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
