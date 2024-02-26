import re
def whitespace(string):
    return string.replace(" ", "")

def checkpar(string):
    temp = re.sub(r'[^\(\){}\[\]]', '', string)
    stack = []
    for char in temp:
        if char in ["(", "{", "["]:
            stack.append(char)
        else:
            if not stack:
                return False
            current_char = stack.pop()
            if current_char == '(':
                if char != ")":
                    return False
            if current_char == '{':
                if char != "}":
                    return False
            if current_char == '[':
                if char != "]":
                    return False
    if stack:
        return False
    return True

def checkchars(string):
    allowed = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","(",")","{","}","[","]"}
    for char in string:
        if char not in allowed:
            return False
    return True

def evaluate(string):
    result = 0
    
    return result

count = input("Zadejte pocet prikladu:")
for i in range(int(count)):
    string = input("Zadejte priklad:")
    string = whitespace(string)   
    if not(checkpar(string)):
        print("ERROR")
    elif not(checkchars(string)):
        print("ERROR")
    else:
        print(evaluate(string))
    