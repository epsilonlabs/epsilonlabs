package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.SequenceType;

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
