package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class AssignmentStatementLoadingOptimisationAnalyser extends AssignmentStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(AssignmentStatement assignmentStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		LoadingOptimisationAnalysisContext leContext = (LoadingOptimisationAnalysisContext) context;
		
		leContext.setCurrentAssignmentStatement(assignmentStatement);
		
		controller.visitContents(assignmentStatement, context);
		return null;
	}

}
