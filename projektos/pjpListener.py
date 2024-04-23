# Generated from ../pjp.g4 by ANTLR 4.13.0
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


    # Enter a parse tree produced by pjpParser#type.
    def enterType(self, ctx:pjpParser.TypeContext):
        pass

    # Exit a parse tree produced by pjpParser#type.
    def exitType(self, ctx:pjpParser.TypeContext):
        pass


    # Enter a parse tree produced by pjpParser#var.
    def enterVar(self, ctx:pjpParser.VarContext):
        pass

    # Exit a parse tree produced by pjpParser#var.
    def exitVar(self, ctx:pjpParser.VarContext):
        pass


    # Enter a parse tree produced by pjpParser#int.
    def enterInt(self, ctx:pjpParser.IntContext):
        pass

    # Exit a parse tree produced by pjpParser#int.
    def exitInt(self, ctx:pjpParser.IntContext):
        pass


    # Enter a parse tree produced by pjpParser#float.
    def enterFloat(self, ctx:pjpParser.FloatContext):
        pass

    # Exit a parse tree produced by pjpParser#float.
    def exitFloat(self, ctx:pjpParser.FloatContext):
        pass


    # Enter a parse tree produced by pjpParser#string.
    def enterString(self, ctx:pjpParser.StringContext):
        pass

    # Exit a parse tree produced by pjpParser#string.
    def exitString(self, ctx:pjpParser.StringContext):
        pass


    # Enter a parse tree produced by pjpParser#bool.
    def enterBool(self, ctx:pjpParser.BoolContext):
        pass

    # Exit a parse tree produced by pjpParser#bool.
    def exitBool(self, ctx:pjpParser.BoolContext):
        pass


    # Enter a parse tree produced by pjpParser#empty.
    def enterEmpty(self, ctx:pjpParser.EmptyContext):
        pass

    # Exit a parse tree produced by pjpParser#empty.
    def exitEmpty(self, ctx:pjpParser.EmptyContext):
        pass


    # Enter a parse tree produced by pjpParser#declaration.
    def enterDeclaration(self, ctx:pjpParser.DeclarationContext):
        pass

    # Exit a parse tree produced by pjpParser#declaration.
    def exitDeclaration(self, ctx:pjpParser.DeclarationContext):
        pass


    # Enter a parse tree produced by pjpParser#expr.
    def enterExpr(self, ctx:pjpParser.ExprContext):
        pass

    # Exit a parse tree produced by pjpParser#expr.
    def exitExpr(self, ctx:pjpParser.ExprContext):
        pass


    # Enter a parse tree produced by pjpParser#read.
    def enterRead(self, ctx:pjpParser.ReadContext):
        pass

    # Exit a parse tree produced by pjpParser#read.
    def exitRead(self, ctx:pjpParser.ReadContext):
        pass


    # Enter a parse tree produced by pjpParser#write.
    def enterWrite(self, ctx:pjpParser.WriteContext):
        pass

    # Exit a parse tree produced by pjpParser#write.
    def exitWrite(self, ctx:pjpParser.WriteContext):
        pass


    # Enter a parse tree produced by pjpParser#block.
    def enterBlock(self, ctx:pjpParser.BlockContext):
        pass

    # Exit a parse tree produced by pjpParser#block.
    def exitBlock(self, ctx:pjpParser.BlockContext):
        pass


    # Enter a parse tree produced by pjpParser#if.
    def enterIf(self, ctx:pjpParser.IfContext):
        pass

    # Exit a parse tree produced by pjpParser#if.
    def exitIf(self, ctx:pjpParser.IfContext):
        pass


    # Enter a parse tree produced by pjpParser#while.
    def enterWhile(self, ctx:pjpParser.WhileContext):
        pass

    # Exit a parse tree produced by pjpParser#while.
    def exitWhile(self, ctx:pjpParser.WhileContext):
        pass


    # Enter a parse tree produced by pjpParser#for.
    def enterFor(self, ctx:pjpParser.ForContext):
        pass

    # Exit a parse tree produced by pjpParser#for.
    def exitFor(self, ctx:pjpParser.ForContext):
        pass


    # Enter a parse tree produced by pjpParser#minus.
    def enterMinus(self, ctx:pjpParser.MinusContext):
        pass

    # Exit a parse tree produced by pjpParser#minus.
    def exitMinus(self, ctx:pjpParser.MinusContext):
        pass


    # Enter a parse tree produced by pjpParser#or.
    def enterOr(self, ctx:pjpParser.OrContext):
        pass

    # Exit a parse tree produced by pjpParser#or.
    def exitOr(self, ctx:pjpParser.OrContext):
        pass


    # Enter a parse tree produced by pjpParser#muldivmod.
    def enterMuldivmod(self, ctx:pjpParser.MuldivmodContext):
        pass

    # Exit a parse tree produced by pjpParser#muldivmod.
    def exitMuldivmod(self, ctx:pjpParser.MuldivmodContext):
        pass


    # Enter a parse tree produced by pjpParser#ltgt.
    def enterLtgt(self, ctx:pjpParser.LtgtContext):
        pass

    # Exit a parse tree produced by pjpParser#ltgt.
    def exitLtgt(self, ctx:pjpParser.LtgtContext):
        pass


    # Enter a parse tree produced by pjpParser#addsub.
    def enterAddsub(self, ctx:pjpParser.AddsubContext):
        pass

    # Exit a parse tree produced by pjpParser#addsub.
    def exitAddsub(self, ctx:pjpParser.AddsubContext):
        pass


    # Enter a parse tree produced by pjpParser#eqneq.
    def enterEqneq(self, ctx:pjpParser.EqneqContext):
        pass

    # Exit a parse tree produced by pjpParser#eqneq.
    def exitEqneq(self, ctx:pjpParser.EqneqContext):
        pass


    # Enter a parse tree produced by pjpParser#literal.
    def enterLiteral(self, ctx:pjpParser.LiteralContext):
        pass

    # Exit a parse tree produced by pjpParser#literal.
    def exitLiteral(self, ctx:pjpParser.LiteralContext):
        pass


    # Enter a parse tree produced by pjpParser#not.
    def enterNot(self, ctx:pjpParser.NotContext):
        pass

    # Exit a parse tree produced by pjpParser#not.
    def exitNot(self, ctx:pjpParser.NotContext):
        pass


    # Enter a parse tree produced by pjpParser#paren.
    def enterParen(self, ctx:pjpParser.ParenContext):
        pass

    # Exit a parse tree produced by pjpParser#paren.
    def exitParen(self, ctx:pjpParser.ParenContext):
        pass


    # Enter a parse tree produced by pjpParser#and.
    def enterAnd(self, ctx:pjpParser.AndContext):
        pass

    # Exit a parse tree produced by pjpParser#and.
    def exitAnd(self, ctx:pjpParser.AndContext):
        pass


    # Enter a parse tree produced by pjpParser#variable.
    def enterVariable(self, ctx:pjpParser.VariableContext):
        pass

    # Exit a parse tree produced by pjpParser#variable.
    def exitVariable(self, ctx:pjpParser.VariableContext):
        pass


    # Enter a parse tree produced by pjpParser#ternary.
    def enterTernary(self, ctx:pjpParser.TernaryContext):
        pass

    # Exit a parse tree produced by pjpParser#ternary.
    def exitTernary(self, ctx:pjpParser.TernaryContext):
        pass


    # Enter a parse tree produced by pjpParser#assign.
    def enterAssign(self, ctx:pjpParser.AssignContext):
        pass

    # Exit a parse tree produced by pjpParser#assign.
    def exitAssign(self, ctx:pjpParser.AssignContext):
        pass



del pjpParser