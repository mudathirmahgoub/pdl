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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Star=7, Semicolon=8, QuestionMark=9, 
		Bar=10, Overline=11, Skip=12, Fail=13, If=14, Fi=15, Do=16, Od=17, Then=18, 
		Else=19, While=20, Repeat=21, Until=22, Union=23, Or=24, And=25, Not=26, 
		LeftParenthesis=27, RightParenthesis=28, LeftSquareBracket=29, RightSquareBracket=30, 
		LeftCurlyBracket=31, RightCurlyBracket=32, LeftAngle=33, RightAngle=34, 
		Identifier=35, IdentifierLetter=36, RightArrow=37, LeftRightArrow=38, 
		Digit=39, LineComment=40, MultiLineComment=41, Whitespace=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "Star", "Semicolon", 
			"QuestionMark", "Bar", "Overline", "Skip", "Fail", "If", "Fi", "Do", 
			"Od", "Then", "Else", "While", "Repeat", "Until", "Union", "Or", "And", 
			"Not", "LeftParenthesis", "RightParenthesis", "LeftSquareBracket", "RightSquareBracket", 
			"LeftCurlyBracket", "RightCurlyBracket", "LeftAngle", "RightAngle", "Identifier", 
			"IdentifierLetter", "RightArrow", "LeftRightArrow", "Digit", "LineComment", 
			"MultiLineComment", "Whitespace"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'K'", "'='", "','", "'m'", "'0'", "'1'", "'*'", "';'", "'?'", 
			"'|'", "'\u203E'", "'skip'", "'fail'", "'if'", "'fi'", "'do'", "'od'", 
			"'then'", "'else'", "'while'", "'repeat'", "'until'", null, null, null, 
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "Star", "Semicolon", "QuestionMark", 
			"Bar", "Overline", "Skip", "Fail", "If", "Fi", "Do", "Od", "Then", "Else", 
			"While", "Repeat", "Until", "Union", "Or", "And", "Not", "LeftParenthesis", 
			"RightParenthesis", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", 
			"RightCurlyBracket", "LeftAngle", "RightAngle", "Identifier", "IdentifierLetter", 
			"RightArrow", "LeftRightArrow", "Digit", "LineComment", "MultiLineComment", 
			"Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u00a7\n\30\3\31\3\31\3\31\5\31\u00ac\n\31\3\32"+
		"\3\32\3\32\3\32\5\32\u00b2\n\32\3\33\3\33\3\33\3\33\5\33\u00b8\n\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\6$\u00cc\n$\r$\16$\u00cd\3%\3%\3&\3&\3&\5&\u00d5\n&\3\'\3\'\3\'\3\'"+
		"\5\'\u00db\n\'\3(\3(\3)\3)\3)\3)\7)\u00e3\n)\f)\16)\u00e6\13)\3)\3)\3"+
		"*\3*\3*\3*\7*\u00ee\n*\f*\16*\u00f1\13*\3*\3*\3*\3*\3*\3+\6+\u00f9\n+"+
		"\r+\16+\u00fa\3+\3+\3\u00ef\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\5\5\2C\\"+
		"aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0108\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y"+
		"\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e"+
		"\3\2\2\2\23g\3\2\2\2\25i\3\2\2\2\27k\3\2\2\2\31m\3\2\2\2\33r\3\2\2\2\35"+
		"w\3\2\2\2\37z\3\2\2\2!}\3\2\2\2#\u0080\3\2\2\2%\u0083\3\2\2\2\'\u0088"+
		"\3\2\2\2)\u008d\3\2\2\2+\u0093\3\2\2\2-\u009a\3\2\2\2/\u00a6\3\2\2\2\61"+
		"\u00ab\3\2\2\2\63\u00b1\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00bb"+
		"\3\2\2\2;\u00bd\3\2\2\2=\u00bf\3\2\2\2?\u00c1\3\2\2\2A\u00c3\3\2\2\2C"+
		"\u00c5\3\2\2\2E\u00c7\3\2\2\2G\u00cb\3\2\2\2I\u00cf\3\2\2\2K\u00d4\3\2"+
		"\2\2M\u00da\3\2\2\2O\u00dc\3\2\2\2Q\u00de\3\2\2\2S\u00e9\3\2\2\2U\u00f8"+
		"\3\2\2\2WX\7M\2\2X\4\3\2\2\2YZ\7?\2\2Z\6\3\2\2\2[\\\7.\2\2\\\b\3\2\2\2"+
		"]^\7o\2\2^\n\3\2\2\2_`\7\62\2\2`\f\3\2\2\2ab\7\63\2\2b\16\3\2\2\2cd\7"+
		",\2\2d\20\3\2\2\2ef\7=\2\2f\22\3\2\2\2gh\7A\2\2h\24\3\2\2\2ij\7~\2\2j"+
		"\26\3\2\2\2kl\7\u2040\2\2l\30\3\2\2\2mn\7u\2\2no\7m\2\2op\7k\2\2pq\7r"+
		"\2\2q\32\3\2\2\2rs\7h\2\2st\7c\2\2tu\7k\2\2uv\7n\2\2v\34\3\2\2\2wx\7k"+
		"\2\2xy\7h\2\2y\36\3\2\2\2z{\7h\2\2{|\7k\2\2| \3\2\2\2}~\7f\2\2~\177\7"+
		"q\2\2\177\"\3\2\2\2\u0080\u0081\7q\2\2\u0081\u0082\7f\2\2\u0082$\3\2\2"+
		"\2\u0083\u0084\7v\2\2\u0084\u0085\7j\2\2\u0085\u0086\7g\2\2\u0086\u0087"+
		"\7p\2\2\u0087&\3\2\2\2\u0088\u0089\7g\2\2\u0089\u008a\7n\2\2\u008a\u008b"+
		"\7u\2\2\u008b\u008c\7g\2\2\u008c(\3\2\2\2\u008d\u008e\7y\2\2\u008e\u008f"+
		"\7j\2\2\u008f\u0090\7k\2\2\u0090\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092"+
		"*\3\2\2\2\u0093\u0094\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7r\2\2\u0096"+
		"\u0097\7g\2\2\u0097\u0098\7c\2\2\u0098\u0099\7v\2\2\u0099,\3\2\2\2\u009a"+
		"\u009b\7w\2\2\u009b\u009c\7p\2\2\u009c\u009d\7v\2\2\u009d\u009e\7k\2\2"+
		"\u009e\u009f\7n\2\2\u009f.\3\2\2\2\u00a0\u00a7\7\u222c\2\2\u00a1\u00a2"+
		"\7w\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7q\2\2\u00a5"+
		"\u00a7\7p\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a7\60\3\2\2\2"+
		"\u00a8\u00a9\7q\2\2\u00a9\u00ac\7t\2\2\u00aa\u00ac\7\u222a\2\2\u00ab\u00a8"+
		"\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\62\3\2\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00af\7p\2\2\u00af\u00b2\7f\2\2\u00b0\u00b2\7\u2229\2\2\u00b1\u00ad\3"+
		"\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5"+
		"\7q\2\2\u00b5\u00b8\7v\2\2\u00b6\u00b8\7\u00ae\2\2\u00b7\u00b3\3\2\2\2"+
		"\u00b7\u00b6\3\2\2\2\u00b8\66\3\2\2\2\u00b9\u00ba\7*\2\2\u00ba8\3\2\2"+
		"\2\u00bb\u00bc\7+\2\2\u00bc:\3\2\2\2\u00bd\u00be\7]\2\2\u00be<\3\2\2\2"+
		"\u00bf\u00c0\7_\2\2\u00c0>\3\2\2\2\u00c1\u00c2\7}\2\2\u00c2@\3\2\2\2\u00c3"+
		"\u00c4\7\177\2\2\u00c4B\3\2\2\2\u00c5\u00c6\7>\2\2\u00c6D\3\2\2\2\u00c7"+
		"\u00c8\7@\2\2\u00c8F\3\2\2\2\u00c9\u00cc\5I%\2\u00ca\u00cc\5O(\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ceH\3\2\2\2\u00cf\u00d0\t\2\2\2\u00d0J\3\2"+
		"\2\2\u00d1\u00d2\7/\2\2\u00d2\u00d5\7@\2\2\u00d3\u00d5\7\u2194\2\2\u00d4"+
		"\u00d1\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5L\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7"+
		"\u00d8\7/\2\2\u00d8\u00db\7@\2\2\u00d9\u00db\7\u2196\2\2\u00da\u00d6\3"+
		"\2\2\2\u00da\u00d9\3\2\2\2\u00dbN\3\2\2\2\u00dc\u00dd\4\62;\2\u00ddP\3"+
		"\2\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e4\3\2\2\2\u00e1"+
		"\u00e3\n\3\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00e8\b)\2\2\u00e8R\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\7,\2\2\u00eb"+
		"\u00ef\3\2\2\2\u00ec\u00ee\13\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3"+
		"\2\2\2\u00ef\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3\u00f4\7\61\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f6\b*\2\2\u00f6T\3\2\2\2\u00f7\u00f9\t\4\2\2\u00f8\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\b+\2\2\u00fdV\3\2\2\2\16\2\u00a6\u00ab\u00b1"+
		"\u00b7\u00cb\u00cd\u00d4\u00da\u00e4\u00ef\u00fa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}