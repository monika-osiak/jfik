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
		T__9=10, FUNCTION=11, REPEAT=12, IF=13, PRINT=14, READ=15, TOINT=16, TOFLOAT=17, 
		PLUS=18, MINUS=19, MUL=20, DIV=21, EQ=22, FLOAT=23, INT=24, ID=25, STRING=26, 
		NEWLINE=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "FUNCTION", "REPEAT", "IF", "PRINT", "READ", "TOINT", "TOFLOAT", 
			"PLUS", "MINUS", "MUL", "DIV", "EQ", "FLOAT", "INT", "ID", "STRING", 
			"NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'string'", "'['", "']'", "'int'", "'float'", "'int[]'", 
			"'float[]'", "'=='", "'def'", "'repeat'", "'if'", "'print'", "'read'", 
			"'(int)'", "'(float)'", "'+'", "'-'", "'*'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "FUNCTION", 
			"REPEAT", "IF", "PRINT", "READ", "TOINT", "TOFLOAT", "PLUS", "MINUS", 
			"MUL", "DIV", "EQ", "FLOAT", "INT", "ID", "STRING", "NEWLINE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00c5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\5\30\u0098\n\30\3\30\6\30\u009b"+
		"\n\30\r\30\16\30\u009c\3\30\3\30\6\30\u00a1\n\30\r\30\16\30\u00a2\3\31"+
		"\5\31\u00a6\n\31\3\31\6\31\u00a9\n\31\r\31\16\31\u00aa\3\32\6\32\u00ae"+
		"\n\32\r\32\16\32\u00af\3\33\3\33\6\33\u00b4\n\33\r\33\16\33\u00b5\3\33"+
		"\3\33\3\34\5\34\u00bb\n\34\3\34\3\34\3\35\6\35\u00c0\n\35\r\35\16\35\u00c1"+
		"\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36\3\2\5\5\2\62;C\\c|\5\2\"\"C\\c|\4\2\13\13\"\"\2\u00cd\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2"+
		"\2\2\5=\3\2\2\2\7?\3\2\2\2\tF\3\2\2\2\13H\3\2\2\2\rJ\3\2\2\2\17N\3\2\2"+
		"\2\21T\3\2\2\2\23Z\3\2\2\2\25b\3\2\2\2\27e\3\2\2\2\31i\3\2\2\2\33p\3\2"+
		"\2\2\35s\3\2\2\2\37y\3\2\2\2!~\3\2\2\2#\u0084\3\2\2\2%\u008c\3\2\2\2\'"+
		"\u008e\3\2\2\2)\u0090\3\2\2\2+\u0092\3\2\2\2-\u0094\3\2\2\2/\u0097\3\2"+
		"\2\2\61\u00a5\3\2\2\2\63\u00ad\3\2\2\2\65\u00b1\3\2\2\2\67\u00ba\3\2\2"+
		"\29\u00bf\3\2\2\2;<\7}\2\2<\4\3\2\2\2=>\7\177\2\2>\6\3\2\2\2?@\7u\2\2"+
		"@A\7v\2\2AB\7t\2\2BC\7k\2\2CD\7p\2\2DE\7i\2\2E\b\3\2\2\2FG\7]\2\2G\n\3"+
		"\2\2\2HI\7_\2\2I\f\3\2\2\2JK\7k\2\2KL\7p\2\2LM\7v\2\2M\16\3\2\2\2NO\7"+
		"h\2\2OP\7n\2\2PQ\7q\2\2QR\7c\2\2RS\7v\2\2S\20\3\2\2\2TU\7k\2\2UV\7p\2"+
		"\2VW\7v\2\2WX\7]\2\2XY\7_\2\2Y\22\3\2\2\2Z[\7h\2\2[\\\7n\2\2\\]\7q\2\2"+
		"]^\7c\2\2^_\7v\2\2_`\7]\2\2`a\7_\2\2a\24\3\2\2\2bc\7?\2\2cd\7?\2\2d\26"+
		"\3\2\2\2ef\7f\2\2fg\7g\2\2gh\7h\2\2h\30\3\2\2\2ij\7t\2\2jk\7g\2\2kl\7"+
		"r\2\2lm\7g\2\2mn\7c\2\2no\7v\2\2o\32\3\2\2\2pq\7k\2\2qr\7h\2\2r\34\3\2"+
		"\2\2st\7r\2\2tu\7t\2\2uv\7k\2\2vw\7p\2\2wx\7v\2\2x\36\3\2\2\2yz\7t\2\2"+
		"z{\7g\2\2{|\7c\2\2|}\7f\2\2} \3\2\2\2~\177\7*\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7p\2\2\u0081\u0082\7v\2\2\u0082\u0083\7+\2\2\u0083\"\3\2\2\2\u0084"+
		"\u0085\7*\2\2\u0085\u0086\7h\2\2\u0086\u0087\7n\2\2\u0087\u0088\7q\2\2"+
		"\u0088\u0089\7c\2\2\u0089\u008a\7v\2\2\u008a\u008b\7+\2\2\u008b$\3\2\2"+
		"\2\u008c\u008d\7-\2\2\u008d&\3\2\2\2\u008e\u008f\7/\2\2\u008f(\3\2\2\2"+
		"\u0090\u0091\7,\2\2\u0091*\3\2\2\2\u0092\u0093\7\61\2\2\u0093,\3\2\2\2"+
		"\u0094\u0095\7?\2\2\u0095.\3\2\2\2\u0096\u0098\7/\2\2\u0097\u0096\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u009b\4\62;\2\u009a"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\7\60\2\2\u009f\u00a1\4\62;\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\60\3\2\2\2\u00a4\u00a6\7/\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a9\4\62;\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\62\3\2\2"+
		"\2\u00ac\u00ae\t\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\64\3\2\2\2\u00b1\u00b3\7$\2\2\u00b2"+
		"\u00b4\t\3\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8"+
		"\66\3\2\2\2\u00b9\u00bb\7\17\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2"+
		"\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\f\2\2\u00bd8\3\2\2\2\u00be\u00c0"+
		"\t\4\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b\35\2\2\u00c4:\3\2\2\2"+
		"\f\2\u0097\u009c\u00a2\u00a5\u00aa\u00af\u00b5\u00ba\u00c1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}