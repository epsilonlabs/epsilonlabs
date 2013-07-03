package org.eclipse.epsilon.emc.graphml;

import org.eclipse.epsilon.emc.graphml.BooleanType;
import org.eclipse.epsilon.emc.graphml.IntegerType;
import org.eclipse.epsilon.emc.graphml.RealType;
import org.eclipse.epsilon.emc.graphml.StringType;
import org.eclipse.epsilon.emc.graphml.GraphmlFactory;

public class PrimitiveTypes {
	
	protected static IntegerType integerType = GraphmlFactory.eINSTANCE.createIntegerType();
	protected static StringType stringType = GraphmlFactory.eINSTANCE.createStringType();
	protected static BooleanType booleanType = GraphmlFactory.eINSTANCE.createBooleanType();
	protected static RealType realType = GraphmlFactory.eINSTANCE.createRealType();
	
	public static IntegerType getIntegerType() {
		return integerType;
	}
	
	public static StringType getStringType() {
		return stringType;
	}
	
	public static BooleanType getBooleanType() {
		return booleanType;
	}
	
	public static RealType getRealType() {
		return realType;
	}
}
