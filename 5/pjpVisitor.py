# Generated from ../pjp.g4 by ANTLR 4.13.0
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


    # Visit a parse tree produced by pjpParser#type.
    def visitType(self, ctx:pjpParser.TypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#id.
    def visitId(self, ctx:pjpParser.IdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#int.
    def visitInt(self, ctx:pjpParser.IntContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#float.
    def visitFloat(self, ctx:pjpParser.FloatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#string.
    def visitString(self, ctx:pjpParser.StringContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#bool.
    def visitBool(self, ctx:pjpParser.BoolContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#empty.
    def visitEmpty(self, ctx:pjpParser.EmptyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#declaration.
    def visitDeclaration(self, ctx:pjpParser.DeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#expr.
    def visitExpr(self, ctx:pjpParser.ExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#read.
    def visitRead(self, ctx:pjpParser.ReadContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#write.
    def visitWrite(self, ctx:pjpParser.WriteContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#block.
    def visitBlock(self, ctx:pjpParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#if.
    def visitIf(self, ctx:pjpParser.IfContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#while.
    def visitWhile(self, ctx:pjpParser.WhileContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#for.
    def visitFor(self, ctx:pjpParser.ForContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#minus.
    def visitMinus(self, ctx:pjpParser.MinusContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#or.
    def visitOr(self, ctx:pjpParser.OrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#muldivmod.
    def visitMuldivmod(self, ctx:pjpParser.MuldivmodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#var.
    def visitVar(self, ctx:pjpParser.VarContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#ltgt.
    def visitLtgt(self, ctx:pjpParser.LtgtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#addsub.
    def visitAddsub(self, ctx:pjpParser.AddsubContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#eqneq.
    def visitEqneq(self, ctx:pjpParser.EqneqContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#not.
    def visitNot(self, ctx:pjpParser.NotContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#paren.
    def visitParen(self, ctx:pjpParser.ParenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#lit.
    def visitLit(self, ctx:pjpParser.LitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#and.
    def visitAnd(self, ctx:pjpParser.AndContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#ternary.
    def visitTernary(self, ctx:pjpParser.TernaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assign.
    def visitAssign(self, ctx:pjpParser.AssignContext):
        return self.visitChildren(ctx)



del pjpParser