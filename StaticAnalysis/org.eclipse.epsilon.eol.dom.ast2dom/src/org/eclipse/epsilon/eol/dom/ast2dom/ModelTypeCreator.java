package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.Type;

public class ModelTypeCreator extends TypeCreator{

	@Override
	public Type create(Ast2DomContext context) {
		return context.getEolFactory().createModelType();
	}

	@Override
	public String getType() {
		return "Model";
	}

}
