package metamodel.connectivity.emf;

import java.util.ArrayList;
import java.util.List;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.util.EcoreFileLoader;
import metamodel.connectivity.util.EcoreRegistryLoader;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class EMFMetamodelDriver implements EMetamodelDriver{
	
	protected String name;
	protected ArrayList<String> aliases;

	protected EPackage ePackage;
	
	public EMFMetamodelDriver()
	{
		aliases = new ArrayList<String>();
		ePackage = null;
	}
	
	public static void main(String[] args) throws Exception
	{
		EMFMetamodelDriver model = new EMFMetamodelDriver();
		
		model.loadModel("Dom.ecore");
		model.printClasses();
		
		EObject obj = model.getTypeForEStructuralFeature(model.getMetaClass("StringExpression"), "val");
		EcorePackage pack = EcorePackage.eINSTANCE;
		EObject obj2 = pack.getEString();
		System.out.println(obj.equals(obj2));
		
//		System.out.println(model.shortestDistanceBetweenClass(model.getMetaClass("IntegerExpression"), model.getMetaClass("Expression")));
//		System.out.println(model.shortestDistanceBetweenClass(model.getMetaClass("DomElement"), model.getMetaClass("DomElement")));
//		System.out.println(model.shortestDistanceBetweenClass(model.getMetaClass("Statement"), model.getMetaClass("DomElement")));
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void loadModel(String sourceString) throws Exception
	{
		ePackage = EcoreRegistryLoader.loadEPackageFromRetistry(sourceString);
		if (ePackage == null) {
			ePackage = EcoreFileLoader.loadEPackageFromFile(sourceString);
		}
		if (ePackage == null) {
			throw new Exception("Cannot load the package specified");
		}
	}
	
	public String getMetamodelName()
	{
		return ePackage.getName();
	}
	
	public String getMetamodelNsURI()
	{
		return ePackage.getNsURI();
	}
	
	public String getMetamodelNsPrefix()
	{
		return ePackage.getNsPrefix();
	}
	
	public boolean containsMetaClass(String metaClassName)
	{
		boolean result = false;
		if(ePackage.getEClassifier(metaClassName) != null)
		{
			result = true;
		}
		return result;
	}
	
	public EClass getMetaClass(String metaClassName)
	{
		return (EClass)ePackage.getEClassifier(metaClassName);
	}
	
	public boolean containsEnum(String enumName)
	{
		boolean result = false;
		EClassifier enumClass = ePackage.getEClassifier(enumName); //get classifier from the package
		if (enumClass != null) { //if there's an EClassifier with the name
			if(enumClass instanceof EEnum) //check if the classifier is of type EENum
			{
				result = true; 
			}
		}
		return result;
	}
	
	public EEnum getEnum(String enumName)
	{
		EClassifier enumClass = ePackage.getEClassifier(enumName); //get EClassifier form the package
		if (enumClass != null) { //if package contains EClassifier
			if (enumClass instanceof EEnum) { //if EClassifier is of type EEnum
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
	
	public boolean containsEnumLiteral(String enumName, String literlName)
	{
		EEnum enumeration = getEnum(enumName);
		if (enumeration != null) {
			return enumeration.getEEnumLiteral(literlName) != null;
		}
		else {
			return false;
		}
	}
	
	public List<EStructuralFeature> getEStructuralFeatures(String metaClassName)
	{
		EClass eClass = getMetaClass(metaClassName);
		if (eClass != null) {
			return eClass.getEAllStructuralFeatures();
		}
		else {
			return null;
		}
	}
		
	public boolean containsEReference(String metaClassName, String eReferenceName)
	{
		EClass eClass = getMetaClass(metaClassName);
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
	
	public boolean containsEAttribute(String metaClassName, String eAttributeName)
	{
		EClass eClass = getMetaClass(metaClassName);
		if (eClass != null) {
			EStructuralFeature feature = eClass.getEStructuralFeature(eAttributeName);
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
	
	public boolean contains(String metaClassName, String property)
	{
		EClass eClass = getMetaClass(metaClassName);
		if (eClass != null) {
			return eClass.getEStructuralFeature(property) != null;
		}
		else {
			return false;
		}
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
		if (feature instanceof EReference) {
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
	
	public EClassifier getTypeForEAttribute(EClass eClass, String attributeName)
	{
		EClassifier result = null;
		for(EAttribute attr: eClass.getEAllAttributes())
		{
			if(attr.getName().equals(attributeName))
			{
				result = attr.getEType();
			}
		}
		return result;
	}
	
	public EClassifier getTypeForEReference(EClass eClass, String referenceName)
	{
		EClassifier result = null;
		for(EReference ref: eClass.getEAllReferences())
		{
			if (ref.getName().equals(referenceName)) {
				result = ref.getEType();
			}
		}
		return result;
	}
	
	public EClassifier getTypeForEStructuralFeature(EClass eClass, String propertyName)
	{
		return getTypeForEAttribute(eClass, propertyName) == null ? getTypeForEReference(eClass, propertyName) : getTypeForEAttribute(eClass, propertyName);
	}
	

	
	public void printClasses()
	{
		for(EClassifier classifier: ePackage.getEClassifiers())
		{
			if(classifier instanceof EClass)
			{
				System.out.println(classifier.getName());
			}
		}
	}
	
	public void addAlias(String s)
	{
		aliases.add(s);
	}
	
	public boolean containsAlias(String s)
	{
		return aliases.contains(s);
	}
	
	public ArrayList<String> getAliases()
	{
		return aliases;
	}
	
	public int equals(EClass a, EClass b)
	{
		int result = -1;
		
		if (a.equals(b)) {
			result = 1;
		}
		
		return result;
	}
			
//	public int shortestDistanceBetweenClass(EClass subClass, EClass superClass)
//	{
//		int result = -1;
//		if(subClass.getEAllSuperTypes().contains(superClass))
//		{
//			ArrayList<MetaClassNode> unvisited = new ArrayList<MetaClassNode>();
//			ArrayList<MetaClassNode> visited = new ArrayList<MetaClassNode>();
//			result = 0;
//			for(EClass cls: subClass.getEAllSuperTypes())
//			{
//				MetaClassNode node = new MetaClassNode(cls);
//				node.setWeight(100000);
//				unvisited.add(node);
//			}
//			MetaClassNode current = new MetaClassNode(subClass);
//			current.setWeight(0);
//			unvisited.add(current);
//			
//			while(unvisited.size() != 0)
//			{
//				MetaClassNode min = current.extractMin(unvisited);
//				if (min.getEClass().equals(superClass)) {
//					break;
//				}
//				visited.add(min);
//				for(MetaClassNode n: current.getNeighbours(min, unvisited))
//				{
//					if (n.getWeight() > min.getWeight() + 1) {
//						n.setWeight(min.getWeight() + 1);
//						n.setPrevious(min);
//					}
//				}
//			}
//			
//			result = visited.size();
//			
//		}
//		else if(subClass.equals(superClass))
//		{
//			result = 0;
//		}
//		
//		
//		return result;
//	}

	@Override
	public EAttribute getEAttribute(String className, String attributeName) {
		EClass eClass = getMetaClass(className);
		if (eClass != null) {
			return getEAttribute(eClass, attributeName);
		}
		else {
			return null;
		}
	}

	@Override
	public EReference getEReference(String className, String referenceName) {
		EClass eClass = getMetaClass(className);
		if (eClass != null) {
			return getEReference(eClass, referenceName);
		}
		else {
			return null;
		}
	}

	@Override
	public EStructuralFeature getEStructuralFeature(String className,
			String featureName) {
		return getEAttribute(className, featureName) == null ? getEReference(className, featureName) : getEAttribute(className, featureName);
	}

	@Override
	public EClassifier getTypeForEAttribute(String className,
			String attributeName) {
		EClass eClass = getMetaClass(className);
		if (eClass != null) {
			return getTypeForEAttribute(eClass, attributeName);
		}
		else {
			return null;	
		}
	}

	@Override
	public EClassifier getTypeForEReference(String className,
			String referenceName) {
		EClass eClass = getMetaClass(className);
		if (eClass != null) {
			return getTypeForEReference(eClass, referenceName);
		}
		else {
			return null;	
		}
	}

	@Override
	public EClassifier getTypeForEStructuralFeature(String className,
			String propertyName) {
		
		EClassifier result = getTypeForEAttribute(className, propertyName);
		if (result == null) {
			result = getTypeForEReference(className, propertyName);
		}
		return result;
	}

}
