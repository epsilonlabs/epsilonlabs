package org.eclipse.epsilon.etl.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.PreBlockVisitor;
import org.eclipse.epsilon.etl.visitor.resolution.variable.context.EtlVariableResolutionContext;

public class PreBlockVariableResolver extends PreBlockVisitor<VariableResolutionContext, Object>{


	@Override
	public Object visit(PreBlock preBlock, VariableResolutionContext context,
			EtlVisitorController<VariableResolutionContext, Object> controller) {
		controller.visit(preBlock.getName(), context);
		controller.visit(preBlock.getBody(), context);
		return null;
	}

}
