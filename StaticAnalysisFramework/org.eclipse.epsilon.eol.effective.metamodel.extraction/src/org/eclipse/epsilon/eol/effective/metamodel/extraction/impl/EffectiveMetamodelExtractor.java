package org.eclipse.epsilon.eol.effective.metamodel.extraction.impl;

import org.eclipse.epsilon.eol.effective.metamodel.extraction.context.EffectiveMetamodelExtractionContext;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.impl.ModelDeclarationStatementTypeResolver;

public class EffectiveMetamodelExtractor {

	protected EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	protected EffectiveMetamodelExtractionContext context = new EffectiveMetamodelExtractionContext();
	
	public EffectiveMetamodelExtractor()
	{
		controller.addDefaultVisitor(new EolDefaultVisitor<TypeResolutionContext, Object>());
		controller.addEOLModuleVisitor(new EOLModuleEME());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionEME());
		
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementTypeResolver());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionEME());
		controller.addOperationDefinitionVisitor(new OperationDefinitionEME());
		controller.addAssignmentStatementVisitor(new AssignmentStatementEME());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionEME());
		controller.addForStatementVisitor(new ForStatementEME());
	}
	
	public void run(EOLElement eolElement)
	{
		controller.visit(eolElement, context);
	}
	
	public EffectiveMetamodelExtractionContext getEffectiveMetamodelExtractionContext()
	{
		return context;
	}
}
