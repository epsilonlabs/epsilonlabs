package org.eclipse.epsilon.eol.performance.analysis.context;

import org.eclipse.epsilon.eol.metamodel.*;

public class OperationDefinitionReference {

	OperationDefinition op = null;
	FOLMethodCallExpression folMethodCallExpression = null;
	
	public OperationDefinitionReference(OperationDefinition op, FOLMethodCallExpression folMethodCallExpression)
	{
		this.op = op;
		this.folMethodCallExpression = folMethodCallExpression;
	}
	
	public OperationDefinition getOperationDefinition()
	{
		return op;
	}
	
	public FOLMethodCallExpression getFolMethodCallExpression()
	{
		return folMethodCallExpression;
	}
}
