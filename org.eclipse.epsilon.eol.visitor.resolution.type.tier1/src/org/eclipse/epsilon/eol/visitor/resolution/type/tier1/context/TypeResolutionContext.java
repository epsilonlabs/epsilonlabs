package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelManager;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class TypeResolutionContext {
	
	//instance
	protected static TypeResolutionContext instance = null;
	
	//supported drivers
	protected final String[] supportedDrivers = {"EMF", "XML"};
	
	//current program
	protected EOLLibraryModule currentProgram = null;
	
	//current eol element
//	protected EOLElement currentEOLElement = null;
	
	//imetamodel manager
	protected IMetamodelManager iMetamodelManager = new IMetamodelManager();
	
	//type registry
	protected TypeRegistry typeRegistry = new TypeRegistry();
	
	//expression to registry map
	protected HashMap<Expression, HashSet<Type>> expressionTypeRegistry = new HashMap<Expression, HashSet<Type>>();
	
	//metamodel related keywords
	protected ArrayList<String> metamodelRelatedKeywords = new ArrayList<String>();
	
	//current statement
	protected Statement currentStatement = null;
	
	//property call stacks
	protected Stack<String> propertyCallStack = new Stack<String>();
		
	public void setCurrentStatement(Statement currentStatement) {
		this.currentStatement = currentStatement;
	}
	
	public Statement getCurrentStatement() {
		return currentStatement;
	}
	
	public void clearPropertyCallStack()
	{
		propertyCallStack.clear();
	}
	
	public void pushPropertyToCall(String string)
	{
		propertyCallStack.push(string);
	}
	
	public String getProperty()
	{
		return propertyCallStack.pop();
	}
	
	
	protected TypeResolutionContext()
	{}
	
	public void generateKeyWordsFromModelDeclarations()
	{
		metamodelRelatedKeywords.addAll(iMetamodelManager.generateKeyWordsFromModelDeclarations());
	}
	
	public ArrayList<String> getMetamodelRelatedKeywords() {
		return metamodelRelatedKeywords;
	}
	
	public static TypeResolutionContext getInstanace()
	{
		if (instance == null) {
			instance = new TypeResolutionContext();
		}
		return instance;
	}
	
	public static TypeResolutionContext getInstance(boolean initialise)
	{
		if (initialise) {
			instance = new TypeResolutionContext();
			OperationDefinitionManager.getInstance(true);
			LogBook.getInstance();
			return instance;
		}
		else {
			return getInstanace();
		}
	}
	
	public TypeUtil getTypeUtil() {
		return TypeUtil.getInstance();
	}
	
	public LogBook getLogBook() {
		return LogBook.getInstance();
	}
	
	public void addIMetamodelDriver(IMetamodelDriver iMetamodelDriver)
	{
		iMetamodelManager.addIMetamodelDriver(iMetamodelDriver);
	}
	
	public String[] getSupportedDrivers() {
		return supportedDrivers;
	}
	public IMetamodelManager getiMetamodelManager() {
		return iMetamodelManager;
	}
	
	public OperationDefinitionManager getOperationDefinitionManager() {
		return OperationDefinitionManager.getInstance();
	}
	
	public void copyLocation(EOLElement created, EOLElement targetLocation)
	{
		created.setRegion(EcoreUtil.copy(targetLocation.getRegion()));
	}
	
	public void setAssets(EOLElement obj, EOLElement container)
	{
		obj.setRegion(EcoreUtil.copy(container.getRegion()));
		obj.setContainer(container);
	}
	
	public TypeRegistry getTypeRegistry() {
		return typeRegistry;
	}
	
	public void registerExpressionWithTypes(Expression expression, HashSet<Type> types)
	{
		expressionTypeRegistry.put(expression, types);
	}
	
	public HashSet<Type> getTypesOfExpression(Expression expression)
	{
		return expressionTypeRegistry.get(expression);
	}
	
}
