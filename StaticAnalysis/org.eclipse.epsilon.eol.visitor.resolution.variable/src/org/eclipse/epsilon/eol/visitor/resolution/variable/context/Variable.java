package org.eclipse.epsilon.eol.visitor.resolution.variable.context;


public class Variable {

	protected String name;
	protected boolean inScope = false;
	
	public boolean getInScope()
	{
		return inScope;
	}
	
	public void setInScope(boolean inScope)
	{
		this.inScope = inScope;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void dispose()
	{
		
	}
	
	
	
//	public static Variable createReadOnlyVariable(String name, VariableDeclarationExpression value){
//		return new Variable(name, value, true);
//	}
	
//	public boolean isReadOnly()
//	{
//		return readOnly;
//	}
	
//	public void setReadOnly(boolean readOnly)
//	{
//		this.readOnly = readOnly;
//	}
	
//	public boolean equals(Variable variable)
//	{
//		return equals(this.name, variable.name) &&
//				equals(this.value, variable.value) &&
//				equals(this.readOnly, variable.readOnly);
//	}
	
//	private boolean equals(Object obj1, Object obj2)
//	{
//		return obj1 == null || obj2 == null ? false : obj1.equals(obj2);
//	}
}
