# Generated from ../pjp.g4 by ANTLR 4.13.0
from antlr4 import *
from enum import Enum
from pjpParser import pjpParser
from virtualMachine import virtualMachine

class Type(Enum):
    INT = 1
    FLOAT = 2
    STRING = 3
    BOOL = 4
    ERROR = 5 

# This class defines a complete generic visitor for a parse tree produced by pjpParser.
class symbolTable:
    def __init__(self):
        self.table = {}
    
    def insertEmpty(self, name, type):
        if name in self.table:
            print(f"Error: variable {name} is already declared")
        else:
            if type == 'int':
                self.table[name] = (name, Type.INT, 0)
            if type == 'float':
                self.table[name] = (name, Type.FLOAT, 0.0)
            if type == 'string':
                self.table[name] = (name, Type.STRING, "")
            if type == 'bool':
                self.table[name] = (name, Type.BOOL, True)
                
    def insertValue(self, name, type,value):
        if name in self.table:
            print(f"Error: variable {name} is already declared")
        else:
            if type == 'int':
                self.table[name] = (name, Type.INT, int(value))
            if type == 'float':
                self.table[name] = (name, Type.FLOAT, float(value))
            if type == 'string':
                if value[0] == '"':
                    value = str(value)[1:]
                    value = str(value)[:len(value)-1]
                self.table[name] = (name, Type.STRING, str(value))
            if type == 'bool':
                self.table[name] = (name, Type.BOOL, bool(value))
            
    
    def getSymbol(self, name):
        if name in self.table:
            return self.table[name]
        else:
            print(f"Error: variable {name} is not declared")
            return (Type.ERROR, 0)
    
    def setSymbol(self, name, value):
        if name in self.table:
            if self.table[name][1] == Type.STRING:
                if value[0] == '"':
                    value = str(value)[1:]
                    value = str(value)[:len(value)-1]
            self.table[name] = (name, self.table[name][1], value)

        else:
            print(f"Error: variable {name} is not declared")


