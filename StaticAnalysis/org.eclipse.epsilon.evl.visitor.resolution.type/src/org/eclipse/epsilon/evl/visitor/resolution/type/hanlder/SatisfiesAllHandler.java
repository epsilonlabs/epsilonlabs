package org.eclipse.epsilon.evl.visitor.resolution.type.hanlder;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.ExprList;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.SequenceExpression;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler.AnyOperationDefinitionHandler;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.evl.metamodel.Invariant;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;

public class SatisfiesAllHandler extends AnyOperationDefinitionHandler{

	public SatisfiesAllHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("satisfiesAll");
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		
		//get the standard library operation definition contianer (quite a long name i know...)
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = null;
		
		result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		EvlTypeResolutionContext leContext = (EvlTypeResolutionContext) context;
		
		Expression arg = null;
		
		MethodCallExpression mce = (MethodCallExpression) featureCallExpression;
		if (mce.getArguments().size() != 1) {
			context.getLogBook().addError(mce, "operation satisfiesAll() must have only one arugment as a sequence");
		}
		else {
			arg = mce.getArguments().get(0);
			if (arg instanceof SequenceExpression ) {
				SequenceExpression seq = (SequenceExpression) arg;
				if (seq.getParameterList() instanceof ExprList) {
					ExprList exprList = (ExprList) seq.getParameterList();
					for(Expression exp: exprList.getExpressions())
					{
						if (exp instanceof StringExpression) {
							String satisfiesString = ((StringExpression) exp).getVal();
							Invariant resolvedInvariant = leContext.getInv(leContext.getCurrentContext(), satisfiesString);
							if (resolvedInvariant != null) {
								Invariant currentInvariant = leContext.getCurrentInvariant();
								if (currentInvariant.getSatisfies() != null) {
									currentInvariant.getSatisfies().add(resolvedInvariant);
								}
								else {
									context.getLogBook().addError(currentInvariant, "resolved inv empty, please initialise first");
								}
							}
							else {
								context.getLogBook().addError(arg, "cannot resolve the depending invariant");
							}
						}
						else {
							context.getLogBook().addError(exp, "expression should be String");
						}
					}
				}
				else {
					context.getLogBook().addError(seq.getParameterList(), "parameters should be string values");
				}
				
			}
			else {
				context.getLogBook().addError(arg, "argument must be sequence");
			}
		}
		
		
		
		return null;
	}

}
