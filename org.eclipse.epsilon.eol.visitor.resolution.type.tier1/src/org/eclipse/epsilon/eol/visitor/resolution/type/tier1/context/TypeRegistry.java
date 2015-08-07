package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;

public class TypeRegistry {

	protected TypeRegisterEntryContainer baseContainer;
	protected TypeRegisterEntryContainer currentContainer;

	
	public TypeRegisterEntryContainer getBaseContainer() {
		return baseContainer;
	}
	
	public TypeRegisterEntryContainer getCurrentContainer() {
		return currentContainer;
	}
	
	public void pushContainer(EOLElement eolElement)
	{
		if (baseContainer == null) {
			baseContainer = new TypeRegisterEntryContainer();
			baseContainer.setScope(eolElement);
			currentContainer = baseContainer;
		}
		else {
			TypeRegisterEntryContainer container = new TypeRegisterEntryContainer();
			container.setPreviousContainer(currentContainer);
			container.setScope(eolElement);
			currentContainer.getSubContainers().add(container);
			currentContainer = container;
		}
	}
	
	public void popContainer()
	{	
		if (currentContainer.getPreviousContainer() != null) {
			currentContainer = currentContainer.getPreviousContainer();	
		}
	}
	
	public void pushVariable(VariableDeclarationExpression variableDeclarationExpression, Type type)
	{
		currentContainer.assignType(variableDeclarationExpression, type);
	}
	
	public HashSet<Type> getTypeForVariable(VariableDeclarationExpression variableDeclarationExpression)
	{
		HashSet<Type> result = new HashSet<Type>();
		HashSet<TypeRegisterEntryContainer> containersToIgnore = currentContainer.getContainersToDisregard(variableDeclarationExpression);
		for(TypeRegisterEntryContainer container : currentContainer.getSubContainers())
		{
			if (containersToIgnore != null) {
				if (containersToIgnore.contains(container)) {
					continue;
				}
			}
			if (container.getType(variableDeclarationExpression) != null) {
				result.add(container.getType(variableDeclarationExpression));
//				result.add(EcoreUtil.copy(container.getType(variableDeclarationExpression)));	
			}
			
		}
		TypeRegisterEntryContainer container = currentContainer;
		while(container != null)
		{
			
			HashSet<TypeRegisterEntryContainer> toIgnore = container.getContainersToDisregard(variableDeclarationExpression);
			for(TypeRegisterEntryContainer c : container.getSubContainers())
			{
				if (toIgnore != null) {
					if (toIgnore.contains(c)) {
						continue;
					}
				}
				if (c.getType(variableDeclarationExpression) != null) {
					result.add(c.getType(variableDeclarationExpression));
//					result.add(EcoreUtil.copy(c.getType(variableDeclarationExpression)));	
				}
				
			}
			
			if (container.getType(variableDeclarationExpression) != null) {
				result.add(container.getType(variableDeclarationExpression));
//				result.add(EcoreUtil.copy(container.getType(variableDeclarationExpression)));	
			}
			container = container.getPreviousContainer();
		}
		return result;
	}
}
