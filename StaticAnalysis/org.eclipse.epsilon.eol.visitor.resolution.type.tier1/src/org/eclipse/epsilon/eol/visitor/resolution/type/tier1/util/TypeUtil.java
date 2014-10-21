package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util;

import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class TypeUtil {

	protected EolFactory eolFactory;
	protected TypeResolutionContext context;
	
	
	public TypeUtil(TypeResolutionContext context)
	{
		this.context = context;
		this.eolFactory = context.getEolFactory();
	}
		
	//returns true if the EObject is a EDataType
	public boolean isEDataType(EObject obj)
	{
		return obj instanceof EDataType;		
	}

	//returns true if the string is a type
	public boolean isType(String string)
	{
		boolean result = false;
		if (string.equals("Integer") || 
			string.equals("Real") ||
			string.equals("String") ||
			string.equals("Boolean") ||
			string.equals("Map") ||
			string.equals("Sequence") ||
			string.equals("Set") ||
			string.equals("OrderedSet") ||
			string.equals("Bag") ||
			string.equals("Native"))
		{
			result = true;
		}
		return result;
	}

	//normalise an EObject into EOL types
	public Type normalise(EObject obj)
	{
		//prepare a return type
		Type result = null;
		//prepare a datatype
		EDataType dataType = (EDataType) obj;
		//get the instance class name of the data type
		String instanceClassName = dataType.getInstanceClassName();
		//if the class name is int then create a IntegerType
		if(instanceClassName.equals("int") ||
				instanceClassName.equals("java.lang.Integer"))
		{
			result = eolFactory.createIntegerType();
		}
		//if is double or float then create a RealType
		else if(instanceClassName.equals("double") ||
				instanceClassName.equals("java.lang.Double") ||
				instanceClassName.equals("float") ||
				instanceClassName.equals("java.lang.Float"))
		{
			result = eolFactory.createRealType();
		}
		//if is boolean then create a BooleanType
		else if(instanceClassName.equals("boolean") ||
				instanceClassName.equals("java.lang.Boolean"))
		{
			result = eolFactory.createBooleanType();
		}
		//if is string then create a StringType
		else if(instanceClassName.equals("String") ||
				instanceClassName.equalsIgnoreCase("java.lang.String"))
		{
			result = eolFactory.createStringType();
		}
		else {
			
		}
		return result;
	}
	
	//returns true if the argument falls into the category of being primitive types in EOL
	public boolean isNormalisable(EObject obj)
	{
		boolean result = false;
		EDataType dataType = (EDataType) obj;
		String className = dataType.getInstanceClassName();
		if(className.equals("boolean") ||
				className.equals("java.lang.Boolean") ||
				className.equals("int") ||
				className.equals("java.lang.Integer") ||
				className.equals("double") ||
				className.equals("java.lang.Double") ||
				className.equals("float") ||
				className.equals("java.lang.Float") ||
				className.equals("String") ||
				className.equalsIgnoreCase("java.lang.String"))
		{
			result = true;
		}
		return result;
	}
		
	public boolean isEqualOrGeneric(EObject t1, EObject t2)
	{
		Type a = null;
		Type b = null;
		if (t1 == null || t2 == null) {
			return false;
		}
		if (isEDataType(t1)) {
			if (isNormalisable(t1)) {
				a = normalise(t1);
			}
		}
		else {
			a = (Type) t1;
		}
		if (isEDataType(t2)) {
			if(isNormalisable(t2))
			{
				b = normalise(t2);
			}
		}
		else {
			b = (Type) t2;
		}
		
		if (t1.eClass().equals(t2.eClass())) { //if the eclasses are the same return true
			return true;
		}
		
		if (a instanceof AnyType || b instanceof AnyType) { //if b is any type, return true
			return true;
		}
		else if(a instanceof PrimitiveType && b instanceof PrimitiveType)
		{
			PrimitiveType type1 = (PrimitiveType) a;
			PrimitiveType type2 = (PrimitiveType) b;
			if (type1.eClass().equals(type2.eClass())) { //if primitive types are equal to each other, return true
				return true;
			}
//			else if ((a instanceof IntegerType && b instanceof RealType) ||
//					(a instanceof IntegerType && b instanceof StringType) ||
//					(a instanceof RealType && b instanceof StringType) ||
//					(a instanceof BooleanType && b instanceof StringType)){ //these deals for type casting
//				return true;
//			}
			else {
				return false;
			}
		}
		else if(a instanceof CollectionType && b instanceof CollectionType) //if both of the types are collection type
		{
			CollectionType type1 = (CollectionType) a;
			CollectionType type2 = (CollectionType) b;
		
			if (type1.eClass().equals(type2.eClass())) { //if the class are equal
				if (isEqualOrGeneric(type1.getContentType(), type2.getContentType())) { //check for content type (this should be recursive for contained collection type, too)
					return true;
				}
				else {
					return false;
				}
			}
			else if(type1 instanceof OrderedCollectionType && type2 instanceof OrderedCollectionType)
			{
				if (isEqualOrGeneric(type1.getContentType(), type2.getContentType())) { //check for content type (this should be recursive for contained collection type, too)
					return true;
				}
				else {
					return false;
				}
			}
			else if (b.getClass().getSimpleName().equals("CollectionTypeImpl")) { //theoretically this should not happen
				return true;
			}
		}
		else if(a instanceof ModelElementType && b instanceof ModelElementType) //when both of the types are ModelElementTypes
		{
			ModelElementType type1 = (ModelElementType) a;
			ModelElementType type2 = (ModelElementType) b;
			
			if(shortestDistanceBetweenClass((EClass)type1.getEcoreType(), (EClass)type2.getEcoreType()) != -1)
			{
				return true;
			}
			else {
				return false;
			}
		}
		else if (b.getClass().getSimpleName().equals("TypeImpl") && a instanceof Type) {
			return true;
		}
		else {
			return false;
		}
		return false;
	}

	public int shortestDistanceBetweenObject(EObject subObj, EObject superObj)
	{
		int result = 998;
		EClass subClass = subObj.eClass(); //get the eclass of subObj
		EClass superClass = superObj.eClass(); //get the eclass of superObj 

		if (subClass.getEPackage().equals(superClass.getEPackage())) { //if these two classes are in the same epackage
			if (subObj instanceof ModelElementType && superObj instanceof ModelElementType) { //if both of the parameters are model element types
				subClass = (EClass) ((ModelElementType)subObj).getEcoreType(); //get the ecoretype
				
				superClass = (EClass) ((ModelElementType)superObj).getEcoreType(); //get the ecore type
				if (subClass == null || superClass == null) { //if ecore type is null, return null
					return -1;
				}
			}
			
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
		}
		return result;
	}
	
	//returns the number of ancestors between the subClass and the superClass, returns -1 if they are not inherently related
	public int shortestDistanceBetweenClass(EClass subClass, EClass superClass)
	{
		int result = -1;
		if (subClass.getEPackage().equals(superClass.getEPackage())) {	//if the class share the same EPackage		
			if(subClass.getEAllSuperTypes().contains(superClass)) //if the superClass is an ancestor of the subClass
			{
				ArrayList<MetaClassNode> unvisited = new ArrayList<MetaClassNode>(); //create unvisited list 
				ArrayList<MetaClassNode> visited = new ArrayList<MetaClassNode>(); //create visited list
				result = 0; //set result to 0
				for(EClass cls: subClass.getEAllSuperTypes()) //for all of the super classes of the subClass
				{
					MetaClassNode node = new MetaClassNode(cls); //create a Node
					node.setWeight(100000); //set weight to be infinite
					unvisited.add(node); //add node to unvisited
				}
				MetaClassNode current = new MetaClassNode(subClass); //set the current node to be the one that contains subClass
				current.setWeight(0); //set the weight to be 0
				unvisited.add(current); //add the current to the unvisited
				
				while(unvisited.size() != 0) //if there are remaining unvisited nodes
				{
					MetaClassNode min = current.extractMin(unvisited); //get the node with the smallest weight
					if (min.getEClass().equals(superClass)) { //stop when sub = super
						break;
					}
					visited.add(min); //add the node with the minimum weight to the visited list
					for(MetaClassNode n: current.getNeighbours(min, unvisited)) //get the neighbours for the current node
					{
						if (n.getWeight() > min.getWeight() + 1) { //if the weight of the node is greater than the min node + 1
							n.setWeight(min.getWeight() + 1); //set the weight to be min node's weight + 1
							n.setPrevious(min); //set the previous of the node to be min
						}
					}
				}
				result = visited.size();
				
			}
			else if(subClass.equals(superClass))
			{
				result = 0;
			}
		}
		return result;
	}

	//returns true if Type t1 and Type t2 are equal
	public boolean isTypeEqual(Type t1, Type t2) //need to include native and map types
	{
		if (t1 == null && t2 == null) {
			return true;
		}
		Type a = null;
		Type b = null;
		
		//normalise t1 and t2 if possible 
		if (isEDataType(t1)) {
			if (isNormalisable(t1)) {
				a = normalise(t1);
			}
		}
		else {
			a = (Type) t1;
		}
		if (isEDataType(t2)) {
			if(isNormalisable(t2))
			{
				b = normalise(t2);
			}
		}
		else {
			b = (Type) t2;
		}
		
		//if a and b are both of type Any then return true
		if (a instanceof AnyType && b instanceof AnyType) {
			return true;
		}
		//if a and b are both of type PrimitiveType and they are of the same class return true, else return false
		else if(a instanceof PrimitiveType && b instanceof PrimitiveType)
		{
			PrimitiveType type1 = (PrimitiveType) a;
			PrimitiveType type2 = (PrimitiveType) b;
			if (type1.eClass().equals(type2.eClass())) {
				return true;
			}
			else {
				return false;
			}
		}
		//if a and b are both of type CollectionType and they have the same content type (including Any), then return true, else false
		else if(a instanceof CollectionType && b instanceof CollectionType)
		{
			CollectionType type1 = (CollectionType) a;
			CollectionType type2 = (CollectionType) b;
		
			if (type1.eClass().equals(type2.eClass())) {
				if (isTypeEqual(type1.getContentType(), type2.getContentType())) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		
		//if a and b are both of type ModelElementType and both refer to the same meta class in the same metamodel, then return true, else fase
		else if(a instanceof ModelElementType && b instanceof ModelElementType)
		{
			ModelElementType type1 = (ModelElementType) a;
			ModelElementType type2 = (ModelElementType) b;
			
			if(type1.getEcoreType().getEPackage().equals(type2.getEcoreType().getEPackage()))
			{
				if (type1.getModelName().equals(type2.getModelName())) {
					if (type1.getElementName().equals(type2.getElementName())) {
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
			else {
				return false;
			}
		}
		else {
			return false;
		}
		return false;
	}
	

	public boolean isKeyWordSimple(String s)
	{
		if (s.equals("Any") ||
				s.equals("Integer") ||
				s.equals("Boolean") ||
				s.equals("Real") ||
				s.equals("String") ||
				s.equals("Bag") ||
				s.equals("Set") ||
				s.equals("OrderedSet") ||
				s.equals("Sequence") ||
				s.equals("Map") ||
				s.equals("_ModelElementType_")) {
			return true;
		}
		else if (s.contains("Bag(")) {
			String temp = s.replaceFirst("Bag\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else if (s.contains("Set\\(")) {
			String temp = s.replaceFirst("Set\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else if (s.contains("OrderedSet(")) {
			String temp = s.replaceFirst("OrderedSet\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else if (s.contains("Sequence(")) {
			String temp = s.replaceFirst("Sequence\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWordSimple(temp);
		}
		else {
			return false;
		}
	}
	
	public boolean isKeyWord(String s)
	{
		if (s.equals("Any") ||
				s.equals("Integer") ||
				s.equals("Boolean") ||
				s.equals("Real") ||
				s.equals("String") ||
				s.equals("Bag") ||
				s.equals("Set") ||
				s.equals("OrderedSet") ||
				s.equals("Sequence") ||
				s.equals("Map")) {
			return true;
		}
		else if (s.contains("Bag(")) {
			String temp = s.replaceFirst("Bag\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWord(temp);
		}
		else if (s.contains("Set(")) {
			String temp = s.replaceFirst("Set\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWord(temp);
		}
		else if (s.contains("OrderedSet(")) {
			String temp = s.replaceFirst("OrderedSet\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWord(temp);
		}
		else if (s.contains("Sequence(")) {
			String temp = s.replaceFirst("Sequence\\(", "");
			temp = temp.replaceFirst("\\)", "");
			return isKeyWord(temp);
		}
		else if (s.contains("!")) {

			String[] arr = s.split("!");
			String model = arr[0];
			String element = arr[1];
			
			if(context.containsMetaModel(model)) //check if metamodel exists
			{
				EMetamodelDriver em = context.getMetaModel(model); //fetch the metamodel
				if(em.containsMetaClass(element)) //if metaclass exists
				{
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
		else if (context.numberOfMetamodelsDefine(s, false) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public Type createType(String s)
	{
		Type result = null;
		if (s.equals("Any")) {
			result = eolFactory.createAnyType();
			return result;
		}
		else if(s.equals("Integer"))
		{
			result = eolFactory.createIntegerType();
			return result;
		}
		else if (s.equals("Real")) {
			result = eolFactory.createRealType();
			return result;
		}
		else if (s.equals("String")) {
			result = eolFactory.createStringType();
			return result;
		}
		else if(s.equals("Bag"))
		{
			result = eolFactory.createBagType();
			return result;
		}
		else if (s.equals("Set")) {
			result = eolFactory.createSetType();
			return result;
		}
		else if(s.equals("Sequence"))
		{
			result = eolFactory.createSequenceType();
			return result;
		}
		else if(s.equals("OrderedSet"))
		{
			result = eolFactory.createOrderedSetType();
			return result;
		}
		else if (s.contains("Bag(")) {
			String temp = s.replaceFirst("Bag\\(", "");
			temp = temp.replaceFirst("\\)", "");
			result = eolFactory.createBagType();
			((BagType)result).setContentType(createType(temp));
			return result;
		}
		else if (s.contains("Set(")) {
			String temp = s.replaceFirst("Set\\(", "");
			temp = temp.replaceFirst("\\)", "");
			result = eolFactory.createSetType();
			((SetType)result).setContentType(createType(temp));
			return result;
		}
		else if (s.contains("OrderedSet(")) {
			String temp = s.replaceFirst("OrderedSet\\(", "");
			temp = temp.replaceFirst("\\)", "");
			result = eolFactory.createOrderedSetType();
			((OrderedSetType)result).setContentType(createType(temp));
			return result;
		}
		else if (s.contains("Sequence(")) {
			String temp = s.replaceFirst("Sequence\\(", "");
			temp = temp.replaceFirst("\\)", "");
			result = eolFactory.createSequenceType();
			((SequenceType)result).setContentType(createType(temp));
			return result;
		}
		else if (s.contains("Native")) {
			String temp = s.replaceFirst("Native\\(", "");
			temp = temp.replace("\\)", "");

			result = eolFactory.createNativeType();
			return result;
		}
		else if (s.equals("_ModelElementType_")) {
			result = eolFactory.createModelElementType();
			return result;
		}
		return result;
	}
	
	public boolean isGeneric(Type subClass, Type superClass)
	{
		if (subClass.eClass().equals(superClass.eClass())) {
			return true;
		}
		if (superClass.eClass().getName().equals("Type")) {
			if(subClass instanceof Type)
			{
				return true;
			}
			else {
				return false;
			}
		}
		if (superClass.eClass().getName().equals("CollectionType")) {
			if (subClass instanceof CollectionType) {
				return true;
			}
			else {
				return false;
			}
		}
		if (superClass.eClass().getName().equals("PrimitiveType")) {
			if(subClass instanceof PrimitiveType)
			{
				return true;
			}
			else {
				return false;
			}
		}
		if(subClass instanceof ModelElementType && superClass instanceof ModelElementType) //when both of the types are ModelElementTypes
		{
			ModelElementType type1 = (ModelElementType) subClass;
			ModelElementType type2 = (ModelElementType) superClass;
			
			if(shortestDistanceBetweenClass((EClass)type1.getEcoreType(), (EClass)type2.getEcoreType()) != -1)
			{
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public boolean isXMLSyntax(String fullName)
	{
		if (fullName.startsWith("a_") || fullName.startsWith("b_") ||
				fullName.startsWith("i_") || fullName.startsWith("f_") || 
				fullName.startsWith("d_") || fullName.startsWith("s_") ||
				fullName.startsWith("t_") || fullName.startsWith("c_") ||
				fullName.startsWith("e_") || fullName.startsWith("x_"))
		{
			return true;
		}
		else {
			return false;
		}
	}
	

	
}
