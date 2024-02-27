identifiers = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"}
numbers = {"1","2","3","4","5","6","7","8","9","0"}
operators = {"+","-","*","/","="}
delimiters = {"(",")",";"}
keywords = {"div","mod"}
array = []
filename = input("Zadejte nazev souboru:")
try:
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
                    temp = ""
                if not(temp2 == "") and (line[i]=="" or line[i]==" " or line[i] == ")"):
                    print("NUM:",temp2)
                    array.append("NUM:"+temp2)
                    temp2 = ""
                if line[i:i+3] in keywords:
                    print("KEY:",line[i:i+3])
                    array.append("KEY:"+line[i:i+3])
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
                elif line[i] in numbers:
                    temp2 += line[i]
                elif line[i] in delimiters:
                    if line[i] == ";":
                        print("DEL:","SEMICOLON")
                        array.append("DEL:"+"SEMICOLON")
                    elif line[i] == "(":
                        print("DEL:","LPAR")
                        array.append("DEL:"+"LPAR")
                    elif line[i] == ")":
                        print("DEL:","RPAR")   
                        array.append("DEL:"+"RPAR")
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
except EOFError:
    print("Soubor nebyl nalezen")