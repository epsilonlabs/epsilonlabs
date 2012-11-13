package org.eclipse.epsilon.live.webxeed.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WObject implements Serializable {
	
	protected ArrayList<WObject> contents = new ArrayList<WObject>();
	protected String title;
	
	public ArrayList<WObject> getContents() {
		return contents;
	}
	
	public void setContents(ArrayList<WObject> contents) {
		this.contents = contents;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
