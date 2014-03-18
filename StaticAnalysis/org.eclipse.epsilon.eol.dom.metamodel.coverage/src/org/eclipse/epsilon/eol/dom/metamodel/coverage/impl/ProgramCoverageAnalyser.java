package org.eclipse.epsilon.eol.dom.metamodel.coverage.impl;

import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.metamodel.coverage.context.CoverageAnalysisContext;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ProgramVisitor;

public class ProgramCoverageAnalyser extends ProgramVisitor<CoverageAnalysisContext, Object> {

	@Override
	public Object visit(Program program, CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		// TODO Auto-generated method stub
		for(OperationDefinition od: program.getOperations())
		{
			controller.visit(od, context);
		}
		controller.visit(program.getBlock(), context);
		return null;
	}

}
