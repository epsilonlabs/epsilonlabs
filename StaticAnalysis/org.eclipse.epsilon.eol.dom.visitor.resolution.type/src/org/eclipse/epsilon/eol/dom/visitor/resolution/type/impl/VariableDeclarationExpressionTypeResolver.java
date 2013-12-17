package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class VariableDeclarationExpressionTypeResolver extends VariableDeclarationExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(variableDeclarationExpression, context);
		if (variableDeclarationExpression.getCreate() != null) {
			boolean newExpression = variableDeclarationExpression.getCreate().isVal();
			if (newExpression) {
				Type rawType = variableDeclarationExpression.getResolvedType();
				if (rawType instanceof ModelElementType) {
					ModelElementType modelElementType = (ModelElementType) rawType;
					String modelName = modelElementType.getModelName();
					String elementName = modelElementType.getElementName();
					EMetaModel em = context.getMetaModel(modelName); //get metamodel
					EClass eClass = em.getMetaClass(elementName);
					if (eClass.isAbstract() || eClass.isInterface()) {
						context.getLogBook().addError(modelElementType, "Model Element Type: " + modelName + "!" + elementName + " is not instantiable");
					}
				}
			}
		}
				
		// TODO Auto-generated method stub
		return null;
	}

}
