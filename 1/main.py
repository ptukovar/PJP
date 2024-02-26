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

def copypart(string, start, length):
    return string[start:start+length]

def calculate(expression):
    numbers = [int(num) for num in re.findall(r'\d+', expression)]
    operators = re.findall(r'[\+\-\*/]', expression)
    result = numbers[0]
    
    for i, operator in enumerate(operators):
        if operator == '+':
            result += numbers[i + 1]
        elif operator == '-':
            result -= numbers[i + 1]
        elif operator == '*':
            result *= numbers[i + 1]
        elif operator == '/':
            if numbers[i + 1] == 0:
                raise ValueError("Division by zero!")
            result /= numbers[i + 1]
    
    return result

def evaluate(string):
    result = 0

    while "(" in string:
        s = string.find("(")
        inside = copypart(string, s+1, string.find(")")-s-1)
        temp = calculate(inside)
        print("inside: ", inside, "temp: ",temp)
        string =string.replace(string[s:string.find(")")+1], str(temp))
        print("string: ",string)

    result = calculate(string)
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
    