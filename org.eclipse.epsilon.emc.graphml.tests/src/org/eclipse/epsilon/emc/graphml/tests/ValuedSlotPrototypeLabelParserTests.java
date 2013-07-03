package org.eclipse.epsilon.emc.graphml.tests;

import static org.junit.Assert.*;

import org.eclipse.epsilon.emc.graphml.PrimitiveTypes;
import org.eclipse.epsilon.emc.graphml.SlotPrototype;
import org.eclipse.epsilon.emc.graphml.ValuedSlotPrototypeLabelParser;
import org.junit.Test;

public class ValuedSlotPrototypeLabelParserTests {
	
	public void testSimple() {
		SlotPrototype prototype = parse("foo");
		assertEquals("foo", prototype.getName());
		assertNull(prototype.getType());
		assertFalse(prototype.isMany());
	}
	
	public void testSimpleValue() {
		SlotPrototype prototype = parse("foo = 5");
		assertEquals("foo", prototype.getName());
		assertNull(prototype.getType());
		assertFalse(prototype.isMany());	
	}
	
	@Test
	public void testMutliplicityAndType() {
		SlotPrototype prototype = parse("Integer[] x = 5");
		assertEquals(PrimitiveTypes.getIntegerType(), prototype.getType());
		assertEquals("x", prototype.getName());
		assertTrue(prototype.isMany());
	}
	
	@Test
	public void testTypeOnly() {
		SlotPrototype prototype = parse("Integer x = 5");
		assertEquals(PrimitiveTypes.getIntegerType(), prototype.getType());
		assertEquals("x", prototype.getName());
		assertTrue(!prototype.isMany());
	}
	
	@Test
	public void testUnknownType() {
		SlotPrototype prototype = parse("Date foo = 12/3/2012");
		assertEquals(prototype.getType(), PrimitiveTypes.getStringType());
		assertEquals("foo", prototype.getName());
		assertEquals(false, prototype.isMany());
	}
	
	@Test
	public void testUnknownTypeAndMultiplicity() {
		SlotPrototype prototype = parse("Date[] foo = 12/3/2012");
		assertEquals(prototype.getType(), PrimitiveTypes.getStringType());
		assertEquals("foo", prototype.getName());
		assertEquals(true, prototype.isMany());
	}
	
	protected SlotPrototype parse(String s) {
		return new ValuedSlotPrototypeLabelParser(s).getPrototype();
	}
}
