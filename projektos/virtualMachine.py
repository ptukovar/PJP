class virtualMachine:
    def __init__(self,code):
        self.code = code
    
    def run(self):
        file = open("output.txt","w")
        for x in self.code:
            file.write(f"{x}\n")
        for x in self.code:
            print(f"{x}")

        pass
