package org.eclipse.epsilon.eol.dom.visitor.optimisation.impl;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.MethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.context.OperationDefinitionReference;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.context.OptimisationContext;

public class MethodCallExpressionOptimiser extends MethodCallExpressionVisitor<OptimisationContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			OptimisationContext context,
			EolVisitorController<OptimisationContext, Object> controller) {
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
	
	public boolean inLoop(DomElement dom)
	{
		DomElement container = dom.getContainer();
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
	
	public boolean isContainedBy(DomElement dom, DomElement container)
	{
		DomElement domContainer = dom;
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
