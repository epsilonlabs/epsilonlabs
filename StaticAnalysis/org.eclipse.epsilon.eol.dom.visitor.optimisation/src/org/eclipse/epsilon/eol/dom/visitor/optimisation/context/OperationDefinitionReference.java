package org.eclipse.epsilon.eol.dom.visitor.optimisation.context;

import org.eclipse.epsilon.eol.dom.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;

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
