package org.eclipse.epsilon.epl;

import java.util.HashMap;

public class PatternMatch {
	
	protected Pattern pattern;
	protected HashMap<String, Object> components = new HashMap<String, Object>();
	
	public PatternMatch(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public HashMap<String, Object> getComponents() {
		return components;
	}
	
	public Object getComponent(String name) {
		return getComponents().get(name);
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
}
