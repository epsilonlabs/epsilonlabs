package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

public class EffectiveType {

	protected String name;
	protected ArrayList<EffectiveFeature> attributes = new ArrayList<EffectiveFeature>();
	protected ArrayList<EffectiveFeature> references = new ArrayList<EffectiveFeature>();
	
	public EffectiveType(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<EffectiveFeature> getAttributes() {
		return attributes;
	}
	
	public ArrayList<EffectiveFeature> getReferences() {
		return references;
	}
	
	public void addToAttributes(String attribute)
	{
		for(EffectiveFeature ef: attributes)
		{
			if (ef.getName().equals(attribute)) {
				return;
			}
		}
		
		EffectiveFeature attr = new EffectiveFeature(attribute);
		attributes.add(attr);
	}
	
	public void addToReferences(String reference)
	{
		for(EffectiveFeature ef: references)
		{
			if(ef.getName().equals(reference))
			{
				return;
			}
		}
		EffectiveFeature ref = new EffectiveFeature(reference);
		references.add(ref);
	}
	
	public void increaseAttributeUsage(String attribute)
	{
		for(EffectiveFeature ef: attributes)
		{
			if (ef.getName().equals(attribute)) {
				ef.increaseUsage();
				return;
			}
		}
	}
	
	public void increaseReferenceUsage(String reference)
	{
		for(EffectiveFeature ef: references)
		{
			if (ef.getName().equals(reference)) {
				ef.increaseUsage();
				return;
			}
		}
	}
	
	public ArrayList<EffectiveFeature> getAllFeatures()
	{
		ArrayList<EffectiveFeature> result = new ArrayList<EffectiveFeature>();
		result.addAll(attributes);
		result.addAll(references);
		return result;
	}
}
