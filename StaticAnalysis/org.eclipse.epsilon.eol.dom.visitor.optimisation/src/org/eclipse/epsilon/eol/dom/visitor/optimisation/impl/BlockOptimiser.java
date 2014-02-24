package org.eclipse.epsilon.eol.dom.visitor.optimisation.impl;

import org.eclipse.epsilon.eol.dom.Block;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.context.OptimisationContext;

import org.eclipse.epsilon.eol.dom.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;

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
