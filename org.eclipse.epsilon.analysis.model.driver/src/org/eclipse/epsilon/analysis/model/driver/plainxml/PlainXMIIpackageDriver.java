package org.eclipse.epsilon.analysis.model.driver.plainxml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;

public class PlainXMIIpackageDriver implements IPackageDriver{
	
	protected EPackage ePackage;
	
	public PlainXMIIpackageDriver(EPackage ePackage)
	{
		this.ePackage = ePackage;
	}
	
	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPackageNSURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPackageNSPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsMetaElement(String elementName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EClassifier getMetaElement(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsClass(String elementName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EClass getClass(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsDataType(String elementName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EDataType getDataType(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEnumeration(String enumerationName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EEnum getEnumeration(String enumerationName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEnumerationLiteral(String enumerationName,
			String literalName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EEnumLiteral getEnumerationLiteral(String enumerationName,
			String literalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAttribute(String elementName, String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsReference(String elementName, String referenceName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsFeature(String elementName, String featureName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EAttribute getAttribute(String elementName, String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference getReference(String elementName, String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature getFeature(String elementName, String featureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EDataType getTypeForAttribute(EClass metaElement,
			String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClass getTypeForReference(EClass metaElement, String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForFeature(EClass metaElement, String featureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EDataType getTypeForAttribute(String elementName,
			String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClass getTypeForReference(String elementName, String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForFeature(String elementName, String featureName) {
		// TODO Auto-generated method stub
		return null;
	}

}
