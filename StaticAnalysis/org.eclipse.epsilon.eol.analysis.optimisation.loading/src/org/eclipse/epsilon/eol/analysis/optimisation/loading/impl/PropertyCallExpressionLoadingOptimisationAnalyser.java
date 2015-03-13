package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;


import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.EffectiveMetamodel;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.EffectiveType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
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
					EffectiveMetamodel mc = leContext.getModelContainer(modelString);
					if (mc != null) {
						EffectiveType mec = mc.getFromAllOfType(elementString);
						if (mec != null) {
							mec.addToReferences(propertyString);
						}
						else {
							mec = mc.getFromAllOfKind(elementString);
							if (mec != null) {
								mec.addToReferences(propertyString);
							}
							else {
								EClass actualClass = driver.getMetaClass(elementString);
								ArrayList<EffectiveType> containers = mc.getAllOfKind();
								for(EffectiveType container: containers)
								{
									String containerElementName = container.getName();
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
					EffectiveMetamodel mc = leContext.getModelContainer(modelString);
					if (mc != null) {
						EffectiveType mec = mc.getFromAllOfType(elementString);
						if (mec != null) {
							mec.addToAttributes(propertyString);
						}
						else {
							mec = mc.getFromAllOfKind(elementString);
							if (mec != null) {
								mec.addToAttributes(propertyString);
							}
							else {
								EClass actualClass = driver.getMetaClass(elementString);
								for(EffectiveType container: mc.getAllOfKind())
								{
									String containerElementName = container.getName();
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
		
		if (target.getResolvedType() instanceof CollectionType) {
			CollectionType rawCollectionType = (CollectionType) target.getResolvedType(); //prepare collection type
			
			if (getInnermostType(rawCollectionType) instanceof ModelElementType) 
			{
				ModelElementType resultContentType = (ModelElementType) getInnermostType(rawCollectionType); //prepare result content type

				//get the model string
				String modelString = resultContentType.getModelName();
				
				//get the element string
				String elementString = resultContentType.getElementName();
				
				//get the driver
				EMetamodelDriver driver = context.getMetaModel(modelString);

				LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;

				if (driver.containsEReference(elementString, propertyString)) {
					EffectiveMetamodel mc = leContext.getModelContainer(modelString);
					if (mc != null) {
						EffectiveType mec = mc.getFromAllOfType(elementString);
						if (mec != null) {
							mec.addToReferences(propertyString);
						}
						else {
							mec = mc.getFromAllOfKind(elementString);
							if (mec != null) {
								mec.addToReferences(propertyString);
							}
							else {
								EClass actualClass = driver.getMetaClass(elementString);
								ArrayList<EffectiveType> containers = mc.getAllOfKind();
								for(EffectiveType container: containers)
								{
									String containerElementName = container.getName();
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
					EffectiveMetamodel mc = leContext.getModelContainer(modelString);
					if (mc != null) {
						EffectiveType mec = mc.getFromAllOfType(elementString);
						if (mec != null) {
							mec.addToAttributes(propertyString);
						}
						else {
							mec = mc.getFromAllOfKind(elementString);
							if (mec != null) {
								mec.addToAttributes(propertyString);
							}
							else {
								EClass actualClass = driver.getMetaClass(elementString);
								for(EffectiveType container: mc.getAllOfKind())
								{
									String containerElementName = container.getName();
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
	
	public Type getInnermostType(Type t)
	{
		if (t instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) t;
			Type contentType = collectionType.getContentType();
			while(contentType instanceof CollectionType)
			{
				contentType = ((CollectionType)contentType).getContentType();
			}
			return EcoreUtil.copy(contentType);
		}
		else {
			return EcoreUtil.copy(t);
		}
	}


}
