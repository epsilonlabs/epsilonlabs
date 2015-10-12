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
	protected HashMap<VariableDeclarationExpression, Type> typeMap = new HashMap<VariableDeclarationExpression, Type>();
	
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
	public void assignType(VariableDeclarationExpression variableDeclarationExpression, Type type)
	{
		if (typeMap.containsKey(variableDeclarationExpression)) {
			//if type contains expression, override
			typeMap.put(variableDeclarationExpression, EcoreUtil.copy(type));
		}
		else {
			typeMap.put(variableDeclarationExpression, EcoreUtil.copy(type));
		}
		
		HashSet<TypeRegisterEntryContainer> temp = new HashSet<TypeRegisterEntryContainer>();
		temp.addAll(subContainers);
		disregardSubContainersMap.put(variableDeclarationExpression, temp);
	}
	
	//get discard
	public HashSet<TypeRegisterEntryContainer> getContainersToDisregard(VariableDeclarationExpression variableDeclarationExpression)
	{
		return disregardSubContainersMap.get(variableDeclarationExpression);
	}
	
	//get type given a variableDeclarationExpression
	public Type getType(VariableDeclarationExpression variableDeclarationExpression)
	{
		return typeMap.get(variableDeclarationExpression);
	}
	
}
