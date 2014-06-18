package metamodel.connectivity.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ecoreUtil {
	
	public boolean enumContainsLitera(EEnum enumeration, String literlName)
	{
			return enumeration.getEEnumLiteral(literlName) != null;	
	}
	
	public EEnumLiteral getEnumLiteral(EEnum enumeration, String literalName)
	{
		return enumeration.getEEnumLiteral(literalName);
	}

	public EAttribute getEAttribute(EClass object, String attributeName)
	{
		EStructuralFeature feature = object.getEStructuralFeature(attributeName);
		if (feature instanceof EAttribute) {
			return (EAttribute) feature;
		}
		else {
			return null;
		}
	}
	
	public EReference getEReference(EClass object, String referenceName)
	{
		EStructuralFeature feature = object.getEStructuralFeature(referenceName);
		if (feature instanceof EAttribute) {
			return (EReference) feature;
		}
		else {
			return null;
		}
	}
	
	public EStructuralFeature getEStructuralFeature(EClass object, String featureName)
	{
		return object.getEStructuralFeature(featureName);
	}
	
	public EClassifier getTypeForEAttribute(EObject object, String attributeName)
	{
		EClassifier result = null;
		EClass eClass = (EClass) object;
		for(EAttribute attr: eClass.getEAllAttributes())
		{
			if(attr.getName().equals(attributeName))
			{
				result = attr.getEType();
			}
		}
		return result;
	}
	
	public EClassifier getTypeForEReference(EObject object, String referenceName)
	{
		EClassifier result = null;
		EClass eClass = (EClass) object;
		for(EReference ref: eClass.getEAllReferences())
		{
			if (ref.getName().equals(referenceName)) {
				result = ref.getEType();
			}
		}
		return result;
	}
	
	public EClassifier getTypeForProperty(EObject object, String propertyName)
	{
		return getTypeForEAttribute(object, propertyName) == null ? getTypeForEReference(object, propertyName) : getTypeForEAttribute(object, propertyName);
	}

}
