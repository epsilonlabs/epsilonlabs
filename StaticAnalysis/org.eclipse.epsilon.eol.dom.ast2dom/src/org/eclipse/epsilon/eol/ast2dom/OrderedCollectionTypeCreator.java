package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class OrderedCollectionTypeCreator extends CollectionTypeCreator{
	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createOrderedCollectionType();
	}

	@Override
	public String getType() {
		return "OrderedCollection";
	}

}
