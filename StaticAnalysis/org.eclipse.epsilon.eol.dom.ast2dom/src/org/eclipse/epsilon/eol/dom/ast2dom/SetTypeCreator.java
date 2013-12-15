package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class SetTypeCreator extends CollectionTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createSetType();
	}

	@Override
	public String getType() {
		return "Set";
	}

}
