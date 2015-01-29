package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;


import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelElementContainer;
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
		
		//visit contents first
		controller.visitContents(propertyCallExpression, context);
		
		//get the name of the proeprty
		String propertyString = propertyCallExpression.getProperty().getName();
		
		//get the target expression
		Expression target = propertyCallExpression.getTarget();
		
		//if target type is model element type
		if (target.getResolvedType() instanceof ModelElementType) {
			
			//get the target type
			ModelElementType targetType = (ModelElementType) target.getResolvedType();
			
			//get the model string
			String modelString = targetType.getModelName();
			
			//get the element string
			String elementString = targetType.getElementName();
			
			//get the driver
			EMetamodelDriver driver = context.getMetaModel(modelString);

			//get context
			LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;
			
			//check if is keyword
			if (isKeyword(propertyString)) {
				if (target instanceof NameExpression) {
					String targetString = ((NameExpression) target).getName();
					
					if (targetString.contains("!")) {
						targetString = targetString.substring(targetString.indexOf("!")+1, targetString.length());
					}
					
					if (driver.containsMetaClass(elementString)) {
						leContext.addToModelAllOfKind(modelString, targetString);
					}

				}
			}
			else {
				if (driver.containsEReference(elementString, propertyString)) {
					ModelContainer mc = leContext.getModelContainer(modelString);
					if (mc != null) {
						ModelElementContainer mec = mc.getFromModelElementsAllOfType(elementString);
						if (mec != null) {
							mec.addToReferences(propertyString);
						}
						else {
							mec = mc.getFromModelElementsAllOfKind(elementString);
							if (mec != null) {
								mec.addToReferences(propertyString);
							}
							else {
								EClass actualClass = driver.getMetaClass(elementString);
								ArrayList<ModelElementContainer> containers = mc.getModelElementsAllOfKind();
								for(ModelElementContainer container: containers)
								{
									String containerElementName = container.getElementName();
									EClass containerClass = driver.getMetaClass(containerElementName);
									
									if (actualClass.getESuperTypes().contains(containerClass)) {
										container.addToReferences(propertyString);
									}
								}
							}
						}
					}
				}
				if (driver.containsEAttribute(elementString, propertyString)) {
					ModelContainer mc = leContext.getModelContainer(modelString);
					if (mc != null) {
						ModelElementContainer mec = mc.getFromModelElementsAllOfType(elementString);
						if (mec != null) {
							mec.addToAttributes(propertyString);
						}
						else {
							mec = mc.getFromModelElementsAllOfKind(elementString);
							if (mec != null) {
								mec.addToAttributes(propertyString);
							}
							else {
								EClass actualClass = driver.getMetaClass(elementString);
								for(ModelElementContainer container: mc.getModelElementsAllOfKind())
								{
									String containerElementName = container.getElementName();
									EClass containerClass = driver.getMetaClass(containerElementName);
									if (actualClass.getESuperTypes().contains(containerClass)) {
										container.addToAttributes(propertyString);
									}
								}
							}
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
				s.equals("allInstances")) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
