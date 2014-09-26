package org.eclipse.epsilon.evl.visitor.resolution.type.hanlder;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler.AnyOperationDefinitionHandler;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.evl.metamodel.Invariant;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;

public class SatisfiesHandler extends AnyOperationDefinitionHandler{

	public SatisfiesHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("satisfies") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		
		//get the standard library operation definition contianer (quite a long name i know...)
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = null;
		
		result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		String satisfiesString = null;
		Expression arg = null;
		
		MethodCallExpression mce = (MethodCallExpression) featureCallExpression;
		if (mce.getArguments().size() != 1) {
			context.getLogBook().addError(mce, "operation satisfies() can only have one argument");
		}
		else {
			arg = mce.getArguments().get(0);
			if (arg instanceof StringExpression) {
				satisfiesString = ((StringExpression)arg).getVal();
			}
			else {
				context.getLogBook().addWarning(arg, "use of String literal is recommended");
			}
		}
		
		EvlTypeResolutionContext leContext = (EvlTypeResolutionContext) context;
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
		
		return null;
	}

}
