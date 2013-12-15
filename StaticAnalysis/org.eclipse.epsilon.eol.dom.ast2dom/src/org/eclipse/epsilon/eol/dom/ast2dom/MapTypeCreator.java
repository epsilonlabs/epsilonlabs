package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class MapTypeCreator extends TypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createMapType();
	}

	@Override
	public String getType() {
		return "Map";
	}

}
