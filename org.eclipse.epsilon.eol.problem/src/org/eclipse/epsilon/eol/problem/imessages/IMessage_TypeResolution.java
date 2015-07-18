package org.eclipse.epsilon.eol.problem.imessages;

public class IMessage_TypeResolution {

	public static final String TYPE_NOT_INSTANTIABLE = "Type %s is not instantiable";
	
	public static final String MODEL_DECL_NO_MODEL_DECLARED = "No metamodel has been declared, please declare a metamodel first";

	public static final String MODEL_DECL_NSURI_OR_PATH_REQUIRED = "nsURI or path is required to access metamodel";
	
	public static final String MODEL_DECL_NO_NAME = "Model Declaration MUST have a name";
	public static final String MODEL_DECL_NO_DRIVER = "Model Declaration MUST have a driver";
	public static final String MODEL_DECL_DRIVER_NOT_SUPPORTED = "Model driver %s is not supported";
	
	
	public static String bindMessage(String message, Object value)
	{
		String result = String.format(message, value.toString());
		return result;
	}
}
