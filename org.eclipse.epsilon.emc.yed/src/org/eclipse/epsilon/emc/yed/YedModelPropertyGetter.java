package org.eclipse.epsilon.emc.yed;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class YedModelPropertyGetter extends AbstractPropertyGetter {

	@Override
	public Object invoke(Object o, String property) throws EolRuntimeException {
		
		Node node = (Node) o;
		
		SlotPrototype prototype = getSlotPrototype(node, property);
		if (prototype == null) throw new EolIllegalPropertyException(node, property, ast, context);
		
		Slot slot = getSlot(node, prototype);
		if (slot == null) {
			slot = YedFactory.eINSTANCE.createSlot();
			slot.setPrototype(prototype);
			node.getSlots().add(slot);
		}
		
		if (prototype.isMany()) {
			return slot.getValues();
		}
		else {
			if (slot.getValues().size() > 0) {
				return slot.getValues().get(0);
			}
			else {
				return getDefaultSlotValue(prototype);
			}
		}
	}
	
	protected Object getDefaultSlotValue(SlotPrototype prototype) {
		if (prototype.getType() instanceof IntegerType) return 0;
		else if (prototype.getType() instanceof StringType) return "";
		else if (prototype.getType() instanceof RealType) return 0.0d;
		else if (prototype.getType() instanceof BooleanType) return false;
		else return null;
	}
	
	protected Slot getSlot(Node node, SlotPrototype prototype) {
		for (Slot slot : node.getSlots()) {
			if (slot.getPrototype() == prototype) {
				return slot;
			}
		}
		return null;
	}
	
	protected SlotPrototype getSlotPrototype(Node node, String property) {
		
		for (SlotPrototype prototype : node.getType().getSlotPrototypes()) {
			if (prototype.getName().equals(property)) {
				return prototype;
			}
		}
		
		return null;
		
	}
	
}
