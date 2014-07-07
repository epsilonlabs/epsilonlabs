package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlProgramVisitor;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class EtlProgramCoverangeAnalyser extends EtlProgramVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(EtlProgram etlProgram, CoverageAnalysisContext context,
			EtlVisitorController<CoverageAnalysisContext, Object> controller) {
		context.setCurrentElement(etlProgram);
		for(PreBlock pre: etlProgram.getPreBlocks())
		{
			controller.visit(pre, context);
		}
		
		for(OperationDefinition op: etlProgram.getOperations())
		{
			controller.visit(op, context);
		}
		
		for(TransformationRule tr: etlProgram.getTransformationRules())
		{
			controller.visit(tr, context);
		}
		
		for(PostBlock post: etlProgram.getPostBlocks())
		{
			controller.visit(post, context);
		}
		return null;
	}

}
