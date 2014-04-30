package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.eol.metamodel.*;

public class SequenceTypeCreator extends CollectionTypeCreator{
	
	@Override
	public SequenceType create(Ast2DomContext context) {
		return context.getEolFactory().createSequenceType();
	}

	@Override
	public String getType() {
		return "Sequence";
	}

}
