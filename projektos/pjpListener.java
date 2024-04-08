// Generated from /workspaces/PJP/projektos/pjp.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pjpParser}.
 */
public interface pjpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pjpParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(pjpParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(pjpParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(pjpParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(pjpParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(pjpParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(pjpParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#assignmentTypeStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentTypeStatement(pjpParser.AssignmentTypeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#assignmentTypeStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentTypeStatement(pjpParser.AssignmentTypeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(pjpParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(pjpParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(pjpParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(pjpParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(pjpParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(pjpParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(pjpParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(pjpParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(pjpParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(pjpParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(pjpParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(pjpParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(pjpParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(pjpParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(pjpParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(pjpParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link pjpParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterLiterals(pjpParser.LiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link pjpParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitLiterals(pjpParser.LiteralsContext ctx);
}