package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class TypeRegisterEntry {

	protected EOLElement scope;
	
	//the map look up
	protected HashMap<VariableDeclarationExpression, ArrayList<Type>> variableTypesInEntry = new HashMap<VariableDeclarationExpression, ArrayList<Type>>();
	
	//types to disregard
	protected HashMap<VariableDeclarationExpression, ArrayList<TypeRegisterEntry>> disregardSubContainersMap = new HashMap<VariableDeclarationExpression, ArrayList<TypeRegisterEntry>>();
	
	//sub containers
	protected ArrayList<TypeRegisterEntry> subEntries = new ArrayList<TypeRegisterEntry>();
	
	//previous container
	protected TypeRegisterEntry previousEntry;
	
	//set the scope
	public void setScope(EOLElement scope) {
		this.scope = scope;
	}
	
	//get sub containers
	public ArrayList<TypeRegisterEntry> getSubEntries() {
		return subEntries;
	}
	
	//set the previous container
	public void setPreviousEntry(
			TypeRegisterEntry previousEntry) {
		this.previousEntry = previousEntry;
	}
	
	//get the previous container
	public TypeRegisterEntry getPreviousEntry() {
		return previousEntry;
	}
	
	//assign the type, will overwrite all previous type in this entry
	public void assignType(VariableDeclarationExpression vde, Type type)
	{
		ArrayList<Type> replace = new ArrayList<Type>();
		
		//if is any type, add all dynamic types
		if (TypeUtil.getInstance().isInstanceofAnyType(type)) {
			AnyType anyType = (AnyType) type;
			for(Type t: anyType.getDynamicTypes())
			{
				replace.add(EcoreUtil.copy(t));
			}
		}
		//if is normal type, add
		else {
			replace.add(EcoreUtil.copy(type));
		}
		variableTypesInEntry.put(vde, replace);
		
		ArrayList<TypeRegisterEntry> temp = new ArrayList<TypeRegisterEntry>();
		temp.addAll(subEntries);
		disregardSubContainersMap.put(vde, temp);
	}
	
	//insert type, will insert a type for a variable in this entry
	public void insertType(VariableDeclarationExpression vde, Type type)
	{
		ArrayList<Type> storedTypes = variableTypesInEntry.get(vde);
		if (storedTypes != null) {
			storedTypes.add(EcoreUtil.copy(type));
		}
		else {
			storedTypes = new ArrayList<Type>();
			storedTypes.add(EcoreUtil.copy(type));
			variableTypesInEntry.put(vde, storedTypes);
		}
	}
	
	//get sub entries to discard for a var
	public ArrayList<TypeRegisterEntry> getEntriesToDiscard(VariableDeclarationExpression variableDeclarationExpression)
	{
		return disregardSubContainersMap.get(variableDeclarationExpression);
	}
	
	//get the types of a var in this entry
	public ArrayList<Type> getTypes(VariableDeclarationExpression vde)
	{
		return variableTypesInEntry.get(vde);
	}
	
}
