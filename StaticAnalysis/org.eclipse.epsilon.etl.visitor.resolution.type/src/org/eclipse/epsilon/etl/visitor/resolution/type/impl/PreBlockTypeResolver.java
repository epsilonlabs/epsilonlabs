package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.PreBlockVisitor;

public class PreBlockTypeResolver extends PreBlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PreBlock preBlock, TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		Block body = preBlock.getBody();
		if (body != null) {
			controller.visit(body, context);
		}
		return null;
	}

}
