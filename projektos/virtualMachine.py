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
        }

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
        for stack in self.stack:
            file.write(str(stack) + "\n")
            print(stack)

    def push(self, type, value):
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
        #print(f"Output ({type}): {value}")

