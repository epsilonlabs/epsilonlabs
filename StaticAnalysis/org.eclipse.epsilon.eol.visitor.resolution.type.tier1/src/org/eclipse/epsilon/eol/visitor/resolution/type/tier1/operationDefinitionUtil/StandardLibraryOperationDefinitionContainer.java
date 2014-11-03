package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;
import org.eclipse.epsilon.eol.ast2eol.util.Ast2EolUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class StandardLibraryOperationDefinitionContainer extends OperationDefinitionContainer{

	protected Ast2EolUtil ast2EolUtil = new Ast2EolUtil();
	public StandardLibraryOperationDefinitionContainer(TypeUtil typeUtil) {
		super(typeUtil);
		init();
	}
	
	public void registerOperation(Class leClass, String filename)
	{
		File currentDirFile = new File("");
		String helper = currentDirFile.getAbsolutePath();
		
		int lastIndexOf = helper.lastIndexOf("/");
		String directoryPathString = helper.substring(0, lastIndexOf+1) + "org.eclipse.epsilon.eol.visitor.resolution.type.tier1/src/org/eclipse/epsilon/eol/visitor/resolution/type/tier1/operationDefinitionUtil/" + filename ;
		
		EolModule eolModule = new EolModule();
		EolProgram program = null;
		try {
			eolModule.parse(new File(directoryPathString));
			program = ast2EolUtil.generateProgram(eolModule.getAst());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			program = ast2EolUtil.generate(leClass, filename);
		}
		
		
		//EolProgram program = ast2EolUtil.generate(leClass, filename);
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
