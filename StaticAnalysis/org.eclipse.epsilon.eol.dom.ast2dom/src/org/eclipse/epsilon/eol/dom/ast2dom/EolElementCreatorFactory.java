package org.eclipse.epsilon.eol.dom.ast2dom;


import java.util.LinkedList;


import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolElementCreatorFactory {
	
	
	LinkedList<DomElement> createdDomElements;
	LinkedList<EolElementCreator> domElementCreators;

	public EolElementCreatorFactory()
	{
		createdDomElements = new LinkedList<DomElement>();
		domElementCreators = new LinkedList<EolElementCreator>();
		initialiseDomElementCreators();
	}
	
	public void initialiseDomElementCreators()
	{
		 domElementCreators.addAll(this.initiateDomElementPool());
	}
	
	public DomElement createDomElement(AST ast, DomElement container, Ast2DomContext context)
	{
		DomElement result = null;
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
			this.addCreatedDomElements(result);
			return result;
		}
	}
	
	public DomElement createDomElement(AST ast, DomElement container, Ast2DomContext context, Class<? extends EolElementCreator> ofCreatorClass)
	{
		DomElement result = null;
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
	
	protected Statement createStatement(AST ast, DomElement container, Ast2DomContext context) {
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
	
	public LinkedList<TypeCreator> initiateTypePool()
	{
		LinkedList<TypeCreator> result = new LinkedList<TypeCreator>();
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
		
		return result;
	}
	
	public LinkedList<EolElementCreator> initiateDomElementPool()
	{
		LinkedList<EolElementCreator> result = new LinkedList<EolElementCreator>();
		result.add(new AnnotationBlockCreator());
		result.addAll(this.initiateAnnotationPool());
		result.add(new BlockCreator());
		result.addAll(initiateCollectionInitValuePool());
		result.addAll(initiateExpressionPool());
		result.add(new ImportCreator());
		result.add(new KeyValueCreator());
		result.add(new ModelDeclarationParameterCreator());
		result.add(new ProgramCreator());
		result.add(new OperationDefinitionCreator());
		result.addAll(this.initiateStatementPool());
		result.addAll(this.initiateTypePool());
		
		return result;
	}
	
	public LinkedList<AnnotationCreator> initiateAnnotationPool()
	{
		LinkedList<AnnotationCreator> result = new LinkedList<AnnotationCreator>();
		result.add(new ExecutableAnnotationCreator());
		result.add(new SimpleAnnotationCreator());
		
		return result;
	}
	
	
	public LinkedList<ExpressionCreator> initiateExpressionPool()
	{
		LinkedList<ExpressionCreator> result = new LinkedList<ExpressionCreator>();
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
	
	public LinkedList<CollectionInitValueCreator> initiateCollectionInitValuePool()
	{
		LinkedList<CollectionInitValueCreator> result = new LinkedList<CollectionInitValueCreator>();
		result.add(new ExpRangeCreator());
		result.add(new ExprListCreator());
		
		return result;
	}
	
	public LinkedList<FeatureCallExpressionCreator> initiateFeatureCallPool()
	{
		LinkedList<FeatureCallExpressionCreator> result = new LinkedList<FeatureCallExpressionCreator>();
		result.add(new MethodCallExpressionCreator());
		result.add(new FOLMethodCallExpressionCreator());
		result.add(new PropertyCallExpressionCreator());
		
		return result;
	}

	public LinkedList<LiteralExpressionCreator> initiateLiteralExpressionPool()
	{
		LinkedList<LiteralExpressionCreator> result = new LinkedList<LiteralExpressionCreator>();
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

	
	public LinkedList<OperatorExpressionCreator> initiateOperatorExpressionPool()
	{
		LinkedList<OperatorExpressionCreator> result = new LinkedList<OperatorExpressionCreator>();
		
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
	
	public LinkedList<StatementCreator> initiateStatementPool()
	{
		LinkedList<StatementCreator> result = new LinkedList<StatementCreator>();
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

	
	
	
	
	public void addCreatedDomElements(DomElement e)
	{
		this.createdDomElements.add(e);
	}
	
	public boolean isProperlyContained()
	{
		boolean result = false;
		for(DomElement de: createdDomElements)
		{
			DomElement trace = de;
			while(!(de instanceof Program) && trace.getContainer() != null)
			{
				trace = trace.getContainer();
			}
			
			if(trace.equals(this.fetchProgram()))
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
		for(DomElement de: createdDomElements)
		{
			if (de instanceof Program) {
				result = (Program) de;
			}
		}
		return result;
			
	}
	
	public LinkedList<Integer> getStatementKeywords()
	{
		LinkedList<Integer> result = new LinkedList<Integer>();
		result.add(EolParser.ABORT);
		result.add(EolParser.ASSIGNMENT);
		result.add(EolParser.SPECIAL_ASSIGNMENT);
		result.add(EolParser.BREAK);
		result.add(EolParser.BREAKALL);
		result.add(EolParser.CONTINUE);
		result.add(EolParser.DELETE);
		result.add(EolParser.FOR);
		result.add(EolParser.IF);
		result.add(EolParser.MODELDECLARATION);
		result.add(EolParser.RETURN);
		result.add(EolParser.SWITCH);
		result.add(EolParser.THROW);
		result.add(EolParser.DEFAULT);
		result.add(EolParser.CASE);
		result.add(EolParser.TRANSACTION);
		result.add(EolParser.WHILE);
		return result;
	}
	
	//returns true if the ast is a statementAST
	public boolean isStatement(AST ast)
	{
		LinkedList<Integer> pool = getStatementKeywords();
		return pool.contains(ast.getType());
	}
	

}
