package org.eclipse.epsilon.eol.problem.imessages;

public class IMessage_IMetamodelDriver {

	public static final String UNABLE_TO_LOAD_METAMODEL = "Unable to load metamodel";
	
	public static String bindMessage(String message, Object value)
	{
		String result = String.format(message, value.toString());
		return result;
	}
}
