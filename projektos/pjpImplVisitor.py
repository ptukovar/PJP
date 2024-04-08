from antlr4 import ParseTreeVisitor
from pjpVisitor import pjpVisitor
from pjpParser import pjpParser
from enum import Enum
import sys

class Type(Enum):
    INT = 1
    FLOAT = 2
    STRING = 3
    BOOL = 4
    ERROR = 4

class Symbol:
    def __init__(self, name, type, value, line, column):
        self.name = name
        self.type = type
        self.value = value
        self.line = line
        self.column = column

class SymbolTable(ParseTreeVisitor):
    def __init__(self):
        self.symbolTable = {}

    def insert(self, symbol):
        if symbol.name in self.symbolTable:
            print(f"Symbol {symbol.name} already defined at line {self.symbolTable[symbol.name].line}, column {self.symbolTable[symbol.name].column}")
            sys.exit(1)
            return False
        self.symbolTable[symbol.name] = symbol
        return True

    def changeValue(self, name, value):
        symbol = self.symbolTable.get(name, None)
        if symbol is None:
            print(f"Symbol {name} not defined")
            sys.exit(1)
            return False
        symbol.value = value
        return True

    def lookup(self, name):
        return self.symbolTable.get(name, None)

    def __str__(self):
        return str(self.symbolTable)

class pjpImplVisitor(pjpVisitor):
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
        if variableType == 'int':
            variableType = Type.INT
        elif variableType == 'float':
            variableType = Type.FLOAT
        elif variableType == 'string':
            variableType = Type.STRING
        elif variableType == 'bool':
            variableType = Type.BOOL
        else:
            print("Unknown type")
            sys.exit(1)

        for i in range(1, len(ctx.children), 2):
            checker = str(ctx.getChild(i).getText())
            if ctx.getChild(i).getText() == ',' or ctx.getChild(i).getText() == ';' or checker.isdigit() or checker.startswith("\""):
                continue
            if ctx.getChild(i+1).getText() == '=':
                variableName = ctx.getChild(i).getText()
                variableValue = ctx.getChild(i+2).getText()
                self.symbolTable.insert(Symbol(variableName, variableType, variableValue, ctx.start.line, ctx.start.column))
            else:
                variableName = ctx.getChild(i).getText()
                self.symbolTable.insert(Symbol(variableName, variableType, None, ctx.start.line, ctx.start.column))
            
            print(self.symbolTable.symbolTable.get(variableName).name, 
                  self.symbolTable.symbolTable.get(variableName).type, 
                  self.symbolTable.symbolTable.get(variableName).value, 
                  self.symbolTable.symbolTable.get(variableName).line, 
                  self.symbolTable.symbolTable.get(variableName).column)
            
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentStatement.
    def visitAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        expression =  ctx.getChild(2).getText()
        variableName = ctx.getChild(0).getText()
        variableValue = ctx.getChild(2).getText()
        
        if ctx.getChildCount() > 4 or '+' in variableValue or '-' in variableValue or '*' in variableValue or '/' in variableValue or '%' in variableValue: 
            variableValue = self.evaluate(variableValue)   
        variableType = self.symbolTable.lookup(variableName).type         
        if '.' in str(variableValue) and  variableType == Type.INT:
            print(f"Variable {variableName} is {Type.INT} at line {ctx.start.line}, column {ctx.start.column} and cannot be assigned a FLOAT value")
            sys.exit(1)
        self.symbolTable.changeValue(variableName, variableValue)

        print(self.symbolTable.symbolTable.get(variableName).name, 
                  self.symbolTable.symbolTable.get(variableName).type, 
                  self.symbolTable.symbolTable.get(variableName).value, 
                  self.symbolTable.symbolTable.get(variableName).line, 
                  self.symbolTable.symbolTable.get(variableName).column)

    # Visit a parse tree produced by pjpParser#readStatement.
    def visitReadStatement(self, ctx:pjpParser.ReadStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#writeStatement.
    def visitWriteStatement(self, ctx:pjpParser.WriteStatementContext):
        print(self.visit(ctx.getChild(1)))
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
    
    def evaluate(self, expression):
        temp = str(expression).split()
        delimiters = ['+', '-', '*', '/', '%']
        return eval(expression)