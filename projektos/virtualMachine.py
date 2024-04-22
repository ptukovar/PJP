class virtualMachine:
    def __init__(self,code):
        self.code = code
    
    def run(self):
        for x in self.code:
            print(f"x: {x}")

        pass
