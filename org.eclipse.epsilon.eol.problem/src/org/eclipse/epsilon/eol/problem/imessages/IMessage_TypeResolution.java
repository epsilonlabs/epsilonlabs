package org.eclipse.epsilon.eol.problem.imessages;

public class IMessage_TypeResolution {

	public static final String TYPE_NOT_INSTANTIABLE = "Type %s is not instantiable";
	
	public static final String MODEL_DECL_NO_MODEL_DECLARED = "No metamodel has been declared, please declare a metamodel first";

	public static final String MODEL_DECL_NSURI_OR_PATH_REQUIRED = "nsURI or path is required to access metamodel";
	
	public static final String MODEL_DECL_NO_NAME = "Model Declaration MUST have a name";
	public static final String MODEL_DECL_NO_DRIVER = "Model Declaration MUST have a driver";
	public static final String MODEL_DECL_DRIVER_NOT_SUPPORTED = "Model driver %s is not supported";
	
	public static final String TYPE_CANNOT_BE_RESOLVED = "%s cannot be resolved to a type";
	
	public static final String INVALID_XML_TYPE_NOTATION = "prefix %s cannot be used to denote an XML type";
	
	public static final String MODEL_NOT_FOUND = "Metamodel named %s cannot be found";
	
	public static final String MODEL_ELEMENT_DEFINED_IN_MULTIPLE_METAMODELS = "Model element %s is defined in more than one metamodels";
	
	public static final String ELEMENT_TYPE_CANNOT_BE_NULL = "Element type cannot be null";
	
	public static final String EXPRESSION_DOES_NOT_HAVE_A_TYPE = "Expression does not have a type";
	public static final String EXPRESSION_NOT_BOOLEAN_TYPE = "Expression is not of type Boolean";
	public static final String EXPRESSION_NOT_NUMERAL = "Expression should be of either type Integer or type Real";
	public static final String EXPRESSION_EXPECTED_BOOLEAN = "Expected boolean type, actual type is: %s";
	public static final String EXPRESSION_EXPECTED_STRING = "Expected String type, actual type is: %s";
	
	public static final String EXPRESSION_CANNOT_BE_BOOLEAN = "Expression cannot be boolean";
	public static final String EXPRESSION_CANNOT_BE_STRING = "Expression cannot be String";
	
	public static final String RESOLVED_CONTENT_NOT_VAR = "resolved content is not a variable declaraion or a formal parameter epression";
	
	public static final String ENUM_CANNOT_BE_RESOLVED = "Enumeration cannot be resolved";
	public static final String ENUM_LITERAL_CANNOT_BE_RESLVED = "Enumeration literal cannot be resolved";
	public static final String ENUM_DUPLICATE = "Multiple enumerations found";
	
	public static final String FOR_STMT_CONDITION_NOT_COLLECTION_TYPE = "Expression should be of type Collection";
	
	public static final String COLLECTION_EXPRESSION_NO_CONTENT_TYPE = "Expression does not have a content type";
	
	
	public static final String RETURN_STATEMENT_NOT_IN_OP = "Return statement should be included in an operation/helper definition";
	
	public static String bindMessage(String message, Object value)
	{
		String result = String.format(message, value.toString());
		return result;
	}
}