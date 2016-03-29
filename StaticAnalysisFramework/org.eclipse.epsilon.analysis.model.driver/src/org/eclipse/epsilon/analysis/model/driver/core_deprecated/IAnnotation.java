package org.eclipse.epsilon.analysis.model.driver.core_deprecated;

import java.util.ArrayList;
import java.util.List;

public class IAnnotation {

	protected String source;
	protected List<IStringToStringMapEntry> details = new ArrayList<IStringToStringMapEntry>();
	
	protected IModelElement iModelElement;
	
	public IAnnotation(String source)
	{
		this.source = source;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public List<IStringToStringMapEntry> getDetails() {
		return details;
	}
	
	public void insertDetails(String key, String value)
	{
		details.add(new IStringToStringMapEntry(key, value));
	}
	
	public IModelElement getiModelElement() {
		return iModelElement;
	}
	
	public void setiModelElement(IModelElement iModelElement) {
		this.iModelElement = iModelElement;
	}
	
}
