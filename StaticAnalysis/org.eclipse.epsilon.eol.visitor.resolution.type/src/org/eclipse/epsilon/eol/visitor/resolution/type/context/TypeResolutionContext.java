package org.eclipse.epsilon.eol.visitor.resolution.type.context;

import java.util.ArrayList;
import java.util.HashMap;

import log.LogBook;
import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLModel;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.OperationDefinitionControl;
import org.eclipse.epsilon.eol.visitor.resolution.type.util.TypeUtil;


public class TypeResolutionContext {
	
	protected boolean pessimistic = false;
	
	//logbook is used to store errors/warnings
	protected LogBook logBook = new LogBook();
		
	//eolFactory
	protected EolFactory eolFactory = new EolFactoryImpl();
	
	//type utility, methods are not declared static for performance concerns
	protected TypeUtil typeUtil = new TypeUtil(this);
	
	//containers to hold meta models
	protected MetamodelContainer container = new MetamodelContainer(this);
	
	//contains model declarations
	protected HashMap<String, ModelDeclarationStatement> modelDeclarations = new HashMap<String, ModelDeclarationStatement>(); 
	
	//namespace for metamodel
	protected ArrayList<String> metaModelNameSpace = new ArrayList<String>();
	
	//operation definition container used to store user defined operations
	protected OperationDefinitionControl operationDefinitionControl = new OperationDefinitionControl(this);
	
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
	public void inputMetaModel(EMFMetamodelDriver metaModel)
	{
		metaModelNameSpace.add(metaModel.getMetamodelName());
		container.inputMetaModel(metaModel);
	}
			
	public EMFMetamodelDriver getMetaModel(String name)
	{
		return container.getMetaModel(name);
	}
	
	public EMFMetamodelDriver getMetaModelWithNSURI(String nsURI)
	{
		return container.getMetaModelWithURI(nsURI);
	}
	
	public ArrayList<EMFMetamodelDriver> getMetaModelsWithAlias(String alias)
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
		obj.setContainer(container);
	}
	
	public boolean isEnum(EObject obj)
	{
		boolean result = false;
		EcorePackage ePack = EcorePackage.eINSTANCE;
		if (obj.equals(ePack.getEEnum())) {
			result = true;
		}
		return result;
	}
	
	public boolean containsMetaClass(String metaClass)
	{
		for(EMFMetamodelDriver em: container.getMetaModels())
		{
			if(em.containsMetaClass(metaClass))
			{
				return true;
			}
		}
		return false;
	}
		
	public EMFMetamodelDriver getMetaModelDefiningMetaClass(String metaClass)
	{
		for(EMFMetamodelDriver em: container.getMetaModels())
		{
			if ((!(em instanceof PlainXMLModel)) && em.containsMetaClass(metaClass)) {
				return em;
			}
		}
		return null;
	}
	
	public boolean containsMetaModel(String metaModel)
	{
		return metaModelNameSpace.contains(metaModel);
	}
	
	public int numberOfMetamodelsDefine(String metaClass, boolean includeXMLModels)
	{
		int result = 0;
		for(EMFMetamodelDriver em: container.getMetaModels())
		{
			if (includeXMLModels) {
				if (em.containsMetaClass(metaClass)) {
					result++;
				}
			}
			else {
				if((!(em instanceof PlainXMLModel)) && em.containsMetaClass(metaClass))
				{
					result ++;
				}
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
	
	public int getNumberofPlainXMLModels()
	{
		int result = 0;
		for(EMFMetamodelDriver em: container.getMetaModels())
		{
			if (em instanceof PlainXMLModel) {
				result++;
			}
		}
		return result;
	}
	
	public PlainXMLModel getOneXMLModel()
	{
		for(EMFMetamodelDriver em: container.getMetaModels())
		{
			if (em instanceof PlainXMLModel) {
				return (PlainXMLModel) em;
			}
		}
		return null;
	}

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
		if (fullName.startsWith("a_") || fullName.startsWith("b_") ||
				fullName.startsWith("i_") || fullName.startsWith("f_") || 
				fullName.startsWith("d_") || fullName.startsWith("s_") ||
				fullName.startsWith("t_") || fullName.startsWith("c_") ||
				fullName.startsWith("e_") || fullName.startsWith("x_"))
		{
			return true;
		}
		else {
			return false;
		}
	}

	public void setLocation(EolElement created, EolElement targetLocation)
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

}
