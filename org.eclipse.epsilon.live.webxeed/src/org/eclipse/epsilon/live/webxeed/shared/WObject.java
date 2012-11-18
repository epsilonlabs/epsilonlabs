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
	protected int id = 0;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
		if (referenceLabel != null) {
			return referenceLabel;
		}
		else return getLabel();
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
