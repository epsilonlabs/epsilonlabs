package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class ForStatementTypeResolver extends ForStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		context.getTypeRegistry().pushScope(forStatement);//////////
		
		
		controller.visit(forStatement.getIterator(), context);
		controller.visit(forStatement.getCondition(), context);
		
		FormalParameterExpression iterator = forStatement.getIterator();
		Expression condition = forStatement.getCondition();
		
		//if condition is collection type
		if (condition.getResolvedType() instanceof CollectionType) {
			CollectionType conditionType = (CollectionType) condition.getResolvedType();
			Type contentType = null;
			//if content typs is not null
			if (conditionType.getContentType() != null) {
				//copy content type
				contentType = EcoreUtil.copy(conditionType.getContentType());
				//if iterator does not have a type, assign type and report error
				
				AnyType iteratorType = (AnyType) iterator.getResolvedType();
				
				if (iteratorType == null) {
					LogBook.getInstance().addError(forStatement.getIterator(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
					iterator.setResolvedType(contentType);
					context.setAssets(contentType, iterator);	
				}
				
				if (TypeUtil.getInstance().isInstanceofAnyType(iteratorType)) {
					if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
						AnyType _contentType = (AnyType) contentType;
						iteratorType.getDynamicTypes().addAll(_contentType.getDynamicTypes());
					}
					else {
						iteratorType.getDynamicTypes().add(contentType);	
					}
					context.getTypeRegistry().assignType(iterator, iteratorType);
				}
				else {
					if (TypeUtil.getInstance().isTypeEqualOrGeneric(iterator, contentType)) {
						
					}
					else {
						LogBook.getInstance().addError(forStatement.getIterator(), IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH);
						iterator.setResolvedType(contentType);
						context.setAssets(contentType, iterator);	
					}
				}
			}
			else {
				//if conditon does not have a content type, report error
				LogBook.getInstance().addError(forStatement.getContainer(), IMessage_TypeResolution.COLLECTION_EXPRESSION_NO_CONTENT_TYPE);
				iterator.setResolvedType(EolFactory.eINSTANCE.createAnyType());
			}
		}
		else {
			//if condition is AnyType, check dynamic type, report error if necessary
			if (TypeUtil.getInstance().isInstanceofAnyType(condition.getResolvedType())) {
				AnyType conditionType = (AnyType) condition.getResolvedType();
				if (!TypeInferenceManager.getInstance().containsDynamicType(conditionType, EolPackage.eINSTANCE.getCollectionType())) {
					LogBook.getInstance().addError(condition, IMessage_TypeResolution.FOR_STMT_CONDITION_NOT_COLLECTION_TYPE);
				}
				else {
					ArrayList<Type> dyntypes = TypeInferenceManager.getInstance().getDynamicTypes(conditionType, EolPackage.eINSTANCE.getCollectionType());
					if (dyntypes.size() == 1) {

						CollectionType _conditionType = (CollectionType) dyntypes.get(0);
						Type contentType = null;
						//if content typs is not null
						if (_conditionType.getContentType() != null) {
							//copy content type
							contentType = EcoreUtil.copy(_conditionType.getContentType());
							//if iterator does not have a type, assign type and report error
							
							AnyType iteratorType = (AnyType) iterator.getResolvedType();
							
							if (iteratorType == null) {
								LogBook.getInstance().addError(forStatement.getIterator(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
								iterator.setResolvedType(contentType);
								context.setAssets(contentType, iterator);	
							}
							
							if (TypeUtil.getInstance().isInstanceofAnyType(iteratorType)) {
								if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
									AnyType _contentType = (AnyType) contentType;
									iteratorType.getDynamicTypes().addAll(_contentType.getDynamicTypes());
								}
								else {
									iteratorType.getDynamicTypes().add(contentType);	
								}
								context.getTypeRegistry().assignType(iterator, iteratorType);
							}
							else {
								if (TypeUtil.getInstance().isTypeEqualOrGeneric(iterator, contentType)) {
									
								}
								else {
									LogBook.getInstance().addError(forStatement.getIterator(), IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH);
									iterator.setResolvedType(contentType);
									context.setAssets(contentType, iterator);	
								}
							}
						}
						else {
							//if conditon does not have a content type, report error
							LogBook.getInstance().addError(forStatement.getContainer(), IMessage_TypeResolution.COLLECTION_EXPRESSION_NO_CONTENT_TYPE);
							iterator.setResolvedType(EolFactory.eINSTANCE.createAnyType());
						}
					
					}
					else {
						AnyType iteratorType = EolFactory.eINSTANCE.createAnyType();
						for(Type t: dyntypes)
						{
							CollectionType _conditionType = (CollectionType) t;
							AnyType contentType = (AnyType) _conditionType.getContentType();
							if (contentType != null) {
								if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
									iteratorType.getDynamicTypes().addAll(EcoreUtil.copy(contentType).getDynamicTypes());
								}
								else {
									iteratorType.getDynamicTypes().add(EcoreUtil.copy(contentType));
								}
							}
						}
						iterator.setResolvedType(iteratorType);
						context.setAssets(iteratorType, iterator);
						context.getTypeRegistry().assignType(iterator, iteratorType);
					}
				}
			}
			LogBook.getInstance().addError(condition, IMessage_TypeResolution.FOR_STMT_CONDITION_NOT_COLLECTION_TYPE);
			iterator.setResolvedType(EolFactory.eINSTANCE.createAnyType());
		}
		
		
		controller.visit(forStatement.getBody(), context);
		
		context.getTypeRegistry().popScope();//////////
		

		return null;
	}
}
