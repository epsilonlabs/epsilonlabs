package org.eclipse.epsilon.emc.yed;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.lang.model.type.PrimitiveType;

import org.eclipse.epsilon.emc.yed.SlotPrototype;
import org.eclipse.epsilon.emc.yed.YedFactory;
import org.eclipse.ui.internal.preferences.PropertyListenerList;

public class ValuedSlotPrototypeLabelParser {
	
	protected SlotPrototype prototype;
	protected Object value;
	
	public static void main(String[] args) {
		new ValuedSlotPrototypeLabelParser("int[] x = 5").getPrototype();
	}
	
	public ValuedSlotPrototypeLabelParser(String label) {
		
		String prototypeLabel = "";
		String valueLabel = "";
		
		// Check if there is an = anywhere in the label
		// If there is, split into a prototype and a value label
		int eq = label.indexOf('=');
		
		if (eq > -1) {
			prototypeLabel = label.substring(0, eq).trim();
			valueLabel = label.substring(eq+1, label.length()).trim();
		}
		else {
			prototypeLabel = label;
			valueLabel = "";
		}
		
		Parser typeAndMultiplicityParser = new Parser("(\\S+?)\\s*\\[.*?\\]\\s+(\\S+)");
		Parser typeParser = new Parser("(\\S+?)\\s+(\\S+)");
		
		String name = "";
		String typeLabel = null;
		boolean many = false;
		
		if (typeAndMultiplicityParser.matches(prototypeLabel)) {
			many = true;
			name = typeAndMultiplicityParser.getGroups().get(1);
			typeLabel = typeAndMultiplicityParser.getGroups().get(0);
		} else if (typeParser.matches(prototypeLabel)) {
			name = typeParser.getGroups().get(1);
			typeLabel = typeParser.getGroups().get(0);
		}
		else {
			name = prototypeLabel;
		}
				
		prototype = YedFactory.eINSTANCE.createSlotPrototype();
		prototype.setName(name);
		prototype.setMany(many);
		
		if (typeLabel != null) {
			if (typeLabel.equals("Integer")) prototype.setType(PrimitiveTypes.getIntegerType());
			else if (typeLabel.equals("Boolean")) prototype.setType(PrimitiveTypes.getBooleanType());
			else if (typeLabel.equals("Real")) prototype.setType(PrimitiveTypes.getRealType());
			else prototype.setType(PrimitiveTypes.getStringType());
		}
		
		value = valueLabel;
		
	}
	
	public SlotPrototype getPrototype() {
		return prototype;
	}
	
	public Object getValue() {
		return value;
	}
	
}
