package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

public class ModelContainer {

	protected String modelName;
	protected ArrayList<ModelElementContainer> modelElementsAllOfType = new ArrayList<ModelElementContainer>();
	protected ArrayList<ModelElementContainer> modelElementsAllOfKind = new ArrayList<ModelElementContainer>();
	
	public ModelContainer(String modelName)
	{
		this.modelName = modelName;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public ArrayList<ModelElementContainer> getModelElementsAllOfType() {
		return modelElementsAllOfType;
	}
	
	public ArrayList<ModelElementContainer> getModelElementsAllOfKind() {
		return modelElementsAllOfKind;
	}
	
	public void addToModelElementsAllOfType(String modelElement)
	{
		if (!modelElementsAllOfTypeContains(modelElement)) {
			modelElementsAllOfType.add(new ModelElementContainer(modelElement));
		}
	}
	
	public void addToModelElementsAllOfKind(String modelElement)
	{
		if (!modelElementsAllOfKindContains(modelElement)) {
			modelElementsAllOfKind.add(new ModelElementContainer(modelElement));
		}
	}
	
	public void addAttributeToModelElement(String elementName, String attribute)
	{
		ModelElementContainer mec = getFromModelElementsAllOfKind(elementName);
		if (mec != null) {
			mec.addToAttributes(attribute);
		}
		mec = getFromModelElementsAllOfType(elementName);
		if (mec != null) {
			mec.addToAttributes(attribute);
		}
	}
	
	public void addReferenceToModelElement(String elementName, String reference)
	{
		ModelElementContainer mec = getFromModelElementsAllOfKind(elementName);
		if (mec != null) {
			mec.addToReferences(reference);
		}
		mec = getFromModelElementsAllOfType(elementName);
		if (mec != null) {
			mec.addToReferences(reference);
		}
	}
	
	
	public ModelElementContainer getFromModelElementsAllOfType(String elementName)
	{
		for(ModelElementContainer mec: modelElementsAllOfType)
		{
			if (mec.getElementName().equals(elementName)) {
				return mec;
			}
		}
		return null;
	}
	
	public ModelElementContainer getFromModelElementsAllOfKind(String elementName)
	{
		for(ModelElementContainer mec: modelElementsAllOfKind)
		{
			if (mec.getElementName().equals(elementName)) {
				return mec;
			}
		}
		return null;
	}
	
	public boolean modelElementsAllOfTypeContains(String modelElement)
	{
		for(ModelElementContainer mec: modelElementsAllOfType)
		{
			if (mec.getElementName().equals(modelElement)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean modelElementsAllOfKindContains(String modelElement)
	{
		for(ModelElementContainer mec: modelElementsAllOfKind)
		{
			if (mec.getElementName().equals(modelElement)) {
				return true;
			}
		}
		return false;
	}

}
