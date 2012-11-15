package org.eclipse.epsilon.live.webxeed.shared;

import java.util.ArrayList;
import java.util.List;

public class WAttributeSlot extends WSlot {
	
	protected List<String> values = new ArrayList<String>();
	
	public List<String> getValues() {
		return values;
	}
	
	public void setValues(List<String> values) {
		this.values = values;
	}
	
}
