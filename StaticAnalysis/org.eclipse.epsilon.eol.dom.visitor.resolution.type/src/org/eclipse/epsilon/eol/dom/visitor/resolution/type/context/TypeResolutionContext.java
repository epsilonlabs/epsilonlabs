package org.eclipse.epsilon.eol.dom.visitor.resolution.type.context;

import java.util.ArrayList;
import java.util.HashMap;

import log.LogBook;
import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.EolFactory;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.OperationDefinitionControl;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.UserDefinedOperationDefinitionContainer;


public class TypeResolutionContext {
	
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
	
	//namespace for metamodel
	protected ArrayList<String> metaModelNameSpace = new ArrayList<String>();
	
	//operation definition container used to store user defined operations
	protected OperationDefinitionControl operationDefinitionControl = new OperationDefinitionControl(this);
	
	public static void main(String[] args) {
		TypeResolutionContext context = new TypeResolutionContext();
		Type type1 = context.getEolFactory().createType();
		Type type2 = context.getEolFactory().createIntegerType();
		
		System.out.println(context.getTypeUtil().isEqualOrGeneric(type2, type1));	
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
	public void inputMetaModel(EMetaModel metaModel)
	{
		metaModelNameSpace.add(metaModel.getMetaModelName());
		metaModelNameSpace.add(metaModel.getName());
		container.inputMetaModel(metaModel);
	}
			
	public EMetaModel getMetaModel(String name)
	{
		return container.getMetaModel(name);
	}
	
	public ArrayList<EMetaModel> getMetaModelsWithAlias(String alias)
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
	
	public void setAssets(DomElement obj, DomElement container)
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
		for(EMetaModel em: container.getMetaModels())
		{
			if(em.containsMetaClass(metaClass))
			{
				return true;
			}
		}
		return false;
	}
		
	public EMetaModel getMetaModelDefiningMetaClass(String metaClass)
	{
		for(EMetaModel em: container.getMetaModels())
		{
			if (em.containsMetaClass(metaClass)) {
				return em;
			}
		}
		return null;
	}
	
	public boolean containsMetaModel(String metaModel)
	{
		return metaModelNameSpace.contains(metaModel);
	}
	
	public int numberOfMetamodelsDefine(String metaClass)
	{
		int result = 0;
		for(EMetaModel em: container.getMetaModels())
		{
			if(em.containsMetaClass(metaClass))
			{
				result ++;
			}
		}
		return result;
	}
	

	
	public void putOperationDefinition(OperationDefinition operation)
	{
		operationDefinitionControl.putOperationDefinition(operation);
	}
	

	

	
}
