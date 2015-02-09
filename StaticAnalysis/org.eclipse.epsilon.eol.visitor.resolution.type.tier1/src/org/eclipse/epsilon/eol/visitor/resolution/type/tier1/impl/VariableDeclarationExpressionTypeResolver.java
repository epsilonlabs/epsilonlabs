package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class VariableDeclarationExpressionTypeResolver extends VariableDeclarationExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit contents first
		controller.visitContents(variableDeclarationExpression, context); 
		
		// if create is not null
		if (variableDeclarationExpression.getCreate() != null) { 
			
			//get the value of the create
			boolean newExpression = variableDeclarationExpression.getCreate().isVal();
			
			//if it is a new variable
			if (newExpression) {
				
				//get resolved type
				Type rawType = variableDeclarationExpression.getResolvedType();
				
				//we are interested in the model element types
				if (rawType instanceof ModelElementType) {
					
					//get the type
					ModelElementType modelElementType = (ModelElementType) rawType;
					
					//if the model element type is a EClass in the meta model
					if (modelElementType.getEcoreType() instanceof EClass) {
						
						//get the EClass
						EClass eClass = (EClass) modelElementType.getEcoreType();
						
						//check if the class is an interface or abstract
						if (eClass.isAbstract() || eClass.isInterface()) {
							
							context.getLogBook().addError(modelElementType, "Model element type is not instantiable"); //throw error
							
						}
					}
				}
			}
			
		}
		return null;
	}

}
