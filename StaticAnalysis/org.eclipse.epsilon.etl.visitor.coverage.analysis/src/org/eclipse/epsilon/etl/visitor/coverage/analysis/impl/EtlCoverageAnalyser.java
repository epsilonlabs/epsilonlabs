package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class EtlCoverageAnalyser {

	protected EtlVisitorController<CoverageAnalysisContext, Object> controller = new EtlVisitorController<CoverageAnalysisContext, Object>();
	protected CoverageAnalysisContext context = new CoverageAnalysisContext();
	
	public EtlCoverageAnalyser()
	{
		controller.addEtlProgramVisitor(new EtlProgramCoverangeAnalyser());
		controller.addTransformationRuleVisitor(new TransformationRuleCoverageAnalyser());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionCoverageAnalyser());
		controller.addModelElementTypeVisitor(new ModelElementTypeCoverageAnalyser());
		controller.addDefaultVisitor(new EolDefaultVisitor<CoverageAnalysisContext, Object>());
	}
	
	public void run(EolElement eolElement)
	{
		controller.visit(eolElement, context);
	}
	
	public CoverageAnalysisContext getContext() {
		return context;
	}
}
