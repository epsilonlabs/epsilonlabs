package org.eclipse.epsilon.live.webxeed.shared;

import java.io.Serializable;
import java.util.List;

public abstract class WSlot implements Serializable {
	
	protected String name;
	protected boolean many;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isMany() {
		return many;
	}
	
	public void setMany(boolean many) {
		this.many = many;
	}
	
	public abstract List<?> getValues();
	
}
