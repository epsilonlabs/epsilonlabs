package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{
	
	
	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>();
	
	
	public void addToModel(String modelName)
	{
		ModelContainer container = getModelContainer(modelName);
		if (container == null) {
			container = new ModelContainer(modelName);
			modelContainers.add(container);
		}
	}
	
	public void addToModelAllOfType(String modelName, String elementName)
	{
		ModelContainer container = getModelContainer(modelName);
		if (container != null) {
			container.addToModelElementsAllOfType(elementName);
		}
		else {
			container = new ModelContainer(modelName);
			container.addToModelElementsAllOfType(elementName);
			modelContainers.add(container);
		}
	}
	
	public void addToModelAllOfKind(String modelName, String elementName)
	{
		ModelContainer container = getModelContainer(modelName);
		if (container != null) {
			container.addToModelElementsAllOfKind(elementName);
		}
		else {
			container = new ModelContainer(modelName);
			container.addToModelElementsAllOfKind(elementName);
			modelContainers.add(container);
		}
	}
	
	public ModelContainer getModelContainer(String modelName)
	{
		for(ModelContainer mc: modelContainers)
		{
			if (mc.getModelName().equals(modelName)) {
				return mc;
			}
		}
		return null;
	}

	public ArrayList<ModelContainer> getModelContainers() {
		return modelContainers;
	}

	public void print()
	{
		for(ModelContainer mc: modelContainers)
		{
			System.out.println(mc.getModelName());
			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
			{
				System.out.println("	" +mec.getElementName());
				for(String attr: mec.getAttributes())
				{
					System.out.println("		" + attr);
				}
				for(String ref: mec.getReferences())
				{
					System.out.println("		" + ref);
				}
			}
			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
			{
				System.out.println("	" +mec.getElementName());
				for(String attr: mec.getAttributes())
				{
					System.out.println("		" + attr);
				}
				for(String ref: mec.getReferences())
				{
					System.out.println("		" + ref);
				}
			}
		}
	}
}
