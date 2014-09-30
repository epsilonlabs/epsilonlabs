package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.AssignmentStatementTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.BlockTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.CollectionExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.EnumerationLiteralExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ExpressionOrStatementBlockTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.FOLMethodCallExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ForStatementTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.FormalParameterExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.IfStatementTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ImportTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.LogicalOperatorExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.MethodCallExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.MinusOperatorExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ModelDeclarationStatementTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ModelElementTypeTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.NameExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.NegativeOperatorExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.NotOperatorExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.OperationDefinitionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.PlusOperatorExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ProgramTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.PropertyCallExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.ReturnStatementTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.SimpleAnnotationTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.SwitchStatementTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.VariableDeclarationExpressionTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.WhileStatementTypeResolver;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;

public class EvlTypeResolver {

	protected EvlVisitorController<TypeResolutionContext, Object> controller = new EvlVisitorController<TypeResolutionContext, Object>();
	protected EvlTypeResolutionContext context = null;
	
	public EvlTypeResolver(org.eclipse.epsilon.eol.EolLibraryModule module)
	{
		context = new EvlTypeResolutionContext(module);
		
		controller.addImportVisitor(new ImportTypeResolver());
		controller.addDefaultVisitor(new EolDefaultVisitor<TypeResolutionContext, Object>());
		controller.addEolProgramVisitor(new ProgramTypeResolver());
		controller.addBlockVisitor(new BlockTypeResolver());
		controller.addOperationDefinitionVisitor(new OperationDefinitionTypeResolver());
		controller.addReturnStatementVisitor(new ReturnStatementTypeResolver());

		controller.addAssignmentStatementVisitor(new AssignmentStatementTypeResolver());
		controller.addIfStatementVisitor(new IfStatementTypeResolver());
		controller.addForStatementVisitor(new ForStatementTypeResolver());
		controller.addWhileStatementVisitor(new WhileStatementTypeResolver());
		controller.addSwitchStatementVisitor(new SwitchStatementTypeResolver());
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementTypeResolver());

		controller.addEnumerationLiteralExpressionVisitor(new EnumerationLiteralExpressionTypeResolver());
		controller.addNameExpressionVisitor(new NameExpressionTypeResolver());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionTypeResolver());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionTypeResolver());
		controller.addBinaryOperatorExpressionVisitor(new LogicalOperatorExpressionTypeResolver());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionTypeResolver());
		controller.addMinusOperatorExpressionVisitor(new MinusOperatorExpressionTypeResolver());
		controller.addNotOperatorExpressionVisitor(new NotOperatorExpressionTypeResolver());
		controller.addNegativeOperatorExpressionVisitor(new NegativeOperatorExpressionTypeResolver());
		
		controller.addModelElementTypeVisitor(new ModelElementTypeTypeResolver());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionTypeResolver());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionTypeResolver());
		controller.addFormalParameterExpressionVisitor(new FormalParameterExpressionTypeResolver());

		controller.addSimpleAnnotationVisitor(new SimpleAnnotationTypeResolver());
		
		controller.addCollectionExpressionVisitor(new CollectionExpressionTypeResolver());
		controller.addExpressionOrStatementBlockVisitor(new ExpressionOrStatementBlockTypeResolver());
		
		
		controller.addEvlProgramVisitor(new EvlProgramTypeResolver());
		controller.addConstraintVisitor(new ConstraintTypeResolver());
		controller.addContextVisitor(new ContextTypeResolver());
		controller.addCritiqueVisitor(new CritiqueTypeResolver());
		controller.addFixVisitor(new FixTypeResolver());
		controller.addPostBlockVisitor(new PostBlockTypeResolver());
		controller.addPreBlockVisitor(new PreBlockTypeResolver());
	}
	
	public void run(EolElement eolElement)
	{
		controller.visit(eolElement, context);
	}
	
	public TypeResolutionContext getContext() {
		return context;
	}

}
