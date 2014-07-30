package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class CollectionTypeCreator extends TypeCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		CollectionType type;
		if (getType().equals("Collection")) {
			type = context.getEolFactory().createCollectionType();
		}
		else {
			type = (CollectionType) create(context);
		}
		this.setAssets(ast, type, container);
		if(ast.getNumberOfChildren() != 0 && ast.getChild(0).getType() != EolParser.EXPRLIST && ast.getChild(0).getType() != EolParser.EXPRRANGE)
		{
			type.setContentType((Type) context.getEolElementCreatorFactory().createDomElement(ast.getChild(0), type, context));
		}
		else {
			AnyType anyType = context.getEolFactory().createAnyType();
			setAssets(ast, anyType, type);
			type.setContentType(anyType);
//			type.setContentType((Type) context.getEolElementCreatorFactory().createDomElement(ast, type, context, AnyTypeCreator.class));
		}
		
		
		return type;
	}
	
	public String getType()
	{
		return "Collection";
	}
}
