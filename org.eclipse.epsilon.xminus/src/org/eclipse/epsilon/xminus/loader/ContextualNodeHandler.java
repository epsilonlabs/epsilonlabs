package org.eclipse.epsilon.xminus.loader;


public abstract class ContextualNodeHandler implements NodeHandler {
	
	protected XminusResourceLoader context = null;
	
	public XminusResourceLoader getContext() {
		return context;
	}
	
	public void setContext(XminusResourceLoader context) {
		this.context = context;
	}
	
}
