package org.eclipse.epsilon.emc.yed;

public class PrimitiveTypes {
	
	protected static IntegerType integerType = YedFactory.eINSTANCE.createIntegerType();
	protected static StringType stringType = YedFactory.eINSTANCE.createStringType();
	protected static BooleanType booleanType = YedFactory.eINSTANCE.createBooleanType();
	protected static RealType realType = YedFactory.eINSTANCE.createRealType();
	
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
