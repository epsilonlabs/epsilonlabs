package org.eclipse.epsilon.emc.htmlunit;

import org.eclipse.epsilon.emc.htmlunit.objectbag.INameEncoder;

public class HtmlUnitClassNameEncoder implements INameEncoder {

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
		if (shortName.startsWith("Html")) {
			return shortName;
		}
		else {
			return "Html" + shortName;
		}
	}

	@Override
	public String encode(String longName) {
		if (longName.startsWith("Html")) {
			return longName.substring(4);
		}
		else {
			return longName;
		}
	}
	
}
