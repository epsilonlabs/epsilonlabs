package org.eclipse.epsilon.eol.dom.visitor.optimisation.impl;

import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ProgramVisitor;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.context.OptimisationContext;

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
