package org.eclipse.epsilon.emc.htmlunit.objectbag;

public interface INameEncoder {
	
	public String encode(String longName);
	
	public String decode(String shortName);
	
	public boolean canEncode(String longName);
	
	public boolean canDecode(String shortName);
	
}
