package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.SequenceType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SequenceTypeVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class SequenceTypeTypeResolver_T1 extends SequenceTypeVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(SequenceType sequenceType,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(sequenceType.getContentType(), context);
		return null;
	}
}
