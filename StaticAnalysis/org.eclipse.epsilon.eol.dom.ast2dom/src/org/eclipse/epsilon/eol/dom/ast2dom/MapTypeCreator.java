package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.MapType;

public class MapTypeCreator extends TypeCreator{

	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		MapType type = context.getEolFactory().createMapType();
		this.setAssets(ast, type, container);
		return type;
	}
	
	@Override
	public String getType() {
		return "Map";
	}

}
