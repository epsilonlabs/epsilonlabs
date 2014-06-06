package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.eol.metamodel.*;


public class AnyTypeCreator extends TypeCreator{

	@Override
	public Type create(Ast2EolContext context) {
		return context.getEolFactory().createAnyType();
	}

	@Override
	public String getType() {
		return "Any";
	}
 
}
