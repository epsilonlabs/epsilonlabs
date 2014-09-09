package org.eclipse.epsilon.eol.visitor.resolution.type.context;

import java.util.ArrayList;
import java.util.HashMap;

import log.LogBook;
import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLMetamodelDriver;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.OperationDefinitionControl;
import org.eclipse.epsilon.eol.visitor.resolution.type.pessimistic.FrameStack;
import org.eclipse.epsilon.eol.visitor.resolution.type.util.TypeUtil;


public class TypeResolutionContext {
	
	//the frameStack
	protected FrameStack stack = new FrameStack();
	
	/*
	 * the 'main' program, is the program that is at the focus of the current E*L editor
	 * this is used to distinguish between the program in question and the parsed programs which are imported by the 'import' statement
	 */
	protected EolLibraryModule mainProgram = null;
	
	//pessimistic switch
	protected boolean pessimistic = true;
	
	//logbook is used to store errors/warnings
	protected LogBook logBook = new LogBook();
		
	//eolFactory
	protected EolFactory eolFactory = new EolFactoryImpl();
	
	//type utility, methods are not declared static for performance concerns
	protected TypeUtil typeUtil = new TypeUtil(this);
	
	//containers to hold meta models
	protected MetamodelContainer container = new MetamodelContainer();
	
	//contains model declarations
	protected HashMap<String, ModelDeclarationStatement> modelDeclarations = new HashMap<String, ModelDeclarationStatement>(); 
	
	//operation definition container used to store user defined operations
	protected OperationDefinitionControl operationDefinitionControl = new OperationDefinitionControl(this);
	
	//the path string of the program in question
	protected String directoryPathString;
	
	
	protected ArrayList<VariableDeclarationExpression> bestGuessVariableDeclarations = new ArrayList<VariableDeclarationExpression>();
	
	public ArrayList<VariableDeclarationExpression> getBestGuessVariableDeclarations() {
		return bestGuessVariableDeclarations;
	}
	
	public void addBestGuessVariableDeclaration(VariableDeclarationExpression var)
	{
		bestGuessVariableDeclarations.add(var);
	}
	
	public boolean containsBestGuessVariableDeclaration(VariableDeclarationExpression var)
	{
		for(VariableDeclarationExpression variable: bestGuessVariableDeclarations)
		{
			if (variable.equals(var)) {
				return true;
			}
		}
		return false;
	}
	
	public EolLibraryModule getMainProgram() {
		return mainProgram;
	}
	
	public void setMainProgram(EolLibraryModule mainProgram) {
		this.mainProgram = mainProgram;
	}
	
	public TypeResolutionContext()
	{
		
	}
	
	public TypeResolutionContext(boolean pessimistic)
	{
		this.pessimistic = pessimistic;
	}
	
	public static void main(String[] args) {
		TypeResolutionContext context = new TypeResolutionContext();
		Type type1 = context.getEolFactory().createModelElementType();
		Type type2 = context.getEolFactory().createAnyType();
		
		System.out.println(context.getTypeUtil().isEqualOrGeneric(type2, type1));	
	}
	
	public void setDirectoryPathString(String directoryPathString) {
		this.directoryPathString = directoryPathString;
	}
	
	public String getDirectoryPathString() {
		return directoryPathString;
	}
	
	//return the logbook
	public LogBook getLogBook()
	{
		return logBook;
	}
	
	//return the eolfactory
	public EolFactory getEolFactory()
	{
		return eolFactory;
	}
	
	public TypeUtil getTypeUtil()
	{
		return typeUtil;
	}
	
	public OperationDefinitionControl getOperationDefinitionControl()
	{
		return operationDefinitionControl;
	}
	
	public HashMap<String, ModelDeclarationStatement> getModelDeclarations()
	{
		return modelDeclarations;
	}
	
	//put metamode in the metamode container
	public String inputMetaModel(EMetamodelDriver metaModel)
	{
		//metaModelNameSpace.add(metaModel.getName());
		//metaModelNameSpace.add(metaModel.getMetamodelName());
		return container.inputMetaModel(metaModel);
	}
			
	public EMetamodelDriver getMetaModel(String name)
	{
		return container.getMetaModel(name);
	}
	
	public EMetamodelDriver getMetaModelWithNSURI(String nsURI)
	{
		return container.getMetaModelWithNSURI(nsURI);
	}
	
