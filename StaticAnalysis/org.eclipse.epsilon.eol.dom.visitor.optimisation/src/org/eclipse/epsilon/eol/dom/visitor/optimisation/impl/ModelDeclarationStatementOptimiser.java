package org.eclipse.epsilon.eol.dom.visitor.optimisation.impl;

import metamodel.connectivity.EMetaModel;

import org.eclipse.epsilon.eol.dom.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ModelDeclarationStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.context.OptimisationContext;

public class ModelDeclarationStatementOptimiser extends ModelDeclarationStatementVisitor<OptimisationContext, Object>{

	@Override
	public Object visit(ModelDeclarationStatement modelDeclarationStatement,
			OptimisationContext context,
			EolVisitorController<OptimisationContext, Object> controller) {
		ModelDeclarationParameter sourceParameter = fetchSourceParameter(modelDeclarationStatement); //fetch the sourceParameter which specifies the metamodel information
		String sourceString = sourceParameter.getValue().getVal(); //fetch the metamodel name or NSURI
		EMetaModel metaModel = new EMetaModel(); //create a new MetaModel
		try {
			metaModel.loadModel(sourceString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //load the metamodel with the name or NSURI
		
		//System.out.println(metaModel.getMetaModelName());
		metaModel.setName(modelDeclarationStatement.getName().getName()); //add given name
		for(NameExpression name: modelDeclarationStatement.getAlias()) //add aliases
		{
			metaModel.addAlias(name.getName());
		}
		context.inputMetaModel(metaModel); //put the metamodel in the context
		context.putModelDeclarationStatement(modelDeclarationStatement.getName().getName(), modelDeclarationStatement); //put the ModelDeclarationStatement in the context
		
		return null;
	}
	
	private ModelDeclarationParameter fetchSourceParameter(ModelDeclarationStatement statement)
	{
		ModelDeclarationParameter result = null; //declare result
		for(ModelDeclarationParameter parameter: statement.getParameters()) //loop through ModelDeclarationParameters
		{
			if (parameter.getName().getName().equals("metamodel")) { //if parameter 'metamodel' is found
				result = parameter; //set result and break
				break;
			}
		}
		return result;
	}
	

}
