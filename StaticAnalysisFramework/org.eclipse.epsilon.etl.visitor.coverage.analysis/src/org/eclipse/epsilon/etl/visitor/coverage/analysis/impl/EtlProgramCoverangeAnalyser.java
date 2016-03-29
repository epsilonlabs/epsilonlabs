package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.etl.metamodel.ETLModule;
import org.eclipse.epsilon.etl.metamodel.NamedBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.ETLModuleVisitor;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class EtlProgramCoverangeAnalyser extends ETLModuleVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(ETLModule etlProgram, CoverageAnalysisContext context,
			EtlVisitorController<CoverageAnalysisContext, Object> controller) {
		context.setCurrentElement(etlProgram);
		for(NamedBlock pre: etlProgram.getPreBlocks())
		{
			controller.visit(pre, context);
		}
		
		for(OperationDefinition op: etlProgram.getOperations())
		{
			controller.visit(op, context);
		}
		
		for(TransformationRule tr: etlProgram.getTransformationRules())
		{
			context.setCurrentElement(tr);
			controller.visit(tr, context);
		}
		context.setCurrentElement(etlProgram);
		for(NamedBlock post: etlProgram.getPostBlocks())
		{
			controller.visit(post, context);
		}
		return null;
	}

}
