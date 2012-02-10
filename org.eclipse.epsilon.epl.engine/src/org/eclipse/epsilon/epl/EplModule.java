package org.eclipse.epsilon.epl;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.commons.parse.EpsilonParser;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.epl.parse.EplLexer;
import org.eclipse.epsilon.epl.parse.EplParser;

public class EplModule extends EolLibraryModule {

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
	
	
	
}
