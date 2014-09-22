package org.eclipse.epsilon.eol.visitor.analysis.coverage.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.EolElement;

public class MetaElementCoverageContainer {

	protected EClass eClass;
	
	//container to store attributes
	protected ArrayList<EStructuralFeatureHolder> attributes = new ArrayList<EStructuralFeatureHolder>();
	//container to store references
	protected ArrayList<EStructuralFeatureHolder> references = new ArrayList<EStructuralFeatureHolder>();
	//container to store features accessed via eOpposite
	protected ArrayList<EStructuralFeatureHolder> referencesAccessedViaOpposite = new ArrayList<EStructuralFeatureHolder>();
	
	//constructor
	public MetaElementCoverageContainer(EClass eClass)
	{
		this.eClass = eClass;
	}
	
	public EClass getEClass() {
		return eClass;
	}
	
	public void setEClass(EClass eClass) {
		this.eClass = eClass;
	}
	
	
	//add attribute that is read to the container
	public void addReadAttribute(EAttribute attribute, EolElement eolElement)
	{
		EStructuralFeatureHolder holder = getEAttributeContainer(attribute);
		if (holder != null) {
			holder.addRead(eolElement);
		}
		else {
			holder = new EStructuralFeatureHolder();
			holder.addRead(eolElement);
			attributes.add(holder);
		}
	}
	
	//add attribute that is written to the container
	public void addWriteAttribute(EAttribute attribute, EolElement eolElement)
	{
		EStructuralFeatureHolder holder = getEAttributeContainer(attribute);
		if (holder != null) {
			holder.addWrite(eolElement);
		}
		else {
			holder = new EStructuralFeatureHolder();
			holder.addWrite(eolElement);
			attributes.add(holder);
		}
	}
	
	//add reference that is read to the container
	public void addReadReference(EReference eReference, EolElement eolElement, boolean viaOpposite)
	{
		if (viaOpposite) {
			EStructuralFeatureHolder holder = getEReferenceViaOppositeContainer(eReference);
			if (holder != null) {
				holder.addRead(eolElement);
			}
			else {
				holder = new EStructuralFeatureHolder();
				holder.addRead(eolElement);
				referencesAccessedViaOpposite.add(holder);
			}
		}
		else {
			EStructuralFeatureHolder holder = getEReferenceContainer(eReference);
			if (holder != null) {
				holder.addRead(eolElement);
			}
			else {
				holder = new EStructuralFeatureHolder();
				holder.addRead(eolElement);
				references.add(holder);
			}
		}
		
	}
	
	//add reference that is written to the container
	public void addWriteReference(EReference eReference, EolElement eolElement, boolean viaOpposite)
	{
		if (viaOpposite) {
			EStructuralFeatureHolder holder = getEReferenceViaOppositeContainer(eReference);
			if (holder != null) {
				holder.addRead(eolElement);
			}
			else {
				holder = new EStructuralFeatureHolder();
				holder.addWrite(eolElement);
				referencesAccessedViaOpposite.add(holder);
			}

		}
		else {
			EStructuralFeatureHolder holder = getEReferenceContainer(eReference);
			if (holder != null) {
				holder.addWrite(eolElement);
			}
			else {
				holder = new EStructuralFeatureHolder();
				holder.addWrite(eolElement);
				references.add(holder);
			}
		}
	}
	
	public ArrayList<EStructuralFeatureHolder> getAllEAttributesContainer() 
	{
		return attributes;
	}
	
	public ArrayList<EStructuralFeatureHolder> getEAttributesContainer()
	{
		ArrayList<EStructuralFeatureHolder> result = new ArrayList<EStructuralFeatureHolder>();
		ArrayList<EStructuralFeature> usedAttributes = getUsedAttributes();
		for(EStructuralFeatureHolder efh: attributes)
		{
			if (usedAttributes.contains(efh.getFeature())) {
				result.add(efh);
			}
		}
		return result;
	}
	
	public ArrayList<EStructuralFeatureHolder> getAllEReferencesContainer() 
	{
		return references;
	}
	
