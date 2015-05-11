package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.OperationDefinitionNode;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.labs.effectivemetamodel.impl.EffectiveType;

public class OperationDefinitionLoadingOptimisationAnalyser extends OperationDefinitionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the context
		LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;
		
		//get the self
		VariableDeclarationExpression self = operationDefinition.getSelf();

		//get node if exist
		OperationDefinitionNode node = leContext.getFromCallGraph(operationDefinition);
		
		//invokers to remove?
		ArrayList<MethodCallExpression> invokersToRemove = new ArrayList<MethodCallExpression>();
		
		//if node is not null
		if (node != null) {
			
			//for each invoker
			for(MethodCallExpression methodCallExpression: node.getInvokers())
			{
				//get the target
				Expression target = methodCallExpression.getTarget();
				
				if (target != null) {
					//if target is name expression
					if (target instanceof NameExpression) {
						
						//get the target
						NameExpression nameExpression = (NameExpression) target;
						
						//if target does not have a resolved content
						if (nameExpression.getResolvedContent() != null) {
							//get the effectivetype from registry
							EffectiveType effectiveType = leContext.getEffectiveTypeFromRegistry(nameExpression.getResolvedContent());
							
							//if effective type is not null
							if (effectiveType != null) {
								//register effective type with self
								leContext.registerEffectiveTypeWithObject(self, effectiveType);
								//visit body
							}
							else {
								//if effective is null, mark invoker as to be removed
								invokersToRemove.add(methodCallExpression);
							}
						}
					}
					
					else {
						EffectiveType effectiveType = leContext.getEffectiveTypeFromRegistry(target);
						if (effectiveType != null) {
							leContext.registerEffectiveTypeWithObject(self, effectiveType);
						}
						else {
							invokersToRemove.add(methodCallExpression);
						}
					}
				}
				
				controller.visit(operationDefinition.getBody(), context);
			}
		}
		
		

		//remove unnecessary invokers
		node.getInvokers().removeAll(invokersToRemove);
		
		
//		if (getInnermostType(self.getResolvedType()) instanceof ModelElementType) {
//			//get the model element type
//			ModelElementType modelElementType = (ModelElementType) getInnermostType(self.getResolvedType());
//			
//			//get the model string
//			String modelString = modelElementType.getModelName();
//			
//			//get the element string
//			String elementString = modelElementType.getElementName();
//			
//			//get the driver
//			EMetamodelDriver driver = context.getMetaModel(modelString);
//			
//			EffectiveMetamodel effectiveMetamodel = leContext.addEffectiveMetamodel(modelString);
//			//add the effective type
//			EffectiveType effectiveType = effectiveMetamodel.addToAllOfKind(targetString);
//			
//			//register effectiveType
//			leContext.registerEffectiveTypeWithObject(propertyCallExpression, effectiveType);
//
//		}
//
//		System.out.println(operationDefinition.getContextType());
//		
//		System.out.println(self.getResolvedType());
//		
		
		return null;
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
