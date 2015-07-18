package org.eclipse.epsilon.analysis.model.driver.plainxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
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

public class PlainXMIIMetamodelDriver implements IMetamodelDriver{

	protected HashMap<String, PlainXMLIpackageDriver> packages = new HashMap<String, PlainXMLIpackageDriver>();
	protected String name;
	protected HashSet<String> aliases = new HashSet<String>();
	protected ModelDeclarationStatement modelDeclarationStatement = null;
	protected LogBook logBook = null;
	protected PlainXMLMetamodelDriverUtil util = new PlainXMLMetamodelDriverUtil();

	@Override
	public boolean loadModel(String URIorPath) {
		ArrayList<XML2EcoreTranslator> result = new ArrayList<XML2EcoreTranslator>();
		result.add(util.translatePlainXML2EPackage(URIorPath));
		if (result.size() > 0) {
			for(XML2EcoreTranslator translator: result)
			{
				EPackage ePackage = translator.getEPackage();
				PlainXMLIpackageDriver driver = new PlainXMLIpackageDriver(ePackage);
				driver.setRoot(translator.get_root());
				packages.put(ePackage.getName(), driver);
			}
			return true;
		}
		else {
			logBook.addError(modelDeclarationStatement, IMessage_IMetamodelDriver.UNABLE_TO_LOAD_METAMODEL);
			return false;
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
		IModel iModel = EolFactory.eINSTANCE.createIModel();
		iModel.setName(modelDeclarationStatement.getName().getName());
		iModel.setDriver(modelDeclarationStatement.getDriver());
		for(VariableDeclarationExpression alias: modelDeclarationStatement.getAlias())
		{
			iModel.getAliases().add(alias.getName());
		}
		
		for(String key: packages.keySet())
		{
			IPackage iPackage = EolFactory.eINSTANCE.createIPackage();
			PlainXMLIpackageDriver planxmliPackageDriver = packages.get(key);
			iPackage.setName(planxmliPackageDriver.getPackageName());
			iPackage.setNsPrefix(planxmliPackageDriver.getPackageNSPrefix());
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
			iPackage.setIPackageDriver(planxmliPackageDriver);
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

}
