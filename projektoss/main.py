import sys
from antlr4 import *
from ExprLexer import ExprLexer
from ExprParser import ExprParser
from VisitorInterp import VisitorInterp
from VirtualMachine import VirtualMachine

def main(argv):
    input_stream = FileStream(sys.argv[1])
    lexer = ExprLexer(input_stream)
    token_stream = CommonTokenStream(lexer)
    parser = ExprParser(token_stream)
    tree = parser.prog()
    
    if parser.getNumberOfSyntaxErrors() > 0:
        print("Number of syntax errors: ", parser.getNumberOfSyntaxErrors())
    else:
        visitor = VisitorInterp()
        code = visitor.visit(tree)
        file = open("output.txt", "w")
       
        inside = 0
        for i in range(len(code)):
            if inside == 1:
                inside = 0
                continue
            if code[i] == 'uminus':
                code[i] = code[i+1]
                code[i+1] = 'uminus'
                inside = 1

        for i in range(len(code)):
            if code[i] == 'pop' and 'load' in code[i-1] and 'save' in code[i-2] and 'save' in code[i+1] and 'load' in code[i+2]:
                for j in range(i, len(code)-1):
                    code[j] = code[j+1]
                code.pop()
                break

        for line in code:
            file.write(str(line) + '\n')

        virtual = VirtualMachine()
        virtual.run(code)


if __name__ == '__main__':
    main(sys.argv)