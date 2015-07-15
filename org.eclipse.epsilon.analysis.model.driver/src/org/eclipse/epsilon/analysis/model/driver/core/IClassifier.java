package org.eclipse.epsilon.analysis.model.driver.core;

public abstract class IClassifier extends INamedElement{

	protected IPackage iPackage;
	protected String instanceClassName;
	protected Class<?> instanceClass;
	
	
	public IPackage getiPackage() {
		return iPackage;
	}
	
	public String getInstanceClassName() {
		return instanceClassName;
	}
	
	public Class<?> getInstanceClass() {
		return instanceClass;
	}
	
	public IClassifier(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public IClassifier(String name, IPackage iPackage, String instanceClassName, Class<?> instanceClass)
	{
		super(name);
		this.iPackage = iPackage;
		this.instanceClassName = instanceClassName;
		this.instanceClass = instanceClass;
	}
	
	public boolean isInstance(Object obj)
	{
		return instanceClass.isInstance(obj);
	}

}
