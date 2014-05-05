package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ProgramVisitor;
import org.eclipse.epsilon.eol.performance.analysis.context.OptimisationContext;

public class ProgramOptimiser extends ProgramVisitor<OptimisationContext, Object>{

	@Override
	public Object visit(Program program, OptimisationContext context,
			EolVisitorController<OptimisationContext, Object> controller) {
		System.err.println("inside Program optimiser");
		for(ModelDeclarationStatement mds: program.getModelDeclarations())
		{
			controller.visit(mds, context);
		}
		controller.visitContents(program, context);
		return null;
	}

}
