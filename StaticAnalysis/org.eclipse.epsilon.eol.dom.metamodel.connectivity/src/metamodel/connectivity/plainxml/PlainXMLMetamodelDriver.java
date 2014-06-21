package metamodel.connectivity.plainxml;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

public class PlainXMLMetamodelDriver implements EMetamodelDriver{

	protected String name;
	protected ArrayList<String> aliases;

	protected EPackage ePackage;

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
		// TODO Auto-generated method stub
		
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
	public EClassifier getMetaClass(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEnum(String enumName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EEnum getEnum(String enumName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEnumLiteral(String enumName, String literalName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEAttribute(String className, String attributeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEReference(String className, String referenceName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String className, String propertyName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EAttribute getEAttribute(String className, String attributeName) {
		// TODO Auto-generated method stub
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
