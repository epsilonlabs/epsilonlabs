/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 * -----------------------------------------------------------------------------
 * ANTLR 3 License
 * [The "BSD licence"]
 * Copyright (c) 2005-2008 Terence Parr
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
parser grammar EplParserRules;
options {backtrack=true; output=AST;}

tokens {
	PATTERN;
	PATTERNS;
	CARDINALITY;
	DOMAIN;
	COMPONENT;
	MATCH;
	NOMATCH;
	DO;
}

@members {

public void setTokenType(ParserRuleReturnScope tree, int type) {
	((CommonTree) tree.getTree()).getToken().setType(type);
}

}

patterns 
	: 
	'patterns'! c=NAME^ '{'! pattern* '}'!
	{$c.setType(PATTERNS);}
	;

pattern
	: 
	'pattern'! c=NAME^ component (','! component)* ('{'! match? do_? nomatch? '}'!)?
	{$c.setType(PATTERN);}
	;

component
	: n=NAME^ ':'! t=typeName {setTokenType(t, TYPE);} cardinality? domain? guard?
	{$n.setType(COMPONENT);}
	;


cardinality
	: c='['^ bound ('..'! bound)? ']'!
	{$c.setType(CARDINALITY);}
	;

bound
	: INT | '*'
	;

domain :
	c='in'^ expressionOrStatementBlock
	{$c.setType(DOMAIN);}
	;
	
match :
	c='match'^ expressionOrStatementBlock
	{$c.setType(MATCH);}
	;

do_ :
	c='do'^ expressionOrStatementBlock
	{$c.setType(DO);}
	;
	
nomatch :
	c='nomatch'^ expressionOrStatementBlock
	{$c.setType(NOMATCH);}
	;