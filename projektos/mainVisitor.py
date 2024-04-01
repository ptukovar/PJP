# Generated from main.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .mainParser import mainParser
else:
    from mainParser import mainParser

# This class defines a complete generic visitor for a parse tree produced by mainParser.

class mainVisitor(ParseTreeVisitor):
    
    # Visit a parse tree produced by mainParser#int.
    def visitInt(self, ctx:mainParser.IntContext):
        return int(ctx.INT().getText(), 10)
   
    # Visit a parse tree produced by mainParser#hexa.
    def visitHexa(self, ctx:mainParser.HexaContext):
        return int(ctx.HEXA().getText(), 16)

    # Visit a parse tree produced by mainParser#oct.
    def visitOct(self, ctx:mainParser.OctContext):
        return int(ctx.OCT().getText(), 8)

    # Visit a parse tree produced by mainParser#par.
    def visitPar(self, ctx:mainParser.ParContext):
        return self.visit(ctx.expr())

    # Visit a parse tree produced by mainParser#add.
    def visitAdd(self, ctx:mainParser.AddContext):
        left = self.visit(ctx.expr()[0])
        right = self.visit(ctx.expr()[1])
        operator = ctx.op
        if operator == '+':
            return left + right
        else:
            return left - right

    # Visit a parse tree produced by mainParser#mul.
    def visitMul(self, ctx:mainParser.MulContext):
        left = self.visit(ctx.getChild(0))
        right = self.visit(ctx.getChild(2))
        operator = ctx.getChild(1).getText()
        if operator == '*':
            return left * right
        else:
            return left / right

    # Visit a parse tree produced by mainParser#prog.
    def visitProg(self, ctx:mainParser.ProgContext):
        for child in ctx.getChildren():
            if child.getChildCount() > 0:
                print(self.visit(child))
        return 0

del mainParser