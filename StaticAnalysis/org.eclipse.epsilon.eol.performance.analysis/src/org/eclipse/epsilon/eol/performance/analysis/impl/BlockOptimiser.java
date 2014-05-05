package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.performance.analysis.context.OptimisationContext;


public class BlockOptimiser extends BlockVisitor<OptimisationContext, Object>{

	@Override
	public Object visit(Block block, OptimisationContext context,
			EolVisitorController<OptimisationContext, Object> controller) {
		for(Statement stmt: block.getStatements())
		{
			controller.visit(stmt, context);
		}
		return null;
	}

}
