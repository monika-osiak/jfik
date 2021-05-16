// Generated from /Users/monika/MGR-SEM1/JFiK/project-repo/Grammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, REPEAT=11, IF=12, PRINT=13, READ=14, TOINT=15, TOFLOAT=16, PLUS=17, 
		MINUS=18, MUL=19, DIV=20, EQ=21, FLOAT=22, INT=23, ID=24, STRING=25, NEWLINE=26, 
		WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "REPEAT", "IF", "PRINT", "READ", "TOINT", "TOFLOAT", "PLUS", 
			"MINUS", "MUL", "DIV", "EQ", "FLOAT", "INT", "ID", "STRING", "NEWLINE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'string'", "'['", "']'", "'int'", "'float'", "'int[]'", 
			"'float[]'", "'=='", "'repeat'", "'if'", "'print'", "'read'", "'(int)'", 
			"'(float)'", "'+'", "'-'", "'*'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "REPEAT", 
			"IF", "PRINT", "READ", "TOINT", "TOFLOAT", "PLUS", "MINUS", "MUL", "DIV", 
			"EQ", "FLOAT", "INT", "ID", "STRING", "NEWLINE", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00bf\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\5\27\u0092\n\27\3\27\6\27\u0095\n\27\r\27\16\27\u0096\3\27\3"+
		"\27\6\27\u009b\n\27\r\27\16\27\u009c\3\30\5\30\u00a0\n\30\3\30\6\30\u00a3"+
		"\n\30\r\30\16\30\u00a4\3\31\6\31\u00a8\n\31\r\31\16\31\u00a9\3\32\3\32"+
		"\6\32\u00ae\n\32\r\32\16\32\u00af\3\32\3\32\3\33\5\33\u00b5\n\33\3\33"+
		"\3\33\3\34\6\34\u00ba\n\34\r\34\16\34\u00bb\3\34\3\34\2\2\35\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\5\5\2\62;C\\"+
		"c|\5\2\"\"C\\c|\4\2\13\13\"\"\2\u00c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\tD\3\2\2\2\13F"+
		"\3\2\2\2\rH\3\2\2\2\17L\3\2\2\2\21R\3\2\2\2\23X\3\2\2\2\25`\3\2\2\2\27"+
		"c\3\2\2\2\31j\3\2\2\2\33m\3\2\2\2\35s\3\2\2\2\37x\3\2\2\2!~\3\2\2\2#\u0086"+
		"\3\2\2\2%\u0088\3\2\2\2\'\u008a\3\2\2\2)\u008c\3\2\2\2+\u008e\3\2\2\2"+
		"-\u0091\3\2\2\2/\u009f\3\2\2\2\61\u00a7\3\2\2\2\63\u00ab\3\2\2\2\65\u00b4"+
		"\3\2\2\2\67\u00b9\3\2\2\29:\7}\2\2:\4\3\2\2\2;<\7\177\2\2<\6\3\2\2\2="+
		">\7u\2\2>?\7v\2\2?@\7t\2\2@A\7k\2\2AB\7p\2\2BC\7i\2\2C\b\3\2\2\2DE\7]"+
		"\2\2E\n\3\2\2\2FG\7_\2\2G\f\3\2\2\2HI\7k\2\2IJ\7p\2\2JK\7v\2\2K\16\3\2"+
		"\2\2LM\7h\2\2MN\7n\2\2NO\7q\2\2OP\7c\2\2PQ\7v\2\2Q\20\3\2\2\2RS\7k\2\2"+
		"ST\7p\2\2TU\7v\2\2UV\7]\2\2VW\7_\2\2W\22\3\2\2\2XY\7h\2\2YZ\7n\2\2Z[\7"+
		"q\2\2[\\\7c\2\2\\]\7v\2\2]^\7]\2\2^_\7_\2\2_\24\3\2\2\2`a\7?\2\2ab\7?"+
		"\2\2b\26\3\2\2\2cd\7t\2\2de\7g\2\2ef\7r\2\2fg\7g\2\2gh\7c\2\2hi\7v\2\2"+
		"i\30\3\2\2\2jk\7k\2\2kl\7h\2\2l\32\3\2\2\2mn\7r\2\2no\7t\2\2op\7k\2\2"+
		"pq\7p\2\2qr\7v\2\2r\34\3\2\2\2st\7t\2\2tu\7g\2\2uv\7c\2\2vw\7f\2\2w\36"+
		"\3\2\2\2xy\7*\2\2yz\7k\2\2z{\7p\2\2{|\7v\2\2|}\7+\2\2} \3\2\2\2~\177\7"+
		"*\2\2\177\u0080\7h\2\2\u0080\u0081\7n\2\2\u0081\u0082\7q\2\2\u0082\u0083"+
		"\7c\2\2\u0083\u0084\7v\2\2\u0084\u0085\7+\2\2\u0085\"\3\2\2\2\u0086\u0087"+
		"\7-\2\2\u0087$\3\2\2\2\u0088\u0089\7/\2\2\u0089&\3\2\2\2\u008a\u008b\7"+
		",\2\2\u008b(\3\2\2\2\u008c\u008d\7\61\2\2\u008d*\3\2\2\2\u008e\u008f\7"+
		"?\2\2\u008f,\3\2\2\2\u0090\u0092\7/\2\2\u0091\u0090\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095\4\62;\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009a\7\60\2\2\u0099\u009b\4\62;\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d.\3\2\2\2"+
		"\u009e\u00a0\7/\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2"+
		"\3\2\2\2\u00a1\u00a3\4\62;\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\60\3\2\2\2\u00a6\u00a8\t\2\2"+
		"\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\62\3\2\2\2\u00ab\u00ad\7$\2\2\u00ac\u00ae\t\3\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7$\2\2\u00b2\64\3\2\2\2\u00b3\u00b5"+
		"\7\17\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b7\7\f\2\2\u00b7\66\3\2\2\2\u00b8\u00ba\t\4\2\2\u00b9\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\b\34\2\2\u00be8\3\2\2\2\f\2\u0091\u0096\u009c"+
		"\u009f\u00a4\u00a9\u00af\u00b4\u00bb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}