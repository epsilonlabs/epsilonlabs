package org.eclipse.epsilon.evl.visitor.resolution.impl;

import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.evl.metamodel.PreBlock;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.metamodel.visitor.PreBlockVisitor;

public class PreBlockVariableResolver extends PreBlockVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(PreBlock preBlock, VariableResolutionContext context,
			EvlVisitorController<VariableResolutionContext, Object> controller) {

		controller.visit(preBlock.getName(), context);
		controller.visit(preBlock.getBody(), context);
		
		return null;
	}

}
