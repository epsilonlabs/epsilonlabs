package org.eclipse.epsilon.xminus.handlers;


public abstract class ContextualNodeHandler implements NodeHandler {
	
	protected XminusContext context = null;
	
	public XminusContext getContext() {
		return context;
	}
	
	public void setContext(XminusContext context) {
		this.context = context;
	}
	
}
