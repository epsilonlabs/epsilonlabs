package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{
	
	
	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>();
	
	
	public void addToModel(String modelName, String elementName)
	{
		ModelContainer container = getModelContainer(modelName);
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

}
