package metamodel.connectivity.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class EMetaModel implements EModel{
	
	protected EPackage ePackage;
	protected EcorePackage ePack = EcorePackage.eINSTANCE;
	protected String name;
	protected ArrayList<String> aliases;
	
	public EMetaModel()
	{
		aliases = new ArrayList<String>();
		ePackage = null;
	}
	
	public static void main(String[] args) throws Exception
	{
		EMetaModel model = new EMetaModel();
		
		model.loadModel("Dom.ecore");
		model.printClasses();
		
		EObject obj = model.getTypeForProperty(model.getMetaClass("StringExpression"), "val");
		EcorePackage pack = EcorePackage.eINSTANCE;
		EObject obj2 = pack.getEString();
		System.out.println(obj.equals(obj2));
		
		System.out.println(model.shortestDistanceBetweenClass(model.getMetaClass("IntegerExpression"), model.getMetaClass("Expression")));
		System.out.println(model.shortestDistanceBetweenClass(model.getMetaClass("DomElement"), model.getMetaClass("DomElement")));
		System.out.println(model.shortestDistanceBetweenClass(model.getMetaClass("BooleanExpression"), model.getMetaClass("DomElement")));
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
		if (sourceString.startsWith("http://")) {
			ePackage = EcoreRegistryLoader.loadEPackageFromRetistry(sourceString);
		}
		else {
			ePackage = EcoreFileLoader.loadEPackageFromFile(sourceString);
		}
		
		if (ePackage == null) {
			throw new Exception("Cannot load the package specified");
		}
	}
	
	public String getMetaModelName()
	{
		return ePackage.getName();
	}
	
	public String getMetaModelNsURI()
	{
		return ePackage.getNsURI();
	}
	
	public String getMetaModelNsPrefix()
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
	
	public boolean enumContainsLiteral(String enumName, String literlName)
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
	
	public int distanceBetween(EClass lower, EClass higher)
	{
		int result = -1;
		if (lower.getEAllSuperTypes().contains(higher)) {
			result = 0;
			EClass temp = lower;
			while(!temp.equals(higher))
			{
				for(EClass cls: temp.getESuperTypes())
				{
					if (cls.getEAllSuperTypes().contains(higher)) {
						temp = cls;
						result++;
						break;
					}
					else if (cls.equals(higher)) {
						temp = cls;
						break;
					}
				}
			}
		}
		else if (lower.equals(higher)) {
			result = 0;
		}
		return result;
	}
	
	
	public int shortestDistanceBetweenClass(EClass subClass, EClass superClass)
	{
		int result = -1;
		if(subClass.getEAllSuperTypes().contains(superClass))
		{
			ArrayList<MetaClassNode> unvisited = new ArrayList<MetaClassNode>();
			ArrayList<MetaClassNode> visited = new ArrayList<MetaClassNode>();
			result = 0;
			for(EClass cls: subClass.getEAllSuperTypes())
			{
				MetaClassNode node = new MetaClassNode(cls);
				node.setWeight(100000);
				unvisited.add(node);
			}
			MetaClassNode current = new MetaClassNode(subClass);
			current.setWeight(0);
			unvisited.add(current);
			
			while(unvisited.size() != 0)
			{
				MetaClassNode min = current.extractMin(unvisited);
				if (min.getEClass().equals(superClass)) {
					break;
				}
				visited.add(min);
				for(MetaClassNode n: current.getNeighbours(min, unvisited))
				{
					if (n.getWeight() > min.getWeight() + 1) {
						n.setWeight(min.getWeight() + 1);
						n.setPrevious(min);
					}
				}
			}
			
			result = visited.size();
			
		}
		else if(subClass.equals(superClass))
		{
			result = 0;
		}
		
		
		return result;
	}

}
