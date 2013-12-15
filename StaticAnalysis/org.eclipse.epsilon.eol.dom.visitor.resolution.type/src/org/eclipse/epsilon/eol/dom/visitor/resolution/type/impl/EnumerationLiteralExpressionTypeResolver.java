package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.eol.dom.EType;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.dom.visitor.EnumerationLiteralExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
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
		
		EMetaModel mm = context.getMetaModel(modelName); //get metamodel
		if (mm != null) { //if metamodel is not null
			if (mm.containsEnum(enumName)) { //if metamodel caontains enumeration
				if (mm.enumContainsLiteral(enumName, literalName)) { //if enumeration contains literal
					
					EType type = context.getEolFactory().createEType(); //create eType
					type.setEcoreType((EClassifier) mm.getEnum(enumName)); //set ecoreType
					context.setAssets(type, enumerationLiteralExpression); //set assets
				}
				else {
					//handle enumerationliteral not found
				}
			}
			else {
				//handle enum not found
			}
		}
		else {
			//handle model not found
		}
		return null;
	}

}
