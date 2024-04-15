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
        self.symbolTable[symbol.name] = symbol
        return True

    def changeValue(self, name, value):
        symbol = self.symbolTable.get(name, None)
        if symbol is None:
            print(f"Symbol {name} not defined")
            sys.exit(1)
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
        return self.symbolTable.lookup(ctx.getChild(0).getText())


    # Visit a parse tree produced by pjpParser#statement.
    def visitStatement(self, ctx:pjpParser.StatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentTypeStatement.
    def visitAssignmentTypeStatement(self, ctx:pjpParser.AssignmentTypeStatementContext):
        if ctx.TYPE().getText() == 'int':
            variableType = Type.INT
        elif ctx.TYPE().getText() == 'float':
            variableType = Type.FLOAT
        elif ctx.TYPE().getText() == 'string':
            variableType = Type.STRING
        elif ctx.TYPE().getText() == 'bool':
            variableType = Type.BOOL

        for i in range(1,ctx.getChildCount()-1):
            value = None
            if ctx.getChild(i-1).getText() == '=':
                continue
            if ctx.getChild(i).getText() == '=':
                continue
            elif ctx.getChild(i).getText() == ';':
                continue
            elif ctx.getChild(i).getText() == ',':
                continue
            elif ctx.getChild(i+1).getText() == '=':
                value = ctx.getChild(i+2).getText()
                if variableType == Type.INT:
                    value = int(value)
                elif variableType == Type.FLOAT:
                    value = float(value)
                elif variableType == Type.BOOL:
                    if value == 'true':
                        value = True
                    elif value == 'false':
                        value = False
                elif variableType == Type.STRING:
                    value = value
            self.symbolTable.insert(Symbol(ctx.getChild(i).getText(), variableType, value, ctx.start.line, ctx.start.column))
            
        for symbol in self.symbolTable.symbolTable.values():
            print(f"{symbol.name} {symbol.type} {symbol.value}")
        print("-----------------------------------------------------")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentStatement.
    def visitAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        name = ctx.getChild(0).getText()
        symbol = self.symbolTable.lookup(name)
        if symbol is None:
            print(f"Symbol {name} not defined")
            sys.exit(1)
        value = ctx.getChild(2).getText()
        if symbol.type == Type.INT:
            value = int(value)
        elif symbol.type == Type.FLOAT:
            value = float(value)
        elif symbol.type == Type.BOOL:
            if value == 'true':
                value = True
            elif value == 'false':
                value = False
        elif symbol.type == Type.STRING:
            value = value
        self.symbolTable.changeValue(name, value)
        print(f"{name} {symbol.type} {value}")
        return self.visitChildren(ctx)  

    # Visit a parse tree produced by pjpParser#readStatement.
    def visitReadStatement(self, ctx:pjpParser.ReadStatementContext):
        return ctx.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#writeStatement.
    def visitWriteStatement(self, ctx:pjpParser.WriteStatementContext):
       
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#block.
    def visitBlock(self, ctx:pjpParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#ifStatement.
    def visitIfStatement(self, ctx:pjpParser.IfStatementContext):
        if self.visit(ctx.getChild(2)):
            return self.visit(ctx.getChild(4))
        elif ctx.getChildCount() == 7:
            return self.visit(ctx.getChild(6))
        return ''


    # Visit a parse tree produced by pjpParser#whileStatement.
    def visitWhileStatement(self, ctx:pjpParser.WhileStatementContext):
        while self.visit(ctx.getChild(2)):
            self.visit(ctx.getChild(4))
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#forStatement.
    def visitForStatement(self, ctx:pjpParser.ForStatementContext):
        self.visit(ctx.getChild(2))
        while self.visit(ctx.getChild(4)):
            self.visit(ctx.getChild(8))
            self.visit(ctx.getChild(6))
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#expression.
    def visitExpression(self, ctx:pjpParser.ExpressionContext):
        #left = self.visit(ctx.getChild(0))
        #right = self.visit(ctx.getChild(2))
        print(f"{left} {right}")
        if ctx.PLUS is not None:
            return left + right
        elif ctx.MINUS is not None:
            return left - right
        elif ctx.MULT is not None:
            return left * right
        elif ctx.DIV is not None:
            return left / right
        elif ctx.MOD is not None:
            return left % right
        elif ctx.LT is not None:
            return left < right
        elif ctx.LE is not None:
            return left <= right
        elif ctx.GT is not None:
            return left > right
        elif ctx.GE is not None:
            return left >= right
        elif ctx.EQ is not None:
            return left == right
        elif ctx.NE is not None:
            return left != right
        elif ctx.AND is not None:
            return left and right
        elif ctx.OR is not None:
            return left or right
        elif ctx.NOT is not None:
            return not left

        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#literals.
    def visitLiterals(self, ctx:pjpParser.LiteralsContext):
        if ctx.INTEGER() is not None:
            return int(ctx.getChild(0).getText())
        elif ctx.FLOAT() is not None:
            return float(ctx.getChild(0).getText())
        elif ctx.BOOLEAN() is not None:
            return bool(ctx.getChild(0).getText())
        elif ctx.STRING() is not None:
            return str(ctx.getChild(0).getText())
        return self.visitChildren(ctx)