package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.EolFactory;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.TextPosition;
import org.eclipse.epsilon.eol.dom.TextRegion;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class AbstractToCollectionHandler extends AnyOperationDefinitionHandler{

	public AbstractToCollectionHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return ((name.equals("asBag") ||
				name.equals("asSequence") ||
				name.equals("asSet") ||
				name.equals("asOrderedSet")) && argTypes.size() == 0);
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {		
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);

		CollectionType returnType = (CollectionType) result.getReturnType();
		
		Type targetType = featureCallExpression.getTarget().getResolvedType();
		if (targetType instanceof AnyType) {
			AnyType temp = (AnyType) targetType;
			if (temp.getTempType() != null) {
				returnType.setContentType(EcoreUtil.copy(temp.getTempType()));
				//result.setReturnType(EcoreUtil.copy(temp.getTempType()));
			}
			else {
				returnType.setContentType(EcoreUtil.copy(targetType));
			}
		}
		else {
			if (targetType instanceof CollectionType) {
				CollectionType temp = (CollectionType) targetType;
				if (temp.getContentType() != null) {
					returnType.setContentType(EcoreUtil.copy(temp.getContentType()));
					//result.setReturnType(EcoreUtil.copy(methodCallExpression.getTarget().getResolvedType()));
				}
			}
			else {
				returnType.setContentType(EcoreUtil.copy(targetType));
			}
		}
		
		return result;
	}

}
