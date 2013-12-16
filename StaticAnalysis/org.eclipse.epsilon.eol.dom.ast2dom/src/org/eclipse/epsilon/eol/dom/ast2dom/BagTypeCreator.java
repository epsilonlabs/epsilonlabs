package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class BagTypeCreator extends CollectionTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createBagType();
	}

	@Override
	public String getType() {
		return "Bag";
	}

}