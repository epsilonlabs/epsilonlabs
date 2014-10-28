package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class MethodCallExpressionLoadingOptimisationAnalyser extends MethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit the contents first
		controller.visitContents(methodCallExpression, context);
		
		//get the method name
		String methodString = methodCallExpression.getMethod().getName();
		Expression target = methodCallExpression.getTarget();
		if (isKeyword(methodString)) {
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
						if (methodString.equals("allOfType")) {
							leContext.addToModelAllOfType(modelString, targetString);
						}
						else {
							leContext.addToModelAllOfKind(modelString, targetString);
						}
					}

				}
				
				

			}
		}
		return null;
	}
	
	public boolean isKeyword(String s)
	{
		if (s.equals("all") ||
				s.equals("allOfType") ||
				s.equals("allOfKind") ||
				s.equals("allInstances")) {
			return true;
		}
		else {
			return false;
		}
		
	}


}
