package metamodel.connectivity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class EcoreModel implements EModel{

	protected EPackage ePackage;
	protected EcorePackage ePack = EcorePackage.eINSTANCE;

	@Override
	public void loadModel(String modelString) throws Exception {
		// TODO Auto-generated method stub
		if (modelString.startsWith("http://")) {
			ePackage = EcoreRegistryLoader.loadEPackageFromRetistry(modelString);
		}
		else {
			ePackage = EcoreFileLoader.loadEPackageFromFile(modelString);
		}
		
		if (ePackage == null) {
			try {
				throw new Exception("Cannot load the package specified");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String getMetaModelName() {
		return ePackage.getName();	}

	@Override
	public String getMetaModelNsURI() {
		return ePackage.getNsURI();
	}

	@Override
	public String getMetaModelNsPrefix() {
		return ePackage.getNsPrefix();
	}

	@Override
	public boolean containsMetaClass(String className) {
		boolean result = false;
		if(ePackage.getEClassifier(className) != null)
		{
			result = true;
		}
		return result;
	}

	@Override
	public EClassifier getMetaClass(String className) {
		return ePackage.getEClassifier(className);
	}

	@Override
	public boolean containsEnum(String enumName) {
		boolean result = false;
		EClassifier enumClass = ePackage.getEClassifier(enumName); //get classifier from the package
		if (enumClass != null) { //if there's an EClassifier with the name
			if(enumClass.getClass().equals(ePack.getEEnum())) //check if the classifier is of type EENum
			{
				result = true; 
			}
		}
		return result;
	}

	@Override
	public EEnum getEnum(String enumName) {
		EClassifier enumClass = ePackage.getEClassifier(enumName); //get EClassifier form the package
		if (enumClass != null) { //if package contains EClassifier
			if (enumClass.getClass().equals(ePack.getEEnum())) { //if EClassifier is of type EEnum
				return (EEnum) enumClass;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public boolean enumContainsLiteral(String enumName, String literalName) {
		EEnum enumeration = getEnum(enumName);
		if (enumeration != null) {
			return enumeration.getEEnumLiteral(literalName) != null;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean containsEAttribute(String className, String attributeName) {
		EClass eClass = (EClass) getMetaClass(className);
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

	@Override
	public boolean containsEReference(String className, String referenceName) {
		EClass eClass = (EClass) getMetaClass(className);
		if (eClass != null) {
			EStructuralFeature feature = eClass.getEStructuralFeature(referenceName);
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

	@Override
	public boolean contains(String className, String propertyName) {
		EClass eClass = (EClass) getMetaClass(className);
		if (eClass != null) {
			return eClass.getEStructuralFeature(propertyName) != null;
		}
		else {
			return false;
		}
	}

	@Override
	public EAttribute getEAttribute(EClass metaClass, String attributeName) {
		EStructuralFeature feature = metaClass.getEStructuralFeature(attributeName);
		if (feature instanceof EAttribute) {
			return (EAttribute) feature;
		}
		else {
			return null;
		}
	}

	@Override
	public EReference getEReference(EClass metaClass, String referenceName) {
		EStructuralFeature feature = metaClass.getEStructuralFeature(referenceName);
		if (feature instanceof EAttribute) {
			return (EReference) feature;
		}
		else {
			return null;
		}
	}

	@Override
	public EStructuralFeature getEStructuralFeature(EClass metaClass,
			String featureName) {
		return metaClass.getEStructuralFeature(featureName);
	}

	@Override
	public EClassifier getTypeForEAttribute(EObject eClass, String attributeName) {
		EClassifier result = null;
		for(EAttribute attr: ((EClass) eClass).getEAllAttributes())
		{
			if(attr.getName().equals(attributeName))
			{
				result = attr.getEType();
			}
		}
		return result;

	}

	@Override
	public EClassifier getTypeForEReference(EObject eClass, String referenceName) {
		EClassifier result = null;
		for(EReference ref: ((EClass) eClass).getEAllReferences())
		{
			if (ref.getName().equals(referenceName)) {
				result = ref.getEType();
			}
		}
		return result;
	}

	@Override
	public EClassifier getTypeForProperty(EObject eClass, String propertyName) {
		return getTypeForEAttribute(eClass, propertyName) == null ? getTypeForEReference(eClass, propertyName) : getTypeForEAttribute(eClass, propertyName);
	}

}
