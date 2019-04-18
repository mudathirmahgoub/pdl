// Generated from Pdl.g4 by ANTLR 4.7.2
package pdl.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PdlLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "Star", "Semicolon", "QuestionMark", "Skip", "Fail", 
			"If", "Fi", "Do", "Od", "Then", "Else", "While", "Until", "Union", "Or", 
			"And", "Not", "LeftParenthesis", "RightParenthesis", "LeftSquareBracket", 
			"RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftAngle", 
			"RightAngle", "Identifier", "IdentifierLetter", "Integer", "RightArrow", 
			"LeftRightArrow", "Digit", "Whitespace"
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


	public PdlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pdl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00d4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0086\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u008d\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0095\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u009c\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\7\35\u00b1\n\35\f\35\16"+
		"\35\u00b4\13\35\3\36\3\36\3\37\6\37\u00b9\n\37\r\37\16\37\u00ba\3 \3 "+
		"\3 \3 \3 \5 \u00c2\n \3!\3!\3!\3!\3!\3!\5!\u00ca\n!\3\"\3\"\3#\6#\u00cf"+
		"\n#\r#\16#\u00d0\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\4\5\2C\\aac|\5\2\13\f\17\17"+
		"\"\"\2\u00dd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2"+
		"\17V\3\2\2\2\21[\3\2\2\2\23^\3\2\2\2\25a\3\2\2\2\27d\3\2\2\2\31g\3\2\2"+
		"\2\33l\3\2\2\2\35q\3\2\2\2\37w\3\2\2\2!\u0085\3\2\2\2#\u008c\3\2\2\2%"+
		"\u0094\3\2\2\2\'\u009b\3\2\2\2)\u009d\3\2\2\2+\u009f\3\2\2\2-\u00a1\3"+
		"\2\2\2/\u00a3\3\2\2\2\61\u00a5\3\2\2\2\63\u00a7\3\2\2\2\65\u00a9\3\2\2"+
		"\2\67\u00ab\3\2\2\29\u00ad\3\2\2\2;\u00b5\3\2\2\2=\u00b8\3\2\2\2?\u00c1"+
		"\3\2\2\2A\u00c9\3\2\2\2C\u00cb\3\2\2\2E\u00ce\3\2\2\2GH\7\62\2\2H\4\3"+
		"\2\2\2IJ\7\63\2\2J\6\3\2\2\2KL\7,\2\2L\b\3\2\2\2MN\7=\2\2N\n\3\2\2\2O"+
		"P\7A\2\2P\f\3\2\2\2QR\7u\2\2RS\7m\2\2ST\7k\2\2TU\7r\2\2U\16\3\2\2\2VW"+
		"\7h\2\2WX\7c\2\2XY\7k\2\2YZ\7n\2\2Z\20\3\2\2\2[\\\7k\2\2\\]\7h\2\2]\22"+
		"\3\2\2\2^_\7h\2\2_`\7k\2\2`\24\3\2\2\2ab\7f\2\2bc\7q\2\2c\26\3\2\2\2d"+
		"e\7q\2\2ef\7f\2\2f\30\3\2\2\2gh\7v\2\2hi\7j\2\2ij\7g\2\2jk\7p\2\2k\32"+
		"\3\2\2\2lm\7g\2\2mn\7n\2\2no\7u\2\2op\7g\2\2p\34\3\2\2\2qr\7y\2\2rs\7"+
		"j\2\2st\7k\2\2tu\7n\2\2uv\7g\2\2v\36\3\2\2\2wx\7w\2\2xy\7p\2\2yz\7v\2"+
		"\2z{\7k\2\2{|\7n\2\2| \3\2\2\2}~\7\u00e4\2\2~\177\7\u02c8\2\2\177\u0086"+
		"\7\u00ac\2\2\u0080\u0081\7w\2\2\u0081\u0082\7p\2\2\u0082\u0083\7k\2\2"+
		"\u0083\u0084\7q\2\2\u0084\u0086\7p\2\2\u0085}\3\2\2\2\u0085\u0080\3\2"+
		"\2\2\u0086\"\3\2\2\2\u0087\u0088\7q\2\2\u0088\u008d\7t\2\2\u0089\u008a"+
		"\7\u00e4\2\2\u008a\u008b\7\u02c8\2\2\u008b\u008d\7\u00aa\2\2\u008c\u0087"+
		"\3\2\2\2\u008c\u0089\3\2\2\2\u008d$\3\2\2\2\u008e\u008f\7c\2\2\u008f\u0090"+
		"\7p\2\2\u0090\u0095\7f\2\2\u0091\u0092\7\u00e4\2\2\u0092\u0093\7\u02c8"+
		"\2\2\u0093\u0095\7\u00a9\2\2\u0094\u008e\3\2\2\2\u0094\u0091\3\2\2\2\u0095"+
		"&\3\2\2\2\u0096\u0097\7p\2\2\u0097\u0098\7q\2\2\u0098\u009c\7v\2\2\u0099"+
		"\u009a\7\u00c4\2\2\u009a\u009c\7\u00ae\2\2\u009b\u0096\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009c(\3\2\2\2\u009d\u009e\7*\2\2\u009e*\3\2\2\2\u009f\u00a0"+
		"\7+\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7]\2\2\u00a2.\3\2\2\2\u00a3\u00a4\7"+
		"_\2\2\u00a4\60\3\2\2\2\u00a5\u00a6\7}\2\2\u00a6\62\3\2\2\2\u00a7\u00a8"+
		"\7\177\2\2\u00a8\64\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa\66\3\2\2\2\u00ab"+
		"\u00ac\7@\2\2\u00ac8\3\2\2\2\u00ad\u00b2\5;\36\2\u00ae\u00b1\5;\36\2\u00af"+
		"\u00b1\5C\"\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3:\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6<\3\2\2\2\u00b7\u00b9\5C\"\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		">\3\2\2\2\u00bc\u00bd\7/\2\2\u00bd\u00c2\7@\2\2\u00be\u00bf\7\u00e4\2"+
		"\2\u00bf\u00c0\7\u2022\2\2\u00c0\u00c2\7\u201b\2\2\u00c1\u00bc\3\2\2\2"+
		"\u00c1\u00be\3\2\2\2\u00c2@\3\2\2\2\u00c3\u00c4\7>\2\2\u00c4\u00c5\7/"+
		"\2\2\u00c5\u00ca\7@\2\2\u00c6\u00c7\7\u00e4\2\2\u00c7\u00c8\7\u2022\2"+
		"\2\u00c8\u00ca\7\u201f\2\2\u00c9\u00c3\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca"+
		"B\3\2\2\2\u00cb\u00cc\4\62;\2\u00ccD\3\2\2\2\u00cd\u00cf\t\3\2\2\u00ce"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b#\2\2\u00d3F\3\2\2\2\r\2\u0085\u008c"+
		"\u0094\u009b\u00b0\u00b2\u00ba\u00c1\u00c9\u00d0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}