package org.eclipse.epsilon.etl.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.PostBlockVisitor;

public class PostBlockVariableResolver extends PostBlockVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(PostBlock postBlock, VariableResolutionContext context,
			EtlVisitorController<VariableResolutionContext, Object> controller) {
		if (postBlock.getName() != null) {
			controller.visit(postBlock.getName(), context);	
		}
		if (postBlock.getBody() != null) {
			controller.visit(postBlock.getBody(), context);	
		}
		
		return null;
	}

}
