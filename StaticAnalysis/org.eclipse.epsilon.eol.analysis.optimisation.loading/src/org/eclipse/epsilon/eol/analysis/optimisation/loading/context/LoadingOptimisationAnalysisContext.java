package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{
	
	protected HashMap<String, EffectiveType> variableRegistry = new HashMap<String, EffectiveType>();
	protected ArrayList<EffectiveMetamodel> effectiveMetamodels = new ArrayList<EffectiveMetamodel>();
	
	protected AssignmentStatement currentAssignmentStatement = null;
	
	public AssignmentStatement getCurrentAssignmentStatement() {
		return currentAssignmentStatement;
	}
	
	public void setCurrentAssignmentStatement(
			AssignmentStatement currentAssignmentStatement) {
		this.currentAssignmentStatement = currentAssignmentStatement;
	}
	

	public EffectiveType getEffectiveTypeByVariableName(String variableName)
	{
		return variableRegistry.get(variableName);
	}
	
	public void registerEffectiveTypeWithVariableName(String variableName, EffectiveType effectiveType)
	{
		if (!variableRegistry.containsValue(effectiveType)) {
			variableRegistry.put(variableName, effectiveType);
		}
	}
	
	public void addEffectiveMetamodel(String modelName)
	{
		EffectiveMetamodel container = getEffectiveMetamodel(modelName);
		if (container == null) {
			container = new EffectiveMetamodel(modelName);
			effectiveMetamodels.add(container);
		}
	}
	
	public void addToEffectiveMetamodelAllOfType(String modelName, String elementName)
	{
		EffectiveMetamodel effectiveMetamodel = getEffectiveMetamodel(modelName);
		if (effectiveMetamodel != null) {
			effectiveMetamodel.addToAllOfType(elementName);
		}
		else {
			effectiveMetamodel = new EffectiveMetamodel(modelName);
			effectiveMetamodel.addToAllOfType(elementName);
			effectiveMetamodels.add(effectiveMetamodel);
		}
	}
	
	public void addToEffectiveMetamodelAllOfKind(String modelName, String elementName)
	{
		EffectiveMetamodel effectiveMetamodel = getEffectiveMetamodel(modelName);
		if (effectiveMetamodel != null) {
			effectiveMetamodel.addToAllOfKind(elementName);
		}
		else {
			effectiveMetamodel = new EffectiveMetamodel(modelName);
			effectiveMetamodel.addToAllOfKind(elementName);
			effectiveMetamodels.add(effectiveMetamodel);
		}
	}
	
	public EffectiveMetamodel getEffectiveMetamodel(String modelName)
	{
		for(EffectiveMetamodel mc: effectiveMetamodels)
		{
			if (mc.getName().equals(modelName)) {
				return mc;
			}
		}
		return null;
	}

	public ArrayList<EffectiveMetamodel> getEffectiveMetamodels() {
		return effectiveMetamodels;
	}
	
	public boolean isKeywordAllOfKind(String keyword)
	{
		if (keyword.equals("all") ||
				keyword.equals("allInstances") ||
				keyword.equals("allOfKind")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isKeywordAllOfType(String keyword)
	{
		if (keyword.equals("allOfType")) {
			return true;
		}
		else {
			return false;
		}
	}

	public void print()
	{
		for(EffectiveMetamodel mc: effectiveMetamodels)
		{
			System.out.println("Model: " + mc.getName());
			for(EffectiveType mec: mc.getAllOfType())
			{
				System.out.println("	AllOfType: " +mec.getName());
				for(EffectiveFeature attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr.getName() + " Usage: " + attr.getUsage());
				}
				for(EffectiveFeature ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref.getName() + " Usage: " + ref.getUsage());
				}
			}
			for(EffectiveType mec: mc.getAllOfKind())
			{
				System.out.println("	AllOfKind: " +mec.getName());
				for(EffectiveFeature attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr.getName() + " Usage: " + attr.getUsage());
				}
				for(EffectiveFeature ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref.getName() + " Usage: " + ref.getUsage());
				}
			}
		}
	}
}
