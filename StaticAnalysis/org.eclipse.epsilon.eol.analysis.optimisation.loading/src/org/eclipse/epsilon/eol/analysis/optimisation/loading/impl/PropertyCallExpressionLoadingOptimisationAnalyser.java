package org.eclipse.epsilon.eol.analysis.optimisation.loading.impl;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;

public class PropertyCallExpressionLoadingOptimisationAnalyser extends PropertyCallExpressionVisitor<LoadingOptimisationAnalysisContext, Object>{

	@Override
	public Object visit(
			PropertyCallExpression propertyCallExpression,
			LoadingOptimisationAnalysisContext context,
			EolVisitorController<LoadingOptimisationAnalysisContext, Object> controller) {
		
		return null;
	}

}
