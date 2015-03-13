package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

public class EffectiveType {

	protected String name;
	protected ArrayList<String> attributes = new ArrayList<String>();
	protected ArrayList<String> references = new ArrayList<String>();
	
	public EffectiveType(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getAttributes() {
		return attributes;
	}
	
	public ArrayList<String> getReferences() {
		return references;
	}
	
	public void addToAttributes(String attribute)
	{
		if (!attributes.contains(attribute)) {
			attributes.add(attribute);
		}
	}
	
	public void addToReferences(String reference)
	{
		if (!references.contains(reference)) {
			references.add(reference);	
		}
	}
}
