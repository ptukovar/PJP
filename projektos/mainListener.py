# Generated from main.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .mainParser import mainParser
else:
    from mainParser import mainParser

# This class defines a complete listener for a parse tree produced by mainParser.
class mainListener(ParseTreeListener):

    # Enter a parse tree produced by mainParser#prog.
    def enterProg(self, ctx:mainParser.ProgContext):
        pass

    # Exit a parse tree produced by mainParser#prog.
    def exitProg(self, ctx:mainParser.ProgContext):
        pass


    # Enter a parse tree produced by mainParser#par.
    def enterPar(self, ctx:mainParser.ParContext):
        pass

    # Exit a parse tree produced by mainParser#par.
    def exitPar(self, ctx:mainParser.ParContext):
        pass


    # Enter a parse tree produced by mainParser#add.
    def enterAdd(self, ctx:mainParser.AddContext):
        pass

    # Exit a parse tree produced by mainParser#add.
    def exitAdd(self, ctx:mainParser.AddContext):
        pass


    # Enter a parse tree produced by mainParser#oct.
    def enterOct(self, ctx:mainParser.OctContext):
        pass

    # Exit a parse tree produced by mainParser#oct.
    def exitOct(self, ctx:mainParser.OctContext):
        pass


    # Enter a parse tree produced by mainParser#mul.
    def enterMul(self, ctx:mainParser.MulContext):
        pass

    # Exit a parse tree produced by mainParser#mul.
    def exitMul(self, ctx:mainParser.MulContext):
        pass


    # Enter a parse tree produced by mainParser#hexa.
    def enterHexa(self, ctx:mainParser.HexaContext):
        pass

    # Exit a parse tree produced by mainParser#hexa.
    def exitHexa(self, ctx:mainParser.HexaContext):
        pass


    # Enter a parse tree produced by mainParser#int.
    def enterInt(self, ctx:mainParser.IntContext):
        pass

    # Exit a parse tree produced by mainParser#int.
    def exitInt(self, ctx:mainParser.IntContext):
        pass



del mainParser