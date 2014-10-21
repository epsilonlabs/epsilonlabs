package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;
import org.eclipse.epsilon.eol.ast2eol.util.Ast2EolUtil;

public class StandardLibraryOperationDefinitionContainer extends OperationDefinitionContainer{

	protected Ast2EolUtil ast2EolUtil = new Ast2EolUtil();
	public StandardLibraryOperationDefinitionContainer(TypeUtil typeUtil) {
		super(typeUtil);
		init();
	}
	
	public void registerOperation(Class leClass, String filename)
	{
		EolProgram program = ast2EolUtil.generate(leClass, filename);
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
		registerOperation(this.getClass(), "operationTypeAny.eol");
		registerOperation(this.getClass(), "operationTypeCollection.eol");
		registerOperation(this.getClass(), "operationTypeInteger.eol");
		registerOperation(this.getClass(), "operationTypeModelElement.eol");
		registerOperation(this.getClass(), "operationTypeReal.eol");
		registerOperation(this.getClass(), "operationTypeString.eol");
	}
	
	
	public Ast2EolUtil getAst2DomUtil()
	{
		return ast2EolUtil;
	}
	
	public ArrayList<OperationDefinition> getOperations()
	{
		return operations;
	}
	

}
