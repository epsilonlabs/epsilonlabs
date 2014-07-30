package org.eclipse.epsilon.etl.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.eclipse.epsilon.eol.visitor.printer.impl.AbortStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.AndOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.AnnotationBlockPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.AnyTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.AssignmentStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BagExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BagTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BlockPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BooleanExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BooleanTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BreakAllStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.BreakStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ContinueStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.DeleteStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.DivideOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.EnumerationLiteralExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.EolProgramPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.EqualsOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ExecutableAnnotationPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ExpRangePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ExprListPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ExpressionOrStatementBlockPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ExpressionStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.FOLMethodCallExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ForStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.FormalParameterExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.GreaterThanOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.GreaterThanOrEqualToOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.IfStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ImpliesOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ImportPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.IntegerExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.IntegerTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.KeyValuePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.LessThanOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.LessThanOrEqualToOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.MapExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.MapTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.MethodCallExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.MinusOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ModelDeclarationParameterPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ModelDeclarationStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ModelElementTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.MultiplyOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.NameExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.NativeTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.NegativeOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.NewExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.NotEqualsOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.NotOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.OperationDefinitionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.OrOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.OrderedSetExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.OrderedSetTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.PlusOperatorExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.PropertyCallExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.RealExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.RealTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ReturnStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SequenceExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SequenceTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SetExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SetTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SimpleAnnotationPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.StringExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.StringTypePrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SwitchCaseDefaultStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SwitchCaseExpressionStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.SwitchStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.ThrowStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.TransactionStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.VariableDeclarationExpressionPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.WhileStatementPrinter;
import org.eclipse.epsilon.eol.visitor.printer.impl.XorOperatorExpressionPrinter;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;

public class EtlPrinter{

	protected EtlVisitorController<PrinterContext, Object> controller = new EtlVisitorController<PrinterContext, Object>();
	protected PrinterContext context = new PrinterContext();
	protected String printedProgram = "";