	public ArrayList<EMetamodelDriver> getMetaModelsWithAlias(String alias)
	{
		return container.getMetaModelsWithAlias(alias);
	}
	
	public void putModelDeclarationStatement(String name, ModelDeclarationStatement modelDeclaration)
	{
		if (modelDeclarations.containsKey(name)) {
			try {
				throw new Exception("model declaration name already in use");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		modelDeclarations.put(name, modelDeclaration);
	}
	
	public ModelDeclarationStatement getModelDeclarationStatement(String name)
	{
		return modelDeclarations.get(name);
	}
	
	public void setAssets(EolElement obj, EolElement container)
	{
		obj.setLine(container.getLine());
		obj.setColumn(container.getColumn());
		obj.setRegion(EcoreUtil.copy(container.getRegion()));
		obj.setContainer(container);
	}
		
	public boolean containsMetaClass(String metaClass)
	{
		for(EMetamodelDriver em: container.getMetaModels())
		{
			if(em.containsMetaClass(metaClass))
			{
				return true;
			}
		}
		return false;
	}
		
	public EMetamodelDriver getMetaModelDefiningMetaClass(String metaClass)
	{
		for(EMetamodelDriver em: container.getMetaModels())
		{
			if ((!(em instanceof PlainXMLMetamodelDriver)) && em.containsMetaClass(metaClass)) {
				return em;
			}
		}
		return null;
	}
	
	public boolean containsMetaModel(String metaModel)
	{
		return container.containsMetaModel(metaModel);
	}
		
	public int numberOfMetamodelsDefine(String metaClass, boolean includeXMLModels)
	{
		int result = 0;
		for(EMetamodelDriver em: container.getMetaModels())
		{
			if (includeXMLModels) {
				if (em.containsMetaClass(metaClass)) {
					result++;
				}
			}
			else {
				if((!(em instanceof PlainXMLMetamodelDriver)) && em.containsMetaClass(metaClass))
				{
					result ++;
				}
			}
		}
		return result;
	}
	
	public ArrayList<EMetamodelDriver> metamodelsDefine(String classString)
	{
		ArrayList<EMetamodelDriver> result = new ArrayList<EMetamodelDriver>();
		for(EMetamodelDriver em: container.getMetaModels())
		{
			if (em.containsMetaClass(classString)) {
				result.add(em);
			}
		}
		return result;
	}
	
	public void putOperationDefinition(OperationDefinition operation)
	{
		operationDefinitionControl.putOperationDefinition(operation);
	}
	
	public MetamodelContainer getContainer() {
		return container;
	}
	
	public int getNumberOfModelsOfType(String type)
	{
		int result = 0;
		if (type.equals("XML")) {
			for(EMetamodelDriver em: container.getMetaModels())
			{
				if (em instanceof PlainXMLMetamodelDriver) {
					result++;
				}
			}
			return result;
		}
		else if (type.equals("EMF")) {
			for(EMetamodelDriver em: container.getMetaModels())
			{
				if (em instanceof EMFMetamodelDriver) {
					result++;
				}
			}
			return result;
		}
		return result;
	}
	
	
//	public PlainXMLModel getOneXMLModel()
//	{
//		for(EMFMetamodelDriver em: container.getMetaModels())
//		{
//			if (em instanceof PlainXMLModel) {
//				return (PlainXMLModel) em;
//			}
//		}
//		return null;
//	}

	public void checkAndDisplayAnnotation(EModelElement element, EolElement dom)
	{
		if (element.getEAnnotations() != null && element.getEAnnotations().size() != 0) {
			for(EAnnotation anno: element.getEAnnotations())
			{
				if (anno.getDetails().get("warning") != null) {
					getLogBook().addWarning(dom, anno.getDetails().get("warning"));	
				}
				if (anno.getDetails().get("error") != null) {
					getLogBook().addError(dom, anno.getDetails().get("error"));	
				}
			}
		}
	}
	
	public boolean isXMLSyntax(String fullName)
	{
		return typeUtil.isXMLSyntax(fullName);
	}

	public void copyLocation(EolElement created, EolElement targetLocation)
	{
		created.setColumn(targetLocation.getColumn());
		created.setLine(targetLocation.getLine());
	}
	
	public boolean getPessimistic()
	{
		return pessimistic;
	}
	
	public void setPessimistic(boolean pessimistic) {
		this.pessimistic = pessimistic;
	}
	
	public FrameStack getStack() {
		return stack;
	}

}
