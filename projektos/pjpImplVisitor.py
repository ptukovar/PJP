from antlr4 import ParseTreeVisitor
from pjpVisitor import pjpVisitor
from pjpParser import pjpParser
from virtualMachine import virtualMachine
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
        self.labelCounter = -1

    def next_label(self):
        self.labelCounter += 1
        return self.labelCounter

    # Visit a parse tree produced by pjpParser#prog.
    def visitProg(self, ctx:pjpParser.ProgContext):
        #virtualMachine(self.machineCode).run()
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
            if (variableType == Type.INT or variableType == Type.FLOAT) and value is None:
                self.symbolTable.insert(Symbol(ctx.getChild(i).getText(), variableType, 0, ctx.start.line, ctx.start.column)) 
                self.machineCode.append(f"push {variableType.name[0].lower()} 0")
                self.machineCode.append(f"save {variableType.name[0].lower()} {ctx.getChild(i).getText()}")        
            else:
                self.symbolTable.insert(Symbol(ctx.getChild(i).getText(), variableType, value, ctx.start.line, ctx.start.column))
        return #self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assignmentStatement.
    def visitAssignmentStatement(self, ctx:pjpParser.AssignmentStatementContext):
        name = self.visit(ctx.getChild(0)).name
        symbol = self.symbolTable.lookup(name)
        value = self.visit(ctx.getChild(2))
        if ctx.getChildCount() == 3 or ctx.getChildCount() == 4:
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
            #self.machineCode.append(f"push {symbol.type.name[0]} {value}")
            self.machineCode.append(f"save {symbol.type.name[0].lower()} {name}")
            self.symbolTable.changeValue(name, value)
        return self.visitChildren(ctx)

    # Visit a parse tree produced by pjpParser#readStatement.
    def visitReadStatement(self, ctx:pjpParser.ReadStatementContext):
        for i in range(1,ctx.getChildCount()-1):
            if ctx.getChild(i).getText() == ',':
                continue
            name = ctx.getChild(i).getText()
            symbol = self.symbolTable.lookup(name)
            temptype = symbol.type
            if symbol.type == Type.INT:
                value = int(input(f"{name} I = "))
            elif symbol.type == Type.FLOAT:
                value = float(input(f"{name} F = "))
            elif symbol.type == Type.BOOL:
                value = bool(input(f"{name} B = "))
            elif symbol.type == Type.STRING:
                value = input(f"{name} S = ")
            
            if symbol.type == Type.INT:
                value = int(value)
                self.machineCode.append(f"read I")
            elif symbol.type == Type.FLOAT:
                value = float(value)
                self.machineCode.append(f"read F")
            elif symbol.type == Type.BOOL:
                value = bool(value)
                self.machineCode.append(f"read B")
            elif symbol.type == Type.STRING:
                value = value
                self.machineCode.append(f"read S")
            self.symbolTable.changeValue(name, value)
            self.machineCode.append(f"save {name}")
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#writeStatement.
    def visitWriteStatement(self, ctx:pjpParser.WriteStatementContext):
        output = ""
        child_count = 0
        for child in ctx.getChildren():
            if isinstance(child, pjpParser.ExpressionContext):
                result = self.visit(child)
                #if isinstance(result, str) and (result.startswith('"') and result.endswith('"')):
                    #output = f'S {result}'
                    #self.machineCode.append(output)
                #elif isinstance(result, str):
                    #output = f'X {result}'
                    #self.machineCode.append(output)
                #elif isinstance(result, int):
                    #output = f'I {result}'
                    #self.machineCode.append(output)
                #elif isinstance(result, float):
                    #output = f'F {result}'
                    #self.machineCode.append(output)
                #elif isinstance(result, bool):
                    #output = f'B {str(result).lower()}'
                    #self.machineCode.append(output)
                child_count += 1
        
        self.machineCode.append(f"print {child_count}")
        #output= f'print {child_count}'
        #print(output)
        #self.machineCode.append(output)
        return self.visitChildren(ctx) if ctx.getChildCount() == 1 else 0;


    # Visit a parse tree produced by pjpParser#block.
    def visitBlock(self, ctx:pjpParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#ifStatement.
    def visitIfStatement(self, ctx:pjpParser.IfStatementContext):
        condition = self.visit(ctx.getChild(2))
        false_label = self.next_label()
        end_label = self.next_label()
        self.machineCode.append(f"fjmp {false_label}")
        self.visit(ctx.getChild(4))
        self.machineCode.append(f"jmp {end_label}")
        self.machineCode.append(f"label {false_label}")
        if ctx.getChildCount() == 7:
            self.visit(ctx.getChild(6))
        self.machineCode.append(f"label {end_label}")
        return None
        if self.visit(ctx.getChild(2)):
            return self.visit(ctx.getChild(4))
        elif ctx.getChildCount() == 7:
            return self.visit(ctx.getChild(6))
        return ''


    # Visit a parse tree produced by pjpParser#whileStatement.
    def visitWhileStatement(self, ctx:pjpParser.WhileStatementContext):
        start_label = self.next_label()
        end_label = self.next_label()
        
        self.machineCode.append(f"label {start_label}")
        self.visit(ctx.getChild(2))
        self.machineCode.append(f"fjmp {end_label}")
        self.visit(ctx.getChild(4))
        self.machineCode.append(f"jmp {start_label}")
        self.machineCode.append(f"label {end_label}")

        return None
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
            if isinstance(left, str) and (left.startswith('"') and left.endswith('"')):
                left_type = Type.STRING
            elif isinstance(left, str):
                left_type = Type.ERROR
            elif isinstance(left, int):
                left_type = Type.INT
            elif isinstance(left, float):
                left_type = Type.FLOAT
            elif isinstance(left, bool):
                left_type = Type.BOOL
            else:
                left_type = Type.ERROR

            if isinstance(right, str) and (right.startswith('"') and right.endswith('"')):
                right_type = Type.STRING
            elif isinstance(right, str):
                right_type = Type.ERROR
            elif isinstance(right, int):
                right_type = Type.INT
            elif isinstance(right, float):
                right_type = Type.FLOAT
            elif isinstance(right, bool):
                right_type = Type.BOOL
            else:
                right_type = Type.ERROR
            if left is None or right is None:
                #print("Error")
                return None
            
            if "+" in ctx.getText() is not None:
                left_type = self.checkIntToFloat(left_type, right_type)
                self.machineCode.append(f"add")
                self.machineCode.append(f"print {left_type.name[0].lower()}")
                return left + right
            elif "-" in ctx.getText() is not None:
                left_type = self.checkIntToFloat(left_type, right_type)
                self.machineCode.append(f"sub")
                self.machineCode.append(f"print {left_type.name[0].lower()}")
                return left - right
            elif "*" in ctx.getText() is not None:
                left_type = self.checkIntToFloat(left_type, right_type)
                self.machineCode.append(f"mul")
                self.machineCode.append(f"print {left_type.name[0].lower()}")
                return left * right
            elif "/" in ctx.getText() is not None:
                left_type = self.checkIntToFloat(left_type, right_type)
                self.machineCode.append(f"div")
                self.machineCode.append(f"print {left_type.name[0].lower()}")
                return left / right
            elif "%" in ctx.getText() is not None:
                left_type = self.checkIntToFloat(left_type, right_type)
                self.machineCode.append(f"mod")
                self.machineCode.append(f"print {left_type.name[0].lower()}")
                return left % right
            elif "<" in ctx.getText() is not None:
                self.machineCode.append(f"lt")
                return left < right
            elif "<=" in ctx.getText() is not None:
                self.machineCode.append(f"le")
                return left <= right
            elif ">" in ctx.getText() is not None:
                self.machineCode.append(f"gt")
                return left > right
            elif ">=" in ctx.getText() is not None:
                self.machineCode.append(f"ge")
                return left >= right
            elif "==" in ctx.getText() is not None:
                self.machineCode.append(f"eq")
                return left == right
            elif "!=" in ctx.getText() is not None:
                self.machineCode.append(f"ne")
                return left != right
            elif "&&" in ctx.getText() is not None:
                self.machineCode.append(f"and")
                return left and right
            elif "||" in ctx.getText() is not None:
                self.machineCode.append(f"or")
                return left or right
            elif "!" in ctx.getText() is not None:
                self.machineCode.append(f"not")
                return not left
        elif ctx.getChildCount() == 1:
            if self.symbolTable.lookup(ctx.getChild(0).getText()) is not None:
                self.machineCode.append(f"load {ctx.getChild(0).getText()}")
                return self.symbolTable.lookup(ctx.getChild(0).getText()).value
            if ctx.INTEGER() is not None:
                self.machineCode.append(f"push i {int(ctx.getChild(0).getText())}")
                return int(ctx.getChild(0).getText())
            elif ctx.FLOAT() is not None:
                self.machineCode.append(f"push f {float(ctx.getChild(0).getText())}")
                return float(ctx.getChild(0).getText())
            elif ctx.BOOLEAN() is not None:
                if ctx.getChild(0).getText() == 'true':
                    self.machineCode.append(f"push B true")
                    return True
                elif ctx.getChild(0).getText() == 'false':
                    self.machineCode.append(f"push B false")
                    return False
            elif ctx.STRING() is not None:
                self.machineCode.append(f"push S {str(ctx.getChild(0).getText())}")
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
    #op
    def checkIntToFloat(self,left,right):
        if left == Type.FLOAT and right == Type.INT:
            self.machineCode.append(f"inttofloat")
            return left
        elif left == Type.INT and right == Type.FLOAT:
            self.machineCode.append(f"inttofloat")
            return right
        else:
            return left