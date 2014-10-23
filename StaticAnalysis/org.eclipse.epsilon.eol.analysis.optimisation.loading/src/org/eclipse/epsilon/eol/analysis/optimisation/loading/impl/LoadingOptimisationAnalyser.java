package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl.ModelDeclarationStatementTypeResolver;

public class LoadingOptimisationAnalyser {
	protected EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	protected LoadingOptimisationAnalysisContext context = new LoadingOptimisationAnalysisContext();

	
	public LoadingOptimisationAnalyser()
	{
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementTypeResolver());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionLoadingOptimisationAnalyser());
	}

}
