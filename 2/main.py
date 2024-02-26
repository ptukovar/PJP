identifiers = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"}
numbers = {"1","2","3","4","5","6","7","8","9","0"}
operators = {"+","-","*","/","="}
delimiters = {"(",")",";"}
keywords = {"div","mod"}

string = input("Zadejte kod:")
temp = ""
temp2 = ""
for char in string:
    if not(temp == "")  and (char=="" or char==" "):
        print("ID:",temp)
        temp = ""
    if not(temp2 == "")  and (char=="" or char==" "):
        print("NUM:",temp2)
        temp2 = ""

    if char in identifiers and not(char in numbers):
        temp += char 
    elif char in identifiers and (char in numbers) and not(temp == ""):
        temp += char 
    elif char in operators:
        print("OP:",char)
    elif char in numbers:
        temp2 += char
    elif char in delimiters:
        if char == ";":
            print("DEL:","SEMICOLON")
        else:
            print("DEL:",char)

if not(temp == ""):
    print("ID:",temp)
    temp = ""

if not(temp2 == ""):
    print("NUM:",temp2)
    temp2 = ""