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
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_IMetamodelDriver;

public class EMFIMetamodelDriver implements IMetamodelDriver{

	protected HashMap<String, EMFIPackageDriver> packages = new HashMap<String, EMFIPackageDriver>();
	protected String name;
	protected HashSet<String> aliases = new HashSet<String>();
	protected ModelDeclarationStatement modelDeclarationStatement = null;
	protected LogBook logBook = null;
	
	@Override
	public void loadModel(String pathOrNSURI) throws Exception {
		ArrayList<EPackage> result = new ArrayList<EPackage>();
		result.addAll(EcoreRegistryLoader.loadEPackageFromRegistry(pathOrNSURI));
		if (result.size() > 0) {
			for(EPackage ePackage: result)
			{
				packages.put(ePackage.getName(), new EMFIPackageDriver(ePackage));
			}
		}
		else {
			result.addAll(EcoreFileLoader.loadEPackageFromFile(pathOrNSURI));
			if (result.size() > 0) {
				for(EPackage ePackage: result)
				{
					packages.put(ePackage.getName(), new EMFIPackageDriver(ePackage));
				}
			}
			else {
				logBook.addError(modelDeclarationStatement, IMessage_IMetamodelDriver.UNABLE_TO_LOAD_METAMODEL);
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
		aliases.add(alias);
		
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

}
