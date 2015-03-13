package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;


public class EffectiveMetamodel {

	protected String name;
	protected String nsuri;
	protected ArrayList<EffectiveType> allOfType = new ArrayList<EffectiveType>();
	protected ArrayList<EffectiveType> allOfKind = new ArrayList<EffectiveType>();
	
	protected ArrayList<EffectiveType> types = new ArrayList<EffectiveType>();
	
	protected ArrayList<String> emptyElements = new ArrayList<String>(); 
	
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
		EffectiveType mec = getFromAllOfKind(elementName);
		if (mec != null) {
			mec.addToAttributes(attribute);
		}
		mec = getFromAllOfType(elementName);
		if (mec != null) {
			mec.addToAttributes(attribute);
		}
		return this;
	}
	
	public EffectiveMetamodel addReferenceToModelElement(String elementName, String reference)
	{
		EffectiveType mec = getFromAllOfKind(elementName);
		if (mec != null) {
			mec.addToReferences(reference);
		}
		mec = getFromAllOfType(elementName);
		if (mec != null) {
			mec.addToReferences(reference);
		}
		return this;
	}
	
	
	public EffectiveType getFromAllOfType(String elementName)
	{
		for(EffectiveType mec: allOfType)
		{
			if (mec.getName().equals(elementName)) {
				return mec;
			}
		}
		return null;
	}
	
	public EffectiveType getFromAllOfKind(String elementName)
	{
		for(EffectiveType mec: allOfKind)
		{
			if (mec.getName().equals(elementName)) {
				return mec;
			}
		}
		return null;
	}
	
	public boolean allOfTypeContains(String modelElement)
	{
		for(EffectiveType mec: allOfType)
		{
			if (mec.getName().equals(modelElement)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean allOfKindContains(String modelElement)
	{
		for(EffectiveType mec: allOfKind)
		{
			if (mec.getName().equals(modelElement)) {
				return true;
			}
		}
		return false;
	}
	
	public void addEmptyElement(String elementName)
	{
		if (!emptyElements.contains(elementName)) {
			emptyElements.add(elementName);
		}
	}
	
	public ArrayList<String> getEmptyElements() {
		return emptyElements;
	}
	

}
