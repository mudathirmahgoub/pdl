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
		Fi=9, Do=10, Od=11, Then=12, Else=13, While=14, Repeat=15, Until=16, Union=17, 
		Or=18, And=19, Not=20, LeftParenthesis=21, RightParenthesis=22, LeftSquareBracket=23, 
		RightSquareBracket=24, LeftCurlyBracket=25, RightCurlyBracket=26, LeftAngle=27, 
		RightAngle=28, Identifier=29, IdentifierLetter=30, Integer=31, RightArrow=32, 
		LeftRightArrow=33, Digit=34, Whitespace=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "Star", "Semicolon", "QuestionMark", "Skip", "Fail", 
			"If", "Fi", "Do", "Od", "Then", "Else", "While", "Repeat", "Until", "Union", 
			"Or", "And", "Not", "LeftParenthesis", "RightParenthesis", "LeftSquareBracket", 
			"RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftAngle", 
			"RightAngle", "Identifier", "IdentifierLetter", "Integer", "RightArrow", 
			"LeftRightArrow", "Digit", "Whitespace"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0'", "'1'", "'*'", "';'", "'?'", "'skip'", "'fail'", "'if'", 
			"'fi'", "'do'", "'od'", "'then'", "'else'", "'while'", "'repeat'", "'until'", 
			null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", 
			"'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Star", "Semicolon", "QuestionMark", "Skip", "Fail", 
			"If", "Fi", "Do", "Od", "Then", "Else", "While", "Repeat", "Until", "Union", 
			"Or", "And", "Not", "LeftParenthesis", "RightParenthesis", "LeftSquareBracket", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u008f\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0096\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u009e\n\24\3\25\3\25\3\25\3\25\3\25\5\25\u00a5\n\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\36\7\36\u00ba\n\36\f\36\16\36\u00bd\13\36\3\37\3\37\3 \6 \u00c2"+
		"\n \r \16 \u00c3\3!\3!\3!\3!\3!\5!\u00cb\n!\3\"\3\"\3\"\3\"\3\"\3\"\5"+
		"\"\u00d3\n\"\3#\3#\3$\6$\u00d8\n$\r$\16$\u00d9\3$\3$\2\2%\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%\3\2\4\5\2C\\aac|\5\2\13\f\17\17\"\"\2\u00e6\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2"+
		"\7M\3\2\2\2\tO\3\2\2\2\13Q\3\2\2\2\rS\3\2\2\2\17X\3\2\2\2\21]\3\2\2\2"+
		"\23`\3\2\2\2\25c\3\2\2\2\27f\3\2\2\2\31i\3\2\2\2\33n\3\2\2\2\35s\3\2\2"+
		"\2\37y\3\2\2\2!\u0080\3\2\2\2#\u008e\3\2\2\2%\u0095\3\2\2\2\'\u009d\3"+
		"\2\2\2)\u00a4\3\2\2\2+\u00a6\3\2\2\2-\u00a8\3\2\2\2/\u00aa\3\2\2\2\61"+
		"\u00ac\3\2\2\2\63\u00ae\3\2\2\2\65\u00b0\3\2\2\2\67\u00b2\3\2\2\29\u00b4"+
		"\3\2\2\2;\u00b6\3\2\2\2=\u00be\3\2\2\2?\u00c1\3\2\2\2A\u00ca\3\2\2\2C"+
		"\u00d2\3\2\2\2E\u00d4\3\2\2\2G\u00d7\3\2\2\2IJ\7\62\2\2J\4\3\2\2\2KL\7"+
		"\63\2\2L\6\3\2\2\2MN\7,\2\2N\b\3\2\2\2OP\7=\2\2P\n\3\2\2\2QR\7A\2\2R\f"+
		"\3\2\2\2ST\7u\2\2TU\7m\2\2UV\7k\2\2VW\7r\2\2W\16\3\2\2\2XY\7h\2\2YZ\7"+
		"c\2\2Z[\7k\2\2[\\\7n\2\2\\\20\3\2\2\2]^\7k\2\2^_\7h\2\2_\22\3\2\2\2`a"+
		"\7h\2\2ab\7k\2\2b\24\3\2\2\2cd\7f\2\2de\7q\2\2e\26\3\2\2\2fg\7q\2\2gh"+
		"\7f\2\2h\30\3\2\2\2ij\7v\2\2jk\7j\2\2kl\7g\2\2lm\7p\2\2m\32\3\2\2\2no"+
		"\7g\2\2op\7n\2\2pq\7u\2\2qr\7g\2\2r\34\3\2\2\2st\7y\2\2tu\7j\2\2uv\7k"+
		"\2\2vw\7n\2\2wx\7g\2\2x\36\3\2\2\2yz\7t\2\2z{\7g\2\2{|\7r\2\2|}\7g\2\2"+
		"}~\7c\2\2~\177\7v\2\2\177 \3\2\2\2\u0080\u0081\7w\2\2\u0081\u0082\7p\2"+
		"\2\u0082\u0083\7v\2\2\u0083\u0084\7k\2\2\u0084\u0085\7n\2\2\u0085\"\3"+
		"\2\2\2\u0086\u0087\7\u00e4\2\2\u0087\u0088\7\u02c8\2\2\u0088\u008f\7\u00ac"+
		"\2\2\u0089\u008a\7w\2\2\u008a\u008b\7p\2\2\u008b\u008c\7k\2\2\u008c\u008d"+
		"\7q\2\2\u008d\u008f\7p\2\2\u008e\u0086\3\2\2\2\u008e\u0089\3\2\2\2\u008f"+
		"$\3\2\2\2\u0090\u0091\7q\2\2\u0091\u0096\7t\2\2\u0092\u0093\7\u00e4\2"+
		"\2\u0093\u0094\7\u02c8\2\2\u0094\u0096\7\u00aa\2\2\u0095\u0090\3\2\2\2"+
		"\u0095\u0092\3\2\2\2\u0096&\3\2\2\2\u0097\u0098\7c\2\2\u0098\u0099\7p"+
		"\2\2\u0099\u009e\7f\2\2\u009a\u009b\7\u00e4\2\2\u009b\u009c\7\u02c8\2"+
		"\2\u009c\u009e\7\u00a9\2\2\u009d\u0097\3\2\2\2\u009d\u009a\3\2\2\2\u009e"+
		"(\3\2\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a5\7v\2\2\u00a2"+
		"\u00a3\7\u00c4\2\2\u00a3\u00a5\7\u00ae\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7*\2\2\u00a7,\3\2\2\2\u00a8\u00a9"+
		"\7+\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7]\2\2\u00ab\60\3\2\2\2\u00ac\u00ad"+
		"\7_\2\2\u00ad\62\3\2\2\2\u00ae\u00af\7}\2\2\u00af\64\3\2\2\2\u00b0\u00b1"+
		"\7\177\2\2\u00b1\66\3\2\2\2\u00b2\u00b3\7>\2\2\u00b38\3\2\2\2\u00b4\u00b5"+
		"\7@\2\2\u00b5:\3\2\2\2\u00b6\u00bb\5=\37\2\u00b7\u00ba\5=\37\2\u00b8\u00ba"+
		"\5E#\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc<\3\2\2\2\u00bd\u00bb\3\2\2\2"+
		"\u00be\u00bf\t\2\2\2\u00bf>\3\2\2\2\u00c0\u00c2\5E#\2\u00c1\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"@\3\2\2\2\u00c5\u00c6\7/\2\2\u00c6\u00cb\7@\2\2\u00c7\u00c8\7\u00e4\2"+
		"\2\u00c8\u00c9\7\u2022\2\2\u00c9\u00cb\7\u201b\2\2\u00ca\u00c5\3\2\2\2"+
		"\u00ca\u00c7\3\2\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7>\2\2\u00cd\u00ce\7/"+
		"\2\2\u00ce\u00d3\7@\2\2\u00cf\u00d0\7\u00e4\2\2\u00d0\u00d1\7\u2022\2"+
		"\2\u00d1\u00d3\7\u201f\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3"+
		"D\3\2\2\2\u00d4\u00d5\4\62;\2\u00d5F\3\2\2\2\u00d6\u00d8\t\3\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b$\2\2\u00dcH\3\2\2\2\r\2\u008e\u0095"+
		"\u009d\u00a4\u00b9\u00bb\u00c3\u00ca\u00d2\u00d9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}