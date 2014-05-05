package org.eclipse.epsilon.eol.printer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.*;



public class EolElementPrinterFactory {
	
	protected int indentation = 0;
	
	protected HashMap<String, EolElementPrinter> map = new HashMap<String, EolElementPrinter>();
	
	
	public EolElementPrinterFactory()
	{
		initialiseEolElementPrinters();
	}
	
	public String print(EolElement e) {
		
		EolElementPrinter printer = null;
		
		printer = map.get(e.getClass().getName());
		
		if (printer == null) throw new RuntimeException("No printer for " + e); 
		
		String str = "";
		
		if (e instanceof Statement) {
			str = whitespace();
		}
		
		return str + printer.print(e, this);
	}
	
	public void initialiseEolElementPrinters()
	{
		map.put(AnnotationBlockImpl.class.getName(), new AnnotationBlockPrinter());
		map.put(SimpleAnnotationImpl.class.getName(), new SimpleAnnotationPrinter());
		map.put(ExecutableAnnotationImpl.class.getName(), new ExecutableAnnotationPrinter());
		map.put(BlockImpl.class.getName(), new BlockPrinter());
		map.put(ExpRangeImpl.class.getName(), new ExpRangePrinter());
		map.put(ExprListImpl.class.getName(), new ExprListPrinter());
		initialiseExpressionPrinters();
		map.put(ImportImpl.class.getName(), new ImportPrinter());
		map.put(ModelDeclarationParameterImpl.class.getName(), new ModelDeclarationParameterPrinter());
		map.put(KeyValueImpl.class.getName(), new KeyValuePrinter());
		map.put(OperationDefinitionImpl.class.getName(), new OperationDefinitionPrinter());
		map.put(ProgramImpl.class.getName(), new ProgramPrinter());
		initialiseStatementPrinters();
		initialiseTypePrinters();
	}
	
	
	public void initialiseExpressionPrinters()
	{
		
		map.put(EnumerationLiteralExpressionImpl.class.getName(), new EnumerationLiteralExpressionPrinter());
		map.put(FormalParameterExpressionImpl.class.getName(), new FormalParameterExpressionPrinter());
		initialiseLiteralExpressionPrinters();
		map.put(NameExpressionImpl.class.getName(), new NameExpressionPrinter());
		map.put(ModelExpressionImpl.class.getName(), new ModelExpressionPrinter());
		map.put(NewExpressionImpl.class.getName(), new NewExpressionPrinter());
		initialiseOperatorExpressionPrinters();
		map.put(VariableDeclarationExpressionImpl.class.getName(), new VariableDeclarationExpressionPrinter());
		initialiseFeatureCallExpressionPrinters();
	}
	
	public void initialiseOperatorExpressionPrinters()
	{
		initialiseBinaryOperatorExpressionPrinters();
		initialiseUnaryOperatorExpressionPrinters();
	}
	
	public void initialiseBinaryOperatorExpressionPrinters()
	{
		map.put(AndOperatorExpressionImpl.class.getName(), new AndOperatorExpressionPrinter());
		map.put(DivideOperatorExpressionImpl.class.getName(), new DivideOperatorExpressionPrinter());
		map.put(EqualsOperatorExpressionImpl.class.getName(), new EqualsOperatorExpressionPrinter());
		map.put(GreaterThanOperatorExpressionImpl.class.getName(), new GreaterThanOperatorExpressionPrinter());
		map.put(GreaterThanOrEqualToOperatorExpressionImpl.class.getName(), new GreaterThanOrEqualToOperatorExpressionPrinter());
		map.put(ImpliesOperatorExpressionImpl.class.getName(), new ImpliesOperatorExpressionPrinter());
		map.put(LessThanOperatorExpressionImpl.class.getName(), new LessThanOperatorExpressionPrinter());
		map.put(LessThanOrEqualToOperatorExpressionImpl.class.getName(), new LessThanOrEqualToOperatorExpressionPrinter());
		map.put(MinusOperatorExpressionImpl.class.getName(), new MinusOperatorExpressionPrinter());
		map.put(MultiplyOperatorExpressionImpl.class.getName(), new MultiplyOperatorExpressionPrinter());
		map.put(NotEqualsOperatorExpressionImpl.class.getName(), new NotEqualsOperatorExpressionPrinter());
		map.put(OrOperatorExpressionImpl.class.getName(), new OrOperatorExpressionPrinter());
		map.put(PlusOperatorExpressionImpl.class.getName(), new PlusOperatorExpressionPrinter());
		map.put(XorOperatorExpressionImpl.class.getName(), new XorOperatorExpressionPrinter());
	}
	
	public void initialiseFeatureCallExpressionPrinters()
	{
		map.put(FOLMethodCallExpressionImpl.class.getName(), new FOLMethodCallExpressionPrinter());
		map.put(MethodCallExpressionImpl.class.getName(), new MethodCallExpressionPrinter());
		map.put(PropertyCallExpressionImpl.class.getName(), new PropertyCallExpressionPrinter());
	}
	
	public void initialiseUnaryOperatorExpressionPrinters()
	{
		map.put(NegativeOperatorExpressionImpl.class.getName(), new NegativeOperatorExpressionPrinter());
		map.put(NotOperatorExpressionImpl.class.getName(), new NotOperatorExpressionPrinter());
	}
	
	public void initialiseLiteralExpressionPrinters()
	{
		initialiseCollectionExpressionPrinters();
		map.put(MapExpressionImpl.class.getName(), new MapExpressionPrinter());
		initialisePrimitiveExpressionPrinters();
	}
	
