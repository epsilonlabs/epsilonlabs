package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2012-02-10 09:05:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

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
public class Epl_EplParserRules extends org.eclipse.epsilon.commons.parse.EpsilonParser {
    public static final int EXPONENT=6;
    public static final int FIX=83;
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int T__160=160;
    public static final int DO=85;
    public static final int FeatureCall=59;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int T__161=161;
    public static final int T__162=162;
    public static final int PATTERN=80;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=65;
    public static final int NAME=19;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__90=90;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int RETURN=37;
    public static final int NewExpression=47;
    public static final int VAR=48;
    public static final int ANNOTATIONBLOCK=50;
    public static final int NativeType=56;
    public static final int ABORT=43;
    public static final int COMMENT=21;
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
    public static final int T__99=99;
    public static final int T__157=157;
    public static final int ITEMSELECTOR=72;
    public static final int T__98=98;
    public static final int T__150=150;
    public static final int T__97=97;
    public static final int T__151=151;
    public static final int MultiplicativeExpression=57;
    public static final int T__96=96;
    public static final int T__152=152;
    public static final int T__95=95;
    public static final int T__153=153;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int EPLMODULE=88;
    public static final int LINE_COMMENT=22;
    public static final int BREAKALL=39;
    public static final int TRANSACTION=41;
    public static final int SWITCH=34;
    public static final int DRIVER=69;
    public static final int ELSE=32;
    public static final int EOLMODULE=60;
    public static final int MODELDECLARATION=66;
    public static final int PARAMLIST=25;
    public static final int INT=8;
    public static final int DELETE=52;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int HELPERMETHOD=28;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
    public static final int T__146=146;
    public static final int CollectionType=44;
    public static final int T__143=143;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
    public static final int CHECK=84;
    public static final int GUARD=79;
    public static final int Annotation=23;
    public static final int T__130=130;
    public static final int Letter=16;
    public static final int T__131=131;
    public static final int EscapeSequence=13;
    public static final int THROW=53;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int T__135=135;
    public static final int SPECIAL_ASSIGNMENT=27;
    public static final int MODELDECLARATIONPARAMETER=71;
    public static final int KEYVAL=74;
    public static final int PARAMETERS=46;
    public static final int POINT=9;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int FOR=30;
    public static final int T__122=122;
    public static final int ENUMERATION_VALUE=64;
    public static final int T__121=121;
    public static final int PRE=76;
    public static final int T__120=120;
    public static final int FLOAT=4;
    public static final int EXECUTABLEANNOTATION=51;
    public static final int IF=31;
    public static final int ModelElementType=45;
    public static final int BOOLEAN=12;
    public static final int CONTINUE=40;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int MESSAGE=87;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int COLLECTION=42;
    public static final int DIGIT=5;
    public static final int CRITIQUE=81;
    public static final int EXPRRANGE=55;
    public static final int PATTERNS=82;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int POINT_POINT=10;
    public static final int SpecialNameChar=17;
    public static final int MODELDECLARATIONPARAMETERS=70;
    public static final int BLOCK=61;
    public static final int MAP=73;
    public static final int FEATURECALL=62;
    public static final int FORMAL=24;
    public static final int POST=77;
    public static final int ARROW=11;
    public static final int ASSIGNMENT=26;
    public static final int EXTENDS=78;
    public static final int STRING=14;
    public static final int TITLE=86;

    // delegates
    // delegators
    public EplParser gEpl;


        public Epl_EplParserRules(TokenStream input, EplParser gEpl) {
            this(input, new RecognizerSharedState(), gEpl);
        }
        public Epl_EplParserRules(TokenStream input, RecognizerSharedState state, EplParser gEpl) {
            super(input, state);
            this.gEpl = gEpl;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EplParser.tokenNames; }
    public String getGrammarFileName() { return "EplParserRules.g"; }


