package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

public class EffectiveFeature {

	protected String name;
	protected int usage;
	
	public EffectiveFeature(String name)
	{
		this.name = name;
		usage = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getUsage() {
		return usage;
	}
	
	public void increaseUsage()
	{
		usage++;
	}
}
