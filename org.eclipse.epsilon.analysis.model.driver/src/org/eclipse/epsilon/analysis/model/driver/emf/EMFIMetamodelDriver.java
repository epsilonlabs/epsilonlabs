package org.eclipse.epsilon.analysis.model.driver.emf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.analysis.model.driver.util.EcoreFileLoader;
import org.eclipse.epsilon.analysis.model.driver.util.EcoreRegistryLoader;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IModel;
import org.eclipse.epsilon.eol.metamodel.IPackage;
import org.eclipse.epsilon.eol.metamodel.KeyValueExpression;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_IMetamodelDriver;

public class EMFIMetamodelDriver implements IMetamodelDriver{

	protected HashMap<String, EMFIPackageDriver> packages = new HashMap<String, EMFIPackageDriver>();
	protected String name;
	protected HashSet<String> aliases = new HashSet<String>();
	protected ModelDeclarationStatement modelDeclarationStatement = null;
	protected LogBook logBook = null;
	protected IModel iModel = null;
	
	@Override
	public boolean loadModel(String pathOrNSURI) {
		ArrayList<EPackage> result = new ArrayList<EPackage>();
		
		result.addAll(EcoreRegistryLoader.loadEPackageFromRegistry(pathOrNSURI));

		if (result.size() > 0) {
			for(EPackage ePackage: result)
			{
				packages.put(ePackage.getName(), new EMFIPackageDriver(ePackage));
			}
			reconcileEolLibraryModule();
			return true;
		}
		else {
			result.addAll(EcoreFileLoader.loadEPackageFromFile(pathOrNSURI));
			if (result.size() > 0) {
				for(EPackage ePackage: result)
				{
					packages.put(ePackage.getName(), new EMFIPackageDriver(ePackage));
				}
				reconcileEolLibraryModule();
				return true;
			}
			else {
				logBook.addError(modelDeclarationStatement, IMessage_IMetamodelDriver.UNABLE_TO_LOAD_METAMODEL);
				return false;
			}
		}
	}
		

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Set<String> getAliases() {
		return aliases;
	}

	@Override
	public void addAlias(String alias) {
		if (!aliases.add(alias)) {
			for(VariableDeclarationExpression var: modelDeclarationStatement.getAlias())
			{
				if (var.getName().getName().equals(alias)) {
					logBook.addWarning(var, IMessage_IMetamodelDriver.bindMessage(IMessage_IMetamodelDriver.DUPLICATE_ALIAS, var.getName().getName()));
				}
			}
		}
	}

	@Override
	public IPackageDriver getIPackageDriver(String packageName) {
		return packages.get(packageName);
	}

	@Override
	public boolean containsIPackage(String packageName) {
		return packages.containsKey(packageName);
	}

	@Override
	public LogBook getLogBook() {
		return logBook;
	}

	@Override
	public void setLogBook(LogBook logBook) {
		this.logBook = logBook;
	}

	@Override
	public ModelDeclarationStatement getModelDeclarationStatement() {
		return modelDeclarationStatement;
	}

	@Override
	public void setModelDeclarationStatement(
			ModelDeclarationStatement modelDeclarationStatement) {
		this.modelDeclarationStatement = modelDeclarationStatement;
	}

	@Override
	public void reconcileEolLibraryModule() {
		iModel = EolFactory.eINSTANCE.createIModel();
		iModel.setName(modelDeclarationStatement.getName().getName());
		iModel.setDriver(modelDeclarationStatement.getDriver());
		for(VariableDeclarationExpression alias: modelDeclarationStatement.getAlias())
		{
			iModel.getAliases().add(alias.getName());
		}
		
		for(String key: packages.keySet())
		{
			IPackage iPackage = EolFactory.eINSTANCE.createIPackage();
			EMFIPackageDriver emfiPackageDriver = packages.get(key);
			iPackage.setName(emfiPackageDriver.getPackageName());
			iPackage.setNsPrefix(emfiPackageDriver.getPackageNSPrefix());
			for(KeyValueExpression keyValue: modelDeclarationStatement.getParameters())
			{
				Expression _key = keyValue.getKey();
				if (_key instanceof NameExpression) {
					NameExpression __key = (NameExpression) _key;
					if (__key.getName().equals("nsURI")) {
						Expression _value = keyValue.getValue();
						StringExpression __value = (StringExpression) _value;
						iPackage.setNsURI(__value);
					}
				}
			}
			iPackage.setIPackageDriver(emfiPackageDriver);
			iModel.getIPackages().add(iPackage);
		}
		
		EOLElement tracer = modelDeclarationStatement;
		while(tracer != null && !(tracer instanceof EOLLibraryModule))
		{
			tracer = tracer.getContainer();
		}
		EOLLibraryModule module = (EOLLibraryModule) tracer;
		module.getIModels().add(iModel);
	}


	@Override
	public ArrayList<IPackageDriver> getIPackageDrivers() {
		ArrayList<IPackageDriver> result = new ArrayList<IPackageDriver>();
		result.addAll(packages.values());
		return result;
	}


	@Override
	public IModel getIModel() {
		return iModel;
	}

}