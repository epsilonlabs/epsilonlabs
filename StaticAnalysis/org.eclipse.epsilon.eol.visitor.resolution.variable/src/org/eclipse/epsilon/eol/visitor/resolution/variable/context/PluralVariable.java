package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;

public class PluralVariable extends Variable{

	protected ArrayList<VariableDeclarationExpression> values;

	public PluralVariable(String name, VariableDeclarationExpression value) {
		this.name = name;
		if (values == null) {
			values = new ArrayList<VariableDeclarationExpression>();
			values.add(value);
		}
		else {
			if(!values.contains(value))
			{
				values.add(value);
			}
		}
	}

	public void dispose()
	{
		values = null;
		name = null;
	}
	
	public ArrayList<VariableDeclarationExpression> getValues() {
		return values;
	}
	
	public void addValue(VariableDeclarationExpression value)
	{
		values.add(value);
	}

}
