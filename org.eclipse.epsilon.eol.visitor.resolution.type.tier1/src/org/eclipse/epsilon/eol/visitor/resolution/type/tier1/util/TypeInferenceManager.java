package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.Type;

public class TypeInferenceManager {

	public static void main(String[] args) {
		Type t1 = EolFactory.eINSTANCE.createRealType();
		Type t2 = EolFactory.eINSTANCE.createIntegerType();
		Type t3 = EolFactory.eINSTANCE.createStringType();
		
		System.out.println(t1.eClass());
		System.out.println(t2.eClass());
		System.out.println(t3.eClass());
		
//		Class<?> c;
//		try {
//			c = Class.forName("java.lang.String");
//			System.out.println(c);
//			System.out.println(c.getDeclaredMethods().length);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		if (t1.eClass().isSuperTypeOf(t2.eClass())) {
			System.out.println("trueeeeeeee");
		}
		
		System.out.println(t3.eClass().isSuperTypeOf(t1.eClass()));
		
		
		TypeInferenceManager typeInferenceManager = new TypeInferenceManager();
		System.out.println(typeInferenceManager.getLeastCommonTypeOf(t2.eClass(), t1.eClass()));
	}
	
	public Type inferType(AnyType anyType)
	{
		Type result = null;
		for(Type t: anyType.getDynamicTypes())
		{
			
		}
		
		if (result == null) {
			return anyType;
		}
		return null;
	}
	
	public Type getLeastCommonType(Type t1, Type t2)
	{
		Type result = null;
		if (t1 == null) {
			return EcoreUtil.copy(t2);
		}
		else {
			if (t2 == null) {
				return EcoreUtil.copy(t1);
			}
		}
		
		if (t1 instanceof PrimitiveType && t2 instanceof PrimitiveType) {
			return getLeastCommonPrimitiveType((PrimitiveType)t1, (PrimitiveType)t2);
		}
		else if (t1 instanceof CollectionType && t2 instanceof CollectionType) {
			if (t1.eClass().equals(t2.eClass())) {
				return EcoreUtil.copy(t1);
			}
			else {
				return null;
			}
		}
		else if (t1 instanceof ModelElementType && t2 instanceof ModelElementType) {
			
		}
		return null;
	}
	
	public ModelElementType getLeastCommonModelElementType(ModelElementType t1, ModelElementType t2)
	{
		EClass eClass1 = (EClass) t1.getModelType();
		EClass eClass2 = (EClass) t2.getModelType();

		if (eClass1.eClass().isSuperTypeOf(eClass2.eClass())) {
			return EcoreUtil.copy(t1);
		}
		else if (eClass2.eClass().isSuperTypeOf(eClass1.eClass())) {
			return EcoreUtil.copy(t2);
		}
		else {
			if(getLeastCommonTypeOf(eClass1, eClass2) != null)
			{
				
			}
		}
		return null;
	}
	
	public Type getLeastCommonPrimitiveType(PrimitiveType t1, PrimitiveType t2)
	{
		if (t1.eClass().isSuperTypeOf(t2.eClass())) {
			return EcoreUtil.copy(t1);
		}
		else if (t2.eClass().isSuperTypeOf(t1.eClass())) {
			return EcoreUtil.copy(t2);
		}
		else {
			
		}
		return null;
	}
	
	public HashSet<EClass> getCommonTypesOf(EClass t1, EClass t2)
	{
		HashSet<EClass> result = new HashSet<EClass>();
		if (t1.isSuperTypeOf(t2)) {
			result.add(t1);
		}
		if (t2.isSuperTypeOf(t1)) {
			result.add(t2);
		}
		
		for(EClass eClass: t1.getEAllSuperTypes())
		{
			if (eClass.isSuperTypeOf(t2)) {
				result.add(eClass);
			}
		}
		for(EClass eClass: t2.getEAllSuperTypes())
		{
			if (eClass.isSuperTypeOf(t1)) {
				result.add(eClass);
			}
		}
		return result;
	}

	
	public EClass getLeastCommonTypeOf(EClass t1, EClass t2)
	{
		HashMap<EClass, Integer> result = new HashMap<EClass, Integer>();
		for(EClass commonType: getCommonTypesOf(t1, t2))
		{
			int temp = 0;
			temp = shortestDistanceBetweenClass(t1, commonType);
			temp = shortestDistanceBetweenClass(t2, commonType);
			result.put(commonType, temp);
		}
		EClass least = null;
		int count = 9999;
		for(EClass eClass: result.keySet())
		{
			int sum = result.get(eClass);
			if (sum < count) {
				least = eClass;
				count = sum;
			}
		}
		return least;
	}

	
	
	protected boolean isInstanceofAnyType(EOLElement eolElement)
	{
		return eolElement.getClass().getSimpleName().equals("AnyTypeImpl");
	}
	
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


}
