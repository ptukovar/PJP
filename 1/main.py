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
        

count = input("Zadejte pocet prikladu:")
for i in range(int(count)):
    string = input("Zadejte priklad:")
    if not(checkpar(string)):
        print("ERROR")
    else:
        print("OK")
