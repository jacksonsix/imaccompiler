// Generated from /Users/bigtree/code/try/javacompiler/expression/Lisp.g4 by ANTLR 4.7.2
package expression;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LispLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, INT=12, FLOAT=13, LINE_COMMENT=14, STRING=15, SPECIAL=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "ID", "ID_LETTER", "INT", "FLOAT", "DIGIT", "LINE_COMMENT", "STRING", 
			"ESC", "SPECIAL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'define'", "')'", "'set!'", "'if'", "'lambda'", "'begin'", 
			"'let'", "'cond'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"INT", "FLOAT", "LINE_COMMENT", "STRING", "SPECIAL", "WS"
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


	public LispLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lisp.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\7\f]\n\f\f\f\16\f`\13\f\3\r\3\r\3\16\6\16"+
		"e\n\16\r\16\16\16f\3\17\3\17\6\17k\n\17\r\17\16\17l\3\17\6\17p\n\17\r"+
		"\17\16\17q\3\17\3\17\7\17v\n\17\f\17\16\17y\13\17\5\17{\n\17\3\20\3\20"+
		"\3\21\3\21\7\21\u0081\n\21\f\21\16\21\u0084\13\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\7\22\u008d\n\22\f\22\16\22\u0090\13\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\6\25\u009a\n\25\r\25\16\25\u009b\3\25\3\25\4"+
		"\u0082\u008e\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\2\33\16\35\17\37\2!\20#\21%\2\'\22)\23\3\2\7\6\2##C\\aac|\3\2\62;\b\2"+
		"$$^^ddppttvv\6\2,-//\61\61??\5\2\13\f\17\17\"\"\2\u00a6\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5"+
		"-\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\13;\3\2\2\2\r>\3\2\2\2\17E\3\2\2\2"+
		"\21K\3\2\2\2\23O\3\2\2\2\25T\3\2\2\2\27Y\3\2\2\2\31a\3\2\2\2\33d\3\2\2"+
		"\2\35z\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0089\3\2\2\2%\u0093\3\2\2\2\'\u0096"+
		"\3\2\2\2)\u0099\3\2\2\2+,\7*\2\2,\4\3\2\2\2-.\7f\2\2./\7g\2\2/\60\7h\2"+
		"\2\60\61\7k\2\2\61\62\7p\2\2\62\63\7g\2\2\63\6\3\2\2\2\64\65\7+\2\2\65"+
		"\b\3\2\2\2\66\67\7u\2\2\678\7g\2\289\7v\2\29:\7#\2\2:\n\3\2\2\2;<\7k\2"+
		"\2<=\7h\2\2=\f\3\2\2\2>?\7n\2\2?@\7c\2\2@A\7o\2\2AB\7d\2\2BC\7f\2\2CD"+
		"\7c\2\2D\16\3\2\2\2EF\7d\2\2FG\7g\2\2GH\7i\2\2HI\7k\2\2IJ\7p\2\2J\20\3"+
		"\2\2\2KL\7n\2\2LM\7g\2\2MN\7v\2\2N\22\3\2\2\2OP\7e\2\2PQ\7q\2\2QR\7p\2"+
		"\2RS\7f\2\2S\24\3\2\2\2TU\7g\2\2UV\7n\2\2VW\7u\2\2WX\7g\2\2X\26\3\2\2"+
		"\2Y^\5\31\r\2Z]\5\31\r\2[]\5\37\20\2\\Z\3\2\2\2\\[\3\2\2\2]`\3\2\2\2^"+
		"\\\3\2\2\2^_\3\2\2\2_\30\3\2\2\2`^\3\2\2\2ab\t\2\2\2b\32\3\2\2\2ce\5\37"+
		"\20\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\34\3\2\2\2hj\7\60\2\2i"+
		"k\5\37\20\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m{\3\2\2\2np\5\37\20"+
		"\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2sw\7\60\2\2tv\5\37"+
		"\20\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zh\3"+
		"\2\2\2zo\3\2\2\2{\36\3\2\2\2|}\t\3\2\2} \3\2\2\2~\u0082\7=\2\2\177\u0081"+
		"\13\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\f"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\21\2\2\u0088\"\3\2\2\2\u0089\u008e"+
		"\7$\2\2\u008a\u008d\5%\23\2\u008b\u008d\13\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008f\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7$\2\2\u0092"+
		"$\3\2\2\2\u0093\u0094\7^\2\2\u0094\u0095\t\4\2\2\u0095&\3\2\2\2\u0096"+
		"\u0097\t\5\2\2\u0097(\3\2\2\2\u0098\u009a\t\6\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\b\25\2\2\u009e*\3\2\2\2\16\2\\^flqwz\u0082\u008c"+
		"\u008e\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}