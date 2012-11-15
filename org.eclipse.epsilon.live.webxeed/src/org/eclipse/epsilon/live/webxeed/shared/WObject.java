package org.eclipse.epsilon.live.webxeed.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WObject implements Serializable {
	
	protected ArrayList<WSlot> slots = new ArrayList<WSlot>();
	protected String title;
	protected String typeName;
	
	public ArrayList<WSlot> getSlots() {
		return slots;
	}
	
	public void setSlots(ArrayList<WSlot> slots) {
		this.slots = slots;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
