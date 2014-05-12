package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.performance.analysis.context.OperationDefinitionReference;
import org.eclipse.epsilon.eol.performance.analysis.context.PerformanceAnalysisContext;

public class MethodCallExpressionOptimiser extends MethodCallExpressionVisitor<PerformanceAnalysisContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			PerformanceAnalysisContext context,
			EolVisitorController<PerformanceAnalysisContext, Object> controller) {
		// TODO Auto-generated method stub
		if (methodCallExpression.getMethod().getResolvedContent() != null) {
			for(OperationDefinitionReference odr: context.getOperationWithPerformancePotential())
			{
				if (inLoop(methodCallExpression)) {
					if (methodCallExpression.getMethod().getResolvedContent().equals(odr.getOperationDefinition())) {
						context.getLogBook().addWarning(odr.getFolMethodCallExpression(), "This expression may perform better with an indexing system");
						break;
					}
				}
			}
		}
		return null;
	}
	
	public boolean inLoop(EolElement dom)
	{
		EolElement container = dom.getContainer();
		while(!(container instanceof Program))
		{
			if (container instanceof ForStatement || container instanceof WhileStatement) {
				if (container instanceof ForStatement) {
					if (isContainedBy(dom, ((ForStatement)container).getIterated())) {
						return false;
					}
					else {
						return true;
					}
				}
				else if (container instanceof WhileStatement) {
					if (isContainedBy(dom, ((WhileStatement)container).getCondition())) {
						return false;
					}
					else {
						return true;
					}
				}
			}
			container = container.getContainer();
		}
		return false;
	}
	
	public boolean isContainedBy(EolElement dom, EolElement container)
	{
		EolElement domContainer = dom;
		while(!(domContainer instanceof Program))
		{
			if (domContainer.equals(container)) {
				return true;
			}
			domContainer = domContainer.getContainer();
		}
		return false;
	}

}
