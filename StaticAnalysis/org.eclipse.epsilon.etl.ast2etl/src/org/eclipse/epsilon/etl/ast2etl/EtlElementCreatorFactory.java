package org.eclipse.epsilon.etl.ast2etl;


import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.AbortStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.AndOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.AnnotationBlockCreator;
import org.eclipse.epsilon.eol.ast2eol.AnnotationCreator;
import org.eclipse.epsilon.eol.ast2eol.AnyTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.AssignmentStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.BagExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.BagTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.BlockCreator;
import org.eclipse.epsilon.eol.ast2eol.BooleanExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.BooleanTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.BreakAllStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.BreakStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.CollectionInitValueCreator;
import org.eclipse.epsilon.eol.ast2eol.CollectionTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.ContinueStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.DeleteStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.DivideOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.EnumerationLiteralExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.EolElementCreator;
import org.eclipse.epsilon.eol.ast2eol.EqualsOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.ExecutableAnnotationCreator;
import org.eclipse.epsilon.eol.ast2eol.ExpRangeCreator;
import org.eclipse.epsilon.eol.ast2eol.ExprListCreator;
import org.eclipse.epsilon.eol.ast2eol.ExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.ExpressionStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.FOLMethodCallExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.FeatureCallExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.ForStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.FormalParameterExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.GreaterThanOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.GreaterThanOrEqualToOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.IfStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.ImpliesOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.ImportCreator;
import org.eclipse.epsilon.eol.ast2eol.IntegerExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.IntegerTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.KeyValueCreator;
import org.eclipse.epsilon.eol.ast2eol.LessThanOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.LessThanOrEqualToOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.LiteralExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.MapExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.MapTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.MethodCallExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.MinusOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.ModelDeclarationParameterCreator;
import org.eclipse.epsilon.eol.ast2eol.ModelDeclarationStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.ModelElementTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.ModelExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.MultiplyOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.NameExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.NativeExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.NativeTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.NegativeOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.NewExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.NotEqualsOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.NotOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.OperationArgTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.OperationDefinitionCreator;
import org.eclipse.epsilon.eol.ast2eol.OperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.OrOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.OrderedSetExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.OrderedSetTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.PlusOperatorExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.PropertyCallExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.RealExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.RealTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.ReturnStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.SelfContentTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.SelfInnerMostTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.SelfTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.SequenceExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.SequenceTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.SetExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.SetTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.SimpleAnnotationCreator;
import org.eclipse.epsilon.eol.ast2eol.SpecialAssignmentStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.StatementCreator;
import org.eclipse.epsilon.eol.ast2eol.StringExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.StringTypeCreator;
import org.eclipse.epsilon.eol.ast2eol.SwitchCaseDefaultCreator;
import org.eclipse.epsilon.eol.ast2eol.SwitchCaseExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.SwitchStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.ThrowStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.TransactionStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.TypeCreator;
import org.eclipse.epsilon.eol.ast2eol.VariableDeclarationExpressionCreator;
import org.eclipse.epsilon.eol.ast2eol.WhileStatementCreator;
import org.eclipse.epsilon.eol.ast2eol.XorOperatorExpressionCreator;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class EtlElementCreatorFactory {
	
	
	ArrayList<EolElement> createdEolElements;
	ArrayList<EolElementCreator> domElementCreators;
	String directoryPathString = null;

	public EtlElementCreatorFactory()
	{
		createdEolElements = new ArrayList<EolElement>();
		domElementCreators = new ArrayList<EolElementCreator>();
		initialiseDomElementCreators();
	}
	
	public EtlElementCreatorFactory(String directoryPath)
	{
		createdEolElements = new ArrayList<EolElement>();
		domElementCreators = new ArrayList<EolElementCreator>();
		directoryPathString = directoryPath;
		initialiseDomElementCreators();
	}
	
	public void initialiseDomElementCreators()
	{
		domElementCreators.addAll(this.initiateDomElementPool());
	}
	
	public EolElement createDomElement(AST ast, EolElement container, Ast2EtlContext context)
	{
		EolElement result = null;
		for(EolElementCreator dec: domElementCreators)
		{
			if(dec.appliesTo(ast))
			{
				result = dec.create(ast, container, context);
				//System.out.println(dec.getClass());
				break;
			}
		}
		
		if(result == null)
		{
			throw new RuntimeException("Cannot create dom element for " + ast.getText() + "->" + ast.getType() + ": " + ast.getLine() + "-" + ast.getColumn());
		}
		else {
			context.getTrace().put(result, ast);
			this.addCreatedDomElements(result);
			return result;
		}
	}
	
	public EolElement createDomElement(AST ast, EolElement container, Ast2EtlContext context, Class<? extends EolElementCreator> ofCreatorClass)
	{
		EolElement result = null;
		for(EolElementCreator dec: domElementCreators)
		{
			if(ofCreatorClass == dec.getClass())
			{
				result = dec.create(ast, container, context);
				break;
			}
		}
		if(result == null)
		{
			throw new RuntimeException("Cannot fetch creator for class: " + ofCreatorClass.toString());
		}
		else {
			this.addCreatedDomElements(result);
			return result;
		}
	}
	
	protected Statement createStatement(AST ast, EolElement container, Ast2EtlContext context) {
		Statement statement = null;
		
		if(ast.getText().equals("="))
		{
			AssignmentStatementCreator asc = fetchAssignmentStatementCreator();
			
			statement = (Statement) asc.create(ast, container, context);
		}
		
		else {
			//DomElement e = createDomElement(ast, container, context);
			if (isStatement(ast)) {
				return (Statement)createDomElement(ast, container, context);
			}
			else {
				ExpressionStatementCreator esc = fetchExpressionStatementCreator();
				statement = (Statement) esc.create(ast, container, context);
			}
		}
		
		return statement;
	}
	
	public ArrayList<TypeCreator> initiateTypePool()
	{
		ArrayList<TypeCreator> result = new ArrayList<TypeCreator>();
		result.add(new TypeCreator());
		result.add(new CollectionTypeCreator());
		result.add(new AnyTypeCreator());
		
		result.add(new BagTypeCreator());
		result.add(new OrderedSetTypeCreator());
		result.add(new SequenceTypeCreator());
		result.add(new SetTypeCreator());
		
		result.add(new MapTypeCreator());
		
		result.add(new ModelElementTypeCreator());
		
		result.add(new NativeTypeCreator());
		
		result.add(new BooleanTypeCreator());
		result.add(new IntegerTypeCreator());
		result.add(new RealTypeCreator());
		result.add(new StringTypeCreator());
		
		result.add(new SelfTypeCreator());
		result.add(new SelfContentTypeCreator());
		result.add(new OperationArgTypeCreator());
		result.add(new SelfInnerMostTypeCreator());
		
		return result;
	}
	
	public ArrayList<EolElementCreator> initiateDomElementPool()
	{
		ArrayList<EolElementCreator> result = new ArrayList<EolElementCreator>();
		result.add(new AnnotationBlockCreator());
		result.addAll(this.initiateAnnotationPool());
		result.add(new BlockCreator());
		result.addAll(initiateCollectionInitValuePool());
		result.addAll(initiateExpressionPool());
		result.add(new ImportCreator());
		result.add(new KeyValueCreator());
		result.add(new ModelDeclarationParameterCreator());
		result.add(new EtlProgramCreator());
		result.add(new OperationDefinitionCreator());
		result.addAll(this.initiateStatementPool());
		result.addAll(this.initiateTypePool());
		
		result.add(new TransformationRuleCreator());
		result.add(new PreBlockCreator());
		result.add(new PostBlockCreator());
		result.add(new GuardCreator());

		return result;
	}
	
	public ArrayList<AnnotationCreator> initiateAnnotationPool()
	{
		ArrayList<AnnotationCreator> result = new ArrayList<AnnotationCreator>();
		result.add(new ExecutableAnnotationCreator());
		result.add(new SimpleAnnotationCreator());
		
		return result;
	}
	
	
	public ArrayList<ExpressionCreator> initiateExpressionPool()
	{
		ArrayList<ExpressionCreator> result = new ArrayList<ExpressionCreator>();
		result.add(new EnumerationLiteralExpressionCreator());
		result.addAll(this.initiateFeatureCallPool());
		result.add(new FormalParameterExpressionCreator());
		result.addAll(this.initiateLiteralExpressionPool());
		result.add(new NameExpressionCreator());
		result.add(new NewExpressionCreator());
		result.addAll(this.initiateOperatorExpressionPool());
		result.add(new VariableDeclarationExpressionCreator());
		result.add(new ModelExpressionCreator());
		result.add(new NativeExpressionCreator());
		
		return result;
	}
	
	public ArrayList<CollectionInitValueCreator> initiateCollectionInitValuePool()
	{
		ArrayList<CollectionInitValueCreator> result = new ArrayList<CollectionInitValueCreator>();
		result.add(new ExpRangeCreator());
		result.add(new ExprListCreator());
		
		return result;
	}
	
	public ArrayList<FeatureCallExpressionCreator> initiateFeatureCallPool()
	{
		ArrayList<FeatureCallExpressionCreator> result = new ArrayList<FeatureCallExpressionCreator>();
		result.add(new MethodCallExpressionCreator());
		result.add(new FOLMethodCallExpressionCreator());
		result.add(new PropertyCallExpressionCreator());
		
		return result;
	}

	public ArrayList<LiteralExpressionCreator> initiateLiteralExpressionPool()
	{
		ArrayList<LiteralExpressionCreator> result = new ArrayList<LiteralExpressionCreator>();
		result.add(new BagExpressionCreator());
		result.add(new OrderedSetExpressionCreator());
		result.add(new SequenceExpressionCreator());
		result.add(new SetExpressionCreator());
		
		result.add(new MapExpressionCreator());
		
		result.add(new BooleanExpressionCreator());
		result.add(new IntegerExpressionCreator());
		result.add(new RealExpressionCreator());
		result.add(new StringExpressionCreator());
		
		return result;
	}

	
	public ArrayList<OperatorExpressionCreator> initiateOperatorExpressionPool()
	{
		ArrayList<OperatorExpressionCreator> result = new ArrayList<OperatorExpressionCreator>();
		
		result.add(new AndOperatorExpressionCreator());
		result.add(new DivideOperatorExpressionCreator());
		result.add(new EqualsOperatorExpressionCreator());
		result.add(new GreaterThanOperatorExpressionCreator());
		result.add(new GreaterThanOrEqualToOperatorExpressionCreator());
		result.add(new ImpliesOperatorExpressionCreator());
		result.add(new LessThanOperatorExpressionCreator());
		result.add(new LessThanOrEqualToOperatorExpressionCreator());
		result.add(new MinusOperatorExpressionCreator());
		result.add(new MultiplyOperatorExpressionCreator());
		result.add(new NotEqualsOperatorExpressionCreator());
		result.add(new OrOperatorExpressionCreator());
		result.add(new PlusOperatorExpressionCreator());
		result.add(new XorOperatorExpressionCreator());		
		
		result.add(new NegativeOperatorExpressionCreator());
		result.add(new NotOperatorExpressionCreator());
		return result;
	}
	
	public ArrayList<StatementCreator> initiateStatementPool()
	{
		ArrayList<StatementCreator> result = new ArrayList<StatementCreator>();
		result.add(new AbortStatementCreator());
		result.add(new AssignmentStatementCreator());
		result.add(new BreakAllStatementCreator());
		result.add(new BreakStatementCreator());
		result.add(new ContinueStatementCreator());
		result.add(new DeleteStatementCreator());
		result.add(new ExpressionStatementCreator());
		result.add(new ForStatementCreator());
		result.add(new IfStatementCreator());
		result.add(new ModelDeclarationStatementCreator());
		result.add(new ReturnStatementCreator());
		result.add(new SwitchStatementCreator());
		result.add(new SwitchCaseDefaultCreator());
		result.add(new SwitchCaseExpressionCreator());
		result.add(new ThrowStatementCreator());
		result.add(new TransactionStatementCreator());
		result.add(new WhileStatementCreator());
		result.add(new SpecialAssignmentStatementCreator());
		
		return result;
	}
	
	public AssignmentStatementCreator fetchAssignmentStatementCreator()
	{
		AssignmentStatementCreator result = null;
		for(EolElementCreator dec: domElementCreators)
		{
			if(dec instanceof AssignmentStatementCreator)
			{
				 result = (AssignmentStatementCreator) dec;
				 break;
			}
		}
		return result;
	}
	
	public ExpressionStatementCreator fetchExpressionStatementCreator()
	{
		ExpressionStatementCreator result = null;
		for(EolElementCreator dec: domElementCreators)
		{
			if(dec instanceof ExpressionStatementCreator)
			{
				 result = (ExpressionStatementCreator) dec;
				 break;
			}
		}
		return result;
	}
	
	public void addCreatedDomElements(EolElement e)
	{
		this.createdEolElements.add(e);
	}
	
	public boolean isProperlyContained()
	{
		boolean result = false;
		for(EolElement de: createdEolElements)
		{
			EolElement trace = de;
			while(!(de instanceof EtlProgram) && trace.getContainer() != null)
			{
				trace = trace.getContainer();
			}
			
			if(trace.equals(this.fetchEtlProgram()))
			{
				result = true;
			}
			else {
				result = false;
				System.err.println("The domElement is: " + trace.getClass());
				break;
			}
		}
		return result;
	}
	
	public Program fetchProgram()
	{
		Program result = null;
		for(EolElement de: createdEolElements)
		{
			if (de instanceof Program) {
				result = (Program) de;
			}
		}
		return result;
			
	}
	
	public EtlProgram fetchEtlProgram()
	{
		EtlProgram result = null;
		for(EolElement de: createdEolElements)
		{
			if (de instanceof EtlProgram) {
				result = (EtlProgram) de;
			}
		}
		return result;

	}
	
	public ArrayList<Integer> getStatementKeywords()
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(EtlParser.ABORT);
		result.add(EtlParser.ASSIGNMENT);
		result.add(EtlParser.SPECIAL_ASSIGNMENT);
		result.add(EtlParser.BREAK);
		result.add(EtlParser.BREAKALL);
		result.add(EtlParser.CONTINUE);
		result.add(EtlParser.DELETE);
		result.add(EtlParser.FOR);
		result.add(EtlParser.IF);
		result.add(EtlParser.MODELDECLARATION);
		result.add(EtlParser.RETURN);
		result.add(EtlParser.SWITCH);
		result.add(EtlParser.THROW);
		result.add(EtlParser.DEFAULT);
		result.add(EtlParser.CASE);
		result.add(EtlParser.TRANSACTION);
		result.add(EtlParser.WHILE);
		
		result.add(EtlParser.GUARD);
		return result;
	}
	
	//returns true if the ast is a statementAST
	public boolean isStatement(AST ast)
	{
		ArrayList<Integer> pool = getStatementKeywords();
		return pool.contains(ast.getType());
	}
	
	public String getDirectoryPathString()
	{
		return directoryPathString;
	}
	

}
