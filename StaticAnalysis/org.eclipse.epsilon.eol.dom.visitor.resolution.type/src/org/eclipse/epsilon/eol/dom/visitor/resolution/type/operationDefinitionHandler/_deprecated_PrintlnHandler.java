package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class _deprecated_PrintlnHandler extends AnyOperationDefinitionHandler{

	public _deprecated_PrintlnHandler(TypeResolutionContext context) {
		super(context);
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("println") && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		
		EolFactory factory = context.getEolFactory();
		
		OperationDefinition result = factory.createOperationDefinition();
		
		NameExpression opName = factory.createNameExpression();
		opName.setName("println");
		result.setName(opName);
		
		result.setContextType(factory.createAnyType());
		
		
		TextRegion region = EolFactory.eINSTANCE.createTextRegion();
		TextPosition start = EolFactory.eINSTANCE.createTextPosition();
		start.setLine(0);
		start.setColumn(0);
		region.setStart(start);
		
		TextPosition end = EolFactory.eINSTANCE.createTextPosition();
		end.setLine(0);
		end.setColumn(1);
		region.setEnd(end);
		
		result.setRegion(region);


		Type targetType = featureCallExpression.getTarget().getResolvedType();
		if (targetType instanceof AnyType) {
			AnyType temp = (AnyType) targetType;
			if (temp.getDynamicType() != null) {
				result.setReturnType(EcoreUtil.copy(temp.getDynamicType()));
			}
			else {
				result.setReturnType(EcoreUtil.copy(featureCallExpression.getTarget().getResolvedType()));
			}
		}
		else {
			result.setReturnType(EcoreUtil.copy(featureCallExpression.getTarget().getResolvedType()));
		}
		
		return result;
	}
}

