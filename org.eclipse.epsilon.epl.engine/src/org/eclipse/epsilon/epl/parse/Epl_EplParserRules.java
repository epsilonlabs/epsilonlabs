package org.eclipse.epsilon.epl.parse;

// $ANTLR 3.1b1 EplParserRules.g 2012-02-10 14:51:48

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
    public static final int MATCH=85;
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
    // EplParserRules.g:59:1: patterns : 'patterns' c= NAME '{' ( pattern )* '}' ;
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
            // EplParserRules.g:60:2: ( 'patterns' c= NAME '{' ( pattern )* '}' )
            // EplParserRules.g:61:2: 'patterns' c= NAME '{' ( pattern )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal1=(Token)match(input,156,FOLLOW_156_in_patterns69); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_patterns74); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            char_literal2=(Token)match(input,94,FOLLOW_94_in_patterns77); if (state.failed) return retval;
            // EplParserRules.g:61:27: ( pattern )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==157) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EplParserRules.g:0:0: pattern
            	    {
            	    pushFollow(FOLLOW_pattern_in_patterns80);
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

            char_literal4=(Token)match(input,95,FOLLOW_95_in_patterns83); if (state.failed) return retval;
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
    // EplParserRules.g:65:1: pattern : 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? '}' )? ;
    public final Epl_EplParserRules.pattern_return pattern() throws RecognitionException {
        Epl_EplParserRules.pattern_return retval = new Epl_EplParserRules.pattern_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal5=null;
        Token char_literal7=null;
        Token char_literal9=null;
        Token char_literal12=null;
        Epl_EplParserRules.component_return component6 = null;

        Epl_EplParserRules.component_return component8 = null;

        Epl_EplParserRules.match_return match10 = null;

        Epl_EplParserRules.do__return do_11 = null;


        CommonTree c_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree char_literal9_tree=null;
        CommonTree char_literal12_tree=null;

        try {
            // EplParserRules.g:66:2: ( 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? '}' )? )
            // EplParserRules.g:67:2: 'pattern' c= NAME component ( ',' component )* ( '{' ( match )? ( do_ )? '}' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal5=(Token)match(input,157,FOLLOW_157_in_pattern100); if (state.failed) return retval;
            c=(Token)match(input,NAME,FOLLOW_NAME_in_pattern105); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_component_in_pattern108);
            component6=component();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, component6.getTree());
            // EplParserRules.g:67:31: ( ',' component )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==91) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EplParserRules.g:67:32: ',' component
            	    {
            	    char_literal7=(Token)match(input,91,FOLLOW_91_in_pattern111); if (state.failed) return retval;
            	    pushFollow(FOLLOW_component_in_pattern114);
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

            // EplParserRules.g:67:49: ( '{' ( match )? ( do_ )? '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==94) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // EplParserRules.g:67:50: '{' ( match )? ( do_ )? '}'
                    {
                    char_literal9=(Token)match(input,94,FOLLOW_94_in_pattern119); if (state.failed) return retval;
                    // EplParserRules.g:67:55: ( match )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==158) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // EplParserRules.g:0:0: match
                            {
                            pushFollow(FOLLOW_match_in_pattern122);
                            match10=match();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, match10.getTree());

                            }
                            break;

                    }

                    // EplParserRules.g:67:62: ( do_ )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==159) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // EplParserRules.g:0:0: do_
                            {
                            pushFollow(FOLLOW_do__in_pattern125);
                            do_11=do_();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, do_11.getTree());

                            }
                            break;

                    }

                    char_literal12=(Token)match(input,95,FOLLOW_95_in_pattern128); if (state.failed) return retval;

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
    // EplParserRules.g:71:1: component : n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )? ;
    public final Epl_EplParserRules.component_return component() throws RecognitionException {
        Epl_EplParserRules.component_return retval = new Epl_EplParserRules.component_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token char_literal13=null;
        Epl_EolParserRules.typeName_return t = null;

        Epl_EplParserRules.cardinality_return cardinality14 = null;

        Epl_EplParserRules.domain_return domain15 = null;

        Epl_ErlParserRules.guard_return guard16 = null;


        CommonTree n_tree=null;
        CommonTree char_literal13_tree=null;

        try {
            // EplParserRules.g:72:2: (n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )? )
            // EplParserRules.g:72:4: n= NAME ':' t= typeName ( cardinality )? ( domain )? ( guard )?
            {
            root_0 = (CommonTree)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_component147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (CommonTree)adaptor.create(n);
            root_0 = (CommonTree)adaptor.becomeRoot(n_tree, root_0);
            }
            char_literal13=(Token)match(input,90,FOLLOW_90_in_component150); if (state.failed) return retval;
            pushFollow(FOLLOW_typeName_in_component155);
            t=gEpl.typeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if ( state.backtracking==0 ) {
              setTokenType(t, TYPE);
            }
            // EplParserRules.g:72:53: ( cardinality )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==147) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // EplParserRules.g:0:0: cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_component159);
                    cardinality14=cardinality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cardinality14.getTree());

                    }
                    break;

            }

            // EplParserRules.g:72:66: ( domain )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==115) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // EplParserRules.g:0:0: domain
                    {
                    pushFollow(FOLLOW_domain_in_component162);
                    domain15=domain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, domain15.getTree());

                    }
                    break;

            }

            // EplParserRules.g:72:74: ( guard )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==154) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // EplParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_component165);
                    guard16=gEpl.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard16.getTree());

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
    // EplParserRules.g:77:1: cardinality : c= '[' bound ( '..' bound )? ']' ;
    public final Epl_EplParserRules.cardinality_return cardinality() throws RecognitionException {
        Epl_EplParserRules.cardinality_return retval = new Epl_EplParserRules.cardinality_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Token string_literal18=null;
        Token char_literal20=null;
        Epl_EplParserRules.bound_return bound17 = null;

        Epl_EplParserRules.bound_return bound19 = null;


        CommonTree c_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree char_literal20_tree=null;

        try {
            // EplParserRules.g:78:2: (c= '[' bound ( '..' bound )? ']' )
            // EplParserRules.g:78:4: c= '[' bound ( '..' bound )? ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,147,FOLLOW_147_in_cardinality183); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_bound_in_cardinality186);
            bound17=bound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bound17.getTree());
            // EplParserRules.g:78:17: ( '..' bound )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==POINT_POINT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // EplParserRules.g:78:18: '..' bound
                    {
                    string_literal18=(Token)match(input,POINT_POINT,FOLLOW_POINT_POINT_in_cardinality189); if (state.failed) return retval;
                    pushFollow(FOLLOW_bound_in_cardinality192);
                    bound19=bound();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bound19.getTree());

                    }
                    break;

            }

            char_literal20=(Token)match(input,148,FOLLOW_148_in_cardinality196); if (state.failed) return retval;
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
    // EplParserRules.g:82:1: bound : ( INT | '*' );
    public final Epl_EplParserRules.bound_return bound() throws RecognitionException {
        Epl_EplParserRules.bound_return retval = new Epl_EplParserRules.bound_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set21=null;

        CommonTree set21_tree=null;

        try {
            // EplParserRules.g:83:2: ( INT | '*' )
            // EplParserRules.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set21=(Token)input.LT(1);
            if ( input.LA(1)==INT||input.LA(1)==144 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set21));
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
    // EplParserRules.g:86:1: domain : c= 'in' expressionOrStatementBlock ;
    public final Epl_EplParserRules.domain_return domain() throws RecognitionException {
        Epl_EplParserRules.domain_return retval = new Epl_EplParserRules.domain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock22 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:86:8: (c= 'in' expressionOrStatementBlock )
            // EplParserRules.g:87:2: c= 'in' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,115,FOLLOW_115_in_domain228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_domain231);
            expressionOrStatementBlock22=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock22.getTree());
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
    // EplParserRules.g:91:1: match : c= 'match' expressionOrStatementBlock ;
    public final Epl_EplParserRules.match_return match() throws RecognitionException {
        Epl_EplParserRules.match_return retval = new Epl_EplParserRules.match_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock23 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:91:7: (c= 'match' expressionOrStatementBlock )
            // EplParserRules.g:92:2: c= 'match' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,158,FOLLOW_158_in_match248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_match251);
            expressionOrStatementBlock23=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock23.getTree());
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
    // EplParserRules.g:96:1: do_ : c= 'do' expressionOrStatementBlock ;
    public final Epl_EplParserRules.do__return do_() throws RecognitionException {
        Epl_EplParserRules.do__return retval = new Epl_EplParserRules.do__return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c=null;
        Epl_EolParserRules.expressionOrStatementBlock_return expressionOrStatementBlock24 = null;


        CommonTree c_tree=null;

        try {
            // EplParserRules.g:96:5: (c= 'do' expressionOrStatementBlock )
            // EplParserRules.g:97:2: c= 'do' expressionOrStatementBlock
            {
            root_0 = (CommonTree)adaptor.nil();

            c=(Token)match(input,159,FOLLOW_159_in_do_267); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            c_tree = (CommonTree)adaptor.create(c);
            root_0 = (CommonTree)adaptor.becomeRoot(c_tree, root_0);
            }
            pushFollow(FOLLOW_expressionOrStatementBlock_in_do_270);
            expressionOrStatementBlock24=gEpl.expressionOrStatementBlock();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionOrStatementBlock24.getTree());
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

    // Delegated rules


 

    public static final BitSet FOLLOW_156_in_patterns69 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_patterns74 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_patterns77 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_pattern_in_patterns80 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_95_in_patterns83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_pattern100 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_pattern105 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern108 = new BitSet(new long[]{0x0000000000000002L,0x0000000048000000L});
    public static final BitSet FOLLOW_91_in_pattern111 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_component_in_pattern114 = new BitSet(new long[]{0x0000000000000002L,0x0000000048000000L});
    public static final BitSet FOLLOW_94_in_pattern119 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_match_in_pattern122 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_do__in_pattern125 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_pattern128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_component147 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_component150 = new BitSet(new long[]{0x0000000000080000L,0x0003FC0000000000L});
    public static final BitSet FOLLOW_typeName_in_component155 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L,0x0000000004080000L});
    public static final BitSet FOLLOW_cardinality_in_component159 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_domain_in_component162 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_guard_in_component165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_cardinality183 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_bound_in_cardinality186 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_POINT_POINT_in_cardinality189 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_bound_in_cardinality192 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_cardinality196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_bound0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_domain228 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_domain231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_match248 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_match251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_do_267 = new BitSet(new long[]{0x0000000000000000L,0x0000000044000000L});
    public static final BitSet FOLLOW_expressionOrStatementBlock_in_do_270 = new BitSet(new long[]{0x0000000000000002L});

}
