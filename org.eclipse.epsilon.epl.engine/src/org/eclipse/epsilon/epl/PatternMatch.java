package org.eclipse.epsilon.epl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.execute.context.Variable;

public class PatternMatch {
	
	protected Pattern pattern;
	protected ArrayList<Variable> components = new ArrayList<Variable>();
	
	public PatternMatch(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public ArrayList<Variable> getComponents() {
		return components;
	}
	
	public Variable getComponent(String name) {
		for (Variable component : components) {
			if (component.getName().equals(name)) {
				return component;
			}
		}
		return null;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
}
