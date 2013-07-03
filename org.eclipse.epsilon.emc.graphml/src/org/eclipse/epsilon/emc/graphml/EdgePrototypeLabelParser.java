package org.eclipse.epsilon.emc.graphml;

import org.eclipse.epsilon.emc.graphml.SlotPrototype;
import org.eclipse.epsilon.emc.graphml.GraphmlFactory;

public class EdgePrototypeLabelParser {
	
	protected SlotPrototype prototype;
	
	public EdgePrototypeLabelParser(String label) {
		Parser nameAndMultiplicityParser = new Parser("(\\S+?)\\s*\\*");
		prototype = GraphmlFactory.eINSTANCE.createSlotPrototype();
		
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
