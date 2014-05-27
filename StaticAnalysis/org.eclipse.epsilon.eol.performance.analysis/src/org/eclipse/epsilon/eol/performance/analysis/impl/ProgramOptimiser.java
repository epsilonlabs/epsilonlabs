package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.performance.analysis.context.PerformanceAnalysisContext;

public class ProgramOptimiser extends EolProgramVisitor<PerformanceAnalysisContext, Object>{

	@Override
	public Object visit(EolProgram program, PerformanceAnalysisContext context,
			EolVisitorController<PerformanceAnalysisContext, Object> controller) {
		System.err.println("inside Program optimiser");
		for(ModelDeclarationStatement mds: program.getModelDeclarations())
		{
			controller.visit(mds, context);
		}
		controller.visitContents(program, context);
		return null;
	}

}
