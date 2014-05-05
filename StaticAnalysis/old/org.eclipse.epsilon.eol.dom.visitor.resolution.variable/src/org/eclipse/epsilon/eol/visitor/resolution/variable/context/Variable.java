package org.eclipse.epsilon.eol.visitor.resolution.variable.context;

import org.eclipse.epsilon.eol.metamodel.*;

public class Variable {

	protected String name;
	protected VariableDeclarationExpression value;
	protected boolean readOnly = false;

	
	public Variable(String name, VariableDeclarationExpression value)
	{
		this.name = name;
		this.value = value;
	}
	
	public Variable(String name, VariableDeclarationExpression value, boolean readOnly)
	{
		this.name = name;
		this.value = value;
		this.readOnly = readOnly;
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
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public static Variable createReadOnlyVariable(String name, VariableDeclarationExpression value){
		return new Variable(name, value, true);
	}
	
	public boolean isReadOnly()
	{
		return readOnly;
	}
	
	public void setReadOnly(boolean readOnly)
	{
		this.readOnly = readOnly;
	}
	
	public boolean equals(Variable variable)
	{
		return equals(this.name, variable.name) &&
				equals(this.value, variable.value) &&
				equals(this.readOnly, variable.readOnly);
	}
	
	private boolean equals(Object obj1, Object obj2)
	{
		return obj1 == null || obj2 == null ? false : obj1.equals(obj2);
	}
}