	public EtlPrinter()
	{
		controller.addAbortStatementVisitor(new AbortStatementPrinter());
		controller.addAndOperatorExpressionVisitor(new AndOperatorExpressionPrinter());
		controller.addAnnotationBlockVisitor(new AnnotationBlockPrinter());
		controller.addAnyTypeVisitor(new AnyTypePrinter());
		controller.addAssignmentStatementVisitor(new AssignmentStatementPrinter());
		controller.addBagExpressionVisitor(new BagExpressionPrinter());
		controller.addBagTypeVisitor(new BagTypePrinter());
		controller.addBlockVisitor(new BlockPrinter());
		controller.addBooleanExpressionVisitor(new BooleanExpressionPrinter());
		controller.addBooleanTypeVisitor(new BooleanTypePrinter());
		controller.addBreakAllStatementVisitor(new BreakAllStatementPrinter());
		controller.addBreakStatementVisitor(new BreakStatementPrinter());
		controller.addContinueStatementVisitor(new ContinueStatementPrinter());
		controller.addDeleteStatementVisitor(new DeleteStatementPrinter());
		controller.addDivideOperatorExpressionVisitor(new DivideOperatorExpressionPrinter());
		controller.addEnumerationLiteralExpressionVisitor(new EnumerationLiteralExpressionPrinter());
		controller.addEolProgramVisitor(new EolProgramPrinter());
		controller.addEqualsOperatorExpressionVisitor(new EqualsOperatorExpressionPrinter());
		controller.addExecutableAnnotationVisitor(new ExecutableAnnotationPrinter());
		controller.addExpRangeVisitor(new ExpRangePrinter());
		controller.addExpressionStatementVisitor(new ExpressionStatementPrinter());
		controller.addExprListVisitor(new ExprListPrinter());
		controller.addExpressionOrStatementBlockVisitor(new ExpressionOrStatementBlockPrinter());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionPrinter());
		controller.addFormalParameterExpressionVisitor(new FormalParameterExpressionPrinter());
		controller.addForStatementVisitor(new ForStatementPrinter());
		controller.addGreaterThanOperatorExpressionVisitor(new GreaterThanOperatorExpressionPrinter());
		controller.addGreaterThanOrEqualToOperatorExpressionVisitor(new GreaterThanOrEqualToOperatorExpressionPrinter());
		controller.addIfStatementVisitor(new IfStatementPrinter());
		controller.addImpliesOperatorExpressionVisitor(new ImpliesOperatorExpressionPrinter());
		controller.addImportVisitor(new ImportPrinter());
		controller.addIntegerExpressionVisitor(new IntegerExpressionPrinter());
		controller.addIntegerTypeVisitor(new IntegerTypePrinter());
		controller.addKeyValueVisitor(new KeyValuePrinter());
		controller.addLessThanOperatorExpressionVisitor(new LessThanOperatorExpressionPrinter());
		controller.addLessThanOrEqualToOperatorExpressionVisitor(new LessThanOrEqualToOperatorExpressionPrinter());
		controller.addMapExpressionVisitor(new MapExpressionPrinter());
		controller.addMapTypeVisitor(new MapTypePrinter());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionPrinter());
		controller.addMinusOperatorExpressionVisitor(new MinusOperatorExpressionPrinter());
		controller.addModelDeclarationParameterVisitor(new ModelDeclarationParameterPrinter());
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementPrinter());
		controller.addModelElementTypeVisitor(new ModelElementTypePrinter());
		controller.addMultiplyOperatorExpressionVisitor(new MultiplyOperatorExpressionPrinter());
		controller.addNameExpressionVisitor(new NameExpressionPrinter());
		controller.addNativeTypeVisitor(new NativeTypePrinter());
		controller.addNegativeOperatorExpressionVisitor(new NegativeOperatorExpressionPrinter());
		controller.addNewExpressionVisitor(new NewExpressionPrinter());
		controller.addNotEqualsOperatorExpressionVisitor(new NotEqualsOperatorExpressionPrinter());
		controller.addNotOperatorExpressionVisitor(new NotOperatorExpressionPrinter());
		controller.addOperationDefinitionVisitor(new OperationDefinitionPrinter());
		controller.addOrderedSetExpressionVisitor(new OrderedSetExpressionPrinter());
		controller.addOrderedSetTypeVisitor(new OrderedSetTypePrinter());
		controller.addOrOperatorExpressionVisitor(new OrOperatorExpressionPrinter());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionPrinter());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionPrinter());
		controller.addRealExpressionVisitor(new RealExpressionPrinter());
		controller.addRealTypeVisitor(new RealTypePrinter());
		controller.addReturnStatementVisitor(new ReturnStatementPrinter());
		controller.addSequenceExpressionVisitor(new SequenceExpressionPrinter());
		controller.addSequenceTypeVisitor(new SequenceTypePrinter());
		controller.addSetExpressionVisitor(new SetExpressionPrinter());
		controller.addSetTypeVisitor(new SetTypePrinter());
		controller.addSimpleAnnotationVisitor(new SimpleAnnotationPrinter());
		controller.addStringExpressionVisitor(new StringExpressionPrinter());
		controller.addStringTypeVisitor(new StringTypePrinter());
		controller.addSwitchCaseDefaultStatementVisitor(new SwitchCaseDefaultStatementPrinter());
		controller.addSwitchCaseExpressionStatementVisitor(new SwitchCaseExpressionStatementPrinter());
		controller.addSwitchStatementVisitor(new SwitchStatementPrinter());
		controller.addThrowStatementVisitor(new ThrowStatementPrinter());
		controller.addTransactionStatementVisitor(new TransactionStatementPrinter());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionPrinter());
		controller.addWhileStatementVisitor(new WhileStatementPrinter());
		controller.addXorOperatorExpressionVisitor(new XorOperatorExpressionPrinter());
		
		controller.addPreBlockVisitor(new PreBlockPrinter());
		controller.addPostBlockVisitor(new PostBlockPrinter());
		controller.addTransformationRuleVisitor(new TransformationRulePrinter());
		controller.addGuardVisitor(new GuardPrinter());
		controller.addEtlProgramVisitor(new EtlProgramPrinter());
	}
	
	
	
	public void run(EolElement eolElement)
	{
		printedProgram = (String) controller.visit(eolElement, context);
	}
	
	public String getPrintedProgram() {
		return printedProgram;
	}

	
}
