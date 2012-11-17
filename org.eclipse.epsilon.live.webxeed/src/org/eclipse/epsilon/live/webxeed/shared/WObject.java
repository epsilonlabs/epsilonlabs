package org.eclipse.epsilon.live.webxeed.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WObject implements Serializable {
	
	protected ArrayList<WSlot> slots = new ArrayList<WSlot>();
	protected String label;
	protected String icon;
	protected String referenceLabel;
	protected String typeName;
	
	public ArrayList<WSlot> getSlots() {
		return slots;
	}
	
	public void setSlots(ArrayList<WSlot> slots) {
		this.slots = slots;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getReferenceLabel() {
		return referenceLabel;
	}
	
	public void setReferenceLabel(String referenceLabel) {
		this.referenceLabel = referenceLabel;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return getLabel()+"";
	}
	
}
