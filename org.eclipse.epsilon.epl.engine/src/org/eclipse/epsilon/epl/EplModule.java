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
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.epl.parse.EplLexer;
import org.eclipse.epsilon.epl.parse.EplParser;

public class EplModule extends EolLibraryModule {
	
	protected List<PatternSet> patternSets = new ArrayList<PatternSet>();
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
		for (AST patternSetAst : AstUtil.getChildren(ast, EplParser.PATTERNS)) {
			patternSets.add(new PatternSet(patternSetAst));
		}
	}
	
	public List<PatternSet> getPatternSets() {
		return patternSets;
	}
	
	@Override
	public List<ModuleElement> getChildren() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		//children.addAll(getDeclaredPre());
		children.addAll(patternSets);
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
		patternSets.clear();
		context = new EolContext();
	}
	
}
