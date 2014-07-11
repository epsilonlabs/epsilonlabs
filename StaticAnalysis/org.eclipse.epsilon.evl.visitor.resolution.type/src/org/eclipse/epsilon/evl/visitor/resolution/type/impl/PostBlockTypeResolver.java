package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

import org.eclipse.epsilon.evl.metamodel.PostBlock;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.metamodel.visitor.PostBlockVisitor;

public class PostBlockTypeResolver extends PostBlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PostBlock postBlock, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {
		Block body = postBlock.getBody();
		if (body != null) {
			controller.visit(body, context);
		}
		return null;
	}

}
