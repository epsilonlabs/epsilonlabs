package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import metamodel.connectivity.emf.EMetaModel;

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
					if (modelElementType.getEcoreType() instanceof EClass) {
						EClass eClass = (EClass) modelElementType.getEcoreType();
						if (eClass.isAbstract() || eClass.isInterface()) {
							context.getLogBook().addError(modelElementType, "Model element type is not instantiable");
						}
					}
//					String modelName = modelElementType.getModelName();
//					String elementName = modelElementType.getElementName();
//					if (modelName != null) {
//						EMetaModel em = context.getMetaModel(modelName); //get metamodel
//						EClass eClass = em.getMetaClass(elementName);
//					}
//					else {
//						if (context.numberOfMetamodelsDefine(elementName, false) == 1) {
//							
//						}
//					}
				}
			}
		}
				
		// TODO Auto-generated method stub
		return null;
	}

}
