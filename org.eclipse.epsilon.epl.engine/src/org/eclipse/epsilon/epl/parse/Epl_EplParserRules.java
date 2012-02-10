package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2012-02-10 11:18:40

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
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int FeatureCall=59;
    public static final int EOF=-1;
    public static final int BREAK=38;
    public static final int KEYVALLIST=75;
    public static final int TYPE=63;
    public static final int PATTERN=80;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int IMPORT=65;
    public static final int T__92=92;
    public static final int NAME=19;
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
    public static final int T__154=154;
    public static final int COMMENT=21;
    public static final int T__155=155;
    public static final int T__99=99;
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
    public static final int EPLMODULE=85;
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
    public static final int T__87=87;
    public static final int HELPERMETHOD=28;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
    public static final int T__88=88;
    public static final int T__146=146;
    public static final int CollectionType=44;
    public static final int T__143=143;
    public static final int CARDINALITY=82;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=20;
    public static final int T__129=129;
    public static final int ALIAS=68;
    public static final int JavaIDDigit=18;
    public static final int GUARD=79;
    public static final int Annotation=23;
    public static final int T__130=130;
    public static final int T__131=131;
    public static final int EscapeSequence=13;
    public static final int Letter=16;
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
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int COLLECTION=42;
    public static final int DIGIT=5;
    public static final int COMPONENT=84;
    public static final int EXPRRANGE=55;
    public static final int PATTERNS=81;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int DOMAIN=83;
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

    
    
    public void setTokenType(ParserRuleReturnScope tree, int type) {
    	((CommonTree) tree.getTree()).getToken().setType(type);
    }
    


    public static class patterns_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start patterns
    // EplParserRules.g:57:1: patterns : 'patterns' c= NAME '{' ( pattern )* '}' ;
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
            // EplParserRules.g:58:2: ( 'patterns' c= NAME '{' ( pattern )* '}' )
            // EplParserRules.g:59:2: 'patterns' c= NAME '{' ( pattern )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,154,FOLLOW_154_in_patterns61); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_patterns66); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            char_literal2=(Token)match(input,92,FOLLOW_92_in_patterns69); if (state.failed) return retval;
            // EplParserRules.g:59:27: ( pattern )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==155) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:0:0: pattern
            	    {
            	    pushFollow(FOLLOW_pattern_in_patterns72);
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

            char_literal4=(Token)match(input,93,FOLLOW_93_in_patterns75); if (state.failed) return retval;
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
    // EplParserRules.g:63:1: pattern : 'pattern' c= NAME component ( ',' component )* ( statementBlock )? ;
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
            // EplParserRules.g:64:2: ( 'pattern' c= NAME component ( ',' component )* ( statementBlock )? )
            // EplParserRules.g:65:2: 'pattern' c= NAME component ( ',' component )* ( statementBlock )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal5=(Token)match(input,155,FOLLOW_155_in_pattern92); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_pattern97); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_component_in_pattern100);
            component6=component();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, component6.getTree());
            // EplParserRules.g:65:31: ( ',' component )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==89) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EplParserRules.g:65:32: ',' component
            	    {
            	    char_literal7=(Token)match(input,89,FOLLOW_89_in_pattern103); if (state.failed) return retval;
            	    pushFollow(FOLLOW_component_in_pattern106);
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

            // EplParserRules.g:65:49: ( statementBlock )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==92) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // EplParserRules.g:0:0: statementBlock
                    {
                    pushFollow(FOLLOW_statementBlock_in_pattern110);
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
    // EplParserRules.g:70:1: component : n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )? ;
    public final Epl_EplParserRules.component_return component() throws RecognitionException {
        Epl_EplParserRules.component_return retval = new Epl_EplParserRules.component_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token char_literal10=null;
        Epl_EolParserRules.typeName_return t = null;

        Epl_EplParserRules.cardinality_return cardinality11 = null;

        Epl_EplParserRules.domain_return domain12 = null;

        Epl_ErlParserRules.guard_return guard13 = null;


        CommonTree n_tree=null;
        CommonTree char_literal10_tree=null;

        try {
            // EplParserRules.g:71:2: (n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )? )
            // EplParserRules.g:71:4: n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )?
            {
            root_0 = (CommonTree)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_component128); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            root_0 = (CommonTree)adaptor.becomeRoot(n_tree, root_0);
            }
            char_literal10=(Token)match(input,88,FOLLOW_88_in_component131); if (state.failed) return retval;
            pushFollow(FOLLOW_typeName_in_component136);
            t=gEpl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(t, TYPE);
            }
            // EplParserRules.g:71:53: ( cardinality )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==145) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // EplParserRules.g:0:0: cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_component140);
                    cardinality11=cardinality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cardinality11.getTree());

                    }
                    break;

            }

            // EplParserRules.g:71:66: ( domain )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==113) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EplParserRules.g:0:0: domain
                    {
                    pushFollow(FOLLOW_domain_in_component143);
                    domain12=domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain12.getTree());

                    }
                    break;

            }

            // EplParserRules.g:71:74: ( guard )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==152) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EplParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_component146);
                    guard13=gEpl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard13.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              n.setType(COMPONENT);
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
    // $ANTLR end component

    public static class cardinality_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cardinality
    // EplParserRules.g:76:1: cardinality : c= '[' bound ( '..' bound )? ']' ;
    public final Epl_EplParserRules.cardinality_return cardinality() throws RecognitionException {
        Epl_EplParserRules.cardinality_return retval = new Epl_EplParserRules.cardinality_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal15=null;
        Token char_literal17=null;
        Epl_EplParserRules.bound_return bound14 = null;

        Epl_EplParserRules.bound_return bound16 = null;


        CommonTree c_tree=null;
        CommonTree string_literal15_tree=null;
        CommonTree char_literal17_tree=null;

        try {
            // EplParserRules.g:77:2: (c= '[' bound ( '..' bound )? ']' )
            // EplParserRules.g:77:4: c= '[' bound ( '..' bound )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,145,FOLLOW_145_in_cardinality164); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_bound_in_cardinality167);
            bound14=bound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bound14.getTree());
            // EplParserRules.g:77:17: ( '..' bound )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==POINT_POINT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EplParserRules.g:77:18: '..' bound
                    {
                    string_literal15=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_cardinality170); if (state.failed) return retval;
                    pushFollow(FOLLOW_bound_in_cardinality173);
                    bound16=bound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bound16.getTree());

                    }
                    break;

            }

            char_literal17=(Token)match(input,146,FOLLOW_146_in_cardinality177); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              c.setType(CARDINALITY);
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
    // $ANTLR end cardinality

    public static class bound_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bound
    // EplParserRules.g:81:1: bound : ( INT | '*' );
    public final Epl_EplParserRules.bound_return bound() throws RecognitionException {
        Epl_EplParserRules.bound_return retval = new Epl_EplParserRules.bound_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set18=null;

        CommonTree set18_tree=null;

        try {
            // EplParserRules.g:82:2: ( INT | '*' )
            // EplParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set18=(Token)input.LT(1);
            if ( input.LA(1)==INT||input.LA(1)==142 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set18));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end bound

    public static class domain_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start domain
    // EplParserRules.g:85:1: domain : c= 'in' expressionOrStatementBlock ;
    public final Epl_EplParserRules.domain_return domain() throws RecognitionException {
        Epl_EplParserRules.domain_return retval = new Epl_EplParserRules.domain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock19 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:85:8: (c= 'in' expressionOrStatementBlock )
            // EplParserRules.g:86:2: c= 'in' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,113,FOLLOW_113_in_domain209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_domain212);
            expressionOrStatementBlock19=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock19.getTree());
            if ( state.backtracking==0 ) {
              c.setType(DOMAIN);
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
    // $ANTLR end domain

    // Delegated rules


 

    public static final BitSet FOLLOW_154_in_patterns61 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_patterns66 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_patterns69 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_pattern_in_patterns72 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_93_in_patterns75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_pattern92 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern97 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern100 = new BitSet(new long[]{0x0000000000000002L,0x0000000012000000L});
    public static final BitSet FOLLOW_89_in_pattern103 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern106 = new BitSet(new long[]{0x0000000000000002L,0x0000000012000000L});
    public static final BitSet FOLLOW_statementBlock_in_pattern110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_component128 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_component131 = new BitSet(new long[]{0x0000000000080000L,0x0000FF0000000000L});
    public static final BitSet FOLLOW_typeName_in_component136 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L,0x0000000001020000L});
    public static final BitSet FOLLOW_cardinality_in_component140 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_domain_in_component143 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_guard_in_component146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_cardinality164 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_bound_in_cardinality167 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_POINT_POINT_in_cardinality170 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_bound_in_cardinality173 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_cardinality177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bound0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_domain209 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_domain212 = new BitSet(new long[]{0x0000000000000002L});

}
