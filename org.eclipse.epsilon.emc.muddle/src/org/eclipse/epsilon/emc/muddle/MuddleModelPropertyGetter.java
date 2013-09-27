package org.eclipse.epsilon.emc.muddle;

import org.eclipse.epsilon.emc.muddle.BooleanType;
import org.eclipse.epsilon.emc.muddle.Feature;
import org.eclipse.epsilon.emc.muddle.IntegerType;
import org.eclipse.epsilon.emc.muddle.MuddleElement;
import org.eclipse.epsilon.emc.muddle.MuddleFactory;
import org.eclipse.epsilon.emc.muddle.RealType;
import org.eclipse.epsilon.emc.muddle.Slot;
import org.eclipse.epsilon.emc.muddle.StringType;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class MuddleModelPropertyGetter extends AbstractPropertyGetter {

	@Override
	public Object invoke(Object o, String property) throws EolRuntimeException {
		
		MuddleElement element = (MuddleElement) o;
		
		Feature feature = getFeature(element, property);
		if (feature == null) throw new EolIllegalPropertyException(element, property, ast, context);
		
		Slot slot = getSlot(element, feature);
		if (slot == null) {
			slot = MuddleFactory.eINSTANCE.createSlot();
			slot.setFeature(feature);
			element.getSlots().add(slot);
		}
		
		if (feature.isMany()) {
			return slot.getValues();
		}
		else {
			if (slot.getValues().size() > 0) {
				return slot.getValues().get(0);
			}
			else {
				return getDefaultSlotValue(feature);
			}
		}
	}
	
	protected Object getDefaultSlotValue(Feature feature) {
		if (feature.getType() instanceof IntegerType) return 0;
		else if (feature.getType() instanceof StringType) return "";
		else if (feature.getType() instanceof RealType) return 0.0d;
		else if (feature.getType() instanceof BooleanType) return false;
		else return null;
	}
	
	protected Slot getSlot(MuddleElement element, Feature feature) {
		for (Slot slot : element.getSlots()) {
			if (slot.getFeature() == feature) {
				return slot;
			}
		}
		return null;
	}
	
	protected Feature getFeature(MuddleElement element, String property) {
		
		for (Feature feature : element.getType().getFeatures()) {
			if (feature.getName().equals(property)) {
				return feature;
			}
		}
		
		return null;
		
	}
	
}
