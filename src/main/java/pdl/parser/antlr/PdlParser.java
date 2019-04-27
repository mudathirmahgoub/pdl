// Generated from Pdl.g4 by ANTLR 4.7.2
package pdl.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PdlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Star=7, Semicolon=8, QuestionMark=9, 
		Bar=10, Skip=11, Fail=12, If=13, Fi=14, Do=15, Od=16, Then=17, Else=18, 
		While=19, Repeat=20, Until=21, Union=22, Or=23, And=24, Not=25, LeftParenthesis=26, 
		RightParenthesis=27, LeftSquareBracket=28, RightSquareBracket=29, LeftCurlyBracket=30, 
		RightCurlyBracket=31, LeftAngle=32, RightAngle=33, Identifier=34, IdentifierLetter=35, 
		RightArrow=36, LeftRightArrow=37, Digit=38, Comment=39, Whitespace=40;
	public static final int
		RULE_pdl = 0, RULE_kripkeFrame = 1, RULE_states = 2, RULE_propositionMeaning = 3, 
		RULE_programMeaning = 4, RULE_pair = 5, RULE_formula = 6, RULE_hoarePartialCorrectness = 7, 
		RULE_falsity = 8, RULE_truth = 9, RULE_atomicFormula = 10, RULE_program = 11, 
		RULE_skip = 12, RULE_fail = 13, RULE_atomicProgram = 14, RULE_alternativeGuardedCommand = 15, 
		RULE_iterativeGuardedCommand = 16, RULE_guardedCommand = 17, RULE_iteProgram = 18, 
		RULE_whileProgram = 19, RULE_repeatProgram = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"pdl", "kripkeFrame", "states", "propositionMeaning", "programMeaning", 
			"pair", "formula", "hoarePartialCorrectness", "falsity", "truth", "atomicFormula", 
			"program", "skip", "fail", "atomicProgram", "alternativeGuardedCommand", 
			"iterativeGuardedCommand", "guardedCommand", "iteProgram", "whileProgram", 
			"repeatProgram"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'K'", "'='", "','", "'m'", "'0'", "'1'", "'*'", "';'", "'?'", 
			"'|'", "'skip'", "'fail'", "'if'", "'fi'", "'do'", "'od'", "'then'", 
			"'else'", "'while'", "'repeat'", "'until'", null, null, null, null, "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "Star", "Semicolon", "QuestionMark", 
			"Bar", "Skip", "Fail", "If", "Fi", "Do", "Od", "Then", "Else", "While", 
			"Repeat", "Until", "Union", "Or", "And", "Not", "LeftParenthesis", "RightParenthesis", 
			"LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", 
			"LeftAngle", "RightAngle", "Identifier", "IdentifierLetter", "RightArrow", 
			"LeftRightArrow", "Digit", "Comment", "Whitespace"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pdl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PdlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PdlContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public KripkeFrameContext kripkeFrame() {
			return getRuleContext(KripkeFrameContext.class,0);
		}
		public PdlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pdl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterPdl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitPdl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitPdl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PdlContext pdl() throws RecognitionException {
		PdlContext _localctx = new PdlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pdl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(42);
				kripkeFrame();
				}
			}

			setState(45);
			formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KripkeFrameContext extends ParserRuleContext {
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public List<PropositionMeaningContext> propositionMeaning() {
			return getRuleContexts(PropositionMeaningContext.class);
		}
		public PropositionMeaningContext propositionMeaning(int i) {
			return getRuleContext(PropositionMeaningContext.class,i);
		}
		public List<ProgramMeaningContext> programMeaning() {
			return getRuleContexts(ProgramMeaningContext.class);
		}
		public ProgramMeaningContext programMeaning(int i) {
			return getRuleContext(ProgramMeaningContext.class,i);
		}
		public KripkeFrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kripkeFrame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterKripkeFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitKripkeFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitKripkeFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KripkeFrameContext kripkeFrame() throws RecognitionException {
		KripkeFrameContext _localctx = new KripkeFrameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_kripkeFrame);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			states();
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					propositionMeaning();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(54);
				programMeaning();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatesContext extends ParserRuleContext {
		public TerminalNode LeftCurlyBracket() { return getToken(PdlParser.LeftCurlyBracket, 0); }
		public List<TerminalNode> Identifier() { return getTokens(PdlParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PdlParser.Identifier, i);
		}
		public TerminalNode RightCurlyBracket() { return getToken(PdlParser.RightCurlyBracket, 0); }
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitStates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitStates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			match(T__1);
			setState(62);
			match(LeftCurlyBracket);
			setState(63);
			match(Identifier);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(64);
				match(T__2);
				setState(65);
				match(Identifier);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropositionMeaningContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(PdlParser.LeftParenthesis, 0); }
		public List<TerminalNode> Identifier() { return getTokens(PdlParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PdlParser.Identifier, i);
		}
		public TerminalNode RightParenthesis() { return getToken(PdlParser.RightParenthesis, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(PdlParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(PdlParser.RightCurlyBracket, 0); }
		public PropositionMeaningContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propositionMeaning; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterPropositionMeaning(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitPropositionMeaning(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitPropositionMeaning(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropositionMeaningContext propositionMeaning() throws RecognitionException {
		PropositionMeaningContext _localctx = new PropositionMeaningContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_propositionMeaning);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__3);
			setState(74);
			match(LeftParenthesis);
			setState(75);
			match(Identifier);
			setState(76);
			match(RightParenthesis);
			setState(77);
			match(T__1);
			setState(78);
			match(LeftCurlyBracket);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(79);
				match(Identifier);
				}
			}

			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(82);
				match(T__2);
				setState(83);
				match(Identifier);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramMeaningContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(PdlParser.LeftParenthesis, 0); }
		public TerminalNode Identifier() { return getToken(PdlParser.Identifier, 0); }
		public TerminalNode RightParenthesis() { return getToken(PdlParser.RightParenthesis, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(PdlParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(PdlParser.RightCurlyBracket, 0); }
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ProgramMeaningContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programMeaning; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterProgramMeaning(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitProgramMeaning(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitProgramMeaning(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramMeaningContext programMeaning() throws RecognitionException {
		ProgramMeaningContext _localctx = new ProgramMeaningContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_programMeaning);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__3);
			setState(92);
			match(LeftParenthesis);
			setState(93);
			match(Identifier);
			setState(94);
			match(RightParenthesis);
			setState(95);
			match(T__1);
			setState(96);
			match(LeftCurlyBracket);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParenthesis) {
				{
				setState(97);
				pair();
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(100);
				match(T__2);
				setState(101);
				pair();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(PdlParser.LeftParenthesis, 0); }
		public List<TerminalNode> Identifier() { return getTokens(PdlParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PdlParser.Identifier, i);
		}
		public TerminalNode RightParenthesis() { return getToken(PdlParser.RightParenthesis, 0); }
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LeftParenthesis);
			setState(110);
			match(Identifier);
			setState(111);
			match(T__2);
			setState(112);
			match(Identifier);
			setState(113);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public FalsityContext falsity() {
			return getRuleContext(FalsityContext.class,0);
		}
		public TruthContext truth() {
			return getRuleContext(TruthContext.class,0);
		}
		public AtomicFormulaContext atomicFormula() {
			return getRuleContext(AtomicFormulaContext.class,0);
		}
		public TerminalNode LeftParenthesis() { return getToken(PdlParser.LeftParenthesis, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode RightParenthesis() { return getToken(PdlParser.RightParenthesis, 0); }
		public TerminalNode Not() { return getToken(PdlParser.Not, 0); }
		public TerminalNode LeftSquareBracket() { return getToken(PdlParser.LeftSquareBracket, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode RightSquareBracket() { return getToken(PdlParser.RightSquareBracket, 0); }
		public TerminalNode LeftAngle() { return getToken(PdlParser.LeftAngle, 0); }
		public TerminalNode RightAngle() { return getToken(PdlParser.RightAngle, 0); }
		public HoarePartialCorrectnessContext hoarePartialCorrectness() {
			return getRuleContext(HoarePartialCorrectnessContext.class,0);
		}
		public TerminalNode And() { return getToken(PdlParser.And, 0); }
		public TerminalNode Or() { return getToken(PdlParser.Or, 0); }
		public TerminalNode RightArrow() { return getToken(PdlParser.RightArrow, 0); }
		public TerminalNode LeftRightArrow() { return getToken(PdlParser.LeftRightArrow, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(116);
				falsity();
				}
				break;
			case T__5:
				{
				setState(117);
				truth();
				}
				break;
			case Identifier:
				{
				setState(118);
				atomicFormula();
				}
				break;
			case LeftParenthesis:
				{
				setState(119);
				match(LeftParenthesis);
				setState(120);
				formula(0);
				setState(121);
				match(RightParenthesis);
				}
				break;
			case Not:
				{
				setState(123);
				match(Not);
				setState(124);
				formula(8);
				}
				break;
			case LeftSquareBracket:
				{
				setState(125);
				match(LeftSquareBracket);
				setState(126);
				program(0);
				setState(127);
				match(RightSquareBracket);
				setState(128);
				formula(7);
				}
				break;
			case LeftAngle:
				{
				setState(130);
				match(LeftAngle);
				setState(131);
				program(0);
				setState(132);
				match(RightAngle);
				setState(133);
				formula(6);
				}
				break;
			case LeftCurlyBracket:
				{
				setState(135);
				hoarePartialCorrectness();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(138);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(139);
						match(And);
						setState(140);
						formula(6);
						}
						break;
					case 2:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(141);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(142);
						match(Or);
						setState(143);
						formula(5);
						}
						break;
					case 3:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(144);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(145);
						match(RightArrow);
						setState(146);
						formula(4);
						}
						break;
					case 4:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(147);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(148);
						match(LeftRightArrow);
						setState(149);
						formula(3);
						}
						break;
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class HoarePartialCorrectnessContext extends ParserRuleContext {
		public List<TerminalNode> LeftCurlyBracket() { return getTokens(PdlParser.LeftCurlyBracket); }
		public TerminalNode LeftCurlyBracket(int i) {
			return getToken(PdlParser.LeftCurlyBracket, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TerminalNode> RightCurlyBracket() { return getTokens(PdlParser.RightCurlyBracket); }
		public TerminalNode RightCurlyBracket(int i) {
			return getToken(PdlParser.RightCurlyBracket, i);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public HoarePartialCorrectnessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hoarePartialCorrectness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterHoarePartialCorrectness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitHoarePartialCorrectness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitHoarePartialCorrectness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HoarePartialCorrectnessContext hoarePartialCorrectness() throws RecognitionException {
		HoarePartialCorrectnessContext _localctx = new HoarePartialCorrectnessContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_hoarePartialCorrectness);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LeftCurlyBracket);
			setState(156);
			formula(0);
			setState(157);
			match(RightCurlyBracket);
			setState(158);
			program(0);
			setState(159);
			match(LeftCurlyBracket);
			setState(160);
			formula(0);
			setState(161);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FalsityContext extends ParserRuleContext {
		public FalsityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falsity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterFalsity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitFalsity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitFalsity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalsityContext falsity() throws RecognitionException {
		FalsityContext _localctx = new FalsityContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_falsity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TruthContext extends ParserRuleContext {
		public TruthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterTruth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitTruth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitTruth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TruthContext truth() throws RecognitionException {
		TruthContext _localctx = new TruthContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_truth);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicFormulaContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PdlParser.Identifier, 0); }
		public AtomicFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterAtomicFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitAtomicFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitAtomicFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicFormulaContext atomicFormula() throws RecognitionException {
		AtomicFormulaContext _localctx = new AtomicFormulaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atomicFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public SkipContext skip() {
			return getRuleContext(SkipContext.class,0);
		}
		public FailContext fail() {
			return getRuleContext(FailContext.class,0);
		}
		public AlternativeGuardedCommandContext alternativeGuardedCommand() {
			return getRuleContext(AlternativeGuardedCommandContext.class,0);
		}
		public IterativeGuardedCommandContext iterativeGuardedCommand() {
			return getRuleContext(IterativeGuardedCommandContext.class,0);
		}
		public AtomicProgramContext atomicProgram() {
			return getRuleContext(AtomicProgramContext.class,0);
		}
		public IteProgramContext iteProgram() {
			return getRuleContext(IteProgramContext.class,0);
		}
		public WhileProgramContext whileProgram() {
			return getRuleContext(WhileProgramContext.class,0);
		}
		public RepeatProgramContext repeatProgram() {
			return getRuleContext(RepeatProgramContext.class,0);
		}
		public TerminalNode LeftParenthesis() { return getToken(PdlParser.LeftParenthesis, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode RightParenthesis() { return getToken(PdlParser.RightParenthesis, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode QuestionMark() { return getToken(PdlParser.QuestionMark, 0); }
		public TerminalNode Semicolon() { return getToken(PdlParser.Semicolon, 0); }
		public TerminalNode Union() { return getToken(PdlParser.Union, 0); }
		public TerminalNode Star() { return getToken(PdlParser.Star, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(170);
				skip();
				}
				break;
			case 3:
				{
				setState(171);
				fail();
				}
				break;
			case 4:
				{
				setState(172);
				alternativeGuardedCommand();
				}
				break;
			case 5:
				{
				setState(173);
				iterativeGuardedCommand();
				}
				break;
			case 6:
				{
				setState(174);
				atomicProgram();
				}
				break;
			case 7:
				{
				setState(175);
				iteProgram();
				}
				break;
			case 8:
				{
				setState(176);
				whileProgram();
				}
				break;
			case 9:
				{
				setState(177);
				repeatProgram();
				}
				break;
			case 10:
				{
				setState(178);
				match(LeftParenthesis);
				setState(179);
				program(0);
				setState(180);
				match(RightParenthesis);
				}
				break;
			case 11:
				{
				setState(182);
				formula(0);
				setState(183);
				match(QuestionMark);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(195);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ProgramContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_program);
						setState(187);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(188);
						match(Semicolon);
						setState(189);
						program(5);
						}
						break;
					case 2:
						{
						_localctx = new ProgramContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_program);
						setState(190);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(191);
						match(Union);
						setState(192);
						program(4);
						}
						break;
					case 3:
						{
						_localctx = new ProgramContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_program);
						setState(193);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(194);
						match(Star);
						}
						break;
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SkipContext extends ParserRuleContext {
		public TerminalNode Skip() { return getToken(PdlParser.Skip, 0); }
		public SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipContext skip() throws RecognitionException {
		SkipContext _localctx = new SkipContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_skip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(Skip);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FailContext extends ParserRuleContext {
		public TerminalNode Fail() { return getToken(PdlParser.Fail, 0); }
		public FailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterFail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitFail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitFail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FailContext fail() throws RecognitionException {
		FailContext _localctx = new FailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(Fail);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicProgramContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PdlParser.Identifier, 0); }
		public AtomicProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterAtomicProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitAtomicProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitAtomicProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicProgramContext atomicProgram() throws RecognitionException {
		AtomicProgramContext _localctx = new AtomicProgramContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atomicProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativeGuardedCommandContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(PdlParser.If, 0); }
		public List<GuardedCommandContext> guardedCommand() {
			return getRuleContexts(GuardedCommandContext.class);
		}
		public GuardedCommandContext guardedCommand(int i) {
			return getRuleContext(GuardedCommandContext.class,i);
		}
		public TerminalNode Fi() { return getToken(PdlParser.Fi, 0); }
		public List<TerminalNode> Bar() { return getTokens(PdlParser.Bar); }
		public TerminalNode Bar(int i) {
			return getToken(PdlParser.Bar, i);
		}
		public AlternativeGuardedCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeGuardedCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterAlternativeGuardedCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitAlternativeGuardedCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitAlternativeGuardedCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativeGuardedCommandContext alternativeGuardedCommand() throws RecognitionException {
		AlternativeGuardedCommandContext _localctx = new AlternativeGuardedCommandContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_alternativeGuardedCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(If);
			setState(207);
			guardedCommand();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Bar) {
				{
				{
				setState(208);
				match(Bar);
				setState(209);
				guardedCommand();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(Fi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterativeGuardedCommandContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(PdlParser.Do, 0); }
		public List<GuardedCommandContext> guardedCommand() {
			return getRuleContexts(GuardedCommandContext.class);
		}
		public GuardedCommandContext guardedCommand(int i) {
			return getRuleContext(GuardedCommandContext.class,i);
		}
		public TerminalNode Od() { return getToken(PdlParser.Od, 0); }
		public List<TerminalNode> Bar() { return getTokens(PdlParser.Bar); }
		public TerminalNode Bar(int i) {
			return getToken(PdlParser.Bar, i);
		}
		public IterativeGuardedCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeGuardedCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterIterativeGuardedCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitIterativeGuardedCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitIterativeGuardedCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeGuardedCommandContext iterativeGuardedCommand() throws RecognitionException {
		IterativeGuardedCommandContext _localctx = new IterativeGuardedCommandContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_iterativeGuardedCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(Do);
			setState(218);
			guardedCommand();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Bar) {
				{
				{
				setState(219);
				match(Bar);
				setState(220);
				guardedCommand();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(Od);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardedCommandContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode RightArrow() { return getToken(PdlParser.RightArrow, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public GuardedCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardedCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterGuardedCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitGuardedCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitGuardedCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardedCommandContext guardedCommand() throws RecognitionException {
		GuardedCommandContext _localctx = new GuardedCommandContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_guardedCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			formula(0);
			setState(229);
			match(RightArrow);
			setState(230);
			program(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IteProgramContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(PdlParser.If, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode Then() { return getToken(PdlParser.Then, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode Else() { return getToken(PdlParser.Else, 0); }
		public IteProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterIteProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitIteProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitIteProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteProgramContext iteProgram() throws RecognitionException {
		IteProgramContext _localctx = new IteProgramContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_iteProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(If);
			setState(233);
			formula(0);
			setState(234);
			match(Then);
			setState(235);
			program(0);
			setState(236);
			match(Else);
			setState(237);
			program(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileProgramContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(PdlParser.While, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode Do() { return getToken(PdlParser.Do, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public WhileProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterWhileProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitWhileProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitWhileProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileProgramContext whileProgram() throws RecognitionException {
		WhileProgramContext _localctx = new WhileProgramContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_whileProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(While);
			setState(240);
			formula(0);
			setState(241);
			match(Do);
			setState(242);
			program(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatProgramContext extends ParserRuleContext {
		public TerminalNode Repeat() { return getToken(PdlParser.Repeat, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode Until() { return getToken(PdlParser.Until, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public RepeatProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).enterRepeatProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PdlListener ) ((PdlListener)listener).exitRepeatProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PdlVisitor ) return ((PdlVisitor<? extends T>)visitor).visitRepeatProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatProgramContext repeatProgram() throws RecognitionException {
		RepeatProgramContext _localctx = new RepeatProgramContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_repeatProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(Repeat);
			setState(245);
			program(0);
			setState(246);
			match(Until);
			setState(247);
			formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 11:
			return program_sempred((ProgramContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00fc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\5\2.\n\2\3\2\3\2\3\3\3\3"+
		"\7\3\64\n\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\7\4E\n\4\f\4\16\4H\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5S\n\5\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6e\n\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008b\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\7\b\u0099\n\b\f\b\16\b\u009c\13\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bc\n\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\r\u00c6\n\r\f\r\16\r\u00c9\13\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\7\21\u00d5\n\21\f\21\16\21\u00d8\13\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\7\22\u00e0\n\22\f\22\16\22\u00e3\13\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\2\4\16\30\27\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*\2\2\2\u0108\2-\3\2\2\2\4\61\3\2\2\2"+
		"\6>\3\2\2\2\bK\3\2\2\2\n]\3\2\2\2\fo\3\2\2\2\16\u008a\3\2\2\2\20\u009d"+
		"\3\2\2\2\22\u00a5\3\2\2\2\24\u00a7\3\2\2\2\26\u00a9\3\2\2\2\30\u00bb\3"+
		"\2\2\2\32\u00ca\3\2\2\2\34\u00cc\3\2\2\2\36\u00ce\3\2\2\2 \u00d0\3\2\2"+
		"\2\"\u00db\3\2\2\2$\u00e6\3\2\2\2&\u00ea\3\2\2\2(\u00f1\3\2\2\2*\u00f6"+
		"\3\2\2\2,.\5\4\3\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60\5\16\b\2\60\3\3\2"+
		"\2\2\61\65\5\6\4\2\62\64\5\b\5\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2"+
		"\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5\n\6\298\3\2\2\2:=\3\2"+
		"\2\2;9\3\2\2\2;<\3\2\2\2<\5\3\2\2\2=;\3\2\2\2>?\7\3\2\2?@\7\4\2\2@A\7"+
		" \2\2AF\7$\2\2BC\7\5\2\2CE\7$\2\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2"+
		"\2\2GI\3\2\2\2HF\3\2\2\2IJ\7!\2\2J\7\3\2\2\2KL\7\6\2\2LM\7\34\2\2MN\7"+
		"$\2\2NO\7\35\2\2OP\7\4\2\2PR\7 \2\2QS\7$\2\2RQ\3\2\2\2RS\3\2\2\2SX\3\2"+
		"\2\2TU\7\5\2\2UW\7$\2\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2"+
		"\2\2ZX\3\2\2\2[\\\7!\2\2\\\t\3\2\2\2]^\7\6\2\2^_\7\34\2\2_`\7$\2\2`a\7"+
		"\35\2\2ab\7\4\2\2bd\7 \2\2ce\5\f\7\2dc\3\2\2\2de\3\2\2\2ej\3\2\2\2fg\7"+
		"\5\2\2gi\5\f\7\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3"+
		"\2\2\2mn\7!\2\2n\13\3\2\2\2op\7\34\2\2pq\7$\2\2qr\7\5\2\2rs\7$\2\2st\7"+
		"\35\2\2t\r\3\2\2\2uv\b\b\1\2v\u008b\5\22\n\2w\u008b\5\24\13\2x\u008b\5"+
		"\26\f\2yz\7\34\2\2z{\5\16\b\2{|\7\35\2\2|\u008b\3\2\2\2}~\7\33\2\2~\u008b"+
		"\5\16\b\n\177\u0080\7\36\2\2\u0080\u0081\5\30\r\2\u0081\u0082\7\37\2\2"+
		"\u0082\u0083\5\16\b\t\u0083\u008b\3\2\2\2\u0084\u0085\7\"\2\2\u0085\u0086"+
		"\5\30\r\2\u0086\u0087\7#\2\2\u0087\u0088\5\16\b\b\u0088\u008b\3\2\2\2"+
		"\u0089\u008b\5\20\t\2\u008au\3\2\2\2\u008aw\3\2\2\2\u008ax\3\2\2\2\u008a"+
		"y\3\2\2\2\u008a}\3\2\2\2\u008a\177\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0089"+
		"\3\2\2\2\u008b\u009a\3\2\2\2\u008c\u008d\f\7\2\2\u008d\u008e\7\32\2\2"+
		"\u008e\u0099\5\16\b\b\u008f\u0090\f\6\2\2\u0090\u0091\7\31\2\2\u0091\u0099"+
		"\5\16\b\7\u0092\u0093\f\5\2\2\u0093\u0094\7&\2\2\u0094\u0099\5\16\b\6"+
		"\u0095\u0096\f\4\2\2\u0096\u0097\7\'\2\2\u0097\u0099\5\16\b\5\u0098\u008c"+
		"\3\2\2\2\u0098\u008f\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0095\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\17\3\2\2"+
		"\2\u009c\u009a\3\2\2\2\u009d\u009e\7 \2\2\u009e\u009f\5\16\b\2\u009f\u00a0"+
		"\7!\2\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2\7 \2\2\u00a2\u00a3\5\16\b\2\u00a3"+
		"\u00a4\7!\2\2\u00a4\21\3\2\2\2\u00a5\u00a6\7\7\2\2\u00a6\23\3\2\2\2\u00a7"+
		"\u00a8\7\b\2\2\u00a8\25\3\2\2\2\u00a9\u00aa\7$\2\2\u00aa\27\3\2\2\2\u00ab"+
		"\u00bc\b\r\1\2\u00ac\u00bc\5\32\16\2\u00ad\u00bc\5\34\17\2\u00ae\u00bc"+
		"\5 \21\2\u00af\u00bc\5\"\22\2\u00b0\u00bc\5\36\20\2\u00b1\u00bc\5&\24"+
		"\2\u00b2\u00bc\5(\25\2\u00b3\u00bc\5*\26\2\u00b4\u00b5\7\34\2\2\u00b5"+
		"\u00b6\5\30\r\2\u00b6\u00b7\7\35\2\2\u00b7\u00bc\3\2\2\2\u00b8\u00b9\5"+
		"\16\b\2\u00b9\u00ba\7\13\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00ab\3\2\2\2\u00bb"+
		"\u00ac\3\2\2\2\u00bb\u00ad\3\2\2\2\u00bb\u00ae\3\2\2\2\u00bb\u00af\3\2"+
		"\2\2\u00bb\u00b0\3\2\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00b2\3\2\2\2\u00bb"+
		"\u00b3\3\2\2\2\u00bb\u00b4\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bc\u00c7\3\2"+
		"\2\2\u00bd\u00be\f\6\2\2\u00be\u00bf\7\n\2\2\u00bf\u00c6\5\30\r\7\u00c0"+
		"\u00c1\f\5\2\2\u00c1\u00c2\7\30\2\2\u00c2\u00c6\5\30\r\6\u00c3\u00c4\f"+
		"\7\2\2\u00c4\u00c6\7\t\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\31\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\r\2\2\u00cb\33"+
		"\3\2\2\2\u00cc\u00cd\7\16\2\2\u00cd\35\3\2\2\2\u00ce\u00cf\7$\2\2\u00cf"+
		"\37\3\2\2\2\u00d0\u00d1\7\17\2\2\u00d1\u00d6\5$\23\2\u00d2\u00d3\7\f\2"+
		"\2\u00d3\u00d5\5$\23\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00da\7\20\2\2\u00da!\3\2\2\2\u00db\u00dc\7\21\2\2\u00dc\u00e1\5$\23"+
		"\2\u00dd\u00de\7\f\2\2\u00de\u00e0\5$\23\2\u00df\u00dd\3\2\2\2\u00e0\u00e3"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00e5\7\22\2\2\u00e5#\3\2\2\2\u00e6\u00e7\5\16\b"+
		"\2\u00e7\u00e8\7&\2\2\u00e8\u00e9\5\30\r\2\u00e9%\3\2\2\2\u00ea\u00eb"+
		"\7\17\2\2\u00eb\u00ec\5\16\b\2\u00ec\u00ed\7\23\2\2\u00ed\u00ee\5\30\r"+
		"\2\u00ee\u00ef\7\24\2\2\u00ef\u00f0\5\30\r\2\u00f0\'\3\2\2\2\u00f1\u00f2"+
		"\7\25\2\2\u00f2\u00f3\5\16\b\2\u00f3\u00f4\7\21\2\2\u00f4\u00f5\5\30\r"+
		"\2\u00f5)\3\2\2\2\u00f6\u00f7\7\26\2\2\u00f7\u00f8\5\30\r\2\u00f8\u00f9"+
		"\7\27\2\2\u00f9\u00fa\5\16\b\2\u00fa+\3\2\2\2\22-\65;FRXdj\u008a\u0098"+
		"\u009a\u00bb\u00c5\u00c7\u00d6\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}