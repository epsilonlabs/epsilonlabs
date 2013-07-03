package org.eclipse.epsilon.emc.yed;

public class EdgePrototypeLabelParser {
	
	protected SlotPrototype prototype;
	
	public EdgePrototypeLabelParser(String label) {
		Parser nameAndMultiplicityParser = new Parser("(\\S+?)\\s*\\*");
		prototype = YedFactory.eINSTANCE.createSlotPrototype();
		
		if (nameAndMultiplicityParser.matches(label)) {
			prototype.setMany(true);
			prototype.setName(nameAndMultiplicityParser.getGroups().get(0));
		}
		else {
			prototype.setName(label);
		}
	}
	
	public SlotPrototype getPrototype() {
		return prototype;
	}
}
