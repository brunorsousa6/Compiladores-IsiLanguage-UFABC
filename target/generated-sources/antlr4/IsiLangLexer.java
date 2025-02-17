// Generated from IsiLang.g4 by ANTLR 4.4

	import br.com.isilanguage.datastructures.IsiSymbol;
	import br.com.isilanguage.datastructures.IsiVariable;
	import br.com.isilanguage.datastructures.IsiSymbolTable;
	import br.com.isilanguage.exceptions.IsiSemanticException;
	import br.com.isilanguage.ast.IsiProgram;
	import br.com.isilanguage.ast.AbstractCommand;
	import br.com.isilanguage.ast.CommandLeitura;
	import br.com.isilanguage.ast.CommandEscrita;
	import br.com.isilanguage.ast.CommandAtribuicao;
	import br.com.isilanguage.ast.CommandDecisao;
	import br.com.isilanguage.ast.CommandEnquanto;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, OPREL=18, 
		ID=19, TEXT=20, NUMBER=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "TEXT", 
		"NUMBER", "WS"
	};


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<AbstractCommand> commandEnq;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("A variavel "+id+" n�o foi declarada ");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		
		
		
		public void compatType(IsiVariable var){
			boolean number = var.getValue().matches(".*[0-9].*");
			boolean string = var.getValue().matches(".*[a-zA-Z].");
			
			if(var.getType() != IsiVariable.NUMBER && number == true){
				throw new IsiSemanticException("A variavel "+var.getName()+" n�o pode receber atribui��o do tipo numero");
			}
			else if(var.getType() != IsiVariable.TEXT && string == true) {
				throw new IsiSemanticException("A variavel "+var.getName()+" n�o pode receber atribui��o do tipo texto");
			}
		}
		
		public void verificaUtilizacao(){
			
			for(IsiSymbol var: symbolTable.getAll()){
				IsiVariable varUsed = (IsiVariable) var;
				if(varUsed.getValue()== null){
					throw new IsiSemanticException("A variavel "+ varUsed.getName()+ " n�o foi utilizada");
				}
			}
			}
			
		
		


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u00a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0087\n\23\3\24\3\24\7\24\u008b\n\24\f\24\16\24\u008e\13\24"+
		"\3\25\3\25\7\25\u0092\n\25\f\25\16\25\u0095\13\25\3\25\3\25\3\26\6\26"+
		"\u009a\n\26\r\26\16\26\u009b\3\26\3\26\6\26\u00a0\n\26\r\26\16\26\u00a1"+
		"\5\26\u00a4\n\26\3\27\3\27\3\27\3\27\3\u0093\2\30\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5"+
		"\2\13\f\17\17\"\"\u00b1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\3/\3\2\2\2\5\62\3\2\2\2\7:\3\2\2\2\tC\3\2\2\2\13L\3\2\2"+
		"\2\rR\3\2\2\2\17Y\3\2\2\2\21b\3\2\2\2\23g\3\2\2\2\25m\3\2\2\2\27o\3\2"+
		"\2\2\31q\3\2\2\2\33s\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#{\3\2\2"+
		"\2%\u0086\3\2\2\2\'\u0088\3\2\2\2)\u008f\3\2\2\2+\u0099\3\2\2\2-\u00a5"+
		"\3\2\2\2/\60\7u\2\2\60\61\7g\2\2\61\4\3\2\2\2\62\63\7g\2\2\63\64\7u\2"+
		"\2\64\65\7e\2\2\65\66\7t\2\2\66\67\7g\2\2\678\7x\2\289\7c\2\29\6\3\2\2"+
		"\2:;\7h\2\2;<\7k\2\2<=\7o\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7i\2\2AB\7"+
		"=\2\2B\b\3\2\2\2CD\7g\2\2DE\7p\2\2EF\7s\2\2FG\7w\2\2GH\7c\2\2HI\7p\2\2"+
		"IJ\7v\2\2JK\7q\2\2K\n\3\2\2\2LM\7u\2\2MN\7g\2\2NO\7p\2\2OP\7c\2\2PQ\7"+
		"q\2\2Q\f\3\2\2\2RS\7p\2\2ST\7w\2\2TU\7o\2\2UV\7g\2\2VW\7t\2\2WX\7q\2\2"+
		"X\16\3\2\2\2YZ\7r\2\2Z[\7t\2\2[\\\7q\2\2\\]\7i\2\2]^\7t\2\2^_\7c\2\2_"+
		"`\7o\2\2`a\7c\2\2a\20\3\2\2\2bc\7n\2\2cd\7g\2\2de\7k\2\2ef\7c\2\2f\22"+
		"\3\2\2\2gh\7v\2\2hi\7g\2\2ij\7z\2\2jk\7v\2\2kl\7q\2\2l\24\3\2\2\2mn\7"+
		"*\2\2n\26\3\2\2\2op\7+\2\2p\30\3\2\2\2qr\7=\2\2r\32\3\2\2\2st\t\2\2\2"+
		"t\34\3\2\2\2uv\7?\2\2v\36\3\2\2\2wx\7.\2\2x \3\2\2\2yz\7}\2\2z\"\3\2\2"+
		"\2{|\7\177\2\2|$\3\2\2\2}\u0087\t\3\2\2~\177\7@\2\2\177\u0087\7?\2\2\u0080"+
		"\u0081\7>\2\2\u0081\u0087\7?\2\2\u0082\u0083\7?\2\2\u0083\u0087\7?\2\2"+
		"\u0084\u0085\7#\2\2\u0085\u0087\7?\2\2\u0086}\3\2\2\2\u0086~\3\2\2\2\u0086"+
		"\u0080\3\2\2\2\u0086\u0082\3\2\2\2\u0086\u0084\3\2\2\2\u0087&\3\2\2\2"+
		"\u0088\u008c\t\4\2\2\u0089\u008b\t\5\2\2\u008a\u0089\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d(\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0093\7)\2\2\u0090\u0092\13\2\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7)\2\2\u0097*\3\2\2\2\u0098"+
		"\u009a\t\6\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u00a3\3\2\2\2\u009d\u009f\7\60\2\2\u009e"+
		"\u00a0\t\6\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4,\3\2\2\2\u00a5\u00a6\t\7\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00a8\b\27\2\2\u00a8.\3\2\2\2\n\2\u0086\u008a\u008c\u0093\u009b"+
		"\u00a1\u00a3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}