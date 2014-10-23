package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{

	
	protected ArrayList<String> modelElementTypeToLoad = new ArrayList<String>();


	public ArrayList<String> getModelElementTypeToLoad() {
		return modelElementTypeToLoad;
	}
	
	public void addToModelElementTypeToLoad(String modelElementType)
	{
		if (!modelElementTypeToLoad.contains(modelElementTypeToLoad)) {
			modelElementTypeToLoad.add(modelElementType);
		}
	}
	
}
