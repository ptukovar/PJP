identifiers = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"}
numbers = {"1","2","3","4","5","6","7","8","9","0"}
operators = {"+","-","*","/","="}
delimiters = {"(",")",";"}
keywords = {"div","mod"}
array = []
filename = input("Zadejte nazev souboru:")
rules = []
class Token:
    def __init__(self, type, value):
        self.type = type
        self.value = value
    def __str__(self):
        return
    
def addRule(rule):
    rules.append(rule)

def expect(arrayofTokens : Token,Tokentype ):
    if arrayofTokens.type == Tokentype:
        arrayofTokens.pop(0)
    else:
        print("Error")
        exit(1)

def E(arrayofTokens: Token):
    addRule(1)
    T(arrayofTokens)
    E1(arrayofTokens)

def T(arrayofTokens: Token):
    addRule(3)
    if(arrayofTokens.value == "+"):
        expect(arrayofTokens,"+")
    
    F(arrayofTokens)
    T1(arrayofTokens)

def E1(arrayofTokens: Token):
    addRule(2)
    if arrayofTokens.value == "+":
        expect(array,"+")
        T(arrayofTokens)
        E1(arrayofTokens)
    elif arrayofTokens.value == "-":
        expect(arrayofTokens.value,"-")
        T(arrayofTokens)
        E1(arrayofTokens)
    elif arrayofTokens.value == " ":
        return
    else:
        print("Error")
        exit(1)

def T1(arrayofTokens: Token):
    addRule(4)
    if arrayofTokens.value == "*":
        expect(arrayofTokens,"*")
        F(arrayofTokens)
        T1(arrayofTokens)
    elif arrayofTokens.value == "/":
        expect(arrayofTokens,"/")
        F(arrayofTokens)
        T1(arrayofTokens)
    elif arrayofTokens.value == " ":
        return
    else:
        print("Error")
        exit(1)

def F(arrayofTokens: Token):
    addRule(5)
    if(arrayofTokens.value == "("):
        expect(arrayofTokens,"(")
        E(arrayofTokens)
        expect(arrayofTokens,")")
    elif(arrayofTokens.value == "ID"):
        expect(arrayofTokens,"ID")
    elif(arrayofTokens.value == "NUM"):
        expect(arrayofTokens,"NUM")
    else:
        print("Error")
        exit(1)

def run(arrayofTokens: Token):
    E(arrayofTokens)
    expect(arrayofTokens,"=")
    E(arrayofTokens)
    expect(arrayofTokens,"SEMICOLON")
    print("Success")

try:
    arrayofTokens = []
    f = open(filename, "r")
    string =  f.read()
    lines = string.splitlines()
    j = 0
    skip = False
    for line in lines:
        temp = ""
        temp2 = ""
        for i in range(len(line)):
            if skip == False:
                if not(temp == "")  and (line[i]=="" or line[i]==" "):
                    print("ID:",temp)
                    array.append("ID:"+temp)
                    arrayofTokens.append(Token("ID",temp))
                    temp = ""
                if not(temp2 == "") and (line[i]=="" or line[i]==" " or line[i] == ")"):
                    print("NUM:",temp2)
                    array.append("NUM:"+temp2)
                    arrayofTokens.append(Token("NUM",temp2))
                    temp2 = ""
                if line[i:i+3] in keywords:
                    print("KEY:",line[i:i+3])
                    array.append("KEY:"+line[i:i+3])
                    arrayofTokens.append(Token("KEY",line[i:i+3]))
                    skip = True
                elif line[i] in identifiers and not(line[i] in numbers):
                    temp += line[i] 
                elif line[i] in identifiers and (line[i] in numbers) and not(temp == ""):
                    temp += line[i] 
                elif line[i] == "/" and line[i+1] == "/":
                    break;    
                elif line[i] in operators:
                    print("OP:",line[i])
                    array.append("OP:"+line[i])
                    arrayofTokens.append(Token("OP",line[i]))
                elif line[i] in numbers:
                    temp2 += line[i]
                elif line[i] in delimiters:
                    if line[i] == ";":
                        print("DEL:","SEMICOLON")
                        array.append("DEL:"+"SEMICOLON")
                        arrayofTokens.append(Token("DEL","SEMICOLON"))
                    elif line[i] == "(":
                        print("DEL:","LPAR")
                        array.append("DEL:"+"LPAR")
                        arrayofTokens.append(Token("DEL","LPAR"))
                    elif line[i] == ")":
                        print("DEL:","RPAR")   
                        array.append("DEL:"+"RPAR")
                        arrayofTokens.append(Token("DEL","RPAR"))
            else:
                j += 1	
                if j == 2:
                    skip = False
                    j = 0

        if not(temp == ""):
            print("ID:",temp)
            array.append("ID:"+temp)
            temp = ""

        if not(temp2 == ""):
            print("NUM:",temp2)
            array.append("NUM:"+temp2)
            temp2 = ""
        print(array)
        run(arrayofTokens)
except EOFError:
    print("Soubor nebyl nalezen")

