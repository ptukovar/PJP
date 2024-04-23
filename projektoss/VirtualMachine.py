from typing import Any, SupportsIndex
from SymbolTable import SymbolTable
from SymbolTable import Type


class VirtualMachine: 
    
    
    code = []
    variables = {}
    stack = []

    def splitter(self,lst):
        for i in lst: 
            if 'push' in i:
                if i[5] == 'I':
                    self.code.append(['push',i[5],int(i[7:])])
                elif i[5] == 'F':
                    self.code.append(['push',i[5],float(i[7:])])
                elif i[5] == 'S':
                    self.code.append(['push','S',str(i[7:])])
                elif i[5] == 'B':
                    var = i[7:]
                    if len(var) == 4:
                        self.code.append(['push','B',True])
                    elif len(var) == 5:
                        self.code.append(['push','B',False])
                else:
                    self.code.append(['push','S',str(i[7:])])
                
            elif 'load' in i:
                self.code.append(['load',i[5:]])
            elif 'save' in i:
                self.code.append(['save',i[5:]])
            elif 'label' in i:
                self.code.append(['label',int(i[6:])])
            elif 'fjmp' in i: 
                self.code.append(['fjmp',int(i[5:])])
            elif 'jmp' in i:
                self.code.append(['jmp',int(i[4:])])
            elif 'print' in i:
                self.code.append(['print',int(i[6:])])
            elif 'read' in i:
                self.code.append(['read',i[5:]])
            elif 'gt' in i:
                self.code.append(['gt'])
            elif 'lt' in i:
                self.code.append(['lt'])
            elif 'eq' in i:
                self.code.append(['eq'])
            elif 'not' in i:
                self.code.append(['not'])
            elif 'and' in i:
                self.code.append(['and'])
            elif 'or' in i:
                self.code.append(['or'])
            elif 'add' in i:
                self.code.append(['add'])
            elif 'sub' in i:
                self.code.append(['sub'])
            elif 'mul' in i:
                self.code.append(['mul'])
            elif 'div' in i:
                self.code.append(['div'])
            elif 'mod' in i:
                self.code.append(['mod'])
            elif 'uminus' in i:
                self.code.append(['uminus'])
            elif 'concat' in i:
                self.code.append(['concat'])
            elif 'pop' in i:
                self.code.append(['pop'])
            elif 'itof' in i:
                self.code.append(['itof'])
            else:
                print("Error: Invalid instruction")
                return None
         

    def run(self,lst):
        self.variables = {}
        self.stack = []
        self.code = []

        self.splitter(lst)
        pc = 0
        while pc < len(self.code):
            instr = self.code[pc]
            jump = self.execute(instr)
            if jump is None:
                pc += 1
            else:
                for i in range(len(self.code)):
                    if self.code[i][0] == 'label' and self.code[i][1] == jump:
                        jump = i
                        break
                pc = jump
        print(self.variables)

    def execute(self,instr):
        if instr[0] == 'push':
            self.stack.append(instr[2])
        elif instr[0] == 'load':
            self.stack.append(self.variables[instr[1]])
        elif instr[0] == 'save':
            self.variables[instr[1]] = self.stack.pop()
        elif instr[0] == 'label':
            pass
        elif instr[0] == 'jmp':
            return instr[1]
        elif instr[0] == 'fjmp': 
            if not self.stack.pop():
                return instr[1]
        elif instr[0] == 'lt':
            self.stack.append(self.stack.pop() > self.stack.pop())
        elif instr[0] == 'gt':
            self.stack.append(self.stack.pop() < self.stack.pop())
        elif instr[0] == 'eq':
            self.stack.append(self.stack.pop() == self.stack.pop())
        elif instr[0] == 'not':
            self.stack.append(not self.stack.pop())
        elif instr[0] == 'print':
            lst = []
            for i in range(instr[1]):
                lst.append(self.stack.pop())
            for i in range(len(lst)):
                print(lst[len(lst)-1-i],end=' ')
            print()
        elif instr[0] == 'and':
            self.stack.append(self.stack.pop() and self.stack.pop())
        elif instr[0] == 'or':
            self.stack.append(self.stack.pop() or self.stack.pop())
        elif instr[0] == 'add':
            self.stack.append(self.stack.pop() + self.stack.pop())
        elif instr[0] == 'sub':
            self.stack.append(self.stack.pop() - self.stack.pop())
        elif instr[0] == 'mul':
            self.stack.append(self.stack.pop() * self.stack.pop())
        elif instr[0] == 'div':
            self.stack.append(self.stack.pop() / self.stack.pop())
        elif instr[0] == 'mod':
            self.stack.append(self.stack.pop() % self.stack.pop())
        elif instr[0] == 'uminus':
            self.stack.append(-self.stack.pop())
        elif instr[0] == 'concat':
            self.stack.append(self.stack.pop() + self.stack.pop())
        elif instr[0] == 'read':
            if instr[1] == 'I':
                self.stack.append(int(input("Enter integer:")))
            elif instr[1] == 'F':
                self.stack.append(float(input("Enter float:")))
            elif instr[1] == 'B':
                if input("Enter bool:") == 'true':
                    self.stack.append(True)
                else:
                    self.stack.append(False)
            elif instr[1] == 'S':
                self.stack.append(input("Enter string:"))

        elif instr[0] == 'pop':
            self.stack.pop()
        elif instr[0] == 'itof':
            self.stack.append(float(self.stack.pop()))