	public ArrayList<EStructuralFeatureHolder> getEReferencesContainer()
	{
		ArrayList<EStructuralFeatureHolder> result = new ArrayList<EStructuralFeatureHolder>();
		ArrayList<EStructuralFeature> usedReferences = getUsedReferences();
		for(EStructuralFeatureHolder efh: references)
		{
			if (usedReferences.contains(efh.getFeature())) {
				result.add(efh);
			}
		}
		return result;
	}

	
	//get the container for the attribute
	public EStructuralFeatureHolder getEAttributeContainer(EAttribute eAttribute)
	{
		for(EStructuralFeatureHolder esf: attributes)
		{
			if (esf.getFeature().equals(eAttribute)) {
				return esf;
			}
		}
		return null;
	}
	
	//get the container for the reference
	public EStructuralFeatureHolder getEReferenceContainer(EReference eReference)
	{
		for(EStructuralFeatureHolder esf: references)
		{
			if (esf.getFeature().equals(eReference)) {
				return esf;
			}
		}
		return null;
	}
	
	public EStructuralFeatureHolder getEReferenceViaOppositeContainer(EReference eReference)
	{
		for(EStructuralFeatureHolder esf: referencesAccessedViaOpposite)
		{
			if (esf.getFeature().equals(eReference)) {
				return esf;
			}
		}
		return null;
	}
	
	//get all the containers for the features accessed
	public ArrayList<EStructuralFeatureHolder> getAllFeaturesContainer()
	{
		ArrayList<EStructuralFeatureHolder> result = new ArrayList<EStructuralFeatureHolder>();
		result.addAll(attributes);
		result.addAll(references);
		return result;
	}
	
	//get all used attributes including inherited ones
	public ArrayList<EStructuralFeature> getAllUsedAttributes()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		for(EStructuralFeatureHolder efh: attributes)
		{
			result.add(efh.getFeature());
		}
		return result;
	}
	
	//get all used local attributes
	public ArrayList<EStructuralFeature> getUsedAttributes()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> allUsedAttributes = getAllUsedAttributes();
		for(EStructuralFeature esf: eClass.getEAttributes())
		{
			if (allUsedAttributes.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
	
	//get all unused attributes including inherited ones
	public ArrayList<EStructuralFeature> getAllUnusedAttributes()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> allUsedAttributes = getAllUsedAttributes();
		for(EStructuralFeature esf: eClass.getEAllAttributes())
		{
			if (!allUsedAttributes.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
	
	//get unused local attributes
	public ArrayList<EStructuralFeature> getUnusedAttributes()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> allUsedAttributes = getAllUsedAttributes();
		for(EStructuralFeature esf: eClass.getEAttributes())
		{
			if (!allUsedAttributes.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
	
	//get all used references including inherited ones
	public ArrayList<EStructuralFeature> getAllUsedReferences()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		for(EStructuralFeatureHolder efh: references)
		{
			result.add(efh.getFeature());
		}
		return result;
	}
	
	//get all unused references including inherited ones
	public ArrayList<EStructuralFeature> getallUnusedReferences()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> allUsedReferences = getAllUsedReferences();
		for(EStructuralFeature esf: eClass.getEAllReferences())
		{
			if (!allUsedReferences.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
	
	//get all unused local references
	public ArrayList<EStructuralFeature> getUnusedReferences()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> allUsedReferences = getAllUsedReferences();
		for(EStructuralFeature esf: eClass.getEReferences())
		{
			if (!allUsedReferences.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
	
	//get all used local references
	public ArrayList<EStructuralFeature> getUsedReferences()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> allUsedReferences = getAllUsedReferences();
		for(EStructuralFeature esf: eClass.getEReferences())
		{
			if (allUsedReferences.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
	
	public ArrayList<EStructuralFeature> getAllFeatures()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		for(EStructuralFeatureHolder efh: attributes)
		{
			result.add(efh.getFeature());
		}
		for (EStructuralFeatureHolder efh: references) {
			result.add(efh.getFeature());
		}
		return result;
	}
	
	
	public ArrayList<EStructuralFeature> getAllUnusedFeatures()
	{
		ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		ArrayList<EStructuralFeature> usedFeatures = getAllFeatures();
		
		for(EStructuralFeature esf: eClass.getEAllStructuralFeatures())
		{
			if (!usedFeatures.contains(esf)) {
				result.add(esf);
			}
		}
		return result;
	}
}	
