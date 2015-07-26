package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.OrderedSetType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OrderedSetTypeVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class OrderedSetTypeTypeResolver_T1 extends OrderedSetTypeVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(OrderedSetType orderedSetType,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(orderedSetType.getContentType(), context);
		return null;
	}

}
