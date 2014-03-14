package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class CollectionTypeCreator extends TypeCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		CollectionType type;
		if (getType().equals("Collection")) {
			type = context.getEolFactory().createCollectionType();
		}
		else {
			type = (CollectionType) create(context);
		}
		if(ast.getNumberOfChildren() != 0 && ast.getChild(0).getType() != EolParser.EXPRLIST && ast.getChild(0).getType() != EolParser.EXPRRANGE)
		{
			type.setContentType((Type) context.getEolElementCreatorFactory().createDomElement(ast.getChild(0), type, context));
		}
		else {
			type.setContentType((Type) context.getEolElementCreatorFactory().createDomElement(ast, type, context, AnyTypeCreator.class));
		}
		this.setAssets(ast, type, container);
		
		return type;
	}
	
	public String getType()
	{
		return "Collection";
	}
}
