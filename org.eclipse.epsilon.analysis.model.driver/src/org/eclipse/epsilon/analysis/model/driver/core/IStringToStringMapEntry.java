package org.eclipse.epsilon.analysis.model.driver.core;

public class IStringToStringMapEntry {

	protected String key;
	protected String value;
	
	public IStringToStringMapEntry(String key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
}
