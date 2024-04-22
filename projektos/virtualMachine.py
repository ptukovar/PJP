class virtualMachine:
    def __init__(self,code):
        self.code = code
        self.stack = []
        self.variables = {}
    
    def run(self):
        file = open("output.txt","w")
        for x in self.code:
            file.write(f"{x}\n")

        try:
            self.code = open("test.txt","r").readlines()
        except FileNotFoundError:
            print("Soubor 'test.txt' nebyl nalezen.")

        operations = {
            'PUSH': self.push,
            'SAVE': self.save,
            'LOAD': self.load,
            'ADD': self.add,
            'MOD': self.mod,
            'PRINT': self.print,
        }
        
        for line in self.code:
            parts = line.strip().split()
            if not parts:
                continue
            instr = parts[0]
            args = parts[1:]
            if instr in operations:
                operations[instr](*args)
        
        with open("XXX.txt", "w") as file:
            while self.stack:
                value = self.stack.pop(0)  
                file.write(f"{value}\n")

    def push(self, type, value):
        if type == 'I':
            self.stack.append(int(value))
        elif type == 'F':
            self.stack.append(float(value))
    
    def save(self, var_name):
        value = self.stack.pop()
        self.variables[var_name] = value
    
    def load(self, var_name):
        value = self.variables.get(var_name, 0)
        self.stack.append(value)
    
    def add(self):
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a + b)
    
    def mod(self):
        b = self.stack.pop()
        a = self.stack.pop()
        self.stack.append(a % b)
    
    def print(self, type=None):
        value = self.stack.pop()
        if type == 'I':
            value = int(value)
        elif type == 'F':
            value = float(value)
        print(value)
        self.stack.append(value) 
