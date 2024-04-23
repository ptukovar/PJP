# Generated from ../pjp.g4 by ANTLR 4.13.0
from antlr4 import *
from enum import Enum
from pjpParser import pjpParser
from pjpVisitor import pjpVisitor
from virtualMachine import virtualMachine

if "." in __name__:
    from .pjpParser import pjpParser
else:
    from pjpParser import pjpParser

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
            print("Error: variable "+name+" already declared")
        else:
            if type == 'int':
                self.table[name] = (name,Type.INT,int(value))
            if type == 'float':
                self.table[name] = (name,Type.FLOAT,float(value))
            if type == 'string':
                if value[0] == '"':
                    value = str(value)[1:]
                    value = str(value)[:len(value)-1]
                self.table[name] = (name,Type.STRING,str(value))
            if type == 'bool':
                self.table[name] = (name,Type.BOOL,bool(value))
            
    
    def getSymbol(self, name):
        if name in self.table:
            return self.table[name]
        else:
            print("Error: variable "+name+" not declared")
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
        self.machineCode = virtualMachine()
        label_counter = 0
        jmp_counter = 0
        inside = 0

    # Visit a parse tree produced by pjpParser#prog.
    def visitProg(self, ctx:pjpParser.ProgContext):
        for child in ctx.getChildren():
            self.visit(child)
        self.checkAll
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#type.
    #def visitType(self, ctx:pjpParser.TypeContext):
    #    return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#var.
    def visitVar(self, ctx:pjpParser.VarContext):
        if ctx.getChild(0).getText() == 'true':
            self.machineCode.append('push B true')
            return True
        elif ctx.getChild(0).getText() == 'false':
            self.machineCode.append('push B false')
            return False
        self.machineCode.append(f"load {ctx.VARIABLE().getText()}")
        return self.symbolTable
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
        return None


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
        left = self.visit(ctx.expr(0))
        right = self.visit(ctx.expr(1))
        self.machineCode.append('or')
        return left or right


    # Visit a parse tree produced by pjpParser#muldivmod.
    def visitMuldivmod(self, ctx:pjpParser.MuldivmodContext):
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


    # Visit a parse tree produced by pjpParser#literal.
    def visitLiteral(self, ctx:pjpParser.LiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#not.
    def visitNot(self, ctx:pjpParser.NotContext):
        variable = not self.visit(ctx.expr())
        self.machineCode.append('not')
        return variable


    # Visit a parse tree produced by pjpParser#paren.
    def visitParen(self, ctx:pjpParser.ParenContext):
        return self.visit(ctx.expr())


    # Visit a parse tree produced by pjpParser#and.
    def visitAnd(self, ctx:pjpParser.AndContext):
        left = self.visit(ctx.expr(0))
        right = self.visit(ctx.expr(1))
        self.machineCode.append('and')
        return left and right


    # Visit a parse tree produced by pjpParser#variable.
    def visitVariable(self, ctx:pjpParser.VariableContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#ternary.
    def visitTernary(self, ctx:pjpParser.TernaryContext):
        self.visit(ctx.expr(0))
        self.machineCode.append('jmpf'+str(self.jmpcounter))
        return self.visitChildren(ctx)


    # Visit a parse tree produced by pjpParser#assign.
    def visitAssign(self, ctx:pjpParser.AssignContext):
        return self.visitChildren(ctx)

    def inttofloat(self, value):
        if isinstance(value, int):
            return float(value)
        return value
    
    def lookup(self, name):
        if name in self.symbolTable:
            return self.symbolTable[name]
        return None
        


del pjpParser