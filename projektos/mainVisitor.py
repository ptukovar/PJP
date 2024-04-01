# Generated from main.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .mainParser import mainParser
else:
    from mainParser import mainParser

# This class defines a complete generic visitor for a parse tree produced by mainParser.

class mainVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by mainParser#prog.
    def visitProg(self, ctx:mainParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by mainParser#par.
    def visitPar(self, ctx:mainParser.ParContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by mainParser#add.
    def visitAdd(self, ctx:mainParser.AddContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by mainParser#oct.
    def visitOct(self, ctx:mainParser.OctContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by mainParser#mul.
    def visitMul(self, ctx:mainParser.MulContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by mainParser#hexa.
    def visitHexa(self, ctx:mainParser.HexaContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by mainParser#int.
    def visitInt(self, ctx:mainParser.IntContext):
        return self.visitChildren(ctx)



del mainParser