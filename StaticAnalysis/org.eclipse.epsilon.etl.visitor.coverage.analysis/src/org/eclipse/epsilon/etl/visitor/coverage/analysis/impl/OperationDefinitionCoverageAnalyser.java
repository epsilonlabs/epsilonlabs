package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class OperationDefinitionCoverageAnalyser extends OperationDefinitionVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		controller.visit(operationDefinition.getContextType(), context);
		for(FormalParameterExpression param: operationDefinition.getParameters())
		{
			controller.visit(param, context);
		}
		controller.visit(operationDefinition.getReturnType(), context);
		
		controller.visit(operationDefinition.getBody(), context);
		return null;
	}

}
