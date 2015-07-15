package org.eclipse.epsilon.analysis.model.driver;

import java.util.Set;

import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.problem.LogBook;

public interface IMetamodelDriver {

	public abstract void loadModel(String path) throws Exception;
	
	public abstract String getName();
	public void setName(String name);
	public abstract Set<String> getAliases();
	public void addAlias(String alias);
	
	public IPackageDriver getIPackageDriver(String packageName);
	public boolean containsIPackage(String packageName);
	
	public LogBook getLogBook();
	public void setLogBook(LogBook logBook);
	
	public ModelDeclarationStatement getModelDeclarationStatement();
	public void setModelDeclarationStatement(ModelDeclarationStatement modelDeclarationStatement);
}
