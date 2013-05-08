package org.eclipse.epsilon.mgl.engine;

import org.eclipse.epsilon.eol.execute.context.EolContext;

public class MglContext extends EolContext {
	
	protected int instanceCount;
	
	public int getInstanceCount() {
		return instanceCount;
	}
	
	public void setInstanceCount(int instanceCount) {
		this.instanceCount = instanceCount;
	}
	
}
