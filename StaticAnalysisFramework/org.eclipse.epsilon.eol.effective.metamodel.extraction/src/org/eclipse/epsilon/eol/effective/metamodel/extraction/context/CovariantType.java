package org.eclipse.epsilon.eol.effective.metamodel.extraction.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.util.MetaClassNode;

public class CovariantType {
	
	//the original type
	protected EClass originalType;
	//covariant types that original type can hold
	protected ArrayList<EClass> covariantTypes = new ArrayList<EClass>();
	
	public EClass getOriginalType() {
		return originalType;
	}
	
	public void setOriginalType(EClass originalType) {
		this.originalType = originalType;
	}
	
	public ArrayList<EClass> getCovariantTypes() {
		return covariantTypes;
	}
	
	public void addCovariantType(EClass type)
	{
		if (!covariantTypes.contains(type)) {
			covariantTypes.add(type);
		}
	}
	
	public CovariantType(EClass originalType)
	{
		this.originalType = originalType;
	}
	
	public CovariantType(EClass originalType, EClass covariantType)
	{
		this.originalType = originalType;
		addCovariantType(covariantType);
	}
	
	//check if covariant types are all in the same package
	public boolean allInSamePackage()
	{
		if (covariantTypes.size() != 0) {
			EPackage ePackage = covariantTypes.get(0).getEPackage();
			for(EClass eClass: covariantTypes){
				if (!eClass.getEPackage().equals(ePackage)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//get a list of common types
	public ArrayList<EClass> commonTypes()
	{
		ArrayList<EClass> result = new ArrayList<EClass>();
		if (allInSamePackage()) {
			EPackage ePackage = covariantTypes.get(0).getEPackage();
			for(EClassifier eClass: ePackage.getEClassifiers())
			{
				if (eClass instanceof EClass) {
					boolean store = true;
					label_1:
					for(EClass leClass: covariantTypes)
					{
						if (!((EClass) eClass).isSuperTypeOf(leClass)) {
							store = false;
							break label_1;
						}
					}
					if (store) {
						result.add((EClass) eClass);
					}
				}
			}
		}
		return result;
	}
	
	public EClass getLeastCommonType()
	{
		if (covariantTypes.size() == 0) {
			return null;
		}
		else if (covariantTypes.size() == 1) {
			return covariantTypes.get(0);
		}
		else if (covariantTypes.size() == 2) {
			EClass type1 = covariantTypes.get(0);
			EClass type2 = covariantTypes.get(1);
			if (type1.isSuperTypeOf(type2)) {
				return type1;
			}
			else if (type2.isSuperTypeOf(type1)) {
				return type2;
			}
			else {
				return getLeastCommonTypeComplex();
			}
		}
		else {
			return getLeastCommonTypeComplex();
		}
		
	}
	
	public EClass getLeastCommonTypeComplex()
	{
		HashMap<EClass, Integer> result = new HashMap<EClass, Integer>();
		for(EClass commonType: commonTypes())
		{
			int temp = 0;
			for(EClass eClass: covariantTypes)
			{
				temp += shortestDistanceBetweenClass(eClass, commonType);
			}
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
	
	public void dispose()
	{
		covariantTypes.clear();
		covariantTypes.add(originalType);
	}
	
}
