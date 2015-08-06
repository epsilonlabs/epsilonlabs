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
	
	protected HashMap<VariableDeclarationExpression, Type> typeMap = new HashMap<VariableDeclarationExpression, Type>();
	
	protected HashMap<VariableDeclarationExpression, HashSet<TypeRegisterEntryContainer>> disregardSubContainersMap = new HashMap<VariableDeclarationExpression, HashSet<TypeRegisterEntryContainer>>();
	
	protected ArrayList<TypeRegisterEntryContainer> subContainers = new ArrayList<TypeRegisterEntryContainer>();
	protected TypeRegisterEntryContainer previousContainer;
	
	public void setScope(EOLElement scope) {
		this.scope = scope;
	}
	
	public ArrayList<TypeRegisterEntryContainer> getSubContainers() {
		return subContainers;
	}
	
	public void setPreviousContainer(
			TypeRegisterEntryContainer previousContainer) {
		this.previousContainer = previousContainer;
	}
	
	public TypeRegisterEntryContainer getPreviousContainer() {
		return previousContainer;
	}
	
	public void assignType(VariableDeclarationExpression variableDeclarationExpression, Type type)
	{
		if (typeMap.containsKey(variableDeclarationExpression)) {
			typeMap.put(variableDeclarationExpression, EcoreUtil.copy(type));
		}
		else {
			typeMap.put(variableDeclarationExpression, EcoreUtil.copy(type));
		}
		
		HashSet<TypeRegisterEntryContainer> temp = new HashSet<TypeRegisterEntryContainer>();
		temp.addAll(subContainers);
		disregardSubContainersMap.put(variableDeclarationExpression, temp);
	}
	
	public HashSet<TypeRegisterEntryContainer> getContainersToDisregard(VariableDeclarationExpression variableDeclarationExpression)
	{
		return disregardSubContainersMap.get(variableDeclarationExpression);
	}
	
	public Type getType(VariableDeclarationExpression variableDeclarationExpression)
	{
		return typeMap.get(variableDeclarationExpression);
	}
	
}
