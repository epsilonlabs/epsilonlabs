package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;

public class OperationDefinitionNode {

	protected OperationDefinition containedOperationDefinition = null;
	protected ArrayList<MethodCallExpression> invokers = new ArrayList<MethodCallExpression>();
	protected ArrayList<FOLMethodCallExpression> containedFolMethodCallExpressions = new ArrayList<FOLMethodCallExpression>();
	
	public OperationDefinitionNode(OperationDefinition operationDefinition)
	{
		containedOperationDefinition = operationDefinition;
	}
	
	public OperationDefinition getContainedOperationDefinition() {
		return containedOperationDefinition;
	}
	
	public ArrayList<MethodCallExpression> getInvokers() {
		return invokers;
	}
	
	public void addInvoker(MethodCallExpression methodCallExpression)
	{
		invokers.add(methodCallExpression);
	}
	
	public ArrayList<FOLMethodCallExpression> getContainedFolMethodCallExpressions() {
		return containedFolMethodCallExpressions;
	}
	
	public void addFolMethodCallExpressions(FOLMethodCallExpression folMethodCallExpression)
	{
		containedFolMethodCallExpressions.add(folMethodCallExpression);
	}
}
