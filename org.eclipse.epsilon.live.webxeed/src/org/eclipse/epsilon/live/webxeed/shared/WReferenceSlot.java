package org.eclipse.epsilon.live.webxeed.shared;

import java.util.ArrayList;
import java.util.List;

public class WReferenceSlot extends WSlot{
	
	protected boolean containment = false;
	protected List<WObject> values = new ArrayList<WObject>();
	
	public List<WObject> getValues() {
		return values;
	}
	
	public void setValues(List<WObject> values) {
		this.values = values;
	}
	
	public boolean isContainment() {
		return containment;
	}
	
	public void setContainment(boolean containment) {
		this.containment = containment;
	}
	
}
