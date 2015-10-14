package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;

public class TypeRegisterEntryContainer {

	protected EOLElement scope;
	
	//the map look up
	protected HashMap<VariableDeclarationExpression, ArrayList<Type>> variableTypesInScope = new HashMap<VariableDeclarationExpression, ArrayList<Type>>();
	
	//types to disregard
	protected HashMap<VariableDeclarationExpression, HashSet<TypeRegisterEntryContainer>> disregardSubContainersMap = new HashMap<VariableDeclarationExpression, HashSet<TypeRegisterEntryContainer>>();
	
	//sub containers
	protected ArrayList<TypeRegisterEntryContainer> subContainers = new ArrayList<TypeRegisterEntryContainer>();
	
	//previous container
	protected TypeRegisterEntryContainer previousContainer;
	
	//set the scope
	public void setScope(EOLElement scope) {
		this.scope = scope;
	}
	
	//get sub containers
	public ArrayList<TypeRegisterEntryContainer> getSubContainers() {
		return subContainers;
	}
	
	//set the previous container
	public void setPreviousContainer(
			TypeRegisterEntryContainer previousContainer) {
		this.previousContainer = previousContainer;
	}
	
	//get the previous container
	public TypeRegisterEntryContainer getPreviousContainer() {
		return previousContainer;
	}
	
	//assign the type
	public void assignType(VariableDeclarationExpression vde, Type type)
	{
		ArrayList<Type> replace = new ArrayList<Type>();
		replace.add(EcoreUtil.copy(type));
		variableTypesInScope.put(vde, replace);
		
		HashSet<TypeRegisterEntryContainer> temp = new HashSet<TypeRegisterEntryContainer>();
		temp.addAll(subContainers);
		disregardSubContainersMap.put(vde, temp);
	}
	
	public void insertType(VariableDeclarationExpression vde, Type type)
	{
		ArrayList<Type> storedTypes = variableTypesInScope.get(vde);
		if (storedTypes != null) {
			storedTypes.add(EcoreUtil.copy(type));
		}
		else {
			storedTypes = new ArrayList<Type>();
			storedTypes.add(EcoreUtil.copy(type));
			variableTypesInScope.put(vde, storedTypes);
		}
	}
	
	//get discard
	public HashSet<TypeRegisterEntryContainer> getContainersToDisregard(VariableDeclarationExpression variableDeclarationExpression)
	{
		return disregardSubContainersMap.get(variableDeclarationExpression);
	}
	
	public ArrayList<Type> getTypes(VariableDeclarationExpression vde)
	{
		return variableTypesInScope.get(vde);
	}
	
}
