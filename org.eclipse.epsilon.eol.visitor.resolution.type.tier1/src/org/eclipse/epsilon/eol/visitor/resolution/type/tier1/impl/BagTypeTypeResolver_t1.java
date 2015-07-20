package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.BagType;
import org.eclipse.epsilon.eol.metamodel.visitor.BagTypeVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class BagTypeTypeResolver_t1 extends BagTypeVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(BagType bagType, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(bagType.getContentType(), context);
		return null;
	}

}
