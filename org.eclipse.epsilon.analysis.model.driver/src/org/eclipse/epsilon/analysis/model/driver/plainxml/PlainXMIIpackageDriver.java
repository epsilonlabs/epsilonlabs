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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.problem.LogBook;

public class PlainXMIIpackageDriver implements IPackageDriver{
	
	protected EPackage ePackage;
	protected EClass root;
	protected PlainXMLMetamodelDriverUtil util = new PlainXMLMetamodelDriverUtil();
	
	protected LogBook logBook = null;
	
	protected EOLElement currentEolElement = null;

	
	public PlainXMIIpackageDriver(EPackage ePackage)
	{
		this.ePackage = ePackage;
	}
	
	public EClass getRoot() {
		return root;
	}
	
	public void setRoot(EClass root) {
		this.root = root;
	}
	
	public LogBook getLogBook() {
		return logBook;
	}
	
	public void setLogBook(LogBook logBook) {
		this.logBook = logBook;
	}
	
	public EOLElement getCurrentEolElement() {
		return currentEolElement;
	}
	
	public void setCurrentEolElement(EOLElement currentEolElement) {
		this.currentEolElement = currentEolElement;
	}
	
	@Override
	public String getPackageName() {
		return ePackage.getName();
	}

	@Override
	public String getPackageNSURI() {
		return ePackage.getNsURI();
	}

	@Override
	public String getPackageNSPrefix() {
		return ePackage.getNsPrefix();
	}

	@Override
	public boolean containsMetaElement(String elementName) {
		if (elementName.startsWith("t_") || elementName.equals("root")) {
			return true;
		}
		return false;
	}

	@Override
	public EClassifier getMetaElement(String elementName) {
		if (elementName.equals("root")) {
			if (root != null) {
				return root;
			}
			else {
				return null;
			}
		}
		else if (elementName.startsWith("t_")) {
			String escapedName = util.removeTag(elementName);
			EClass result = (EClass) ePackage.getEClassifier(escapedName);
			if (result != null) {
				return result; 
			}
			else {
				result = EcoreFactory.eINSTANCE.createEClass();
				result.setName(escapedName);
				ePackage.getEClassifiers().add(result);
				return result;
			}
		}
		else {
			return null;
		}
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
