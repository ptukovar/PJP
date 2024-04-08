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
		DOT=1, PLUS=2, MINUS=3, TIMES=4, DIVIDE=5, MOD=6, AND=7, OR=8, EQ=9, NEQ=10, 
		LT=11, LEQ=12, GT=13, GEQ=14, NOT=15, LPAREN=16, RPAREN=17, LBRACE=18, 
		RBRACE=19, ASSIGN=20, IF=21, ELSE=22, WHILE=23, FOR=24, READ=25, WRITE=26, 
		SEMICOLON=27, COMMA=28, TYPE=29, INTEGER=30, FLOAT=31, STRING=32, BOOLEAN=33, 
		WHITESPACE=34, COMMENT=35, COMMENT_LINE=36, VARIABLE=37;
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
			null, "'.'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'=='", 
			"'!='", "'<'", "'<='", "'>'", "'>='", "'!'", "'('", "')'", "'{'", "'}'", 
			"'='", "'if'", "'else'", "'while'", "'for'", "'read'", "'write'", "';'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "PLUS", "MINUS", "TIMES", "DIVIDE", "MOD", "AND", "OR", 
			"EQ", "NEQ", "LT", "LEQ", "GT", "GEQ", "NOT", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "ASSIGN", "IF", "ELSE", "WHILE", "FOR", "READ", "WRITE", "SEMICOLON", 
			"COMMA", "TYPE", "INTEGER", "FLOAT", "STRING", "BOOLEAN", "WHITESPACE", 
			"COMMENT", "COMMENT_LINE", "VARIABLE"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 154344456200L) != 0) );
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			variables();
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					match(ASSIGN);
					setState(70);
					variables();
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(76);
			match(ASSIGN);
			setState(77);
			expression(0);
			setState(78);
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
			setState(80);
			match(READ);
			setState(81);
			variables();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(83);
				variables();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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
			setState(91);
			match(WRITE);
			setState(92);
			expression(0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				expression(0);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
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
			setState(102);
			match(LBRACE);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 154344456200L) != 0)) {
				{
				{
				setState(103);
				statement();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
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
			setState(111);
			match(IF);
			setState(112);
			match(LPAREN);
			setState(113);
			expression(0);
			setState(114);
			match(RPAREN);
			setState(115);
			statement();
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(116);
				match(ELSE);
				setState(117);
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
			setState(120);
			match(WHILE);
			setState(121);
			match(LPAREN);
			setState(122);
			expression(0);
			setState(123);
			match(RPAREN);
			setState(124);
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
			setState(126);
			match(FOR);
			setState(127);
			match(LPAREN);
			setState(128);
			expression(0);
			setState(129);
			match(SEMICOLON);
			setState(130);
			expression(0);
			setState(131);
			match(SEMICOLON);
			setState(132);
			expression(0);
			setState(133);
			match(RPAREN);
			setState(134);
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
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(137);
				match(MINUS);
				setState(138);
				expression(22);
				}
				break;
			case 2:
				{
				setState(139);
				match(STRING);
				setState(140);
				match(DOT);
				setState(141);
				match(STRING);
				}
				break;
			case 3:
				{
				setState(142);
				match(INTEGER);
				}
				break;
			case 4:
				{
				setState(143);
				match(FLOAT);
				}
				break;
			case 5:
				{
				setState(144);
				match(STRING);
				}
				break;
			case 6:
				{
				setState(145);
				match(BOOLEAN);
				}
				break;
			case 7:
				{
				setState(146);
				variables();
				}
				break;
			case 8:
				{
				setState(147);
				match(LPAREN);
				setState(148);
				expression(0);
				setState(149);
				match(RPAREN);
				}
				break;
			case 9:
				{
				setState(151);
				match(NOT);
				setState(152);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(194);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(156);
						match(PLUS);
						setState(157);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(159);
						match(MINUS);
						setState(160);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(162);
						match(TIMES);
						setState(163);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(165);
						match(DIVIDE);
						setState(166);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(168);
						match(MOD);
						setState(169);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(171);
						match(EQ);
						setState(172);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(174);
						match(NEQ);
						setState(175);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(177);
						match(LT);
						setState(178);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(180);
						match(LEQ);
						setState(181);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(183);
						match(GT);
						setState(184);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(185);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(186);
						match(GEQ);
						setState(187);
						expression(5);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(189);
						match(AND);
						setState(190);
						expression(4);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(192);
						match(OR);
						setState(193);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
			setState(199);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
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
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00ca\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004\f\u0004"+
		"K\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005U\b\u0005\n\u0005\f\u0005"+
		"X\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006`\b\u0006\n\u0006\f\u0006c\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007i\b\u0007\n\u0007\f\u0007"+
		"l\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bw\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u009a\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00c3\b\u000b\n\u000b\f\u000b\u00c6\t\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0000\u0001\u0016\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u0000\u0001\u0001\u0000\u001e!\u00e3\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000"+
		"\u0000\u00061\u0001\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000\nP\u0001"+
		"\u0000\u0000\u0000\f[\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000"+
		"\u0000\u0010o\u0001\u0000\u0000\u0000\u0012x\u0001\u0000\u0000\u0000\u0014"+
		"~\u0001\u0000\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000\u0018\u00c7"+
		"\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0004\u0002\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f \u0005\u0000\u0000\u0001 \u0001\u0001\u0000"+
		"\u0000\u0000!\"\u0005%\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000#0\u0005"+
		"\u001b\u0000\u0000$0\u0003\u0006\u0003\u0000%&\u0003\u0016\u000b\u0000"+
		"&\'\u0005\u001b\u0000\u0000\'0\u0001\u0000\u0000\u0000(0\u0003\n\u0005"+
		"\u0000)0\u0003\f\u0006\u0000*0\u0003\u000e\u0007\u0000+0\u0003\u0010\b"+
		"\u0000,0\u0003\u0012\t\u0000-0\u0003\u0014\n\u0000.0\u0003\b\u0004\u0000"+
		"/#\u0001\u0000\u0000\u0000/$\u0001\u0000\u0000\u0000/%\u0001\u0000\u0000"+
		"\u0000/(\u0001\u0000\u0000\u0000/)\u0001\u0000\u0000\u0000/*\u0001\u0000"+
		"\u0000\u0000/+\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u0000/-\u0001"+
		"\u0000\u0000\u0000/.\u0001\u0000\u0000\u00000\u0005\u0001\u0000\u0000"+
		"\u000012\u0005\u001d\u0000\u000025\u0003\u0002\u0001\u000034\u0005\u0014"+
		"\u0000\u000046\u0003\u0016\u000b\u000053\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u00006?\u0001\u0000\u0000\u000078\u0005\u001c\u0000\u0000"+
		"8;\u0003\u0002\u0001\u00009:\u0005\u0014\u0000\u0000:<\u0003\u0016\u000b"+
		"\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000"+
		"\u0000\u0000=7\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000BC\u0005\u001b\u0000\u0000C\u0007\u0001\u0000"+
		"\u0000\u0000DI\u0003\u0002\u0001\u0000EF\u0005\u0014\u0000\u0000FH\u0003"+
		"\u0002\u0001\u0000GE\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LM\u0005\u0014\u0000\u0000MN\u0003\u0016"+
		"\u000b\u0000NO\u0005\u001b\u0000\u0000O\t\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u0019\u0000\u0000QV\u0003\u0002\u0001\u0000RS\u0005\u001c\u0000\u0000"+
		"SU\u0003\u0002\u0001\u0000TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\u001b\u0000\u0000Z\u000b"+
		"\u0001\u0000\u0000\u0000[\\\u0005\u001a\u0000\u0000\\a\u0003\u0016\u000b"+
		"\u0000]^\u0005\u001c\u0000\u0000^`\u0003\u0016\u000b\u0000_]\u0001\u0000"+
		"\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"de\u0005\u001b\u0000\u0000e\r\u0001\u0000\u0000\u0000fj\u0005\u0012\u0000"+
		"\u0000gi\u0003\u0004\u0002\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u0013\u0000\u0000"+
		"n\u000f\u0001\u0000\u0000\u0000op\u0005\u0015\u0000\u0000pq\u0005\u0010"+
		"\u0000\u0000qr\u0003\u0016\u000b\u0000rs\u0005\u0011\u0000\u0000sv\u0003"+
		"\u0004\u0002\u0000tu\u0005\u0016\u0000\u0000uw\u0003\u0004\u0002\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\u0011\u0001\u0000"+
		"\u0000\u0000xy\u0005\u0017\u0000\u0000yz\u0005\u0010\u0000\u0000z{\u0003"+
		"\u0016\u000b\u0000{|\u0005\u0011\u0000\u0000|}\u0003\u0004\u0002\u0000"+
		"}\u0013\u0001\u0000\u0000\u0000~\u007f\u0005\u0018\u0000\u0000\u007f\u0080"+
		"\u0005\u0010\u0000\u0000\u0080\u0081\u0003\u0016\u000b\u0000\u0081\u0082"+
		"\u0005\u001b\u0000\u0000\u0082\u0083\u0003\u0016\u000b\u0000\u0083\u0084"+
		"\u0005\u001b\u0000\u0000\u0084\u0085\u0003\u0016\u000b\u0000\u0085\u0086"+
		"\u0005\u0011\u0000\u0000\u0086\u0087\u0003\u0004\u0002\u0000\u0087\u0015"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0006\u000b\uffff\uffff\u0000\u0089"+
		"\u008a\u0005\u0003\u0000\u0000\u008a\u009a\u0003\u0016\u000b\u0016\u008b"+
		"\u008c\u0005 \u0000\u0000\u008c\u008d\u0005\u0001\u0000\u0000\u008d\u009a"+
		"\u0005 \u0000\u0000\u008e\u009a\u0005\u001e\u0000\u0000\u008f\u009a\u0005"+
		"\u001f\u0000\u0000\u0090\u009a\u0005 \u0000\u0000\u0091\u009a\u0005!\u0000"+
		"\u0000\u0092\u009a\u0003\u0002\u0001\u0000\u0093\u0094\u0005\u0010\u0000"+
		"\u0000\u0094\u0095\u0003\u0016\u000b\u0000\u0095\u0096\u0005\u0011\u0000"+
		"\u0000\u0096\u009a\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u000f\u0000"+
		"\u0000\u0098\u009a\u0003\u0016\u000b\u0001\u0099\u0088\u0001\u0000\u0000"+
		"\u0000\u0099\u008b\u0001\u0000\u0000\u0000\u0099\u008e\u0001\u0000\u0000"+
		"\u0000\u0099\u008f\u0001\u0000\u0000\u0000\u0099\u0090\u0001\u0000\u0000"+
		"\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099\u0092\u0001\u0000\u0000"+
		"\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u009a\u00c4\u0001\u0000\u0000\u0000\u009b\u009c\n\u000e\u0000\u0000"+
		"\u009c\u009d\u0005\u0002\u0000\u0000\u009d\u00c3\u0003\u0016\u000b\u000f"+
		"\u009e\u009f\n\r\u0000\u0000\u009f\u00a0\u0005\u0003\u0000\u0000\u00a0"+
		"\u00c3\u0003\u0016\u000b\u000e\u00a1\u00a2\n\f\u0000\u0000\u00a2\u00a3"+
		"\u0005\u0004\u0000\u0000\u00a3\u00c3\u0003\u0016\u000b\r\u00a4\u00a5\n"+
		"\u000b\u0000\u0000\u00a5\u00a6\u0005\u0005\u0000\u0000\u00a6\u00c3\u0003"+
		"\u0016\u000b\f\u00a7\u00a8\n\n\u0000\u0000\u00a8\u00a9\u0005\u0006\u0000"+
		"\u0000\u00a9\u00c3\u0003\u0016\u000b\u000b\u00aa\u00ab\n\t\u0000\u0000"+
		"\u00ab\u00ac\u0005\t\u0000\u0000\u00ac\u00c3\u0003\u0016\u000b\n\u00ad"+
		"\u00ae\n\b\u0000\u0000\u00ae\u00af\u0005\n\u0000\u0000\u00af\u00c3\u0003"+
		"\u0016\u000b\t\u00b0\u00b1\n\u0007\u0000\u0000\u00b1\u00b2\u0005\u000b"+
		"\u0000\u0000\u00b2\u00c3\u0003\u0016\u000b\b\u00b3\u00b4\n\u0006\u0000"+
		"\u0000\u00b4\u00b5\u0005\f\u0000\u0000\u00b5\u00c3\u0003\u0016\u000b\u0007"+
		"\u00b6\u00b7\n\u0005\u0000\u0000\u00b7\u00b8\u0005\r\u0000\u0000\u00b8"+
		"\u00c3\u0003\u0016\u000b\u0006\u00b9\u00ba\n\u0004\u0000\u0000\u00ba\u00bb"+
		"\u0005\u000e\u0000\u0000\u00bb\u00c3\u0003\u0016\u000b\u0005\u00bc\u00bd"+
		"\n\u0003\u0000\u0000\u00bd\u00be\u0005\u0007\u0000\u0000\u00be\u00c3\u0003"+
		"\u0016\u000b\u0004\u00bf\u00c0\n\u0002\u0000\u0000\u00c0\u00c1\u0005\b"+
		"\u0000\u0000\u00c1\u00c3\u0003\u0016\u000b\u0003\u00c2\u009b\u0001\u0000"+
		"\u0000\u0000\u00c2\u009e\u0001\u0000\u0000\u0000\u00c2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00c2\u00a4\u0001\u0000\u0000\u0000\u00c2\u00a7\u0001\u0000"+
		"\u0000\u0000\u00c2\u00aa\u0001\u0000\u0000\u0000\u00c2\u00ad\u0001\u0000"+
		"\u0000\u0000\u00c2\u00b0\u0001\u0000\u0000\u0000\u00c2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00c2\u00b6\u0001\u0000\u0000\u0000\u00c2\u00b9\u0001\u0000"+
		"\u0000\u0000\u00c2\u00bc\u0001\u0000\u0000\u0000\u00c2\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u0017\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0000"+
		"\u0000\u0000\u00c8\u0019\u0001\u0000\u0000\u0000\r\u001d/5;?IVajv\u0099"+
		"\u00c2\u00c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}