package org.eclipse.epsilon.eol.effective.metamodel.extraction.impl;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.effective.metamodel.impl.EffectiveMetamodel;
import org.eclipse.epsilon.effective.metamodel.impl.EffectiveType;
import org.eclipse.epsilon.eol.effective.metamodel.extraction.context.EffectiveMetamodelExtractionContext;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.IPackage;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.context.TypeResolutionContext;

public class FOLMethodCallExpressionEME extends FOLMethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the context
		EffectiveMetamodelExtractionContext leContext = (EffectiveMetamodelExtractionContext) context;
		
		//push the current iterator =================================================================
		leContext.setCurrentIterator(fOLMethodCallExpression.getIterator());
		leContext.pushToCovariantType();

		//push the current fol method call
		leContext.setCurrentFolMethodCallExpression(fOLMethodCallExpression);
		
		//visit the target first
		controller.visit(fOLMethodCallExpression.getTarget(), context);

		//get the target
		Expression target = fOLMethodCallExpression.getTarget();
		
		if (fOLMethodCallExpression.getMethod().getName().equals("select")) {
			//if target is a name expression
			if (target instanceof NameExpression) {
				
				//get the name expression
				NameExpression nameExpression = (NameExpression) target;
				
				//if the target is a collection
				if (target.getResolvedType() instanceof CollectionType) {
					
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
				else {
					
				}
			}
			
			else if (target instanceof PropertyCallExpression) {
				
				PropertyCallExpression propertyCallExpression = (PropertyCallExpression) target;
				if (propertyCallExpression.getResolvedType() instanceof CollectionType) {
					
					EffectiveType effectiveType = leContext.getEffectiveTypeFromRegistry(propertyCallExpression);
					
					if (effectiveType != null) {
						leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression.getIterator(), effectiveType);
						leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression, effectiveType);
					}
				}
			}
			else {
				EffectiveType et = leContext.getEffectiveTypeFromRegistry(target);
				if (et != null) {
					leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression.getIterator(), et);
					leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression, et);
				}
			}
			
			FormalParameterExpression iterator = fOLMethodCallExpression.getIterator();
			if (iterator.getResolvedType() != null && (!(iterator.getResolvedType() instanceof AnyType))) {
				Type iteratorType = iterator.getResolvedType();
				if (iteratorType instanceof ModelElementType) {
					//get the target type
					ModelElementType targetType = (ModelElementType) iteratorType;
					
					//get the model string
					String modelString = targetType.getModelName();
					
					//get the element string
					String elementString = targetType.getElementName();
					
					//get the driver
//					EMetamodelDriver driver = context.getMetaModel(modelString);
					IPackage iPackage = targetType.getResolvedIPackage();
					
					IPackageDriver iPackageDriver = (IPackageDriver) iPackage.getIPackageDriver();

					
					EffectiveType et = leContext.getEffectiveTypeFromRegistry(iterator);
					if (et != null && !et.getName().equals(elementString)) {
						EffectiveMetamodel em = et.getEffectiveMetamodel();
						
						EffectiveType newET = em.addToTypes(elementString);
						leContext.registerEffectiveTypeWithObject(iterator, newET);
						leContext.registerEffectiveTypeWithObject(fOLMethodCallExpression, newET);
					}
				}
			}
			else {
				System.err.println("THIS IS EXECUTED");
			}

			for(Expression condition: fOLMethodCallExpression.getConditions())
			{
				controller.visit(condition, context);
			}
		}
		leContext.popCurrentFOLMethodCallExpression();
		leContext.popCovarintTypes();
		leContext.popCurrentIterator();
		return null;
	}
	
}
