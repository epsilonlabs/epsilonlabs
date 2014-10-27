package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

public class ModelElementContainer {

	protected String elementName;
	protected ArrayList<String> attributes = new ArrayList<String>();
	protected ArrayList<String> references = new ArrayList<String>();
	
	public ModelElementContainer(String elementName)
	{
		this.elementName = elementName;
	}
	
	public String getElementName() {
		return elementName;
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
			attributes.add(reference);	
		}
	}
}
