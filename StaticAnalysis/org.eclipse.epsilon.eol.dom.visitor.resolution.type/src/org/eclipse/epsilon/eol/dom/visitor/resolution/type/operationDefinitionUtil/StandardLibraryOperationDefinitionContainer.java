package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.ast2dom.util.Ast2DomUtil;
import org.eclipse.epsilon.eol.dom.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeUtil;

public class StandardLibraryOperationDefinitionContainer extends OperationDefinitionContainer{

	protected Ast2DomUtil ast2DomUtil = new Ast2DomUtil();
	public StandardLibraryOperationDefinitionContainer(TypeUtil typeUtil) {
		super(typeUtil);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public void putOperationTypeAny()
	{
		Program program = ast2DomUtil.generate(getClass(), "operationTypeAny.eol");
		for(OperationDefinition operationDefinition : program.getOperations())
		{
			Type contextType = operationDefinition.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			
			if (!containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) {
				putOperation(operationDefinition);
			}
		}
	}
	
	public void putOperationTypeInteger()
	{
		Program program = ast2DomUtil.generate(getClass(), "operationTypeInteger.eol");
		for(OperationDefinition operationDefinition : program.getOperations())
		{
			Type contextType = operationDefinition.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			
			if (!containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) {
				putOperation(operationDefinition);
			}
		}

	}
	
	public void putOperationTypeReal()
	{
		Program program = ast2DomUtil.generate(getClass(), "operationTypeReal.eol");
		for(OperationDefinition operationDefinition : program.getOperations())
		{
			Type contextType = operationDefinition.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			
			if (!containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) {
				putOperation(operationDefinition);
			}
		}
		
	}
	
	public void putOperationTypeString()
	{
		Program program = ast2DomUtil.generate(getClass(), "operationTypeString.eol");
		for(OperationDefinition operationDefinition : program.getOperations())
		{
			Type contextType = operationDefinition.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			
			if (!containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) {
				putOperation(operationDefinition);
			}
		}
		
	}
	
	public void putOperationTypeCollection()
	{
		Program program = ast2DomUtil.generate(getClass(), "operationTypeCollection.eol");
		for(OperationDefinition operationDefinition : program.getOperations())
		{
			Type contextType = operationDefinition.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			
			if (!containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) {
				putOperation(operationDefinition);
			}
		}
		
	}
	
	public void putOperationTypeModeElement()
	{
		Program program = ast2DomUtil.generate(getClass(), "operationTypeModelElement.eol");
		for(OperationDefinition operationDefinition : program.getOperations())
		{
			Type contextType = operationDefinition.getContextType(); //get the contextType
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			
			for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
			{
				argTypes.add(v.getResolvedType()); //resolve and collect argument types
			}
			
			if (!containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) {
				putOperation(operationDefinition);
			}
		}
		
	}
	
	public void init()
	{
		putOperationTypeAny();
		putOperationTypeInteger();
		putOperationTypeReal();
		putOperationTypeString();
		putOperationTypeCollection();
		putOperationTypeModeElement();
	}
	
	
	public Ast2DomUtil getAst2DomUtil()
	{
		return ast2DomUtil;
	}
	
	public static void main(String[] args) {
		StandardLibraryOperationDefinitionContainer a = new StandardLibraryOperationDefinitionContainer(new TypeUtil(new TypeResolutionContext()));
		System.out.println(a.getOperations().size());
		//Program p = a.getAst2DomUtil().generate(a.getClass(), "operationTypeAny.eol");
		//System.out.println(p.getOperations().size());
	}
	
	public ArrayList<OperationDefinition> getOperations()
	{
		return operations;
	}
	

}
