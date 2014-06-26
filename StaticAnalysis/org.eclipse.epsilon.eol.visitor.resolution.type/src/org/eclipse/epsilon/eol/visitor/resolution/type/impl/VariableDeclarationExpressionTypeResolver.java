package org.eclipse.epsilon.eol.visitor.resolution.type.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class VariableDeclarationExpressionTypeResolver extends VariableDeclarationExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(variableDeclarationExpression, context); //visit the content of the var first
		
		if (variableDeclarationExpression.getCreate() != null) { // if create is not null
			boolean newExpression = variableDeclarationExpression.getCreate().isVal(); //get the value of the create
			if (newExpression) { //if it is a new variable
				Type rawType = variableDeclarationExpression.getResolvedType(); //get resolved type
				if (rawType instanceof ModelElementType) { //we are interested in the model element types
					ModelElementType modelElementType = (ModelElementType) rawType; //get the type
					if (modelElementType.getEcoreType() instanceof EClass) { //if the model element type is a EClass in the meta model
						EClass eClass = (EClass) modelElementType.getEcoreType(); //get the EClass
						if (eClass.isAbstract() || eClass.isInterface()) { //check if the class is an interface or abstract
							context.getLogBook().addError(modelElementType, "Model element type is not instantiable"); //throw error
						}
					}
				}
			}
		}
		return null;
	}

}
