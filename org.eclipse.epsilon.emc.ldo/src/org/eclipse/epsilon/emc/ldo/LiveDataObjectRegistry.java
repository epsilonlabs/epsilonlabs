package org.eclipse.epsilon.emc.ldo;

import java.util.WeakHashMap;

public class LiveDataObjectRegistry {
	
	public static LiveDataObjectRegistry INSTANCE = new LiveDataObjectRegistry();
	protected WeakHashMap<LiveDataObject, String> registered = new WeakHashMap<LiveDataObject, String>();
	
	public void register(LiveDataObject o) {
		registered.put(o, "");
	}
	
	public int getRegisteredCount() {
		return registered.size();
	}
	
	public void gc() {
		System.gc();
	}
}
