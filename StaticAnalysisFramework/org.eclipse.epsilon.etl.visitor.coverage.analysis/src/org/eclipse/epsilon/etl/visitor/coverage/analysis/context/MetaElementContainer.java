package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class MetaElementContainer {

//	protected boolean visited;
	protected EClass clazz;
	protected ArrayList<EAttribute> attributes;
	protected ArrayList<EReference> references;
	
	protected ArrayList<EReference> featuresAccessedViaOpposite;
//	protected ArrayList<EAttribute> unvisitedAttributes;
//	protected ArrayList<EReference> unvisitedEReferences;
	
//	protected boolean usedAttributeDeplited;
//	protected boolean usedReferenceEplited;
	
	public MetaElementContainer(EClass eClass)
	{
//		visited = false;
		this.clazz = eClass;
		attributes = new ArrayList<EAttribute>();
		references = new ArrayList<EReference>();
		
		featuresAccessedViaOpposite = new ArrayList<EReference>();
		
//		unvisitedAttributes = new ArrayList<EAttribute>();
//		unvisitedEReferences = new ArrayList<EReference>();
		
//		usedAttributeDeplited = false;
//		usedReferenceEplited = false;
	}
	
	
	public EClass getEClass() {
		return clazz;
	}
	
	public void setEClass(EClass eClass) {
		this.clazz = eClass;
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

	public void add(String propertyName, boolean accessedViaOpposite)
	{
		for(EAttribute attribute: clazz.getEAllAttributes())
		{
			if (attribute.getName().equals(propertyName)) {
				if (attributes.contains(attribute)) {
					return;
				}
				attributes.add(attribute);
				return;
			}
			
		}
		for(EReference reference : clazz.getEAllReferences())
		{
			if (reference.getName().equals(propertyName)) {
				if (references.contains(reference)) {
					if (accessedViaOpposite) {
						featuresAccessedViaOpposite.add(reference);
					}
					return;
				}
				else {
					if (accessedViaOpposite) {
						featuresAccessedViaOpposite.add(reference);
					}
					references.add(reference);
				}
			}
		}
	}
	
	public ArrayList<EAttribute> getUnusedAttributes()
	{
		ArrayList<EAttribute> result = new ArrayList<EAttribute>();
		for(EAttribute attr: clazz.getEAllAttributes())
		{
			if (!attributes.contains(attr)) {
				result.add(attr);
			}
		}
		return result;
	}
	
	public ArrayList<EReference> getUnusedEReferences()
	{
		ArrayList<EReference> result = new ArrayList<EReference>();
		for(EReference eRef: clazz.getEAllReferences())
		{
			if (!references.contains(eRef)) {
				result.add(eRef);
			}
		}
		return result;
	}
	
	public ArrayList<EStructuralFeature> getAllUnusedFeatures()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		result.addAll(getUnusedAttributes());
		result.addAll(getUnusedEReferences());
		return result;
	}
	
	public ArrayList<EReference> getFeaturesAccessedViaOpposite() {
		return featuresAccessedViaOpposite;
	}
	
//	public void sync()
//	{
//		unvisitedAttributes.addAll(attributes);
//		unvisitedEReferences.addAll(references);
//	}
//	
//	public void setVisited(boolean visited) {
//		this.visited = visited;
//	}
//	
//	public boolean isVisited() {
//		return visited;
//	}
//
//	public EAttribute getOneUsedAttribute()
//	{
//		if (unvisitedAttributes.size() != 0) {
//			EAttribute attribute = unvisitedAttributes.get(0);
//			unvisitedAttributes.remove(attribute);
//			return attribute;
//		}
//		else {
//			return null;
//		}
//	}
}
