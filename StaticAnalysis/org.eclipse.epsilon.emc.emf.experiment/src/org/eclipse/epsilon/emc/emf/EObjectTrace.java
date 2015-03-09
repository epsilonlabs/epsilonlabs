package org.eclipse.epsilon.emc.emf;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

public class EObjectTrace {
	protected String name;
	protected EObject eObject;
	protected ArrayList<EObjectTrace> children = new ArrayList<EObjectTrace>();
	
	public EObjectTrace(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<EObjectTrace> getChildren() {
		return children;
	}
	
	public EObjectTrace getChild(String name)
	{
		for(EObjectTrace et: children)
		{
			if (et.getName().equals(name)) {
				return et;
			}
		}
		return null;
	}
	
	public EObject geteObject() {
		return eObject;
	}
	
	public void seteObject(EObject eObject) {
		this.eObject = eObject;
	}
	
	public void createChild(String name)
	{
		EObjectTrace child = new EObjectTrace(name);
		children.add(child);
	}
}
