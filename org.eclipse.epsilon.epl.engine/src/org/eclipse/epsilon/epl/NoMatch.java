package org.eclipse.epsilon.epl;

import org.eclipse.epsilon.eol.execute.introspection.IUndefined;

public class NoMatch implements IUndefined {
	
	private NoMatch(){}
	
	public static NoMatch INSTANCE = new NoMatch();
	
}
