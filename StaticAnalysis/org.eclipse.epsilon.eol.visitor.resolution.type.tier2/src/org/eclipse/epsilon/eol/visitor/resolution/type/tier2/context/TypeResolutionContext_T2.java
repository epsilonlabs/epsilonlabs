package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context;


import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.framestack.FrameStack;

public class TypeResolutionContext_T2 extends TypeResolutionContext{

	protected FrameStack stack = new FrameStack();
	protected ArrayList<VariableDeclarationExpression> unsafeVariables = new ArrayList<VariableDeclarationExpression>();
	
	
	public void addUnsafeVariable(VariableDeclarationExpression variableDeclarationExpression)
	{
		unsafeVariables.add(variableDeclarationExpression);
	}
	
	public boolean isSafeVariable(VariableDeclarationExpression variableDeclarationExpression)
	{
		return !unsafeVariables.contains(variableDeclarationExpression);
	}
	
	
	public TypeResolutionContext_T2()
	{
		super();
	}
	
	public FrameStack getStack() {
		return stack;
	}
	
	
}
