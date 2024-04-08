# Generated from pjp.g4 by ANTLR 4.13.0
from enum import Enum
import sys

class Type(Enum):
    INT = 1
    FLOAT = 2
    STRING = 3
    BOOLEAN = 4
    ERROR = 4

class Symbol:
    def __init__(self, name, type, value, line, column):
        self.name = name
        self.type = type
        self.value = value
        self.line = line
        self.column = column

class SymbolTable:
    def __init__(self):
        self.symbolTable = {}

    def insert(self, symbol):
        if symbol.name in self.symbolTable:
            print(f"Symbol {symbol.name} already defined at line {self.symbolTable[symbol.name].line}, column {self.symbolTable[symbol.name].column}")
            return False
        self.symbolTable[symbol.name] = symbol
        return True

    def lookup(self, name):
        return self.symbolTable.get(name, None)

    def __str__(self):
        return str(self.symbolTable)

from antlr4 import *
if "." in __name__:
    from .pjpParser import pjpParser
else:
    from pjpParser import pjpParser

# This class defines a complete generic visitor for a parse tree produced by pjpParser.

class pjpVisitor(ParseTreeVisitor):
    def __init__(self):
        self.symbolTable = SymbolTable()

    # Visit a parse tree produced by pjpParser#prog.
    def visitProg(self, ctx:pjpParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#variables.
    def visitVariables(self, ctx:pjpParser.VariablesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#statement.
    def visitStatement(self, ctx:pjpParser.StatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentTypeStatement.
    def visitAssignmentTypeStatement(self, ctx:pjpParser.AssignmentTypeStatementContext):
        variableType = ctx.getChild(0).getText()
        variableName = ctx.getChild(1).getText()
        variableValue = ctx.getChild(3).getText()
        if variableType == "int":
            variableValue = int(variableValue)
            variableType = Type.INT
        elif variableType == "float":
            variableValue = float(variableValue)
            variableType = Type.FLOAT
        elif variableType == "string":
            variableValue = variableValue[1:-1]
            variableType = Type.STRING
        elif variableType == "bool":
            variableValue = variableValue == "true"
            variableType = Type.BOOLEAN
        else:
            print(f"Unknown type {variableType}")
            variableType = Type.ERROR
            return self.visitChildren(ctx)
            

        symbol = Symbol(variableName, variableType, variableValue, ctx.start.line, ctx.start.column)
        
        self.symbolTable.insert(symbol)
        print(symbol.name, symbol.type, symbol.value)
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentStatement.
    def visitAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        variableName = ctx.getChild(0).getText()
        symbol = self.symbolTable.lookup(variableName)
        if symbol is None:
            print(f"Symbol {variableName} not defined")
            sys.exit(1)
            return None
        
        variableValue = ctx.getChild(2).getText()

        if symbol.type == Type.INT:
            variableValue = int(variableValue)
        elif symbol.type == Type.FLOAT:
            variableValue = float(variableValue)
        elif symbol.type == Type.STRING:
            variableValue = variableValue[1:-1]
        elif symbol.type == Type.BOOL:
            variableValue = variableValue == "true"
        else:
            print(f"Unknown type {symbol.type}")
            return None
        
        symbol.value = variableValue
        print(symbol.name, symbol.type, symbol.value)
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


    # Visit a parse tree produced by pjpParser#literals.
    def visitLiterals(self, ctx:pjpParser.LiteralsContext):
        return self.visitChildren(ctx)



del pjpParser