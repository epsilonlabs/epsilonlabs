package org.eclipse.epsilon.eol.coverage.analysis.impl;

import org.eclipse.epsilon.eol.coverage.analysis.context.CoverageAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;

public class CoverageAnalyser {

	EolVisitorController<CoverageAnalysisContext, Object> controller = new EolVisitorController<CoverageAnalysisContext, Object>();
	CoverageAnalysisContext context = new CoverageAnalysisContext();
	
	public CoverageAnalyser()
	{
		controller.addDefaultVisitor(new EolDefaultVisitor<CoverageAnalysisContext, Object>());
		controller.addModelElementTypeVisitor(new ModelElementTypeCoverageAnalyser());
		controller.addOperationDefinitionVisitor(new OperationDefinitionCoverageAnalyser());
		controller.addProgramVisitor(new ProgramCoverageAnalyser());
	}
	
	public void run(EolElement dom)
	{
		controller.visit(dom, context);
	}
	
	public void print()
	{
		System.out.println(context.getCoverageAnalysisRepo().toString());
	}
	
	public CoverageAnalysisContext getCoverageAnalysisContext() {
		return context;
	}
}
