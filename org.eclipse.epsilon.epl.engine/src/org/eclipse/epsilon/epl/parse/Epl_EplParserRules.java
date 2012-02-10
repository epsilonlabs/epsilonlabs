package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2012-02-10 18:11:52

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
    public static final int T__159=159;
    public static final int WHILE=33;
    public static final int StatementBlock=29;
    public static final int T__158=158;
    public static final int StrangeNameLiteral=15;
    public static final int CASE=35;
    public static final int NEW=49;
    public static final int DO=86;
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
    public static final int EPLMODULE=87;
    public static final int LINE_COMMENT=22;
    public static final int BREAKALL=39;
    public static final int TRANSACTION=41;
    public static final int SWITCH=34;
    public static final int DRIVER=69;
    public static final int ELSE=32;
    public static final int EOLMODULE=60;
    public static final int MODELDECLARATION=66;
    public static final int PARAMLIST=25;
    public static final int MATCH=84;
    public static final int INT=8;
    public static final int DELETE=52;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int HELPERMETHOD=28;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int NAMESPACE=67;
    public static final int T__88=88;
    public static final int T__146=146;
    public static final int CollectionType=44;
    public static final int T__143=143;
    public static final int CARDINALITY=81;
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
    public static final int COMPONENT=83;
    public static final int EXPRRANGE=55;
    public static final int NOMATCH=85;
    public static final int OPERATOR=58;
    public static final int EXPRLIST=54;
    public static final int DEFAULT=36;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int DOMAIN=82;
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
    


    public static class pattern_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pattern
    // EplParserRules.g:66:1: pattern : 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? ( nomatch )? '}' )? ;
    public final Epl_EplParserRules.pattern_return pattern() throws RecognitionException {
        Epl_EplParserRules.pattern_return retval = new Epl_EplParserRules.pattern_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal1=null;
        Token char_literal3=null;
        Token char_literal5=null;
        Token char_literal9=null;
        Epl_EplParserRules.component_return component2 = null;

        Epl_EplParserRules.component_return component4 = null;

        Epl_EplParserRules.match_return match6 = null;

        Epl_EplParserRules.do__return do_7 = null;

        Epl_EplParserRules.nomatch_return nomatch8 = null;


        CommonTree c_tree=null;
        CommonTree string_literal1_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // EplParserRules.g:67:2: ( 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? ( nomatch )? '}' )? )
            // EplParserRules.g:68:2: 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? ( nomatch )? '}' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,156,FOLLOW_156_in_pattern76); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_pattern81); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_component_in_pattern84);
            component2=component();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, component2.getTree());
            // EplParserRules.g:68:31: ( ',' component )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==91) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:68:32: ',' component
            	    {
            	    char_literal3=(Token)match(input,91,FOLLOW_91_in_pattern87); if (state.failed) return retval;
            	    pushFollow(FOLLOW_component_in_pattern90);
            	    component4=component();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, component4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // EplParserRules.g:68:49: ( '{' ( match )? ( do_ )? ( nomatch )? '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==94) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EplParserRules.g:68:50: '{' ( match )? ( do_ )? ( nomatch )? '}'
                    {
                    char_literal5=(Token)match(input,94,FOLLOW_94_in_pattern95); if (state.failed) return retval;
                    // EplParserRules.g:68:55: ( match )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==157) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // EplParserRules.g:0:0: match
                            {
                            pushFollow(FOLLOW_match_in_pattern98);
                            match6=match();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, match6.getTree());

                            }
                            break;

                    }

                    // EplParserRules.g:68:62: ( do_ )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==158) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // EplParserRules.g:0:0: do_
                            {
                            pushFollow(FOLLOW_do__in_pattern101);
                            do_7=do_();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, do_7.getTree());

                            }
                            break;

                    }

                    // EplParserRules.g:68:67: ( nomatch )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==159) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // EplParserRules.g:0:0: nomatch
                            {
                            pushFollow(FOLLOW_nomatch_in_pattern104);
                            nomatch8=nomatch();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, nomatch8.getTree());

                            }
                            break;

                    }

                    char_literal9=(Token)match(input,95,FOLLOW_95_in_pattern107); if (state.failed) return retval;

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
    // EplParserRules.g:72:1: component : n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )? ;
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
            // EplParserRules.g:73:2: (n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )? )
            // EplParserRules.g:73:4: n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )?
            {
            root_0 = (CommonTree)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_component126); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            root_0 = (CommonTree)adaptor.becomeRoot(n_tree, root_0);
            }
            char_literal10=(Token)match(input,90,FOLLOW_90_in_component129); if (state.failed) return retval;
            pushFollow(FOLLOW_typeName_in_component134);
            t=gEpl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(t, TYPE);
            }
            // EplParserRules.g:73:53: ( cardinality )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==147) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EplParserRules.g:0:0: cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_component138);
                    cardinality11=cardinality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cardinality11.getTree());

                    }
                    break;

            }

            // EplParserRules.g:73:66: ( domain )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==115) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EplParserRules.g:0:0: domain
                    {
                    pushFollow(FOLLOW_domain_in_component141);
                    domain12=domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain12.getTree());

                    }
                    break;

            }

            // EplParserRules.g:73:74: ( guard )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==154) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EplParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_component144);
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
    // EplParserRules.g:78:1: cardinality : c= '[' bound ( '..' bound )? ']' ;
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
            // EplParserRules.g:79:2: (c= '[' bound ( '..' bound )? ']' )
            // EplParserRules.g:79:4: c= '[' bound ( '..' bound )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,147,FOLLOW_147_in_cardinality162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_bound_in_cardinality165);
            bound14=bound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bound14.getTree());
            // EplParserRules.g:79:17: ( '..' bound )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==POINT_POINT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EplParserRules.g:79:18: '..' bound
                    {
                    string_literal15=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_cardinality168); if (state.failed) return retval;
                    pushFollow(FOLLOW_bound_in_cardinality171);
                    bound16=bound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bound16.getTree());

                    }
                    break;

            }

            char_literal17=(Token)match(input,148,FOLLOW_148_in_cardinality175); if (state.failed) return retval;
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
    // EplParserRules.g:83:1: bound : ( INT | '*' );
    public final Epl_EplParserRules.bound_return bound() throws RecognitionException {
        Epl_EplParserRules.bound_return retval = new Epl_EplParserRules.bound_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set18=null;

        CommonTree set18_tree=null;

        try {
            // EplParserRules.g:84:2: ( INT | '*' )
            // EplParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set18=(Token)input.LT(1);
            if ( input.LA(1)==INT||input.LA(1)==144 ) {
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
    // EplParserRules.g:87:1: domain : c= 'in' expressionOrStatementBlock ;
    public final Epl_EplParserRules.domain_return domain() throws RecognitionException {
        Epl_EplParserRules.domain_return retval = new Epl_EplParserRules.domain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock19 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:87:8: (c= 'in' expressionOrStatementBlock )
            // EplParserRules.g:88:2: c= 'in' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,115,FOLLOW_115_in_domain207); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_domain210);
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

    public static class match_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start match
    // EplParserRules.g:92:1: match : c= 'match' expressionOrStatementBlock ;
    public final Epl_EplParserRules.match_return match() throws RecognitionException {
        Epl_EplParserRules.match_return retval = new Epl_EplParserRules.match_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock20 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:92:7: (c= 'match' expressionOrStatementBlock )
            // EplParserRules.g:93:2: c= 'match' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,157,FOLLOW_157_in_match227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_match230);
            expressionOrStatementBlock20=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock20.getTree());
            if ( state.backtracking==0 ) {
              c.setType(MATCH);
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
    // $ANTLR end match

    public static class do__return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start do_
    // EplParserRules.g:97:1: do_ : c= 'do' expressionOrStatementBlock ;
    public final Epl_EplParserRules.do__return do_() throws RecognitionException {
        Epl_EplParserRules.do__return retval = new Epl_EplParserRules.do__return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock21 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:97:5: (c= 'do' expressionOrStatementBlock )
            // EplParserRules.g:98:2: c= 'do' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,158,FOLLOW_158_in_do_246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_do_249);
            expressionOrStatementBlock21=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock21.getTree());
            if ( state.backtracking==0 ) {
              c.setType(DO);
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
    // $ANTLR end do_

    public static class nomatch_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nomatch
    // EplParserRules.g:102:1: nomatch : c= 'nomatch' expressionOrStatementBlock ;
    public final Epl_EplParserRules.nomatch_return nomatch() throws RecognitionException {
        Epl_EplParserRules.nomatch_return retval = new Epl_EplParserRules.nomatch_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock22 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:102:9: (c= 'nomatch' expressionOrStatementBlock )
            // EplParserRules.g:103:2: c= 'nomatch' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,159,FOLLOW_159_in_nomatch266); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_nomatch269);
            expressionOrStatementBlock22=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock22.getTree());
            if ( state.backtracking==0 ) {
              c.setType(NOMATCH);
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
    // $ANTLR end nomatch

    // Delegated rules


 

    public static final BitSet FOLLOW_156_in_pattern76 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern81 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern84 = new BitSet(new long[]{0x0000000000000002L,0x0000000048000000L});
    public static final BitSet FOLLOW_91_in_pattern87 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern90 = new BitSet(new long[]{0x0000000000000002L,0x0000000048000000L});
    public static final BitSet FOLLOW_94_in_pattern95 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_match_in_pattern98 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_do__in_pattern101 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_nomatch_in_pattern104 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_pattern107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_component126 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_component129 = new BitSet(new long[]{0x0000000000080000L,0x0003FC0000000000L});
    public static final BitSet FOLLOW_typeName_in_component134 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L,0x0000000004080000L});
    public static final BitSet FOLLOW_cardinality_in_component138 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_domain_in_component141 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_guard_in_component144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_cardinality162 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_bound_in_cardinality165 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_POINT_POINT_in_cardinality168 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_bound_in_cardinality171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_cardinality175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bound0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_domain207 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_domain210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_match227 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_match230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_do_246 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_do_249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_nomatch266 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_nomatch269 = new BitSet(new long[]{0x0000000000000002L});

}
