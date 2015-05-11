package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.labs.effectivemetamodel.impl.EffectiveType;

public class FOLMethodCallExpressionLoadingOptimisationAnalyser extends FOLMethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the context
		LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;
		
		//push the current iterator =================================================================
		leContext.setCurrentIterator(fOLMethodCallExpression.getIterator());

		//push the current fol method call
		leContext.setCurrentFolMethodCallExpression(fOLMethodCallExpression);
		
		//visit the target first
		controller.visit(fOLMethodCallExpression.getTarget(), context);

		//get the target
		Expression target = fOLMethodCallExpression.getTarget();
		
		//if target is a name expression
		if (target instanceof NameExpression) {
			
			//get the name expression
			NameExpression nameExpression = (NameExpression) target;
			
			//if the target is a collection
			if (target.getResolvedType() instanceof CollectionType) {
				
				//get the collection type
				CollectionType collectionType = (CollectionType) target.getResolvedType();
				
				//if the innermost type of the collection is a model element type
				if (collectionType.getContentType() != null && getInnermostType(collectionType) instanceof ModelElementType) {
					
					//name expression has a resolved content and it is a variable declaration
					if (nameExpression.getResolvedContent() instanceof VariableDeclarationExpression) {
						
						//get the variable declaration
						VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) nameExpression.getResolvedContent();
						
						//get the effective type if it the variable declaration is registered
						EffectiveType effectiveType = leContext.getEffectiveTypeFromRegistry(variableDeclarationExpression);
						
						//if registered
						if (effectiveType != null) {
							leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression.getIterator(), effectiveType);
							leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression, effectiveType);
						}
					}
				}
			}
			else {
				
			}
		}
		
		else if (target instanceof PropertyCallExpression) {
			
			PropertyCallExpression propertyCallExpression = (PropertyCallExpression) target;
			if (propertyCallExpression.getResolvedType() instanceof CollectionType) {
				
				CollectionType collectionType = (CollectionType) target.getResolvedType();
				
				if (collectionType.getContentType() != null && getInnermostType(collectionType) instanceof ModelElementType) {
					EffectiveType effectiveType = leContext.getEffectiveTypeFromRegistry(propertyCallExpression);
					
					if (effectiveType != null) {
						leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression.getIterator(), effectiveType);
						leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression, effectiveType);
					}
				}
				
			}
		}
		
//		else if(target instanceof FOLMethodCallExpression)
//		{
//			FOLMethodCallExpression folMethodCallExpression2 = (FOLMethodCallExpression) target;
//
//			EffectiveType effectiveType = leContext.getEffectiveTypeFromRegistry(folMethodCallExpression2);
//			if (effectiveType != null) {
//				leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression.getIterator(), effectiveType);;
//				leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression, effectiveType);
//			}
//		}

		controller.visit(fOLMethodCallExpression.getCondition(), context);
		leContext.popCurrentFOLMethodCallExpression();
		leContext.popCurrentIterator();
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