    public static class patterns_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start patterns
    // EplParserRules.g:52:1: patterns : 'patterns' c= NAME '{' ( pattern )* '}' ;
    public final Epl_EplParserRules.patterns_return patterns() throws RecognitionException {
        Epl_EplParserRules.patterns_return retval = new Epl_EplParserRules.patterns_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal1=null;
        Token char_literal2=null;
        Token char_literal4=null;
        Epl_EplParserRules.pattern_return pattern3 = null;


        CommonTree c_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree char_literal2_tree=null;
        CommonTree char_literal4_tree=null;

        try {
            // EplParserRules.g:53:2: ( 'patterns' c= NAME '{' ( pattern )* '}' )
            // EplParserRules.g:54:2: 'patterns' c= NAME '{' ( pattern )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,157,FOLLOW_157_in_patterns67); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_patterns72); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            char_literal2=(Token)match(input,95,FOLLOW_95_in_patterns75); if (state.failed) return retval;
            // EplParserRules.g:54:27: ( pattern )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==158) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:0:0: pattern
            	    {
            	    pushFollow(FOLLOW_pattern_in_patterns78);
            	    pattern3=pattern();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pattern3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            char_literal4=(Token)match(input,96,FOLLOW_96_in_patterns81); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(PATTERNS);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end patterns

    public static class pattern_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pattern
    // EplParserRules.g:58:1: pattern : 'pattern' c= NAME component ( ',' component )* ( statementBlock )? ;
    public final Epl_EplParserRules.pattern_return pattern() throws RecognitionException {
        Epl_EplParserRules.pattern_return retval = new Epl_EplParserRules.pattern_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal5=null;
        Token char_literal7=null;
        Epl_EplParserRules.component_return component6 = null;

        Epl_EplParserRules.component_return component8 = null;

        Epl_EolParserRules.statementBlock_return statementBlock9 = null;


        CommonTree c_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree char_literal7_tree=null;

        try {
            // EplParserRules.g:59:2: ( 'pattern' c= NAME component ( ',' component )* ( statementBlock )? )
            // EplParserRules.g:60:2: 'pattern' c= NAME component ( ',' component )* ( statementBlock )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal5=(Token)match(input,158,FOLLOW_158_in_pattern98); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_pattern103); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_component_in_pattern106);
            component6=component();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, component6.getTree());
            // EplParserRules.g:60:31: ( ',' component )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==92) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EplParserRules.g:60:32: ',' component
            	    {
            	    char_literal7=(Token)match(input,92,FOLLOW_92_in_pattern109); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal7_tree = (CommonTree)adaptor.create(char_literal7);
            	    adaptor.addChild(root_0, char_literal7_tree);
            	    }
            	    pushFollow(FOLLOW_component_in_pattern111);
            	    component8=component();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, component8.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // EplParserRules.g:60:48: ( statementBlock )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==95) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EplParserRules.g:0:0: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_pattern115);
                    statementBlock9=gEpl.statementBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock9.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              c.setType(PATTERN);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end pattern

    public static class component_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start component
    // EplParserRules.g:65:1: component : p= formalParameter ;
    public final Epl_EplParserRules.component_return component() throws RecognitionException {
        Epl_EplParserRules.component_return retval = new Epl_EplParserRules.component_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Epl_EolParserRules.formalParameter_return p = null;



        try {
            // EplParserRules.g:66:2: (p= formalParameter )
            // EplParserRules.g:66:4: p= formalParameter
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_formalParameter_in_component133);
            p=gEpl.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end component

    public static class critique_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start critique
    // EplParserRules.g:69:1: critique : 'critique' c= NAME '{' ( guard )? check ( message )? ( fix )* '}' ;
    public final Epl_EplParserRules.critique_return critique() throws RecognitionException {
        Epl_EplParserRules.critique_return retval = new Epl_EplParserRules.critique_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal10=null;
        Token char_literal11=null;
        Token char_literal16=null;
        Epl_ErlParserRules.guard_return guard12 = null;

        Epl_EplParserRules.check_return check13 = null;

        Epl_EplParserRules.message_return message14 = null;

        Epl_EplParserRules.fix_return fix15 = null;


        CommonTree c_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal16_tree=null;

        try {
            // EplParserRules.g:70:2: ( 'critique' c= NAME '{' ( guard )? check ( message )? ( fix )* '}' )
            // EplParserRules.g:71:2: 'critique' c= NAME '{' ( guard )? check ( message )? ( fix )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal10=(Token)match(input,159,FOLLOW_159_in_critique146); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_critique151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            char_literal11=(Token)match(input,95,FOLLOW_95_in_critique154); if (state.failed) return retval;
            // EplParserRules.g:71:27: ( guard )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==155) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EplParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_critique157);
                    guard12=gEpl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard12.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_check_in_critique160);
            check13=check();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, check13.getTree());
            // EplParserRules.g:71:40: ( message )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==161) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EplParserRules.g:0:0: message
                    {
                    pushFollow(FOLLOW_message_in_critique162);
                    message14=message();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, message14.getTree());

                    }
                    break;

            }

            // EplParserRules.g:71:49: ( fix )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==162) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EplParserRules.g:71:50: fix
            	    {
            	    pushFollow(FOLLOW_fix_in_critique166);
            	    fix15=fix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fix15.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            char_literal16=(Token)match(input,96,FOLLOW_96_in_critique170); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CRITIQUE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end critique

    public static class check_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start check
    // EplParserRules.g:75:1: check : c= 'check' expressionOrStatementBlock ;
    public final Epl_EplParserRules.check_return check() throws RecognitionException {
        Epl_EplParserRules.check_return retval = new Epl_EplParserRules.check_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock17 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:76:2: (c= 'check' expressionOrStatementBlock )
            // EplParserRules.g:76:4: c= 'check' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,160,FOLLOW_160_in_check188); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_check191);
            expressionOrStatementBlock17=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock17.getTree());
            if ( state.backtracking==0 ) {
              c.setType(CHECK);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end check

    public static class message_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start message
    // EplParserRules.g:80:1: message : m= 'message' expressionOrStatementBlock ;
    public final Epl_EplParserRules.message_return message() throws RecognitionException {
        Epl_EplParserRules.message_return retval = new Epl_EplParserRules.message_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token m=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock18 = null;


        CommonTree m_tree=null;

        try {
            // EplParserRules.g:81:2: (m= 'message' expressionOrStatementBlock )
            // EplParserRules.g:81:4: m= 'message' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            m=(Token)match(input,161,FOLLOW_161_in_message208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (CommonTree)adaptor.create(m);
            root_0 = (CommonTree)adaptor.becomeRoot(m_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_message211);
            expressionOrStatementBlock18=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock18.getTree());
            if ( state.backtracking==0 ) {
              m.setType(MESSAGE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end message

    public static class fix_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fix
    // EplParserRules.g:85:1: fix : f= 'fix' '{' ( guard )? title fixBody '}' ;
    public final Epl_EplParserRules.fix_return fix() throws RecognitionException {
        Epl_EplParserRules.fix_return retval = new Epl_EplParserRules.fix_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token f=null;
        Token char_literal19=null;
        Token char_literal23=null;
        Epl_ErlParserRules.guard_return guard20 = null;

        Epl_EplParserRules.title_return title21 = null;

        Epl_EplParserRules.fixBody_return fixBody22 = null;


        CommonTree f_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal23_tree=null;

        try {
            // EplParserRules.g:86:2: (f= 'fix' '{' ( guard )? title fixBody '}' )
            // EplParserRules.g:86:4: f= 'fix' '{' ( guard )? title fixBody '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            f=(Token)match(input,162,FOLLOW_162_in_fix228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            f_tree = (CommonTree)adaptor.create(f);
            root_0 = (CommonTree)adaptor.becomeRoot(f_tree, root_0);
            }
            char_literal19=(Token)match(input,95,FOLLOW_95_in_fix231); if (state.failed) return retval;
            // EplParserRules.g:86:18: ( guard )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==155) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EplParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_fix234);
                    guard20=gEpl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard20.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_title_in_fix237);
            title21=title();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, title21.getTree());
            pushFollow(FOLLOW_fixBody_in_fix239);
            fixBody22=fixBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fixBody22.getTree());
            char_literal23=(Token)match(input,96,FOLLOW_96_in_fix241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              f.setType(FIX);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end fix

    public static class title_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start title
    // EplParserRules.g:90:1: title : t= 'title' expressionOrStatementBlock ;
    public final Epl_EplParserRules.title_return title() throws RecognitionException {
        Epl_EplParserRules.title_return retval = new Epl_EplParserRules.title_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock24 = null;


        CommonTree t_tree=null;

        try {
            // EplParserRules.g:91:2: (t= 'title' expressionOrStatementBlock )
            // EplParserRules.g:91:4: t= 'title' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            t=(Token)match(input,163,FOLLOW_163_in_title258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (CommonTree)adaptor.create(t);
            root_0 = (CommonTree)adaptor.becomeRoot(t_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_title261);
            expressionOrStatementBlock24=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock24.getTree());
            if ( state.backtracking==0 ) {
              t.setType(TITLE);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end title

    public static class fixBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fixBody
    // EplParserRules.g:95:1: fixBody : d= 'do' statementBlock ;
    public final Epl_EplParserRules.fixBody_return fixBody() throws RecognitionException {
        Epl_EplParserRules.fixBody_return retval = new Epl_EplParserRules.fixBody_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d=null;
        Epl_EolParserRules.statementBlock_return statementBlock25 = null;


        CommonTree d_tree=null;

        try {
            // EplParserRules.g:96:2: (d= 'do' statementBlock )
            // EplParserRules.g:96:4: d= 'do' statementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            d=(Token)match(input,164,FOLLOW_164_in_fixBody278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            d_tree = (CommonTree)adaptor.create(d);
            root_0 = (CommonTree)adaptor.becomeRoot(d_tree, root_0);
            }
            pushFollow(FOLLOW_statementBlock_in_fixBody281);
            statementBlock25=gEpl.statementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statementBlock25.getTree());
            if ( state.backtracking==0 ) {
              d.setType(DO);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end fixBody

    // Delegated rules


 

    public static final BitSet FOLLOW_157_in_patterns67 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_patterns72 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_patterns75 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_pattern_in_patterns78 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_96_in_patterns81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_pattern98 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern103 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern106 = new BitSet(new long[]{0x0000000000000002L,0x0000000090000000L});
    public static final BitSet FOLLOW_92_in_pattern109 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern111 = new BitSet(new long[]{0x0000000000000002L,0x0000000090000000L});
    public static final BitSet FOLLOW_statementBlock_in_pattern115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formalParameter_in_component133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_critique146 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_critique151 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_critique154 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_guard_in_critique157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000108000000L});
    public static final BitSet FOLLOW_check_in_critique160 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_message_in_critique162 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_fix_in_critique166 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_96_in_critique170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_check188 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_check191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_message208 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_message211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_fix228 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_fix231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_guard_in_fix234 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000808000000L});
    public static final BitSet FOLLOW_title_in_fix237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_fixBody_in_fix239 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_fix241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_title258 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_title261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_fixBody278 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_statementBlock_in_fixBody281 = new BitSet(new long[]{0x0000000000000002L});

}
