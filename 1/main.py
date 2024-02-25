def whitespace(string):
    return string.replace(" ", "")

count = input("Zadejte pocet prikladu:")
for i in range(int(count)):
    string = input("Zadejte priklad:")
    print(whitespace(string))
