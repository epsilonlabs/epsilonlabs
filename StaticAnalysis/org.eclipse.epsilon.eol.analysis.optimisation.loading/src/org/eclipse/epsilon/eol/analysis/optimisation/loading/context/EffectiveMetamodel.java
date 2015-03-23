package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;


public class EffectiveMetamodel {

	protected String name;
	protected String nsuri;
	protected ArrayList<EffectiveType> allOfType = new ArrayList<EffectiveType>();
	protected ArrayList<EffectiveType> allOfKind = new ArrayList<EffectiveType>();
	
	protected ArrayList<EffectiveType> types = new ArrayList<EffectiveType>();
	
	public EffectiveMetamodel(String name)
	{
		this.name = name;
	}
	
	public EffectiveMetamodel(String name, String nsuri)
	{
		this.name = name;
		this.nsuri = nsuri;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNsuri() {
		return nsuri;
	}
	
	public ArrayList<EffectiveType> getAllOfType() {
		return allOfType;
	}
	
	public ArrayList<EffectiveType> getAllOfKind() {
		return allOfKind;
	}
	
	public EffectiveMetamodel addToAllOfType(String modelElement)
	{
		if (!allOfTypeContains(modelElement)) {
			allOfType.add(new EffectiveType(modelElement));
		}
		return this;
	}
	
	public EffectiveMetamodel addToAllOfKind(String modelElement)
	{
		if (!allOfKindContains(modelElement)) {
			allOfKind.add(new EffectiveType(modelElement));
		}
		return this;
	}
	
	public EffectiveMetamodel addAttributeToModelElement(String elementName, String attribute)
	{
		EffectiveType effectiveType = getFromAllOfKind(elementName);
		if (effectiveType != null) {
			effectiveType.addToAttributes(attribute);
		}
		effectiveType = getFromAllOfType(elementName);
		if (effectiveType != null) {
			effectiveType.addToAttributes(attribute);
		}
		return this;
	}
	
	public EffectiveMetamodel addReferenceToModelElement(String elementName, String reference)
	{
		EffectiveType effectiveType = getFromAllOfKind(elementName);
		if (effectiveType != null) {
			effectiveType.addToReferences(reference);
		}
		effectiveType = getFromAllOfType(elementName);
		if (effectiveType != null) {
			effectiveType.addToReferences(reference);
		}
		return this;
	}
	
	
	public EffectiveType getFromAllOfType(String elementName)
	{
		for(EffectiveType ef: allOfType)
		{
			if (ef.getName().equals(elementName)) {
				return ef;
			}
		}
		return null;
	}
	
	public EffectiveType getFromAllOfKind(String elementName)
	{
		for(EffectiveType ef: allOfKind)
		{
			if (ef.getName().equals(elementName)) {
				return ef;
			}
		}
		return null;
	}
	
	public boolean allOfTypeContains(String modelElement)
	{
		for(EffectiveType ef: allOfType)
		{
			if (ef.getName().equals(modelElement)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean allOfKindContains(String modelElement)
	{
		for(EffectiveType ef: allOfKind)
		{
			if (ef.getName().equals(modelElement)) {
				return true;
			}
		}
		return false;
	}
}
