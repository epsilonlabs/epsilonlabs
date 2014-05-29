package org.eclipse.epsilon.evl.visitor.resolution.impl;

import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.evl.metamodel.PostBlock;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.metamodel.visitor.PostBlockVisitor;

public class PostBlockVariableResolver extends PostBlockVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(PostBlock postBlock, VariableResolutionContext context,
			EvlVisitorController<VariableResolutionContext, Object> controller) {
		
		controller.visit(postBlock.getName(), context);
		controller.visit(postBlock.getBody(), context);
		
		return null;
	}

}
