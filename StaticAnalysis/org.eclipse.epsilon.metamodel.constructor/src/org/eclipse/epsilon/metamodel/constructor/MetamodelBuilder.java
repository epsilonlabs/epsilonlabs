package org.eclipse.epsilon.metamodel.constructor;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class MetamodelBuilder {
	protected EcoreFactory factory = EcoreFactory.eINSTANCE;
	protected EPackage ePackage = factory.createEPackage();
	protected EcorePackage ecorePackage = EcorePackage.eINSTANCE;
	
	public MetamodelBuilder()
	{
		
	}
	
	public EPackage getEPackage() {
		return ePackage;
	}
	
	public EcorePackage getEcorePackage() {
		return ecorePackage;
	}
		
	public String getEPackageName()
	{
		return ePackage.getName();
	}
	
	public void setEPackageName(String name)
	{
		ePackage.setName(name);
	}
	
	public String getEPackageNsURI()
	{
		return ePackage.getNsURI();
	}
	
	public void setEPackageNsURI(String nsURI)
	{
		ePackage.setNsURI(nsURI);
	}
	
	public String getEpackageNsPrefix()
	{
		return ePackage.getNsPrefix();
	}
	
	public void setEPackageNsPrefix(String nsPrefix)
	{
		ePackage.setNsPrefix(nsPrefix);
	}
	
	public boolean containsEClass(String className)
	{
		return ePackage.getEClassifier(className) != null;
	}
	
	public EClass getEClass(String className)
	{
		return (EClass)ePackage.getEClassifier(className);
	}
	
	public EClass createEClass(String className)
	{
		if (containsEClass(className)) {
			return null;
		}
		else {
			EClass result = factory.createEClass();
			result.setName(className);
			ePackage.getEClassifiers().add(result);
			return result;
		}
	}
	
	public EClass createEClass(String className, String superClassName)
	{
		EClass eClass = createEClass(className);
		if (eClass!=null) {
			EClass superClass = getEClass(superClassName);
			if (superClass!=null) {
				eClass.getESuperTypes().add(superClass);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		return null;
	}
	
	public boolean containsEAttribute(String className, String attributeName)
	{
		EClass eClass = getEClass(className);
		if (eClass != null) {
			EStructuralFeature feature = eClass.getEStructuralFeature(attributeName);
			if (feature instanceof EAttribute) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public EAttribute getEAttribute(String className, String attributeName)
	{
		if (containsEClass(className)) {
			EClass eClass = getEClass(className);
			EStructuralFeature feature = eClass.getEStructuralFeature(attributeName);
			if (feature instanceof EAttribute) {
				return (EAttribute) feature;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public EAttribute createEAttribute(String className, String attributeName)
	{
		if (containsEAttribute(className, attributeName)) {
			return null;
		}
		else {
			EClass eClass = getEClass(className);
			EAttribute eAttribute = factory.createEAttribute();
			eAttribute.setName(attributeName);
			eAttribute.setLowerBound(0);
			eAttribute.setUpperBound(1);
			eClass.getEStructuralFeatures().add(eAttribute);
			return eAttribute;
		}
	}
	
	public EAttribute createEAttribute(String className, String attributeName, EDataType type, boolean unbounded)
	{
		if (containsEAttribute(className, attributeName)) {
			return null;
		}
		else {
			EClass eClass = getEClass(className);
			EAttribute eAttribute = factory.createEAttribute();
			eAttribute.setName(attributeName);
			eAttribute.setEType(type);
			eAttribute.setLowerBound(0);
			if (unbounded) {
				eAttribute.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
			}
			else {
				eAttribute.setUpperBound(1);
			}
			eClass.getEStructuralFeatures().add(eAttribute);
			return eAttribute;
		}
	}
	
	public boolean containsEReference(String className, String eReferenceName)
	{
		EClass eClass = getEClass(className);
		if (eClass != null) {
			EStructuralFeature feature = eClass.getEStructuralFeature(eReferenceName);
			if (feature instanceof EReference) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public EReference getEReference(String className, String eReferenceName)
	{
		if (containsEClass(className)) {
			EClass eClass = getEClass(className);
			EStructuralFeature feature = eClass.getEStructuralFeature(eReferenceName);
			if (feature instanceof EReference) {
				return (EReference) feature;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public EReference createEReference(String className, String eReferenceName)
	{
		if (containsEAttribute(className, eReferenceName)) {
			return null;
		}
		else {
			EClass eClass = getEClass(className);
			EReference eReference = factory.createEReference();
			
			eReference.setName(eReferenceName);
			eReference.setLowerBound(0);
			eReference.setUpperBound(1);
			eClass.getEStructuralFeatures().add(eReference);
			return eReference;
		}
	}
	
	public EReference createEReference(String className, String eReferenceName, EClass type, boolean containment, boolean unbounded)
	{
		if (containsEClass(type.getName())) {
			if (containsEAttribute(className, eReferenceName)) {
				return null;
			}
			else {
				EClass eClass = getEClass(className);
				EReference eReference = factory.createEReference();				
				eReference.setName(eReferenceName);
				eReference.setEType(type);
				eReference.setContainment(containment);
				eReference.setLowerBound(0);
				if (unbounded) {
					eReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
				}
				else {
					eReference.setUpperBound(1);
				}
				eClass.getEStructuralFeatures().add(eReference);
				return eReference;
			}
		}
		else {
			return null;
		}
	}
	
	public void save(String name)
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(name + ".ecore").getAbsolutePath()));
		resource.getContents().add(ePackage);
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) {
		System.out.println("program started");
		
		
		MetamodelBuilder builder = new MetamodelBuilder();
		builder.setEPackageName("TestPackage");
		builder.setEPackageNsURI("http://testpackage/1.0");
		builder.setEPackageNsPrefix("tp");
		builder.createEClass("A");
		builder.createEClass("B", "A");
		builder.createEClass("C");
		
		builder.createEAttribute("A", "a_attr", builder.ecorePackage.getEInt(), false);
		builder.createEReference("B", "b_ref", builder.getEClass("C"), true, true);
		builder.createEAttribute("C", "c_attr");
		builder.save("testModel");
		
		
		System.out.println("program terminated");
	}
}
