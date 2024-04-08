# Generated from pjp.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .pjpParser import pjpParser
else:
    from pjpParser import pjpParser

# This class defines a complete listener for a parse tree produced by pjpParser.
class pjpListener(ParseTreeListener):

    # Enter a parse tree produced by pjpParser#prog.
    def enterProg(self, ctx:pjpParser.ProgContext):
        pass

    # Exit a parse tree produced by pjpParser#prog.
    def exitProg(self, ctx:pjpParser.ProgContext):
        pass


    # Enter a parse tree produced by pjpParser#variables.
    def enterVariables(self, ctx:pjpParser.VariablesContext):
        pass

    # Exit a parse tree produced by pjpParser#variables.
    def exitVariables(self, ctx:pjpParser.VariablesContext):
        pass


    # Enter a parse tree produced by pjpParser#statement.
    def enterStatement(self, ctx:pjpParser.StatementContext):
        pass

    # Exit a parse tree produced by pjpParser#statement.
    def exitStatement(self, ctx:pjpParser.StatementContext):
        pass


    # Enter a parse tree produced by pjpParser#assignmentStatement.
    def enterAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        pass

    # Exit a parse tree produced by pjpParser#assignmentStatement.
    def exitAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        pass


    # Enter a parse tree produced by pjpParser#readStatement.
    def enterReadStatement(self, ctx:pjpParser.ReadStatementContext):
        pass

    # Exit a parse tree produced by pjpParser#readStatement.
    def exitReadStatement(self, ctx:pjpParser.ReadStatementContext):
        pass


    # Enter a parse tree produced by pjpParser#writeStatement.
    def enterWriteStatement(self, ctx:pjpParser.WriteStatementContext):
        pass

    # Exit a parse tree produced by pjpParser#writeStatement.
    def exitWriteStatement(self, ctx:pjpParser.WriteStatementContext):
        pass


    # Enter a parse tree produced by pjpParser#block.
    def enterBlock(self, ctx:pjpParser.BlockContext):
        pass

    # Exit a parse tree produced by pjpParser#block.
    def exitBlock(self, ctx:pjpParser.BlockContext):
        pass


    # Enter a parse tree produced by pjpParser#ifStatement.
    def enterIfStatement(self, ctx:pjpParser.IfStatementContext):
        pass

    # Exit a parse tree produced by pjpParser#ifStatement.
    def exitIfStatement(self, ctx:pjpParser.IfStatementContext):
        pass


    # Enter a parse tree produced by pjpParser#whileStatement.
    def enterWhileStatement(self, ctx:pjpParser.WhileStatementContext):
        pass

    # Exit a parse tree produced by pjpParser#whileStatement.
    def exitWhileStatement(self, ctx:pjpParser.WhileStatementContext):
        pass


    # Enter a parse tree produced by pjpParser#forStatement.
    def enterForStatement(self, ctx:pjpParser.ForStatementContext):
        pass

    # Exit a parse tree produced by pjpParser#forStatement.
    def exitForStatement(self, ctx:pjpParser.ForStatementContext):
        pass


    # Enter a parse tree produced by pjpParser#expression.
    def enterExpression(self, ctx:pjpParser.ExpressionContext):
        pass

    # Exit a parse tree produced by pjpParser#expression.
    def exitExpression(self, ctx:pjpParser.ExpressionContext):
        pass


    # Enter a parse tree produced by pjpParser#literals.
    def enterLiterals(self, ctx:pjpParser.LiteralsContext):
        pass

    # Exit a parse tree produced by pjpParser#literals.
    def exitLiterals(self, ctx:pjpParser.LiteralsContext):
        pass



del pjpParser