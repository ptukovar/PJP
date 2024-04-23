class virtualMachine:
    def __init__(self, code):
        self.code = code
        self.stack = []
        self.variables = {}

    def debug_state(self, message=""):
        print(f"{message}\nCurrent Stack: {self.stack}")
        print(f"Current Variables: {self.variables}\n")

    def run(self):
        operations = {
            'PUSH': self.push,
            'SAVE': self.save,
            'LOAD': self.load,
            'ADD': self.add,
            'SUB': self.sub,
            'MUL': self.mul,
            'DIV': self.div,
            'MOD': self.mod,
            'PRINT': self.print,
            'lt': self.ltt,
            'lte': self.ltet,
            'gt': self.gtt,
            'gte': self.gtet,
            'eq': self.eqt,
            'neq': self.neqt,
            'and': self.andt,
            'or': self.ort,
            'not': self.nott,
            'fjmp': self.fjmpt,
            'jmp': self.jmpt,
            'label': self.label,

        }
        file = open("YYY.txt", "w")
        for line in self.code:
            file.write(line + "\n")

        for line in self.code:
            parts = line.strip().split()
            if not parts:
                continue
            instr = parts[0].upper()
            args = parts[1:]
            if instr in operations:
                #self.debug_state(f"Before {instr} {args}")
                operations[instr](*args)
                #self.debug_state(f"After {instr} {args}")
        
        file = open("XXX.txt", "a")
       #for stack in self.stack:
        #    file.write(str(stack) + "\n")
        #    print(stack)

    def push(self, type, *values):
        if type == 'S':
            value = ' '.join(values)
            self.stack.append(value)
        elif type == 'B':
            value = values[0].lower()
            if value == 'true':
                self.stack.append(True)
            elif value == 'false':
                self.stack.append(False)
            else:
                raise Exception(f"Invalid boolean value {value}")
        else:
            for value in values:
                self.stack.append(float(value) if type == 'f' else int(value))

    def save(self, type, var_name):
        if not self.stack:
            raise Exception("Attempt to save but stack is empty")
        value = self.stack.pop()
        self.variables[var_name] = value

    def load(self, var_name):
        if var_name not in self.variables:
            raise Exception(f"Variable {var_name} not defined")
        self.stack.append(self.variables[var_name])

    def add(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform add")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a + b)

    def sub(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform sub")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a - b)

    def mul(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform mul")
        b = self.stack.pop()
        a = self.stack.pop()
        if self.variables[a] != int(self.variables[a]):
            a = self.variables[a]
        if self.variables[b] != int(self.variables[b]):
            b = self.variables[b]
        self.stack.append(a * b)
    
    def div(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform div")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a / b)

    def mod(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform mod")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a % b)

    def print(self, type):
        if not self.stack:
            raise Exception("Attempt to print but stack is empty")
        value = self.stack[-1]
        print(f"{value}")

    def ltt(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform lt")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a < b)

    def ltet(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform lte")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a <= b)
    
    def gtt(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform gt")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a > b)
    
    def gtet(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform gte")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a >= b)
    
    def eqt(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform eq")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a == b)
    
    def neqt(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform neq")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a != b)
    
    def andt(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform and")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a and b)
    
    def ort(self):
        if len(self.stack) < 2:
            raise Exception("Not enough elements on the stack to perform or")
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a or b)

    def nott(self):
        if not self.stack:
            raise Exception("Attempt to print but stack is empty")
        value = self.stack[-1]
        self.stack.append(not value)

    def fjmpt(self, label):
        if not self.stack:
            raise Exception("Attempt to jump but stack is empty")
        if not self.stack.pop():
            self.jmpt(label)
        
    def jmpt(self, label):
        for i, line in enumerate(self.code):
            if line.strip() == f"label {label}":
                break
            else:
                raise Exception(f"Label {label} not found")
        self.code = self.code[i:]
    
    def label(self, label):
        pass
