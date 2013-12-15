package metamodel.connectivity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface EModel {

	public abstract void loadModel(String modelString) throws Exception; 
	
	public abstract String getMetaModelName();
	public abstract String getMetaModelNsURI();
	public abstract String getMetaModelNsPrefix();
	
	public abstract boolean containsMetaClass(String className);
	public abstract EClassifier getMetaClass(String className);
	
	public abstract boolean containsEnum(String enumName);
	public abstract EEnum getEnum(String enumName);
	
	public abstract boolean enumContainsLiteral(String enumName, String literalName);
	
	public abstract boolean containsEAttribute(String className, String attributeName);
	public abstract boolean containsEReference(String className, String referenceName);
	public abstract boolean contains(String className, String propertyName);
	
	public abstract EAttribute getEAttribute(EClass metaClass, String attributeName);
	public abstract EReference getEReference(EClass metaClass, String referenceName);
	public abstract EStructuralFeature getEStructuralFeature(EClass metaClass, String featureName);
	
	public abstract EClassifier getTypeForEAttribute(EObject eClass, String attributeName);
	public abstract EClassifier getTypeForEReference(EObject eClass, String referenceName);
	public abstract EClassifier getTypeForProperty(EObject eClass, String propertyName);
}
