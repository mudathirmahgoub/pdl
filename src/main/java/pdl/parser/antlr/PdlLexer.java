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
		Skip=10, Fail=11, If=12, Fi=13, Do=14, Od=15, Then=16, Else=17, While=18, 
		Repeat=19, Until=20, Union=21, Or=22, And=23, Not=24, LeftParenthesis=25, 
		RightParenthesis=26, LeftSquareBracket=27, RightSquareBracket=28, LeftCurlyBracket=29, 
		RightCurlyBracket=30, LeftAngle=31, RightAngle=32, Identifier=33, IdentifierLetter=34, 
		Integer=35, RightArrow=36, LeftRightArrow=37, Digit=38, Whitespace=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "Star", "Semicolon", 
			"QuestionMark", "Skip", "Fail", "If", "Fi", "Do", "Od", "Then", "Else", 
			"While", "Repeat", "Until", "Union", "Or", "And", "Not", "LeftParenthesis", 
			"RightParenthesis", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", 
			"RightCurlyBracket", "LeftAngle", "RightAngle", "Identifier", "IdentifierLetter", 
			"Integer", "RightArrow", "LeftRightArrow", "Digit", "Whitespace"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'K'", "'='", "','", "'m'", "'0'", "'1'", "'*'", "';'", "'?'", 
			"'skip'", "'fail'", "'if'", "'fi'", "'do'", "'od'", "'then'", "'else'", 
			"'while'", "'repeat'", "'until'", null, null, null, null, "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "Star", "Semicolon", "QuestionMark", 
			"Skip", "Fail", "If", "Fi", "Do", "Od", "Then", "Else", "While", "Repeat", 
			"Until", "Union", "Or", "And", "Not", "LeftParenthesis", "RightParenthesis", 
			"LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", 
			"LeftAngle", "RightAngle", "Identifier", "IdentifierLetter", "Integer", 
			"RightArrow", "LeftRightArrow", "Digit", "Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u00e2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u009d\n\26\3\27"+
		"\3\27\3\27\5\27\u00a2\n\27\3\30\3\30\3\30\3\30\5\30\u00a8\n\30\3\31\3"+
		"\31\3\31\3\31\5\31\u00ae\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\7\"\u00c3\n\"\f\"\16\"\u00c6"+
		"\13\"\3#\3#\3$\6$\u00cb\n$\r$\16$\u00cc\3%\3%\3%\5%\u00d2\n%\3&\3&\3&"+
		"\3&\5&\u00d8\n&\3\'\3\'\3(\6(\u00dd\n(\r(\16(\u00de\3(\3(\2\2)\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)\3\2\4\5\2C\\aac|\5\2\13\f\17\17\"\"\2\u00eb\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW"+
		"\3\2\2\2\13Y\3\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25"+
		"c\3\2\2\2\27h\3\2\2\2\31m\3\2\2\2\33p\3\2\2\2\35s\3\2\2\2\37v\3\2\2\2"+
		"!y\3\2\2\2#~\3\2\2\2%\u0083\3\2\2\2\'\u0089\3\2\2\2)\u0090\3\2\2\2+\u009c"+
		"\3\2\2\2-\u00a1\3\2\2\2/\u00a7\3\2\2\2\61\u00ad\3\2\2\2\63\u00af\3\2\2"+
		"\2\65\u00b1\3\2\2\2\67\u00b3\3\2\2\29\u00b5\3\2\2\2;\u00b7\3\2\2\2=\u00b9"+
		"\3\2\2\2?\u00bb\3\2\2\2A\u00bd\3\2\2\2C\u00bf\3\2\2\2E\u00c7\3\2\2\2G"+
		"\u00ca\3\2\2\2I\u00d1\3\2\2\2K\u00d7\3\2\2\2M\u00d9\3\2\2\2O\u00dc\3\2"+
		"\2\2QR\7M\2\2R\4\3\2\2\2ST\7?\2\2T\6\3\2\2\2UV\7.\2\2V\b\3\2\2\2WX\7o"+
		"\2\2X\n\3\2\2\2YZ\7\62\2\2Z\f\3\2\2\2[\\\7\63\2\2\\\16\3\2\2\2]^\7,\2"+
		"\2^\20\3\2\2\2_`\7=\2\2`\22\3\2\2\2ab\7A\2\2b\24\3\2\2\2cd\7u\2\2de\7"+
		"m\2\2ef\7k\2\2fg\7r\2\2g\26\3\2\2\2hi\7h\2\2ij\7c\2\2jk\7k\2\2kl\7n\2"+
		"\2l\30\3\2\2\2mn\7k\2\2no\7h\2\2o\32\3\2\2\2pq\7h\2\2qr\7k\2\2r\34\3\2"+
		"\2\2st\7f\2\2tu\7q\2\2u\36\3\2\2\2vw\7q\2\2wx\7f\2\2x \3\2\2\2yz\7v\2"+
		"\2z{\7j\2\2{|\7g\2\2|}\7p\2\2}\"\3\2\2\2~\177\7g\2\2\177\u0080\7n\2\2"+
		"\u0080\u0081\7u\2\2\u0081\u0082\7g\2\2\u0082$\3\2\2\2\u0083\u0084\7y\2"+
		"\2\u0084\u0085\7j\2\2\u0085\u0086\7k\2\2\u0086\u0087\7n\2\2\u0087\u0088"+
		"\7g\2\2\u0088&\3\2\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2\u008b\u008c"+
		"\7r\2\2\u008c\u008d\7g\2\2\u008d\u008e\7c\2\2\u008e\u008f\7v\2\2\u008f"+
		"(\3\2\2\2\u0090\u0091\7w\2\2\u0091\u0092\7p\2\2\u0092\u0093\7v\2\2\u0093"+
		"\u0094\7k\2\2\u0094\u0095\7n\2\2\u0095*\3\2\2\2\u0096\u009d\7\u222c\2"+
		"\2\u0097\u0098\7w\2\2\u0098\u0099\7p\2\2\u0099\u009a\7k\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009d\7p\2\2\u009c\u0096\3\2\2\2\u009c\u0097\3\2\2\2\u009d"+
		",\3\2\2\2\u009e\u009f\7q\2\2\u009f\u00a2\7t\2\2\u00a0\u00a2\7\u222a\2"+
		"\2\u00a1\u009e\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2.\3\2\2\2\u00a3\u00a4"+
		"\7c\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a8\7f\2\2\u00a6\u00a8\7\u2229\2\2"+
		"\u00a7\u00a3\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\60\3\2\2\2\u00a9\u00aa"+
		"\7p\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ae\7v\2\2\u00ac\u00ae\7\u00ae\2\2"+
		"\u00ad\u00a9\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\62\3\2\2\2\u00af\u00b0"+
		"\7*\2\2\u00b0\64\3\2\2\2\u00b1\u00b2\7+\2\2\u00b2\66\3\2\2\2\u00b3\u00b4"+
		"\7]\2\2\u00b48\3\2\2\2\u00b5\u00b6\7_\2\2\u00b6:\3\2\2\2\u00b7\u00b8\7"+
		"}\2\2\u00b8<\3\2\2\2\u00b9\u00ba\7\177\2\2\u00ba>\3\2\2\2\u00bb\u00bc"+
		"\7>\2\2\u00bc@\3\2\2\2\u00bd\u00be\7@\2\2\u00beB\3\2\2\2\u00bf\u00c4\5"+
		"E#\2\u00c0\u00c3\5E#\2\u00c1\u00c3\5M\'\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"D\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\t\2\2\2\u00c8F\3\2\2\2\u00c9"+
		"\u00cb\5M\'\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cdH\3\2\2\2\u00ce\u00cf\7/\2\2\u00cf\u00d2"+
		"\7@\2\2\u00d0\u00d2\7\u2194\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00d0\3\2\2"+
		"\2\u00d2J\3\2\2\2\u00d3\u00d4\7>\2\2\u00d4\u00d5\7/\2\2\u00d5\u00d8\7"+
		"@\2\2\u00d6\u00d8\7\u2196\2\2\u00d7\u00d3\3\2\2\2\u00d7\u00d6\3\2\2\2"+
		"\u00d8L\3\2\2\2\u00d9\u00da\4\62;\2\u00daN\3\2\2\2\u00db\u00dd\t\3\2\2"+
		"\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b(\2\2\u00e1P\3\2\2\2\r\2\u009c"+
		"\u00a1\u00a7\u00ad\u00c2\u00c4\u00cc\u00d1\u00d7\u00de\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}