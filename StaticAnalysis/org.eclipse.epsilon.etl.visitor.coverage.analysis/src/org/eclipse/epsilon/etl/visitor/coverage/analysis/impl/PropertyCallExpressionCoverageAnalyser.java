package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class PropertyCallExpressionCoverageAnalyser extends PropertyCallExpressionVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		Type tempType = propertyCallExpression.getTarget().getResolvedType();
		if (tempType instanceof ModelElementType) {
			ModelElementType targetTypde = (ModelElementType) tempType;
			EClassifier ecoreType = targetTypde.getEcoreType();
			String propertyName = propertyCallExpression.getProperty().getName();
			context.add(ecoreType, propertyName);
		}
		return null;
	}

}
