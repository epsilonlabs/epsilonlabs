package org.eclipse.epsilon.epl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.epl.parse.EplLexer;
import org.eclipse.epsilon.epl.parse.EplParser;

public class EplModule extends EolLibraryModule implements IEolExecutableModule{
	
	protected List<Pattern> patterns = new ArrayList<Pattern>();
	protected EolContext context;
	
	public EplModule() {
		reset();
	}
	
	@Override
	public Lexer createLexer(InputStream inputStream) {
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new EplLexer(input);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EplParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "eplModule";
	}
	
	@Override
	public void buildModel() throws Exception {
		super.buildModel();
		for (AST patternAst : AstUtil.getChildren(ast, EplParser.PATTERN)) {
			patterns.add(new Pattern(patternAst));
		}
	}
	
	public List<Pattern> getPatterns() {
		return patterns;
	}
	
	@Override
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		//children.addAll(getDeclaredPre());
		children.addAll(patterns);
		//children.addAll(getDeclaredPost());
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public IEolContext getContext() {
		return context;
	}
	
	public void setContext(EolContext context) {
		this.context = context;
	}
	
	@Override
	public void reset() {
		super.reset();
		patterns.clear();
		context = new EolContext();
	}

	@Override
	public Object execute() throws EolRuntimeException {
		new PatternMatcher().match(this);
		return null;
	}
	
}
