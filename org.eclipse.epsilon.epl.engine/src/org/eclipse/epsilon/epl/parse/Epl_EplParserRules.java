package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2012-03-23 23:35:19

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
    public static final int T__160=160;
    public static final int DO=86;
    public static final int FeatureCall=59;
    public static final int EOF=-1;
    public static final int BREAK=38;
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
    public static final int NO=87;
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
    // EplParserRules.g:61:1: pattern : 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? ( nomatch )? '}' )? ;
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
            // EplParserRules.g:62:2: ( 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? ( nomatch )? '}' )? )
            // EplParserRules.g:63:2: 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? ( nomatch )? '}' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,157,FOLLOW_157_in_pattern76); if (state.failed) return retval;
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
            // EplParserRules.g:63:31: ( ',' component )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==92) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:63:32: ',' component
            	    {
            	    char_literal3=(Token)match(input,92,FOLLOW_92_in_pattern87); if (state.failed) return retval;
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

            // EplParserRules.g:63:49: ( '{' ( match )? ( do_ )? ( nomatch )? '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==95) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EplParserRules.g:63:50: '{' ( match )? ( do_ )? ( nomatch )? '}'
                    {
                    char_literal5=(Token)match(input,95,FOLLOW_95_in_pattern95); if (state.failed) return retval;
                    // EplParserRules.g:63:55: ( match )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==160) ) {
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

                    // EplParserRules.g:63:62: ( do_ )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==161) ) {
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

                    // EplParserRules.g:63:67: ( nomatch )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==162) ) {
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

                    char_literal9=(Token)match(input,96,FOLLOW_96_in_pattern107); if (state.failed) return retval;

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
    // EplParserRules.g:67:1: component : ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( domain )? ( guard )? ;
    public final Epl_EplParserRules.component_return component() throws RecognitionException {
        Epl_EplParserRules.component_return retval = new Epl_EplParserRules.component_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token NAME11=null;
        Token char_literal12=null;
        Token NAME13=null;
        Epl_EolParserRules.typeName_return t = null;

        Epl_EplParserRules.no_return no10 = null;

        Epl_EplParserRules.domain_return domain14 = null;

        Epl_ErlParserRules.guard_return guard15 = null;


        CommonTree n_tree=null;
        CommonTree NAME11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree NAME13_tree=null;

        try {
            // EplParserRules.g:68:2: ( ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( domain )? ( guard )? )
            // EplParserRules.g:68:4: ( no )? NAME ( ',' NAME )* n= ':' t= typeName ( domain )? ( guard )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // EplParserRules.g:68:4: ( no )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==158) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EplParserRules.g:0:0: no
                    {
                    pushFollow(FOLLOW_no_in_component124);
                    no10=no();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, no10.getTree());

                    }
                    break;

            }

            NAME11=(Token)match(input,NAME,FOLLOW_NAME_in_component127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME11_tree = (CommonTree)adaptor.create(NAME11);
            adaptor.addChild(root_0, NAME11_tree);
            }
            // EplParserRules.g:68:13: ( ',' NAME )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==92) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // EplParserRules.g:68:14: ',' NAME
            	    {
            	    char_literal12=(Token)match(input,92,FOLLOW_92_in_component130); if (state.failed) return retval;
            	    NAME13=(Token)match(input,NAME,FOLLOW_NAME_in_component133); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME13_tree = (CommonTree)adaptor.create(NAME13);
            	    adaptor.addChild(root_0, NAME13_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            n=(Token)match(input,91,FOLLOW_91_in_component139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            root_0 = (CommonTree)adaptor.becomeRoot(n_tree, root_0);
            }
            pushFollow(FOLLOW_typeName_in_component144);
            t=gEpl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(t, TYPE);
            }
            // EplParserRules.g:68:69: ( domain )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==116||LA8_0==159) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EplParserRules.g:0:0: domain
                    {
                    pushFollow(FOLLOW_domain_in_component148);
                    domain14=domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain14.getTree());

                    }
                    break;

            }

            // EplParserRules.g:68:77: ( guard )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==155) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EplParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_component151);
                    guard15=gEpl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard15.getTree());

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

    public static class no_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start no
    // EplParserRules.g:72:1: no : n= 'no' ;
    public final Epl_EplParserRules.no_return no() throws RecognitionException {
        Epl_EplParserRules.no_return retval = new Epl_EplParserRules.no_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;

        CommonTree n_tree=null;

        try {
            // EplParserRules.g:72:4: (n= 'no' )
            // EplParserRules.g:72:6: n= 'no'
            {
            root_0 = (CommonTree)adaptor.nil();

            n=(Token)match(input,158,FOLLOW_158_in_no167); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
              n.setType(NO);
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
    // $ANTLR end no

    public static class cardinality_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cardinality
    // EplParserRules.g:74:1: cardinality : c= '[' bound ( '..' bound )? ']' ;
    public final Epl_EplParserRules.cardinality_return cardinality() throws RecognitionException {
        Epl_EplParserRules.cardinality_return retval = new Epl_EplParserRules.cardinality_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal17=null;
        Token char_literal19=null;
        Epl_EplParserRules.bound_return bound16 = null;

        Epl_EplParserRules.bound_return bound18 = null;


        CommonTree c_tree=null;
        CommonTree string_literal17_tree=null;
        CommonTree char_literal19_tree=null;

        try {
            // EplParserRules.g:75:2: (c= '[' bound ( '..' bound )? ']' )
            // EplParserRules.g:75:4: c= '[' bound ( '..' bound )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,148,FOLLOW_148_in_cardinality180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_bound_in_cardinality183);
            bound16=bound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bound16.getTree());
            // EplParserRules.g:75:17: ( '..' bound )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==POINT_POINT) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // EplParserRules.g:75:18: '..' bound
                    {
                    string_literal17=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_cardinality186); if (state.failed) return retval;
                    pushFollow(FOLLOW_bound_in_cardinality189);
                    bound18=bound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bound18.getTree());

                    }
                    break;

            }

            char_literal19=(Token)match(input,149,FOLLOW_149_in_cardinality193); if (state.failed) return retval;
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
    // EplParserRules.g:79:1: bound : ( INT | '*' );
    public final Epl_EplParserRules.bound_return bound() throws RecognitionException {
        Epl_EplParserRules.bound_return retval = new Epl_EplParserRules.bound_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set20=null;

        CommonTree set20_tree=null;

        try {
            // EplParserRules.g:80:2: ( INT | '*' )
            // EplParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set20=(Token)input.LT(1);
            if ( input.LA(1)==INT||input.LA(1)==145 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set20));
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
    // EplParserRules.g:83:1: domain : (c= 'in' | c= 'from' ) expressionOrStatementBlock ;
    public final Epl_EplParserRules.domain_return domain() throws RecognitionException {
        Epl_EplParserRules.domain_return retval = new Epl_EplParserRules.domain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock21 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:83:8: ( (c= 'in' | c= 'from' ) expressionOrStatementBlock )
            // EplParserRules.g:84:2: (c= 'in' | c= 'from' ) expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            // EplParserRules.g:84:2: (c= 'in' | c= 'from' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==116) ) {
                alt11=1;
            }
            else if ( (LA11_0==159) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // EplParserRules.g:84:3: c= 'in'
                    {
                    c=(Token)match(input,116,FOLLOW_116_in_domain226); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (CommonTree)adaptor.create(c);
                    root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // EplParserRules.g:84:11: c= 'from'
                    {
                    c=(Token)match(input,159,FOLLOW_159_in_domain231); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c_tree = (CommonTree)adaptor.create(c);
                    root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_expressionOrStatementBlock_in_domain235);
            expressionOrStatementBlock21=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock21.getTree());
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
    // EplParserRules.g:88:1: match : c= 'match' expressionOrStatementBlock ;
    public final Epl_EplParserRules.match_return match() throws RecognitionException {
        Epl_EplParserRules.match_return retval = new Epl_EplParserRules.match_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock22 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:88:7: (c= 'match' expressionOrStatementBlock )
            // EplParserRules.g:89:2: c= 'match' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,160,FOLLOW_160_in_match252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_match255);
            expressionOrStatementBlock22=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock22.getTree());
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
    // EplParserRules.g:93:1: do_ : c= 'do' expressionOrStatementBlock ;
    public final Epl_EplParserRules.do__return do_() throws RecognitionException {
        Epl_EplParserRules.do__return retval = new Epl_EplParserRules.do__return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock23 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:93:5: (c= 'do' expressionOrStatementBlock )
            // EplParserRules.g:94:2: c= 'do' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,161,FOLLOW_161_in_do_271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_do_274);
            expressionOrStatementBlock23=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock23.getTree());
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
    // EplParserRules.g:98:1: nomatch : c= 'nomatch' expressionOrStatementBlock ;
    public final Epl_EplParserRules.nomatch_return nomatch() throws RecognitionException {
        Epl_EplParserRules.nomatch_return retval = new Epl_EplParserRules.nomatch_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock24 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:98:9: (c= 'nomatch' expressionOrStatementBlock )
            // EplParserRules.g:99:2: c= 'nomatch' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,162,FOLLOW_162_in_nomatch291); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_nomatch294);
            expressionOrStatementBlock24=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock24.getTree());
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


 

    public static final BitSet FOLLOW_157_in_pattern76 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern81 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_component_in_pattern84 = new BitSet(new long[]{0x0000000000000002L,0x0000000090000000L});
    public static final BitSet FOLLOW_92_in_pattern87 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_component_in_pattern90 = new BitSet(new long[]{0x0000000000000002L,0x0000000090000000L});
    public static final BitSet FOLLOW_95_in_pattern95 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000700000000L});
    public static final BitSet FOLLOW_match_in_pattern98 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_do__in_pattern101 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_nomatch_in_pattern104 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_pattern107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_no_in_component124 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_component127 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_92_in_component130 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_component133 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_91_in_component139 = new BitSet(new long[]{0x0000000000080000L,0x0007F80000000000L});
    public static final BitSet FOLLOW_typeName_in_component144 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_domain_in_component148 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_guard_in_component151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_no167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_cardinality180 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_bound_in_cardinality183 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_POINT_POINT_in_cardinality186 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_bound_in_cardinality189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_149_in_cardinality193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bound0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_domain226 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_159_in_domain231 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_domain235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_match252 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_match255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_do_271 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_do_274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_nomatch291 = new BitSet(new long[]{0x0000000000000000L,0x0000000088000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_nomatch294 = new BitSet(new long[]{0x0000000000000002L});

}
