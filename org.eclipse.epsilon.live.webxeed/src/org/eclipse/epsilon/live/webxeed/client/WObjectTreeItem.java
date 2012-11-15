package org.eclipse.epsilon.live.webxeed.client;

import org.eclipse.epsilon.live.webxeed.shared.WObject;

import com.google.gwt.user.client.ui.TreeItem;

public class WObjectTreeItem extends TreeItem {
	
	protected WObject wObject = null;
	
	public WObject getWObject() {
		return wObject;
	}
	
	public void setWObject(WObject wObject) {
		this.wObject = wObject;
	}
	
}
