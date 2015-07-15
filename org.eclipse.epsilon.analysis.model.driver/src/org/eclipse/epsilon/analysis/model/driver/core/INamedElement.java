package org.eclipse.epsilon.analysis.model.driver.core;

public abstract class INamedElement {

	protected String name;
	
	public INamedElement(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
