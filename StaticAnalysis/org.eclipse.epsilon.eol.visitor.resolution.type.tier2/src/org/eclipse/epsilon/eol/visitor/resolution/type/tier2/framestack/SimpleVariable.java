package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.framestack;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;

public class SimpleVariable extends Variable{

	protected VariableDeclarationExpression value;

	public SimpleVariable(String name, VariableDeclarationExpression value) {
		this.name = name;
		this.value = value;
	}

	public void dispose()
	{
		value = null;
		name = null;
	}
	
	public EolElement getVariable()
	{
		return value;
	}

}
