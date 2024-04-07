# Generated from pjp.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .pjpParser import pjpParser
else:
    from pjpParser import pjpParser

# This class defines a complete generic visitor for a parse tree produced by pjpParser.

class pjpVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by pjpParser#prog.
    def visitProg(self, ctx:pjpParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#literals.
    def visitLiterals(self, ctx:pjpParser.LiteralsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#variables.
    def visitVariables(self, ctx:pjpParser.VariablesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#statement.
    def visitStatement(self, ctx:pjpParser.StatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#readStatement.
    def visitReadStatement(self, ctx:pjpParser.ReadStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#writeStatement.
    def visitWriteStatement(self, ctx:pjpParser.WriteStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#block.
    def visitBlock(self, ctx:pjpParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#ifStatement.
    def visitIfStatement(self, ctx:pjpParser.IfStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#whileStatement.
    def visitWhileStatement(self, ctx:pjpParser.WhileStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#forStatement.
    def visitForStatement(self, ctx:pjpParser.ForStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#expression.
    def visitExpression(self, ctx:pjpParser.ExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#condition.
    def visitCondition(self, ctx:pjpParser.ConditionContext):
        return self.visitChildren(ctx)



del pjpParser