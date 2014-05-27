package org.eclipse.epsilon.etl.visitor.resolution.variable.impl;

import java.util.HashMap;

import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlProgramVisitor;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;

public class EtlProgramVariableResolver extends EtlProgramVisitor<VariableResolutionContext, Object>{
	
	public void resolveInheritance(EtlProgram etlProgram, VariableResolutionContext context)
	{
		HashMap<String, TransformationRule> map = new HashMap<String, TransformationRule>();
		for(TransformationRule rule: etlProgram.getTransformationRules())
		{
			String name = rule.getName().getName();
			if (map.containsKey(name)) {
				context.getLogBook().addError(rule, "rule with name" + name + " already exists");
			}
			map.put(rule.getName().getName(), rule);
		}
		
		for(TransformationRule rule: etlProgram.getTransformationRules())
		{
			if (rule.getExtends().size()>0) {
				for(NameExpression name: rule.getExtends())
				{
					if (map.containsKey(name.getName())) {
						rule.getResolvedParentRules().add(map.get(name.getName()));
						name.setResolvedContent(map.get(name.getName()));
					}
					else {
						context.getLogBook().addError(name, "rule does not exist");
					}
				}
			}
		}
	}

	@Override
	public Object visit(EtlProgram etlProgram,
			VariableResolutionContext context,
			EtlVisitorController<VariableResolutionContext, Object> controller) {
		//System.out.println("this is executed");
		
		if (context.getMainProgram() == null) { //if the program is the ETL in question (the main program)
			context.getStack().push(etlProgram, true); //insert a stack
			context.setMainProgram(etlProgram); //set the main program to be this one
		}
		
		for(Import imported : etlProgram.getImports())
		{
			controller.visit(imported, context); //visit each import statement and resolve the imported programs
		}
		for(PreBlock pre: etlProgram.getPreBlocks())
		{
			controller.visit(pre, context);
		}
		for(OperationDefinition op: etlProgram.getOperations())
		{
			controller.visit(op, context);
		}
		resolveInheritance(etlProgram, context);
		for(TransformationRule rule: etlProgram.getTransformationRules())
		{
			controller.visit(rule, context);
		}
		
		for(PostBlock post: etlProgram.getPostBlocks())
		{
			controller.visit(post, context);
		}

		return null;
	}

}
