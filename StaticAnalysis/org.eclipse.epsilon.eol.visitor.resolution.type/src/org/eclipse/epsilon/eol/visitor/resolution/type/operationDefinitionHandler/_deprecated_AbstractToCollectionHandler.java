//package org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler;
//
//import java.util.ArrayList;
//
//import org.eclipse.emf.ecore.util.EcoreUtil;
//import org.eclipse.epsilon.eol.metamodel.*;
//import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
//import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
//
//public class _deprecated_AbstractToCollectionHandler extends AnyOperationDefinitionHandler{
//
//	public _deprecated_AbstractToCollectionHandler(TypeResolutionContext context) {
//		super(context);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
//		// TODO Auto-generated method stub
//		return ((name.equals("asBag") ||
//				name.equals("asSequence") ||
//				name.equals("asSet") ||
//				name.equals("asOrderedSet")) && argTypes.size() == 0);
//	}
//
//	@Override
//	public OperationDefinition handle(
//			FeatureCallExpression featureCallExpression, Type contextType,
//			ArrayList<Type> argTypes) {		
//		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer(); //get container
//		
//		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes); //get operation
//
//		CollectionType returnType = (CollectionType) result.getReturnType(); //get return type
//		
//		Type targetType = featureCallExpression.getTarget().getResolvedType(); //get target type
//		if (targetType instanceof AnyType) { //if target type is of any
//			AnyType temp = (AnyType) targetType; 
//			if (temp.getDynamicType() != null) { //if there is a temp type
//				returnType.setContentType(EcoreUtil.copy(temp.getDynamicType())); //set temp type
//				//result.setReturnType(EcoreUtil.copy(temp.getTempType()));
//			}
//			else {
//				returnType.setContentType(EcoreUtil.copy(targetType));
//			}
//		}
//		else {
//			if (targetType instanceof CollectionType) {
//				CollectionType temp = (CollectionType) targetType;
//				if (temp.getContentType() != null) {
//					returnType.setContentType(EcoreUtil.copy(temp.getContentType()));
//					//result.setReturnType(EcoreUtil.copy(methodCallExpression.getTarget().getResolvedType()));
//				}
//			}
//			else {
//				returnType.setContentType(EcoreUtil.copy(targetType));
//			}
//		}
//		
//		return result;
//	}
//
//}
