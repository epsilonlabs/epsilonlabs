package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util;

public class NativeTypeInferenceManager {

	public Class<?> getClassByName(String name) throws ClassNotFoundException
	{
		return Class.forName(name);
	}
}
