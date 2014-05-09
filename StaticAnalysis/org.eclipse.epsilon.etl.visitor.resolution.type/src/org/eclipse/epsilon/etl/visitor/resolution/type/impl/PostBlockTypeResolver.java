package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.PostBlockVisitor;

public class PostBlockTypeResolver extends PostBlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PostBlock postBlock, TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		Block body = postBlock.getBody();
		if (body != null) {
			controller.visit(body, context);
		}
		return null;
	}

}
