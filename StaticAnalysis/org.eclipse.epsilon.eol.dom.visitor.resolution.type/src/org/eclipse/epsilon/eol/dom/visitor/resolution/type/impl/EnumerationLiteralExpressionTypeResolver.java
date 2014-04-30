package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import metamodel.connectivity.emf.EMetaModel;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EnumerationLiteralExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class EnumerationLiteralExpressionTypeResolver extends EnumerationLiteralExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			EnumerationLiteralExpression enumerationLiteralExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		String modelName = enumerationLiteralExpression.getModel().getName(); //get model name
		String enumName = enumerationLiteralExpression.getEnumeration().getName(); //get enumName
		String literalName = enumerationLiteralExpression.getLiteral().getName(); //get literalname
		enumerationLiteralExpression.setResolvedType(context.getEolFactory().createIntegerType());

		
		EMetaModel mm = context.getMetaModel(modelName); //get metamodel
		if (mm != null) { //if metamodel is not null
			if (mm.containsEnum(enumName)) { //if metamodel caontains enumeration
				if (mm.enumContainsLiteral(enumName, literalName)) { //if enumeration contains literal
					
					EType type = context.getEolFactory().createEType(); //create eType
					type.setEcoreType((EClassifier) mm.getEnum(enumName)); //set ecoreType
					context.setAssets(type, enumerationLiteralExpression); //set assets
					enumerationLiteralExpression.setResolvedType(type);
				}
				else {
					//handle enumerationliteral not found
					context.getLogBook().addError(enumerationLiteralExpression.getLiteral(), "literal is not found");
				}
			}
			else {
				//handle enum not found
				context.getLogBook().addError(enumerationLiteralExpression.getEnumeration(), "Enumeration is not found");
			}
		}
		else {
			context.getLogBook().addError(enumerationLiteralExpression.getModel(), "Model not found");
			//handle model not found
		}
		return null;
	}

}