	public void initialiseCollectionExpressionPrinters()
	{
		map.put(BagExpressionImpl.class.getName(), new BagExpressionPrinter());
		map.put(OrderedSetExpressionImpl.class.getName(), new OrderedSetExpressionPrinter());
		map.put(SequenceExpressionImpl.class.getName(), new SequenceExpressionPrinter());
		map.put(SetExpressionImpl.class.getName(), new SetExpressionPrinter());
	}
	
	public void initialisePrimitiveExpressionPrinters()
	{
		map.put(BooleanExpressionImpl.class.getName(), new BooleanExpressionPrinter());
		map.put(IntegerExpressionImpl.class.getName(), new IntegerExpressionPrinter());
		map.put(RealExpressionImpl.class.getName(), new RealExpressionPrinter());
		map.put(StringExpressionImpl.class.getName(), new StringExpressionPrinter());
	}
	public void initialiseStatementPrinters()
	{
		map.put(AbortStatementImpl.class.getName(), new AbortStatementPrinter());
		map.put(AssignmentStatementImpl.class.getName(), new AssignmentStatementPrinter());
		map.put(BreakAllStatementImpl.class.getName(), new BreakAllStatementPrinter());
		map.put(BreakStatementImpl.class.getName(), new BreakStatementPrinter());
		map.put(ContinueStatementImpl.class.getName(), new ContinueStatementPrinter());
		map.put(DeleteStatementImpl.class.getName(), new DeleteStatementPrinter());
		map.put(ExpressionStatementImpl.class.getName(), new ExpressionStatementPrinter());
		map.put(ForStatementImpl.class.getName(), new ForStatementPrinter());
		map.put(IfStatementImpl.class.getName(), new IfStatementPrinter());
		map.put(ModelDeclarationStatementImpl.class.getName(), new ModelDeclarationStatementPrinter());
		map.put(ReturnStatementImpl.class.getName(), new ReturnStatementPrinter());
		map.put(SwitchCaseDefaultStatementImpl.class.getName(), new SwitchCaseDefaultStatementPrinter());
		map.put(SwitchCaseExpressionStatementImpl.class.getName(), new SwitchCaseExpressionPrinter());
		map.put(SwitchStatementImpl.class.getName(), new SwitchStatementPrinter());
		map.put(ThrowStatementImpl.class.getName(), new ThrowStatementPrinter());
		map.put(TransactionStatementImpl.class.getName(), new TransactionStatementPrinter());
		map.put(WhileStatementImpl.class.getName(), new WhileStatementPrinter());
	}
	
	public void initialiseTypePrinters()
	{		
		map.put(TypeImpl.class.getName(), new TypePrinter());
		map.put(AnyTypeImpl.class.getName(), new AnyTypePrinter());
		map.put(BagTypeImpl.class.getName(), new BagTypePrinter());
		map.put(OrderedSetTypeImpl.class.getName(), new OrderedSetTypePrinter());
		map.put(SequenceTypeImpl.class.getName(), new SequenceTypePrinter());
		map.put(SetTypeImpl.class.getName(), new SetTypePrinter());
		map.put(MapTypeImpl.class.getName(), new MapTypePrinter());
		map.put(ModelElementTypeImpl.class.getName(), new ModelElementTypePrinter());
		map.put(NativeTypeImpl.class.getName(), new NativeTypePrinter());
		map.put(BooleanTypeImpl.class.getName(), new BooleanTypePrinter());
		map.put(IntegerTypeImpl.class.getName(), new IntegerTypePrinter());
		map.put(RealTypeImpl.class.getName(), new RealTypePrinter());
		map.put(StringTypeImpl.class.getName(), new StringTypePrinter());
	}
	
	
	
	public String whitespace() {
		String str = "";
		for (int i = 0; i<indentation; i++) {
			str += "   ";
		}
		return str;
	}
	
	protected HashSet<String> keywords = null;
	protected Collection<String> getKeywords() {
		if (keywords == null) {
			keywords = new HashSet<String>();
			keywords.add("for");
		}
		return keywords;
	}
	
	protected boolean isValidIdentifier(String s) {
	    if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
	        return false;
	    }
	    for (int i=1; i<s.length(); i++) {
	        if (!Character.isJavaIdentifierPart(s.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public String escapeName(String name) {
		if (getKeywords().contains(name) || !isValidIdentifier(name)) {
			return "`" + name + "`";
		}
		else {
			return name;
		}
	}
	
	public boolean nameExists(String name)
	{
		if (getKeywords().contains(name) || !isValidIdentifier(name)) {
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String print(Collection c, String delimiter) {
		Iterator it = c.iterator();
		String str = "";
		while (it.hasNext()) {
			str = str + print((EolElement) it.next());
			if (it.hasNext()) {
				str = str + delimiter;
			}
		}
		return str;
	}
	
	public String print(Collection c) {
		return print(c, true);
	}
	
	public String print(Collection c, boolean newline) {
		if (newline) return print(c, newline());
		else return print(c,"");
	}
	
	public String addQuotes(String s) {
		return "\"" + s + "\"";
	}
	
	public String newline() {
		return System.getProperty("line.separator");
	}
	
	public String indent() {
		indentation++;
		return "";
	}
	
	public String outdent() {
		indentation--;
		if (indentation < 0) indentation = 0;
		return "";
	}
	
}
