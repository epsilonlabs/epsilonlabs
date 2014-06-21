package org.eclipse.epsilon.eol.performance.analysis.context;

import java.util.ArrayList;
import java.util.HashMap;

import log.LogBook;
import metamodel.connectivity.emf.EMFMetamodelDriver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.MetamodelContainer;

public class PerformanceAnalysisContext {

		//logbook is used to store errors/warnings
		protected LogBook logBook = new LogBook();
			
		//eolFactory
		protected EolFactory eolFactory = new EolFactoryImpl();
		
		//type utility, methods are not declared static for performance concerns
		protected TypeUtil typeUtil = new TypeUtil(this);
		
		protected ArrayList<OperationDefinitionReference> operationsWithPerformancePotential = new ArrayList<OperationDefinitionReference>();
		
		//containers to hold meta models
		protected MetamodelContainer container = new MetamodelContainer();
		
		//contains model declarations
		protected HashMap<String, ModelDeclarationStatement> modelDeclarations = new HashMap<String, ModelDeclarationStatement>(); 
		
		//namespace for metamodel
		protected ArrayList<String> metaModelNameSpace = new ArrayList<String>();

		protected String directoryPathString;
		//return the logbook
		
		public void registerOperationWithPerformancePotential(OperationDefinition op, FOLMethodCallExpression folMethodCallExpression)
		{
			operationsWithPerformancePotential.add(new OperationDefinitionReference(op, folMethodCallExpression));
		}
		
		public ArrayList<OperationDefinitionReference> getOperationWithPerformancePotential()
		{
			return operationsWithPerformancePotential;
		}
		
		public String getDirectoryPathString() {
			return directoryPathString;
		}
		
		public void setDirectoryPathString(String directoryPathString) {
			this.directoryPathString = directoryPathString;
		}
		
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
				
		public HashMap<String, ModelDeclarationStatement> getModelDeclarations()
		{
			return modelDeclarations;
		}
		
		//put metamode in the metamode container
		public void inputMetaModel(EMFMetamodelDriver metaModel)
		{
			metaModelNameSpace.add(metaModel.getMetamodelName());
			metaModelNameSpace.add(metaModel.getMetamodelName());
			container.inputMetaModel(metaModel);
		}
				
		public EMFMetamodelDriver getMetaModel(String name)
		{
			return container.getMetaModel(name);
		}
		
		public ArrayList<EMFMetamodelDriver> getMetaModelsWithAlias(String alias)
		{
			return container.getMetaModelsWithAlias(alias);
		}
		

		
		public void putModelDeclarationStatement(String name, ModelDeclarationStatement modelDeclaration)
		{
			if (modelDeclarations.containsKey(name)) {
				System.err.println("model declaration name already in use");
			}
			else
			{
				modelDeclarations.put(name, modelDeclaration);	
			}
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
			for(EMFMetamodelDriver em: container.getMetaModels())
			{
				if(em.containsMetaClass(metaClass))
				{
					result ++;
				}
			}
			return result;
		}		

}
