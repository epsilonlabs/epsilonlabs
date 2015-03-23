package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;

public class AssignmentStatementLoadingOptimisationAnalyser extends AssignmentStatementVisitor<LoadingOptimisationAnalysisContext, Object>{

	@Override
	public Object visit(
			AssignmentStatement assignmentStatement,
			LoadingOptimisationAnalysisContext context,
			EolVisitorController<LoadingOptimisationAnalysisContext, Object> controller) {
		
		context.setCurrentAssignmentStatement(assignmentStatement);
		controller.visitContents(assignmentStatement, context);
		
		return null;
	}

}
