package org.eclipse.epsilon.emc.htmlunit.objectbag;


public class DefaultNameEncoder implements INameEncoder {

	@Override
	public boolean canDecode(String shortName) {
		return true;
	}

	@Override
	public boolean canEncode(String longName) {
		return true;
	}

	@Override
	public String decode(String shortName) {
		return shortName;
	}

	@Override
	public String encode(String longName) {
		return longName;
	}

}
