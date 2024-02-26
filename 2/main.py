identifiers = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"}
numbers = {"1","2","3","4","5","6","7","8","9","0"}
operators = {"+","-","*","/","="}
delimiters = {"(",")",";"}
keywords = {"div","mod"}

string = input("Zadejte kod:")
temp = ""
for char in string:
    if not(temp == "")  and (char=="" or char==" "):
        print("ID:",temp)
        temp = ""

    if char in identifiers and not(char in numbers):
        temp += char 
    elif char in identifiers and (char in numbers) and not(temp == ""):
        temp += char 
    elif char in operators:
        print("OP:",char)
    elif char in numbers:
        print("NUM:",char)
    elif char in delimiters:
        print("DEL:",char)

if not(temp == ""):
    print("ID:",temp)
    temp = ""