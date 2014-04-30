package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class OrderedSetTypeCreator extends CollectionTypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createOrderedSetType();
	}

	@Override
	public String getType() {
		return "OrderedSet";
	}

}
