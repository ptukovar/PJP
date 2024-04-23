// Generated from /workspaces/PJP/projektos/pjp.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class pjpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, DOT=3, PLUS=4, MINUS=5, TIMES=6, DIVIDE=7, MOD=8, AND=9, 
		OR=10, EQ=11, NEQ=12, LT=13, LEQ=14, GT=15, GEQ=16, NOT=17, LPAREN=18, 
		RPAREN=19, LBRACE=20, RBRACE=21, ASSIGN=22, IF=23, ELSE=24, WHILE=25, 
		FOR=26, READ=27, WRITE=28, INCREMENT=29, DECREMENT=30, SEMICOLON=31, COMMA=32, 
		TYPE=33, INTEGER=34, FLOAT=35, STRING=36, BOOLEAN=37, WHITESPACE=38, COMMENT=39, 
		COMMENT_LINE=40, VARIABLE=41;
	public static final int
		RULE_prog = 0, RULE_variables = 1, RULE_statement = 2, RULE_assignmentTypeStatement = 3, 
		RULE_assignmentStatement = 4, RULE_readStatement = 5, RULE_writeStatement = 6, 
		RULE_block = 7, RULE_ifStatement = 8, RULE_whileStatement = 9, RULE_forStatement = 10, 
		RULE_expression = 11, RULE_literals = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "variables", "statement", "assignmentTypeStatement", "assignmentStatement", 
			"readStatement", "writeStatement", "block", "ifStatement", "whileStatement", 
			"forStatement", "expression", "literals"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'?'", "':'", "'.'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", 
			"'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'!'", "'('", "')'", 
			"'{'", "'}'", "'='", "'if'", "'else'", "'while'", "'for'", "'read'", 
			"'write'", "'++'", "'--'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "DOT", "PLUS", "MINUS", "TIMES", "DIVIDE", "MOD", "AND", 
			"OR", "EQ", "NEQ", "LT", "LEQ", "GT", "GEQ", "NOT", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "ASSIGN", "IF", "ELSE", "WHILE", "FOR", "READ", "WRITE", 
			"INCREMENT", "DECREMENT", "SEMICOLON", "COMMA", "TYPE", "INTEGER", "FLOAT", 
			"STRING", "BOOLEAN", "WHITESPACE", "COMMENT", "COMMENT_LINE", "VARIABLE"
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
	public String getGrammarFileName() { return "pjp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public pjpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(pjpParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				statement();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2467971858464L) != 0) );
			setState(31);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(pjpParser.VARIABLE, 0); }
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitVariables(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(VARIABLE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(pjpParser.SEMICOLON, 0); }
		public AssignmentTypeStatementContext assignmentTypeStatement() {
			return getRuleContext(AssignmentTypeStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				assignmentTypeStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				expression(0);
				setState(38);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				readStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				writeStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(43);
				ifStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(44);
				whileStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(45);
				forStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(46);
				assignmentStatement();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentTypeStatementContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(pjpParser.TYPE, 0); }
		public List<VariablesContext> variables() {
			return getRuleContexts(VariablesContext.class);
		}
		public VariablesContext variables(int i) {
			return getRuleContext(VariablesContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(pjpParser.SEMICOLON, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(pjpParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(pjpParser.ASSIGN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(pjpParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(pjpParser.COMMA, i);
		}
		public TerminalNode PLUS() { return getToken(pjpParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(pjpParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(pjpParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(pjpParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(pjpParser.MOD, 0); }
		public AssignmentTypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentTypeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterAssignmentTypeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitAssignmentTypeStatement(this);
		}
	}

	public final AssignmentTypeStatementContext assignmentTypeStatement() throws RecognitionException {
		AssignmentTypeStatementContext _localctx = new AssignmentTypeStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignmentTypeStatement);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(TYPE);
				setState(50);
				variables();
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(51);
					match(ASSIGN);
					setState(52);
					expression(0);
					}
				}

				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(55);
					match(COMMA);
					setState(56);
					variables();
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASSIGN) {
						{
						setState(57);
						match(ASSIGN);
						setState(58);
						expression(0);
						}
					}

					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(TYPE);
				setState(69);
				variables();
				setState(70);
				match(ASSIGN);
				setState(71);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 496L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(72);
				expression(0);
				setState(73);
				match(SEMICOLON);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends ParserRuleContext {
		public List<VariablesContext> variables() {
			return getRuleContexts(VariablesContext.class);
		}
		public VariablesContext variables(int i) {
			return getRuleContext(VariablesContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(pjpParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(pjpParser.ASSIGN, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(pjpParser.SEMICOLON, 0); }
		public TerminalNode PLUS() { return getToken(pjpParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(pjpParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(pjpParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(pjpParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(pjpParser.MOD, 0); }
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitAssignmentStatement(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignmentStatement);
		int _la;
		try {
			int _alt;
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				variables();
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						match(ASSIGN);
						setState(79);
						variables();
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(85);
				match(ASSIGN);
				setState(86);
				expression(0);
				setState(87);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				variables();
				setState(90);
				match(ASSIGN);
				setState(91);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 496L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(92);
				expression(0);
				setState(93);
				match(SEMICOLON);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadStatementContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(pjpParser.READ, 0); }
		public List<VariablesContext> variables() {
			return getRuleContexts(VariablesContext.class);
		}
		public VariablesContext variables(int i) {
			return getRuleContext(VariablesContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(pjpParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(pjpParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(pjpParser.COMMA, i);
		}
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitReadStatement(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_readStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(READ);
			setState(98);
			variables();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(99);
				match(COMMA);
				setState(100);
				variables();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStatementContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(pjpParser.WRITE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(pjpParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(pjpParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(pjpParser.COMMA, i);
		}
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitWriteStatement(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_writeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(WRITE);
			setState(109);
			expression(0);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(110);
				match(COMMA);
				setState(111);
				expression(0);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(pjpParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(pjpParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(LBRACE);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2467971858464L) != 0)) {
				{
				{
				setState(120);
				statement();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(pjpParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(pjpParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(pjpParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(pjpParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(IF);
			setState(129);
			match(LPAREN);
			setState(130);
			expression(0);
			setState(131);
			match(RPAREN);
			setState(132);
			statement();
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(133);
				match(ELSE);
				setState(134);
				statement();
				}
				break;
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(pjpParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(pjpParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(pjpParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(WHILE);
			setState(138);
			match(LPAREN);
			setState(139);
			expression(0);
			setState(140);
			match(RPAREN);
			setState(141);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(pjpParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(pjpParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(pjpParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(pjpParser.SEMICOLON, i);
		}
		public TerminalNode RPAREN() { return getToken(pjpParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(FOR);
			setState(144);
			match(LPAREN);
			setState(145);
			expression(0);
			setState(146);
			match(SEMICOLON);
			setState(147);
			expression(0);
			setState(148);
			match(SEMICOLON);
			setState(149);
			expression(0);
			setState(150);
			match(RPAREN);
			setState(151);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(pjpParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(pjpParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(pjpParser.ASSIGN, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(pjpParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(pjpParser.TYPE, i);
		}
		public List<TerminalNode> STRING() { return getTokens(pjpParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(pjpParser.STRING, i);
		}
		public TerminalNode DOT() { return getToken(pjpParser.DOT, 0); }
		public TerminalNode INTEGER() { return getToken(pjpParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(pjpParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(pjpParser.BOOLEAN, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(pjpParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(pjpParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(pjpParser.NOT, 0); }
		public TerminalNode PLUS() { return getToken(pjpParser.PLUS, 0); }
		public TerminalNode TIMES() { return getToken(pjpParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(pjpParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(pjpParser.MOD, 0); }
		public TerminalNode EQ() { return getToken(pjpParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(pjpParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(pjpParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(pjpParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(pjpParser.GT, 0); }
		public TerminalNode GEQ() { return getToken(pjpParser.GEQ, 0); }
		public TerminalNode AND() { return getToken(pjpParser.AND, 0); }
		public TerminalNode OR() { return getToken(pjpParser.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(154);
				match(MINUS);
				setState(155);
				expression(24);
				}
				break;
			case 2:
				{
				setState(164); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(157); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(156);
								match(TYPE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(159); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(161);
						expression(0);
						setState(162);
						match(ASSIGN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(166); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(168);
				expression(0);
				setState(169);
				expression(23);
				}
				break;
			case 3:
				{
				setState(171);
				match(STRING);
				setState(172);
				match(DOT);
				setState(173);
				match(STRING);
				}
				break;
			case 4:
				{
				setState(174);
				match(INTEGER);
				}
				break;
			case 5:
				{
				setState(175);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(176);
				match(STRING);
				}
				break;
			case 7:
				{
				setState(177);
				match(BOOLEAN);
				}
				break;
			case 8:
				{
				setState(178);
				variables();
				}
				break;
			case 9:
				{
				setState(179);
				match(LPAREN);
				setState(180);
				expression(0);
				setState(181);
				match(RPAREN);
				}
				break;
			case 10:
				{
				setState(183);
				match(NOT);
				setState(184);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(232);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(188);
						match(T__0);
						setState(189);
						expression(0);
						setState(190);
						match(T__1);
						setState(191);
						expression(23);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(193);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(194);
						match(PLUS);
						setState(195);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(197);
						match(MINUS);
						setState(198);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(200);
						match(TIMES);
						setState(201);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(202);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(203);
						match(DIVIDE);
						setState(204);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(206);
						match(MOD);
						setState(207);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(209);
						match(EQ);
						setState(210);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(212);
						match(NEQ);
						setState(213);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(215);
						match(LT);
						setState(216);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(218);
						match(LEQ);
						setState(219);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(221);
						match(GT);
						setState(222);
						expression(6);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(224);
						match(GEQ);
						setState(225);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(227);
						match(AND);
						setState(228);
						expression(4);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(230);
						match(OR);
						setState(231);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralsContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(pjpParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(pjpParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(pjpParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(pjpParser.BOOLEAN, 0); }
		public LiteralsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).enterLiterals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pjpListener ) ((pjpListener)listener).exitLiterals(this);
		}
	}

	public final LiteralsContext literals() throws RecognitionException {
		LiteralsContext _localctx = new LiteralsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 257698037760L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 22);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00f0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000\f\u0000\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00036\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003"+
		"\u0005\u0003>\b\u0003\n\u0003\f\u0003A\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003L\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004`\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005f\b\u0005\n\u0005\f\u0005i\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006q\b\u0006\n\u0006\f\u0006t\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0005\u0007z\b\u0007\n\u0007\f\u0007}\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u0088\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b"+
		"\u009e\b\u000b\u000b\u000b\f\u000b\u009f\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000b\u00a5\b\u000b\u000b\u000b\f\u000b\u00a6\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00ba\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e9\b\u000b\n\u000b"+
		"\f\u000b\u00ec\t\u000b\u0001\f\u0001\f\u0001\f\u0000\u0001\u0016\r\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002"+
		"\u0001\u0000\u0004\b\u0001\u0000\"%\u010f\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0002!\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006"+
		"K\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\na\u0001\u0000\u0000"+
		"\u0000\fl\u0001\u0000\u0000\u0000\u000ew\u0001\u0000\u0000\u0000\u0010"+
		"\u0080\u0001\u0000\u0000\u0000\u0012\u0089\u0001\u0000\u0000\u0000\u0014"+
		"\u008f\u0001\u0000\u0000\u0000\u0016\u00b9\u0001\u0000\u0000\u0000\u0018"+
		"\u00ed\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0004\u0002\u0000\u001b"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f \u0005\u0000\u0000\u0001 \u0001\u0001"+
		"\u0000\u0000\u0000!\"\u0005)\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000"+
		"#0\u0005\u001f\u0000\u0000$0\u0003\u0006\u0003\u0000%&\u0003\u0016\u000b"+
		"\u0000&\'\u0005\u001f\u0000\u0000\'0\u0001\u0000\u0000\u0000(0\u0003\n"+
		"\u0005\u0000)0\u0003\f\u0006\u0000*0\u0003\u000e\u0007\u0000+0\u0003\u0010"+
		"\b\u0000,0\u0003\u0012\t\u0000-0\u0003\u0014\n\u0000.0\u0003\b\u0004\u0000"+
		"/#\u0001\u0000\u0000\u0000/$\u0001\u0000\u0000\u0000/%\u0001\u0000\u0000"+
		"\u0000/(\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000\u0000/*\u0001\u0000"+
		"\u0000\u0000/+\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u0000/-\u0001"+
		"\u0000\u0000\u0000/.\u0001\u0000\u0000\u00000\u0005\u0001\u0000\u0000"+
		"\u000012\u0005!\u0000\u000025\u0003\u0002\u0001\u000034\u0005\u0016\u0000"+
		"\u000046\u0003\u0016\u000b\u000053\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u00006?\u0001\u0000\u0000\u000078\u0005 \u0000\u00008;\u0003\u0002"+
		"\u0001\u00009:\u0005\u0016\u0000\u0000:<\u0003\u0016\u000b\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000"+
		"=7\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000BC\u0005\u001f\u0000\u0000CL\u0001\u0000\u0000\u0000DE\u0005"+
		"!\u0000\u0000EF\u0003\u0002\u0001\u0000FG\u0005\u0016\u0000\u0000GH\u0007"+
		"\u0000\u0000\u0000HI\u0003\u0016\u000b\u0000IJ\u0005\u001f\u0000\u0000"+
		"JL\u0001\u0000\u0000\u0000K1\u0001\u0000\u0000\u0000KD\u0001\u0000\u0000"+
		"\u0000L\u0007\u0001\u0000\u0000\u0000MR\u0003\u0002\u0001\u0000NO\u0005"+
		"\u0016\u0000\u0000OQ\u0003\u0002\u0001\u0000PN\u0001\u0000\u0000\u0000"+
		"QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005\u0016"+
		"\u0000\u0000VW\u0003\u0016\u000b\u0000WX\u0005\u001f\u0000\u0000X`\u0001"+
		"\u0000\u0000\u0000YZ\u0003\u0002\u0001\u0000Z[\u0005\u0016\u0000\u0000"+
		"[\\\u0007\u0000\u0000\u0000\\]\u0003\u0016\u000b\u0000]^\u0005\u001f\u0000"+
		"\u0000^`\u0001\u0000\u0000\u0000_M\u0001\u0000\u0000\u0000_Y\u0001\u0000"+
		"\u0000\u0000`\t\u0001\u0000\u0000\u0000ab\u0005\u001b\u0000\u0000bg\u0003"+
		"\u0002\u0001\u0000cd\u0005 \u0000\u0000df\u0003\u0002\u0001\u0000ec\u0001"+
		"\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000jk\u0005\u001f\u0000\u0000k\u000b\u0001\u0000\u0000\u0000lm\u0005"+
		"\u001c\u0000\u0000mr\u0003\u0016\u000b\u0000no\u0005 \u0000\u0000oq\u0003"+
		"\u0016\u000b\u0000pn\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000"+
		"\u0000tr\u0001\u0000\u0000\u0000uv\u0005\u001f\u0000\u0000v\r\u0001\u0000"+
		"\u0000\u0000w{\u0005\u0014\u0000\u0000xz\u0003\u0004\u0002\u0000yx\u0001"+
		"\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005\u0015\u0000\u0000\u007f\u000f\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\u0017\u0000\u0000\u0081\u0082\u0005\u0012\u0000\u0000"+
		"\u0082\u0083\u0003\u0016\u000b\u0000\u0083\u0084\u0005\u0013\u0000\u0000"+
		"\u0084\u0087\u0003\u0004\u0002\u0000\u0085\u0086\u0005\u0018\u0000\u0000"+
		"\u0086\u0088\u0003\u0004\u0002\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0011\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005\u0019\u0000\u0000\u008a\u008b\u0005\u0012\u0000\u0000"+
		"\u008b\u008c\u0003\u0016\u000b\u0000\u008c\u008d\u0005\u0013\u0000\u0000"+
		"\u008d\u008e\u0003\u0004\u0002\u0000\u008e\u0013\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005\u001a\u0000\u0000\u0090\u0091\u0005\u0012\u0000\u0000"+
		"\u0091\u0092\u0003\u0016\u000b\u0000\u0092\u0093\u0005\u001f\u0000\u0000"+
		"\u0093\u0094\u0003\u0016\u000b\u0000\u0094\u0095\u0005\u001f\u0000\u0000"+
		"\u0095\u0096\u0003\u0016\u000b\u0000\u0096\u0097\u0005\u0013\u0000\u0000"+
		"\u0097\u0098\u0003\u0004\u0002\u0000\u0098\u0015\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0006\u000b\uffff\uffff\u0000\u009a\u009b\u0005\u0005\u0000"+
		"\u0000\u009b\u00ba\u0003\u0016\u000b\u0018\u009c\u009e\u0005!\u0000\u0000"+
		"\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u0016\u000b\u0000"+
		"\u00a2\u00a3\u0005\u0016\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a4\u009d\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0003\u0016\u000b\u0000"+
		"\u00a9\u00aa\u0003\u0016\u000b\u0017\u00aa\u00ba\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005$\u0000\u0000\u00ac\u00ad\u0005\u0003\u0000\u0000\u00ad"+
		"\u00ba\u0005$\u0000\u0000\u00ae\u00ba\u0005\"\u0000\u0000\u00af\u00ba"+
		"\u0005#\u0000\u0000\u00b0\u00ba\u0005$\u0000\u0000\u00b1\u00ba\u0005%"+
		"\u0000\u0000\u00b2\u00ba\u0003\u0002\u0001\u0000\u00b3\u00b4\u0005\u0012"+
		"\u0000\u0000\u00b4\u00b5\u0003\u0016\u000b\u0000\u00b5\u00b6\u0005\u0013"+
		"\u0000\u0000\u00b6\u00ba\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0011"+
		"\u0000\u0000\u00b8\u00ba\u0003\u0016\u000b\u0001\u00b9\u0099\u0001\u0000"+
		"\u0000\u0000\u00b9\u00a4\u0001\u0000\u0000\u0000\u00b9\u00ab\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ae\u0001\u0000\u0000\u0000\u00b9\u00af\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b0\u0001\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b2\u0001\u0000\u0000\u0000\u00b9\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00ea\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\n\u0016\u0000\u0000\u00bc\u00bd\u0005\u0001\u0000"+
		"\u0000\u00bd\u00be\u0003\u0016\u000b\u0000\u00be\u00bf\u0005\u0002\u0000"+
		"\u0000\u00bf\u00c0\u0003\u0016\u000b\u0017\u00c0\u00e9\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\n\u000e\u0000\u0000\u00c2\u00c3\u0005\u0004\u0000\u0000"+
		"\u00c3\u00e9\u0003\u0016\u000b\u000f\u00c4\u00c5\n\r\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0005\u0000\u0000\u00c6\u00e9\u0003\u0016\u000b\u000e\u00c7"+
		"\u00c8\n\f\u0000\u0000\u00c8\u00c9\u0005\u0006\u0000\u0000\u00c9\u00e9"+
		"\u0003\u0016\u000b\r\u00ca\u00cb\n\u000b\u0000\u0000\u00cb\u00cc\u0005"+
		"\u0007\u0000\u0000\u00cc\u00e9\u0003\u0016\u000b\f\u00cd\u00ce\n\n\u0000"+
		"\u0000\u00ce\u00cf\u0005\b\u0000\u0000\u00cf\u00e9\u0003\u0016\u000b\u000b"+
		"\u00d0\u00d1\n\t\u0000\u0000\u00d1\u00d2\u0005\u000b\u0000\u0000\u00d2"+
		"\u00e9\u0003\u0016\u000b\n\u00d3\u00d4\n\b\u0000\u0000\u00d4\u00d5\u0005"+
		"\f\u0000\u0000\u00d5\u00e9\u0003\u0016\u000b\t\u00d6\u00d7\n\u0007\u0000"+
		"\u0000\u00d7\u00d8\u0005\r\u0000\u0000\u00d8\u00e9\u0003\u0016\u000b\b"+
		"\u00d9\u00da\n\u0006\u0000\u0000\u00da\u00db\u0005\u000e\u0000\u0000\u00db"+
		"\u00e9\u0003\u0016\u000b\u0007\u00dc\u00dd\n\u0005\u0000\u0000\u00dd\u00de"+
		"\u0005\u000f\u0000\u0000\u00de\u00e9\u0003\u0016\u000b\u0006\u00df\u00e0"+
		"\n\u0004\u0000\u0000\u00e0\u00e1\u0005\u0010\u0000\u0000\u00e1\u00e9\u0003"+
		"\u0016\u000b\u0005\u00e2\u00e3\n\u0003\u0000\u0000\u00e3\u00e4\u0005\t"+
		"\u0000\u0000\u00e4\u00e9\u0003\u0016\u000b\u0004\u00e5\u00e6\n\u0002\u0000"+
		"\u0000\u00e6\u00e7\u0005\n\u0000\u0000\u00e7\u00e9\u0003\u0016\u000b\u0003"+
		"\u00e8\u00bb\u0001\u0000\u0000\u0000\u00e8\u00c1\u0001\u0000\u0000\u0000"+
		"\u00e8\u00c4\u0001\u0000\u0000\u0000\u00e8\u00c7\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ca\u0001\u0000\u0000\u0000\u00e8\u00cd\u0001\u0000\u0000\u0000"+
		"\u00e8\u00d0\u0001\u0000\u0000\u0000\u00e8\u00d3\u0001\u0000\u0000\u0000"+
		"\u00e8\u00d6\u0001\u0000\u0000\u0000\u00e8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00e8\u00dc\u0001\u0000\u0000\u0000\u00e8\u00df\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e2\u0001\u0000\u0000\u0000\u00e8\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u0017\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ee\u0007\u0001\u0000\u0000"+
		"\u00ee\u0019\u0001\u0000\u0000\u0000\u0011\u001d/5;?KR_gr{\u0087\u009f"+
		"\u00a6\u00b9\u00e8\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}