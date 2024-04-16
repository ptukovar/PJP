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
        self.machineCode = []

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
            
        #for symbol in self.symbolTable.symbolTable.values():
        #    print(f"{symbol.name} {symbol.type} {symbol.value}")
        #print("-----------------------------------------------------")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentStatement.
    def visitAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        name = self.visit(ctx.getChild(0)).name
        symbol = self.symbolTable.lookup(name)
        if symbol is not None:
            value = self.symbolTable.lookup(name).value
            if self.symbolTable.lookup(name).value == None:
                value = ctx.getChild(2).getText()
        else:
            value = ctx.getChild(2).getText()
        if symbol.type == Type.INT:
            value = int(value)
            self.machineCode.append(f"push I {value}")
        elif symbol.type == Type.FLOAT:
            value = float(value)
            self.machineCode.append(f"push F {value}")
        elif symbol.type == Type.BOOL:
            if value == 'true':
                value = True
            elif value == 'false':
                value = False
            self.machineCode.append(f"push B {str(value).lower()}")
        elif symbol.type == Type.STRING:
            value = value
            self.machineCode.append(f"push S {value}")
        self.symbolTable.changeValue(name, value)
        #print(f"{name} {symbol.type} {value}")
        return self.visitChildren(ctx)  

    # Visit a parse tree produced by pjpParser#readStatement.
    def visitReadStatement(self, ctx:pjpParser.ReadStatementContext):
        for i in range(1,ctx.getChildCount()-1):
            if ctx.getChild(i).getText() == ',':
                continue
            name = ctx.getChild(i).getText()
            symbol = self.symbolTable.lookup(name)
            value = input(f"{name} = ")
            if symbol.type == Type.INT:
                value = int(value)
                print(f"read I")
                self.machineCode.append(f"read I")
            elif symbol.type == Type.FLOAT:
                value = float(value)
                print(f"read F")
                self.machineCode.append(f"read F")
            elif symbol.type == Type.BOOL:
                value = bool(value)
                print(f"read B")
                self.machineCode.append(f"read B")
            elif symbol.type == Type.STRING:
                value = value
                print(f"read S")
                self.machineCode.append(f"read S")
            self.symbolTable.changeValue(name, value)
            print(f"save {name}")
            self.machineCode.append(f"save {name}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#writeStatement.
    def visitWriteStatement(self, ctx:pjpParser.WriteStatementContext):
        output = ""
        child_count = 0
        for child in ctx.getChildren():
            if isinstance(child, pjpParser.ExpressionContext):
                result = self.visit(child)
                if isinstance(result, str) and (result.startswith('"') and result.endswith('"')):
                    output = f'push S {result}'
                    self.machineCode.append(output)
                elif isinstance(result, str):
                    output = f'load {result}'
                    self.machineCode.append(output)
                elif isinstance(result, int):
                    output = f'push I {result}'
                    self.machineCode.append(output)
                elif isinstance(result, float):
                    output = f'push F {result}'
                    self.machineCode.append(output)
                elif isinstance(result, bool):
                    output = f'push B {str(result).lower()}'
                    self.machineCode.append(output)
                print(output)
                child_count += 1

        output= f'print {child_count}'
        
        print(output)
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
        if ctx.getChildCount() == 3:
            left = self.visit(ctx.getChild(0))
            right = self.visit(ctx.getChild(2))
            if left is None or right is None:
                #print("Error: Unsupported operand type(s) for +: 'NoneType' and 'NoneType'")
                return None
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
        elif ctx.getChildCount() == 1:
            if ctx.INTEGER() is not None:
                return int(ctx.getChild(0).getText())
            elif ctx.FLOAT() is not None:
                return float(ctx.getChild(0).getText())
            elif ctx.BOOLEAN() is not None:
                return bool(ctx.getChild(0).getText())
            elif ctx.STRING() is not None:
                return str(ctx.getChild(0).getText())

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