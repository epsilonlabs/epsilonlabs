package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.EolFactory;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.TextPosition;
import org.eclipse.epsilon.eol.dom.TextRegion;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class AbstractPrintHanlder  {
/*
	public AbstractPrintHanlder(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return ((name.equals("print") ||
				name.equals("println") ||
				name.equals("err") ||
				name.equals("errln")) 
				&& 
				(argTypes.size() == 0 || argTypes.size() == 1));
	}

	@Override
	public OperationDefinition handle(
			MethodCallExpression methodCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(methodCallExpression.getMethod().getName(), argTypes);

		Type targetType = methodCallExpression.getTarget().getResolvedType();
		if (targetType instanceof AnyType) {
			AnyType temp = (AnyType) targetType;
			if (temp.getTempType() != null) {
				result.setReturnType(EcoreUtil.copy(temp.getTempType()));
			}
			else {
				result.setReturnType(EcoreUtil.copy(targetType));
			}
		}
		else {
			result.setReturnType(EcoreUtil.copy(targetType));
		}
		
		return result;
	}
*/
}
