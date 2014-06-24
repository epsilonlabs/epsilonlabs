package metamodel.connectivity.plainxml;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

public class PlainXMLMetamodelDriver implements EMetamodelDriver{

	protected String name;
	protected ArrayList<String> aliases;

	protected EPackage ePackage;
	protected EClass root;
	protected PlainXMLMetamodelDriverUtil util;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getAliases() {
		return aliases;
	}
	
	public void setAliases(ArrayList<String> aliases) {
		this.aliases = aliases;
	}
	
	public void addAlias(String alias)
	{
		aliases.add(alias);
	}
	
	public boolean containsAlias(String alias)
	{
		return aliases.contains(alias);
	}
	
	@Override
	public void loadModel(String modelString) throws Exception {
	}

	@Override
	public String getMetamodelName() {
		return ePackage.getName();
	}

	@Override
	public String getMetamodelNsURI() {
		return ePackage.getNsURI();
	}

	@Override
	public String getMetamodelNsPrefix() {
		return ePackage.getNsPrefix();
	}

	@Override
	public boolean containsMetaClass(String className) {
		if (className.startsWith("t_")) {
			return true;
		}
		return false;
	}

	@Override
	public EClass getMetaClass(String className) {
		if (className.equals("root")) {
			if (root != null) {
				return root;
			}
			else {
				return null;
			}
		}
		else if (className.startsWith("t_")) {
			String escapedName = util.removeTag(className);
			EClass result = (EClass) ePackage.getEClassifier(escapedName);
			if (result != null) {
				return result; 
			}
			else {
				result = util.getFactory().createEClass();
				result.setName(escapedName);
				result.getEAnnotations().add(util.createAnnotationForWarning("Type may not exist in the metamodel"));
				ePackage.getEClassifiers().add(result);
				return result;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public boolean containsEnum(String enumName) {
		// TODO Auto-generated method stub
		//enum not supported yet
		return false;
	}

	@Override
	public EEnum getEnum(String enumName) {
		// TODO Auto-generated method stub
		// enum not supported yet
		return null;
	}

	@Override
	public boolean containsEnumLiteral(String enumName, String literalName) {
		// TODO Auto-generated method stub
		// enum not supported yet
		return false;
	}

	@Override
	public boolean containsEAttribute(String className, String attributeName) {
		if (util.isXMLSyntax(className) && util.isXMLSyntax(attributeName)) {
			return true;
		}
		else if (util.isXMLSyntax(className) && attributeName.equals("text")) {
			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public boolean containsEReference(String className, String referenceName) {
		if (util.isXMLSyntax(className) && util.isXMLSyntax(referenceName)) {
			return true;
		}
		else {
			return false;	
		}
	}

	@Override
	public boolean contains(String className, String propertyName) {
		if (propertyName.equals("text") || propertyName.equals("parentNode") || propertyName.equals("children") || propertyName.equals("tagName")) {
			return true;
		}
		
		if (util.isXMLSyntax(className) && util.isXMLSyntax(propertyName)) {
			if ((!(className.startsWith("t_"))) || propertyName.startsWith("x_")) { //class should always start with t_ and property should never start with x_
				return false;
			}
			else {
				return true;	
			}
		}
		else {
			return false;
		}		

	}

	@Override
	public EAttribute getEAttribute(String className, String attributeName) {
		if (util.isXMLSyntax(className) || attributeName.equals("text") || attributeName.equals("tagname")) {
			EClass clazz = getMetaClass(util.removeTag(className));
			if (clazz != null) {
				if (attributeName.equals("text") || attributeName.equals("tagname")) {
					EAttribute result = (EAttribute) clazz.getEStructuralFeature(attributeName);
					if (result == null) {
						EAttribute attr = util.getFactory().createEAttribute();
						attr.setName(attributeName);
						attr.setLowerBound(0);
						attr.setUpperBound(1);
						attr.setEType(util.getEcorePackage().getEString());
						clazz.getEStructuralFeatures().add(attr);
						return attr;
					}
					else {
						return result;
					}
				}
				else {
					
				}
				
				

			}
			else {
				return null;
			}
		}
		return null;
	}

	@Override
	public EReference getEReference(String className, String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature getEStructuralFeature(String className,
			String featureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EAttribute getEAttribute(EClass metaClass, String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference getEReference(EClass metaClass, String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature getEStructuralFeature(EClass metaClass,
			String featureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForEAttribute(EClass eClass, String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForEReference(EClass eClass, String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForEStructuralFeature(EClass eClass,
			String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForEAttribute(String className,
			String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForEReference(String className,
			String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClassifier getTypeForEStructuralFeature(String className,
			String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
