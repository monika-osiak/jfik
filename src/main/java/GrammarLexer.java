// Generated from /Users/monika/MRG-SEM1/JFiK/P2.2/Grammar.g4 by ANTLR 4.9.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PRINT=8, READ=9, 
		TOINT=10, TOFLOAT=11, PLUS=12, MINUS=13, MUL=14, DIV=15, EQ=16, FLOAT=17, 
		INT=18, ID=19, STRING=20, NEWLINE=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PRINT", "READ", 
			"TOINT", "TOFLOAT", "PLUS", "MINUS", "MUL", "DIV", "EQ", "FLOAT", "INT", 
			"ID", "STRING", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'string'", "'['", "']'", "'int'", "'float'", "'int[]'", "'float[]'", 
			"'print'", "'read'", "'(int)'", "'(float)'", "'+'", "'-'", "'*'", "'/'", 
			"'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PRINT", "READ", "TOINT", 
			"TOFLOAT", "PLUS", "MINUS", "MUL", "DIV", "EQ", "FLOAT", "INT", "ID", 
			"STRING", "NEWLINE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00a4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\5\22w\n\22\3\22\6\22z\n\22\r\22\16\22{\3\22\3\22\6\22\u0080\n\22"+
		"\r\22\16\22\u0081\3\23\5\23\u0085\n\23\3\23\6\23\u0088\n\23\r\23\16\23"+
		"\u0089\3\24\6\24\u008d\n\24\r\24\16\24\u008e\3\25\3\25\6\25\u0093\n\25"+
		"\r\25\16\25\u0094\3\25\3\25\3\26\5\26\u009a\n\26\3\26\3\26\3\27\6\27\u009f"+
		"\n\27\r\27\16\27\u00a0\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30\3\2\5\5\2\62;C\\c|\5\2\"\"C\\c|\4\2\13\13\"\"\2\u00ac\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\66\3\2\2"+
		"\2\78\3\2\2\2\t:\3\2\2\2\13>\3\2\2\2\rD\3\2\2\2\17J\3\2\2\2\21R\3\2\2"+
		"\2\23X\3\2\2\2\25]\3\2\2\2\27c\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2"+
		"\2\2\37q\3\2\2\2!s\3\2\2\2#v\3\2\2\2%\u0084\3\2\2\2\'\u008c\3\2\2\2)\u0090"+
		"\3\2\2\2+\u0099\3\2\2\2-\u009e\3\2\2\2/\60\7u\2\2\60\61\7v\2\2\61\62\7"+
		"t\2\2\62\63\7k\2\2\63\64\7p\2\2\64\65\7i\2\2\65\4\3\2\2\2\66\67\7]\2\2"+
		"\67\6\3\2\2\289\7_\2\29\b\3\2\2\2:;\7k\2\2;<\7p\2\2<=\7v\2\2=\n\3\2\2"+
		"\2>?\7h\2\2?@\7n\2\2@A\7q\2\2AB\7c\2\2BC\7v\2\2C\f\3\2\2\2DE\7k\2\2EF"+
		"\7p\2\2FG\7v\2\2GH\7]\2\2HI\7_\2\2I\16\3\2\2\2JK\7h\2\2KL\7n\2\2LM\7q"+
		"\2\2MN\7c\2\2NO\7v\2\2OP\7]\2\2PQ\7_\2\2Q\20\3\2\2\2RS\7r\2\2ST\7t\2\2"+
		"TU\7k\2\2UV\7p\2\2VW\7v\2\2W\22\3\2\2\2XY\7t\2\2YZ\7g\2\2Z[\7c\2\2[\\"+
		"\7f\2\2\\\24\3\2\2\2]^\7*\2\2^_\7k\2\2_`\7p\2\2`a\7v\2\2ab\7+\2\2b\26"+
		"\3\2\2\2cd\7*\2\2de\7h\2\2ef\7n\2\2fg\7q\2\2gh\7c\2\2hi\7v\2\2ij\7+\2"+
		"\2j\30\3\2\2\2kl\7-\2\2l\32\3\2\2\2mn\7/\2\2n\34\3\2\2\2op\7,\2\2p\36"+
		"\3\2\2\2qr\7\61\2\2r \3\2\2\2st\7?\2\2t\"\3\2\2\2uw\7/\2\2vu\3\2\2\2v"+
		"w\3\2\2\2wy\3\2\2\2xz\4\62;\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2"+
		"|}\3\2\2\2}\177\7\60\2\2~\u0080\4\62;\2\177~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082$\3\2\2\2\u0083\u0085\7"+
		"/\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0088\4\62;\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a&\3\2\2\2\u008b\u008d\t\2\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"(\3\2\2\2\u0090\u0092\7$\2\2\u0091\u0093\t\3\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\7$\2\2\u0097*\3\2\2\2\u0098\u009a\7\17\2\2\u0099\u0098"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\f\2\2\u009c"+
		",\3\2\2\2\u009d\u009f\t\4\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\b\27\2\2\u00a3.\3\2\2\2\f\2v{\u0081\u0084\u0089\u008e\u0094\u0099\u00a0"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}