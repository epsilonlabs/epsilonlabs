package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.BagType;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.OrderedSetType;
import org.eclipse.epsilon.eol.dom.SequenceType;
import org.eclipse.epsilon.eol.dom.SetType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class CollectionFirstAndLastOperationHandler extends CollectionOperationDefinitionHandler{

	public CollectionFirstAndLastOperationHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return (name.equals("first") || name.equals("last")) && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);

		CollectionType targetType = (CollectionType) featureCallExpression.getTarget().getResolvedType();
		
		if (!(targetType instanceof SequenceType || targetType instanceof OrderedSetType || targetType instanceof SetType || targetType instanceof BagType)) {
			context.getLogBook().addError(featureCallExpression.getTarget(), "Operation invert() can only be performed on collection types");
		}
		else {
			if (!(targetType.getContentType() instanceof AnyType)) { //if content type is not any
				Type contentType = targetType.getContentType();
				result.setReturnType(EcoreUtil.copy(contentType));
			}
			
		}
		return result;

	}

}
