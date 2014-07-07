package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class MetaElementContainer {

	protected EClass clazz;
	protected ArrayList<EAttribute> attributes;
	protected ArrayList<EReference> references;
	
	public MetaElementContainer(EClass classifier)
	{
		this.clazz = classifier;
		attributes = new ArrayList<EAttribute>();
		references = new ArrayList<EReference>();
	}
	
	
	public EClass getClassifier() {
		return clazz;
	}
	
	public void setClassifier(EClass classifier) {
		this.clazz = classifier;
	}
	
	public ArrayList<EAttribute> getAttributes() {
		return attributes;
	}
	
	public ArrayList<EReference> getReferences() {
		return references;
	}
	
	public void addAttribute(EAttribute attribute)
	{
		if (!attributes.contains(attribute)) {
			attributes.add(attribute);
		}
	}
	
	public void addReference(EReference reference)
	{
		if (references.contains(reference)) {
			references.add(reference);
		}
	}
	
	public ArrayList<EStructuralFeature> getAllFeatures()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		result.addAll(attributes);
		result.addAll(references);
		return result;
	}

	public void add(String propertyName)
	{
		for(EAttribute attribute: clazz.getEAllAttributes())
		{
			if (attribute.getName().equals(propertyName)) {
				attributes.add(attribute);
			}
		}
		for(EReference reference : clazz.getEAllReferences())
		{
			if (reference.getName().equals(propertyName)) {
				references.add(reference);
			}
		}
	}
}
