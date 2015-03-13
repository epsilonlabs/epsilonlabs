package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{
	
	
	protected ArrayList<EffectiveMetamodel> modelContainers = new ArrayList<EffectiveMetamodel>();
	
	public void addToModel(String modelName)
	{
		EffectiveMetamodel container = getModelContainer(modelName);
		if (container == null) {
			container = new EffectiveMetamodel(modelName);
			modelContainers.add(container);
		}
	}
	
	public void addToModelAllOfType(String modelName, String elementName)
	{
		EffectiveMetamodel container = getModelContainer(modelName);
		if (container != null) {
			container.addToAllOfType(elementName);
		}
		else {
			container = new EffectiveMetamodel(modelName);
			container.addToAllOfType(elementName);
			modelContainers.add(container);
		}
	}
	
	public void addToModelAllOfKind(String modelName, String elementName)
	{
		EffectiveMetamodel container = getModelContainer(modelName);
		if (container != null) {
			container.addToAllOfKind(elementName);
		}
		else {
			container = new EffectiveMetamodel(modelName);
			container.addToAllOfKind(elementName);
			modelContainers.add(container);
		}
	}
	
	public EffectiveMetamodel getModelContainer(String modelName)
	{
		for(EffectiveMetamodel mc: modelContainers)
		{
			if (mc.getName().equals(modelName)) {
				return mc;
			}
		}
		return null;
	}

	public ArrayList<EffectiveMetamodel> getModelContainers() {
		return modelContainers;
	}

	public void print()
	{
		for(EffectiveMetamodel mc: modelContainers)
		{
			System.out.println("Model: " + mc.getName());
			for(EffectiveType mec: mc.getAllOfType())
			{
				System.out.println("	AllOfType: " +mec.getName());
				for(String attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr);
				}
				for(String ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref);
				}
			}
			for(EffectiveType mec: mc.getAllOfKind())
			{
				System.out.println("	AllOfKind: " +mec.getName());
				for(String attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr);
				}
				for(String ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref);
				}
			}
		}
	}
}