class pjpImplVisitor(ParseTreeVisitor):
    def __init__(self):
        self.symbolTable = symbolTable()
        self.machineCode = []
        self.jmpcounter = 0
        self.labelcounter = 0

    # Visit a parse tree produced by pjpParser#prog.
    def visitProg(self, ctx:pjpParser.ProgContext):
        for child in ctx.getChildren():
            self.visit(child)
        return self.machineCode


    # Visit a parse tree produced by pjpParser#type.
    def visitType(self, ctx:pjpParser.TypeContext):
        return #self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#Id.
    def visitId(self, ctx:pjpParser.IdContext):
        self.machineCode.append(f"push I {ctx.ID().getText()}")
        return self.symbolTable.getSymbol(ctx.ID().getText())[0]


    # Visit a parse tree produced by pjpParser#int.
    def visitInt(self, ctx:pjpParser.IntContext):
        self.machineCode.append(f"push I {ctx.INTEGER().getText()}")
        return int(ctx.INTEGER().getText())


    # Visit a parse tree produced by pjpParser#float.
    def visitFloat(self, ctx:pjpParser.FloatContext):
        self.machineCode.append(f"push F {ctx.FLOAT().getText()}")
        return float(ctx.FLOAT().getText())


    # Visit a parse tree produced by pjpParser#string.
    def visitString(self, ctx:pjpParser.StringContext):
        self.machineCode.append(f"push S {ctx.STRING().getText()}")
        if str(ctx.STRING().getText())[0] == '"':
            return str(ctx.STRING().getText())[1:]
        return " "


    # Visit a parse tree produced by pjpParser#bool.
    def visitBool(self, ctx:pjpParser.BoolContext):
        self.machineCode.append(f"push B {ctx.BOOL().getText()}")
        return ctx.BOOLEAN().getText() == 'true'


    # Visit a parse tree produced by pjpParser#empty.
    def visitEmpty(self, ctx:pjpParser.EmptyContext):
        return None


    # Visit a parse tree produced by pjpParser#declaration.
    def visitDeclaration(self, ctx:pjpParser.DeclarationContext):
        variabletype = ctx.getChild(0).getText()
        for i in range(1, ctx.getChildCount()-1):
            if ctx.getChild(i).getText() == ',':
                continue
            if variabletype == 'int':
                self.machineCode.append(f"push I 0")
            elif variabletype == 'float':
                self.machineCode.append(f"push F 0.0")
            elif variabletype == 'string':
                self.machineCode.append(f"push S ")
            elif variabletype == 'bool':
                self.machineCode.append(f"push B false")
            self.machineCode.append(f"save {ctx.getChild(i).getText()}")
            self.symbolTable.insertEmpty(ctx.getChild(i).getText(), variabletype)
        return


    # Visit a parse tree produced by pjpParser#expr.
    def visitExpr(self, ctx:pjpParser.ExprContext):
        return


    # Visit a parse tree produced by pjpParser#read.
    def visitRead(self, ctx:pjpParser.ReadContext):
        for i in range(1, ctx.getChildCount()-1):
            if ctx.getChild(i).getText() == ',':
                continue
            value = input("Enter value: ")
            variabletype = self.symbolTable.getSymbol(ctx.getChild(i).getText())[1]
            if variabletype == Type.INT:
                self.machineCode.append(f"read I")
                value = int(value)
            elif variabletype == Type.FLOAT:
                self.machineCode.append(f"read F")
                value = float(value)
            elif variabletype == Type.BOOL:
                self.machineCode.append(f"read B")
                value = value == 'true'
            else:
                self.machineCode.append(f"read S")
            self.machineCode.append(f"save {ctx.getChild(i).getText()}")
            self.symbolTable.setSymbol(ctx.getChild(i).getText(), value)
        return


    # Visit a parse tree produced by pjpParser#write.
    def visitWrite(self, ctx:pjpParser.WriteContext):
        writecount = 0
        for i in range(1, ctx.getChildCount()-1):
            if ctx.getChild(i).getText() == ',':
                continue
            writecount = writecount + 1
            print(self.visit(ctx.getChild(i)), end=' ')
        self.machineCode.append(f"print {writecount}")
        print()
        return None


    # Visit a parse tree produced by pjpParser#block.
    def visitBlock(self, ctx:pjpParser.BlockContext):
        for i in range(1, ctx.getChildCount()-1):
            self.visit(ctx.getChild(i))
        return


    # Visit a parse tree produced by pjpParser#if.
    def visitIf(self, ctx:pjpParser.IfContext):
        self.visit(ctx.expression())
        self.machineCode.append(f"fjmp {self.labelcounter}")
        self.visit(ctx.statement(0))
        self.machineCode.append(f"jmp {self.labelcounter+1}")
        self.machineCode.append(f"label {self.labelcounter}")
        self.labelcounter += 1

        if ctx.statement(1) != None:
            self.visit(ctx.statement(1))
            self.machineCode.append(f"label {self.labelcounter}")
            self.labelcounter += 1
        else:
            self.machineCode.append(f"label {self.labelcounter}")
            self.labelcounter += 1
        return


    # Visit a parse tree produced by pjpParser#while.
    def visitWhile(self, ctx:pjpParser.WhileContext):
        self.machineCode.append(f"label {self.labelcounter}")
        self.visit(ctx.expression())
        self.machineCode.append(f"fjmp {self.labelcounter+1}")
        self.visit(ctx.statement())
        self.machineCode.append(f"jmp {self.labelcounter}")
        self.machineCode.append(f"label {self.labelcounter+1}")
        self.labelcounter += 2
        return None


    # Visit a parse tree produced by pjpParser#for.
    def visitFor(self, ctx:pjpParser.ForContext):
        self.visit(ctx.expression(0))
        self.machineCode.append(f"label {self.labelcounter}")
        self.visit(ctx.expression(1))
        self.machineCode.append(f"fjmp {self.labelcounter+1}")
        self.visit(ctx.statement())
        self.visit(ctx.expression(2))
        self.machineCode.append(f"jmp {self.labelcounter}")
        self.machineCode.append(f"label {self.labelcounter+1}")
        self.labelcounter += 2
        return #ZIDANE


    # Visit a parse tree produced by pjpParser#minus.
    def visitMinus(self, ctx:pjpParser.MinusContext):
        return


    # Visit a parse tree produced by pjpParser#or.
    def visitOr(self, ctx:pjpParser.OrContext):
        left = self.visit(ctx.expression(0))
        right = self.visit(ctx.expression(1))
        self.machineCode.append('or')
        return left or right


    # Visit a parse tree produced by pjpParser#muldivmod.
    def visitMuldivmod(self, ctx:pjpParser.MuldivmodContext):
        left = self.visit(ctx.expression(0))
        if type(left) == int and ctx.expression(1).getText().__contains__('.'):
            self.machineCode.append('inttofloat')
        right = self.visit(ctx.expression(1))
        if type(right) == int and ctx.expression(1).getText().__contains__('.'):
            self.machineCode.append('inttofloat')
        if ctx.op.type == pjpParser.MUL:
            self.machineCode.append('mul')
            if type(left) == float or type(right) == float:
                return self.inttofloat(left) * self.inttofloat(right)
            return left * right
        if ctx.op.type == pjpParser.DIV:
            self.machineCode.append('div')
            if type(left) == float or type(right) == float:
                return self.inttofloat(left) / self.inttofloat(right)
            return left / right
        if type(left) == float or type(right) == float:
            print(f"Error: Modulo operation is not allowed with float")
            return ''
        self.machineCode.append('mod')
        return left % right


    # Visit a parse tree produced by pjpParser#ltgt.
    def visitLtgt(self, ctx:pjpParser.LtgtContext):
        left = self.visit(ctx.expression(0))
        if type(left) == int and ctx.expression(1).getText().__contains__('.'):
            self.machineCode.append('inttofloat')
        right = self.visit(ctx.expression(1))
        if ctx.op.type == 7:
            self.machineCode.append('lt')
            #print(f"DEBUG: {self.inttofloat(left)} {ctx.op.type} {self.inttofloat(right)}")
            return self.inttofloat(left) < self.inttofloat(right)
        self.machineCode.append('gt')
        return self.inttofloat(left) > self.inttofloat(right)


    # Visit a parse tree produced by pjpParser#addsub.
    def visitAddsub(self, ctx:pjpParser.AddsubContext):
        left = self.visit(ctx.expression(0))
        if type(left) == int and ctx.expression(1).getText().__contains__('.'):
            self.machineCode.append('inttofloat')
        right = self.visit(ctx.expression(1))
        if type(right) == int and ctx.expression(0).getText().__contains__('.'):
            self.machineCode.append('inttofloat')
        if ctx.op.type == 12:
            self.machineCode.append('add')
            if type(left) == str or type(right) == str:
                print(f"Error: String concatenation with number is not allowed")
                return ''
            if type(left) == float or type(right) == float:
                return self.inttofloat(left) + self.inttofloat(right)
            return left + right
        if type(left) == str and type(right) == str:
            self.machineCode.append('concat')
            return str(left) + str(right)
        if type(left) == str or type(right) == str:
            print(f"Error: String concatenation with number is not allowed")
            return ''
        self.machineCode.append('sub')
        if type(left) == float or type(right) == float:
            return self.inttofloat(left) - self.inttofloat(right)
        return left - right


    # Visit a parse tree produced by pjpParser#eqneq.
    def visitEqneq(self, ctx:pjpParser.EqneqContext):
        left = self.visit(ctx.expression(0))
        right = self.visit(ctx.expression(1))
        if ctx.op.type == pjpParser.EQ:
            self.machineCode.append('eq')
            return left == right
        self.machineCode.append('eq')
        self.machineCode.append('not')
        return left != right


    # Visit a parse tree produced by pjpParser#literal.
    def visitLit(self, ctx:pjpParser.LiteralsContext):
        return self.visit(ctx.getChild(0))


    # Visit a parse tree produced by pjpParser#not.
    def visitNot(self, ctx:pjpParser.NotContext):
        variable = not self.visit(ctx.expression())
        self.machineCode.append('not')
        return variable


    # Visit a parse tree produced by pjpParser#paren.
    def visitParen(self, ctx:pjpParser.ParenContext):
        return self.visit(ctx.expression())


    # Visit a parse tree produced by pjpParser#and.
    def visitAnd(self, ctx:pjpParser.AndContext):
        left = self.visit(ctx.expression(0))
        right = self.visit(ctx.expression(1))
        self.machineCode.append('and')
        return left and right


    def visitVar(self, ctx:pjpParser.VarContext):
        if ctx.getChild(0).getText() == 'true':
            self.machineCode.append(f"push B true")
            return True
        if ctx.getChild(0).getText() == 'false':
            self.machineCode.append(f"push B false")
            return False
        self.machineCode.append(f"load {ctx.getChild(0).getText()}")
        return self.symbolTable.getSymbol(ctx.getChild(0).getText())[2]


    # Visit a parse tree produced by pjpParser#ternary.
    def visitTernary(self, ctx:pjpParser.TernaryContext):
        self.visit(ctx.expression(0))
        self.machineCode.append(f"fjmp {self.jmpcounter}")
        self.visit(ctx.expression(1))
        self.machineCode.append(f"jmp {self.jmpcounter+1}")
        self.machineCode.append(f"label {self.jmpcounter}")
        self.visit(ctx.expression(2))
        self.machineCode.append(f"label {self.jmpcounter+1}")
        self.jmpcounter += 2
        return None


    # Visit a parse tree produced by pjpParser#assign.
    def visitAssign(self, ctx:pjpParser.AssignContext):
        value = self.visit(ctx.expression())
        if self.symbolTable.getSymbol(ctx.variables().getText())[1] == Type.INT and type(value) == float:
            print(f"Error: Cannot assign float to int")
            return None
        if self.symbolTable.getSymbol(ctx.variables().getText())[1] == Type.FLOAT and type(value) == int:
            self.machineCode.append('inttofloat')
            self.symbolTable.setSymbol(ctx.variables().getText(), self.inttofloat(value))
        else:
            self.symbolTable.setSymbol(ctx.variables().getText(), value)
        self.machineCode.append(f"save {ctx.variables().getText()}")
        self.machineCode.append(f"load {ctx.variables().getText()}")
        if ctx.expression().getText().count('=') > 1:
            self.machineCode.append(f"pop")
        if ctx.expression().getText().count('=') == 0:
            self.machineCode.append(f"pop")
        return value

    def inttofloat(self, value):
        if type(value) == int:
            return float(value)
        return value
        


del pjpParser