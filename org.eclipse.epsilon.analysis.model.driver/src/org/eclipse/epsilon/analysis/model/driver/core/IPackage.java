package org.eclipse.epsilon.analysis.model.driver.core;

import java.util.ArrayList;
import java.util.List;

public class IPackage extends INamedElement{

	protected String nsURI;
	protected String nsPrefix;
	protected List<IClassifier> iClassifiers = new ArrayList<IClassifier>();
	protected List<IPackage> subPackages = new ArrayList<IPackage>();
	protected List<IPackage> superPackages = new ArrayList<IPackage>();
	
	public IPackage(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public List<IClassifier> getiClassifiers() {
		return iClassifiers;
	}
	
	public void addIClassifier(IClassifier iClassifier)
	{
		iClassifiers.add(iClassifier);
	}
	
	public List<IPackage> getsubPackages() {
		return subPackages;
	}
	
	public void addSubpackage(IPackage subPackage){
		subPackages.add(subPackage);
	}
	
	public List<IPackage> getSuperPackages() {
		return superPackages;
	}
	
	public void addSuperPackage(IPackage superPackage)
	{
		superPackages.add(superPackage);
	}
	
	public IClassifier getIClassifier(String name)
	{
		for(IClassifier iClassifier: iClassifiers)
		{
			if (iClassifier.getName().equals(name)) {
				return iClassifier;
			}
		}
		return null;
	}

}
