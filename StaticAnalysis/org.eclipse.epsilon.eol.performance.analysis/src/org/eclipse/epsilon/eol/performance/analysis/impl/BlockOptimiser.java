package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.performance.analysis.context.PerformanceAnalysisContext;


public class BlockOptimiser extends BlockVisitor<PerformanceAnalysisContext, Object>{

	@Override
	public Object visit(Block block, PerformanceAnalysisContext context,
			EolVisitorController<PerformanceAnalysisContext, Object> controller) {
		for(Statement stmt: block.getStatements())
		{
			controller.visit(stmt, context);
		}
		return null;
	}

}
