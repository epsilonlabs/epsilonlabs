package org.eclipse.epsilon.eol.coverage.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.eol.coverage.analysis.context.CoverageAnalysisContext;


public class OperationDefinitionCoverageAnalyser extends OperationDefinitionVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		// TODO Auto-generated method stub
		if (operationDefinition.getContextType() != null) {
			controller.visit(operationDefinition.getContextType(), context);
		}
		if (operationDefinition.getReturnType() != null) {
			controller.visit(operationDefinition.getReturnType(), context);	
		}
		for(FormalParameterExpression fpe: operationDefinition.getParameters())
		{
			controller.visit(fpe, context);
		}
		controller.visit(operationDefinition.getBody(), context);
		return null;
	}

}
