package org.eclipse.epsilon.epl;

import java.util.HashMap;

public class PatternMatch {
	
	protected Pattern pattern;
	HashMap<String, Object> properties = new HashMap<String, Object>();
	
	public PatternMatch(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public void put(String component, Object value) {
		properties.put(component, value);
	}
	
	public Object get(String component) {
		return properties.get(component);
	}
	
	public HashMap<String, Object> getProperties() {
		return properties;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
}
