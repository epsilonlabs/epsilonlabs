package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_CollectionIndexOfOperationHandler extends _deprecated_CollectionOperationDefinitionHandler{

	public _deprecated_CollectionIndexOfOperationHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("indexOf") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer(); //get operation container
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes); //get the raw operation definition

		CollectionType targetType = (CollectionType) featureCallExpression.getTarget().getResolvedType(); // get the target type
		
		if (!(targetType instanceof SequenceType || targetType instanceof OrderedSetType)) { //if target type is illegitimate
			context.getLogBook().addError(featureCallExpression.getTarget(), "Operation invert() can only be performed on Sequence and OrderedSet types");
		}
		else {
			if (targetType instanceof SequenceType) { //if target type is Sequence
				Type argType = argTypes.get(0); //get the parameter type
				Type contentType = ((SequenceType)targetType).getContentType(); //get the content type of the sequence
				if (contentType != null) { //if content type is not null
					if (!context.getTypeUtil().isEqualOrGeneric(argType, contentType)) { //is content type is compatible with the target
						context.getLogBook().addError(featureCallExpression.getTarget(), "The argument's type should be the Sequence's content type");
					}
					else {
						//should be ok
					}
				}
				result.setContextType(EcoreUtil.copy(targetType));
			}
			if (targetType instanceof OrderedSetType) {
				Type argType = argTypes.get(0);
				Type contentType = ((OrderedSetType)targetType).getContentType();
				if (contentType != null) {
					if (!context.getTypeUtil().isEqualOrGeneric(argType, contentType)) {
						context.getLogBook().addError(featureCallExpression.getTarget(), "The argument's type should be the OrderedSet's content type");
					}
				}
				result.setContextType(EcoreUtil.copy(targetType));
			}
		}
		return result;
	}

}
