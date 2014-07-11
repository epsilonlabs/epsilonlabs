package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.evl.metamodel.PreBlock;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.metamodel.visitor.PreBlockVisitor;

public class PreBlockTypeResolver extends PreBlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PreBlock preBlock, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {

		Block body = preBlock.getBody();
		if (body != null) {
			controller.visit(body, context);
		}
		
		return null;
	}

}
