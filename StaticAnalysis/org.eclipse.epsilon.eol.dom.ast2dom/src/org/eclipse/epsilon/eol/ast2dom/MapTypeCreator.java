package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;

public class MapTypeCreator extends TypeCreator{

	public EolElement create(AST ast, EolElement container,
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
