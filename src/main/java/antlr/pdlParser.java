// Generated from pdl.g4 by ANTLR 4.7.2
package pdl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class pdlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Star=3, Semicolon=4, QuestionMark=5, Skip=6, Fail=7, If=8, 
		Fi=9, Do=10, Od=11, Then=12, Else=13, While=14, Until=15, Union=16, Or=17, 
		And=18, Not=19, LeftParenthesis=20, RightParenthesis=21, LeftSquareBracket=22, 
		RightSquareBracket=23, LeftCurlyBracket=24, RightCurlyBracket=25, LeftAngle=26, 
		RightAngle=27, Identifier=28, IdentifierLetter=29, Integer=30, RightArrow=31, 
		LeftRightArrow=32, Digit=33, Whitespace=34;
	public static final int
		RULE_pdl = 0, RULE_formula = 1, RULE_hoarePartialCorrectness = 2, RULE_falsity = 3, 
		RULE_truth = 4, RULE_atomicFormula = 5, RULE_program = 6, RULE_skip = 7, 
		RULE_fail = 8, RULE_atomicProgram = 9, RULE_alternativeGuardedCommand = 10, 
		RULE_iterativeGuardedCommand = 11, RULE_guardedCommand = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"pdl", "formula", "hoarePartialCorrectness", "falsity", "truth", "atomicFormula", 
			"program", "skip", "fail", "atomicProgram", "alternativeGuardedCommand", 
			"iterativeGuardedCommand", "guardedCommand"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0'", "'1'", "'*'", "';'", "'?'", "'skip'", "'fail'", "'if'", 
			"'fi'", "'do'", "'od'", "'then'", "'else'", "'while'", "'until'", null, 
			null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Star", "Semicolon", "QuestionMark", "Skip", "Fail", 
			"If", "Fi", "Do", "Od", "Then", "Else", "While", "Until", "Union", "Or", 
			"And", "Not", "LeftParenthesis", "RightParenthesis", "LeftSquareBracket", 
			"RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftAngle", 
			"RightAngle", "Identifier", "IdentifierLetter", "Integer", "RightArrow", 
			"LeftRightArrow", "Digit", "Whitespace"
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
	public String getGrammarFileName() { return "pdl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public pdlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PdlContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PdlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pdl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterPdl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitPdl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitPdl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PdlContext pdl() throws RecognitionException {
		PdlContext _localctx = new PdlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pdl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
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
		public TerminalNode LeftParenthesis() { return getToken(pdlParser.LeftParenthesis, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode RightParenthesis() { return getToken(pdlParser.RightParenthesis, 0); }
		public TerminalNode Not() { return getToken(pdlParser.Not, 0); }
		public TerminalNode LeftSquareBracket() { return getToken(pdlParser.LeftSquareBracket, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode RightSquareBracket() { return getToken(pdlParser.RightSquareBracket, 0); }
		public TerminalNode LeftAngle() { return getToken(pdlParser.LeftAngle, 0); }
		public TerminalNode RightAngle() { return getToken(pdlParser.RightAngle, 0); }
		public HoarePartialCorrectnessContext hoarePartialCorrectness() {
			return getRuleContext(HoarePartialCorrectnessContext.class,0);
		}
		public TerminalNode And() { return getToken(pdlParser.And, 0); }
		public TerminalNode Or() { return getToken(pdlParser.Or, 0); }
		public TerminalNode RightArrow() { return getToken(pdlParser.RightArrow, 0); }
		public TerminalNode LeftRightArrow() { return getToken(pdlParser.LeftRightArrow, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitFormula(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(29);
				falsity();
				}
				break;
			case T__1:
				{
				setState(30);
				truth();
				}
				break;
			case Identifier:
				{
				setState(31);
				atomicFormula();
				}
				break;
			case LeftParenthesis:
				{
				setState(32);
				match(LeftParenthesis);
				setState(33);
				formula(0);
				setState(34);
				match(RightParenthesis);
				}
				break;
			case Not:
				{
				setState(36);
				match(Not);
				setState(37);
				formula(8);
				}
				break;
			case LeftSquareBracket:
				{
				setState(38);
				match(LeftSquareBracket);
				setState(39);
				program(0);
				setState(40);
				match(RightSquareBracket);
				setState(41);
				formula(7);
				}
				break;
			case LeftAngle:
				{
				setState(43);
				match(LeftAngle);
				setState(44);
				program(0);
				setState(45);
				match(RightAngle);
				setState(46);
				formula(6);
				}
				break;
			case LeftCurlyBracket:
				{
				setState(48);
				hoarePartialCorrectness();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(63);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(51);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(52);
						match(And);
						setState(53);
						formula(6);
						}
						break;
					case 2:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(54);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(55);
						match(Or);
						setState(56);
						formula(5);
						}
						break;
					case 3:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(57);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(58);
						match(RightArrow);
						setState(59);
						formula(4);
						}
						break;
					case 4:
						{
						_localctx = new FormulaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(60);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(61);
						match(LeftRightArrow);
						setState(62);
						formula(3);
						}
						break;
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		public List<TerminalNode> LeftCurlyBracket() { return getTokens(pdlParser.LeftCurlyBracket); }
		public TerminalNode LeftCurlyBracket(int i) {
			return getToken(pdlParser.LeftCurlyBracket, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TerminalNode> RightCurlyBracket() { return getTokens(pdlParser.RightCurlyBracket); }
		public TerminalNode RightCurlyBracket(int i) {
			return getToken(pdlParser.RightCurlyBracket, i);
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
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterHoarePartialCorrectness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitHoarePartialCorrectness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitHoarePartialCorrectness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HoarePartialCorrectnessContext hoarePartialCorrectness() throws RecognitionException {
		HoarePartialCorrectnessContext _localctx = new HoarePartialCorrectnessContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_hoarePartialCorrectness);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(LeftCurlyBracket);
			setState(69);
			formula(0);
			setState(70);
			match(RightCurlyBracket);
			setState(71);
			program(0);
			setState(72);
			match(LeftCurlyBracket);
			setState(73);
			formula(0);
			setState(74);
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
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterFalsity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitFalsity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitFalsity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalsityContext falsity() throws RecognitionException {
		FalsityContext _localctx = new FalsityContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_falsity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__0);
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
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterTruth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitTruth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitTruth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TruthContext truth() throws RecognitionException {
		TruthContext _localctx = new TruthContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_truth);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__1);
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
		public TerminalNode Identifier() { return getToken(pdlParser.Identifier, 0); }
		public AtomicFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicFormula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterAtomicFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitAtomicFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitAtomicFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicFormulaContext atomicFormula() throws RecognitionException {
		AtomicFormulaContext _localctx = new AtomicFormulaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomicFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
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
		public TerminalNode LeftParenthesis() { return getToken(pdlParser.LeftParenthesis, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode RightParenthesis() { return getToken(pdlParser.RightParenthesis, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode QuestionMark() { return getToken(pdlParser.QuestionMark, 0); }
		public TerminalNode Semicolon() { return getToken(pdlParser.Semicolon, 0); }
		public TerminalNode Union() { return getToken(pdlParser.Union, 0); }
		public TerminalNode Star() { return getToken(pdlParser.Star, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitProgram(this);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(83);
				skip();
				}
				break;
			case 3:
				{
				setState(84);
				fail();
				}
				break;
			case 4:
				{
				setState(85);
				alternativeGuardedCommand();
				}
				break;
			case 5:
				{
				setState(86);
				iterativeGuardedCommand();
				}
				break;
			case 6:
				{
				setState(87);
				atomicProgram();
				}
				break;
			case 7:
				{
				setState(88);
				match(LeftParenthesis);
				setState(89);
				program(0);
				setState(90);
				match(RightParenthesis);
				}
				break;
			case 8:
				{
				setState(92);
				formula(0);
				setState(93);
				match(QuestionMark);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(105);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ProgramContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_program);
						setState(97);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(98);
						match(Semicolon);
						setState(99);
						program(5);
						}
						break;
					case 2:
						{
						_localctx = new ProgramContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_program);
						setState(100);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(101);
						match(Union);
						setState(102);
						program(4);
						}
						break;
					case 3:
						{
						_localctx = new ProgramContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_program);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(104);
						match(Star);
						}
						break;
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public TerminalNode Skip() { return getToken(pdlParser.Skip, 0); }
		public SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipContext skip() throws RecognitionException {
		SkipContext _localctx = new SkipContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_skip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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
		public TerminalNode Fail() { return getToken(pdlParser.Fail, 0); }
		public FailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterFail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitFail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitFail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FailContext fail() throws RecognitionException {
		FailContext _localctx = new FailContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
		public TerminalNode Identifier() { return getToken(pdlParser.Identifier, 0); }
		public AtomicProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterAtomicProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitAtomicProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitAtomicProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicProgramContext atomicProgram() throws RecognitionException {
		AtomicProgramContext _localctx = new AtomicProgramContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atomicProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
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
		public TerminalNode If() { return getToken(pdlParser.If, 0); }
		public TerminalNode Fi() { return getToken(pdlParser.Fi, 0); }
		public List<GuardedCommandContext> guardedCommand() {
			return getRuleContexts(GuardedCommandContext.class);
		}
		public GuardedCommandContext guardedCommand(int i) {
			return getRuleContext(GuardedCommandContext.class,i);
		}
		public AlternativeGuardedCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeGuardedCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterAlternativeGuardedCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitAlternativeGuardedCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitAlternativeGuardedCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternativeGuardedCommandContext alternativeGuardedCommand() throws RecognitionException {
		AlternativeGuardedCommandContext _localctx = new AlternativeGuardedCommandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_alternativeGuardedCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(If);
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				guardedCommand();
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << Not) | (1L << LeftParenthesis) | (1L << LeftSquareBracket) | (1L << LeftCurlyBracket) | (1L << LeftAngle) | (1L << Identifier))) != 0) );
			setState(122);
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
		public TerminalNode Do() { return getToken(pdlParser.Do, 0); }
		public TerminalNode Od() { return getToken(pdlParser.Od, 0); }
		public List<GuardedCommandContext> guardedCommand() {
			return getRuleContexts(GuardedCommandContext.class);
		}
		public GuardedCommandContext guardedCommand(int i) {
			return getRuleContext(GuardedCommandContext.class,i);
		}
		public IterativeGuardedCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeGuardedCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterIterativeGuardedCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitIterativeGuardedCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitIterativeGuardedCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeGuardedCommandContext iterativeGuardedCommand() throws RecognitionException {
		IterativeGuardedCommandContext _localctx = new IterativeGuardedCommandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_iterativeGuardedCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(Do);
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				guardedCommand();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << Not) | (1L << LeftParenthesis) | (1L << LeftSquareBracket) | (1L << LeftCurlyBracket) | (1L << LeftAngle) | (1L << Identifier))) != 0) );
			setState(130);
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
		public TerminalNode RightArrow() { return getToken(pdlParser.RightArrow, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public GuardedCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardedCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).enterGuardedCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pdlListener ) ((pdlListener)listener).exitGuardedCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pdlVisitor ) return ((pdlVisitor<? extends T>)visitor).visitGuardedCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardedCommandContext guardedCommand() throws RecognitionException {
		GuardedCommandContext _localctx = new GuardedCommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_guardedCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			formula(0);
			setState(133);
			match(RightArrow);
			setState(134);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 6:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u008b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\64\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3B\n\3\f\3\16\3E\13\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bb\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\7\bl\n\b\f\b\16\bo\13\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\6\fy"+
		"\n\f\r\f\16\fz\3\f\3\f\3\r\3\r\6\r\u0081\n\r\r\r\16\r\u0082\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\2\4\4\16\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2"+
		"\2\2\u0094\2\34\3\2\2\2\4\63\3\2\2\2\6F\3\2\2\2\bN\3\2\2\2\nP\3\2\2\2"+
		"\fR\3\2\2\2\16a\3\2\2\2\20p\3\2\2\2\22r\3\2\2\2\24t\3\2\2\2\26v\3\2\2"+
		"\2\30~\3\2\2\2\32\u0086\3\2\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36\37\b\3\1"+
		"\2\37\64\5\b\5\2 \64\5\n\6\2!\64\5\f\7\2\"#\7\26\2\2#$\5\4\3\2$%\7\27"+
		"\2\2%\64\3\2\2\2&\'\7\25\2\2\'\64\5\4\3\n()\7\30\2\2)*\5\16\b\2*+\7\31"+
		"\2\2+,\5\4\3\t,\64\3\2\2\2-.\7\34\2\2./\5\16\b\2/\60\7\35\2\2\60\61\5"+
		"\4\3\b\61\64\3\2\2\2\62\64\5\6\4\2\63\36\3\2\2\2\63 \3\2\2\2\63!\3\2\2"+
		"\2\63\"\3\2\2\2\63&\3\2\2\2\63(\3\2\2\2\63-\3\2\2\2\63\62\3\2\2\2\64C"+
		"\3\2\2\2\65\66\f\7\2\2\66\67\7\24\2\2\67B\5\4\3\b89\f\6\2\29:\7\23\2\2"+
		":B\5\4\3\7;<\f\5\2\2<=\7!\2\2=B\5\4\3\6>?\f\4\2\2?@\7\"\2\2@B\5\4\3\5"+
		"A\65\3\2\2\2A8\3\2\2\2A;\3\2\2\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2"+
		"\2D\5\3\2\2\2EC\3\2\2\2FG\7\32\2\2GH\5\4\3\2HI\7\33\2\2IJ\5\16\b\2JK\7"+
		"\32\2\2KL\5\4\3\2LM\7\33\2\2M\7\3\2\2\2NO\7\3\2\2O\t\3\2\2\2PQ\7\4\2\2"+
		"Q\13\3\2\2\2RS\7\36\2\2S\r\3\2\2\2Tb\b\b\1\2Ub\5\20\t\2Vb\5\22\n\2Wb\5"+
		"\26\f\2Xb\5\30\r\2Yb\5\24\13\2Z[\7\26\2\2[\\\5\16\b\2\\]\7\27\2\2]b\3"+
		"\2\2\2^_\5\4\3\2_`\7\7\2\2`b\3\2\2\2aT\3\2\2\2aU\3\2\2\2aV\3\2\2\2aW\3"+
		"\2\2\2aX\3\2\2\2aY\3\2\2\2aZ\3\2\2\2a^\3\2\2\2bm\3\2\2\2cd\f\6\2\2de\7"+
		"\6\2\2el\5\16\b\7fg\f\5\2\2gh\7\22\2\2hl\5\16\b\6ij\f\7\2\2jl\7\5\2\2"+
		"kc\3\2\2\2kf\3\2\2\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\17\3\2\2"+
		"\2om\3\2\2\2pq\7\b\2\2q\21\3\2\2\2rs\7\t\2\2s\23\3\2\2\2tu\7\36\2\2u\25"+
		"\3\2\2\2vx\7\n\2\2wy\5\32\16\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{|\3\2\2\2|}\7\13\2\2}\27\3\2\2\2~\u0080\7\f\2\2\177\u0081\5\32\16\2\u0080"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0084\3\2\2\2\u0084\u0085\7\r\2\2\u0085\31\3\2\2\2\u0086\u0087"+
		"\5\4\3\2\u0087\u0088\7!\2\2\u0088\u0089\5\16\b\2\u0089\33\3\2\2\2\n\63"+
		"ACakmz\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}