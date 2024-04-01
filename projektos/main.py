import sys
from antlr4 import *
from mainLexer import mainLexer
from mainParser import mainParser
from mainVisitor import mainVisitor

def main(argv):
    input_stream = FileStream(argv[1])
    lexer = mainLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = mainParser(stream)
    tree = parser.prog()

    if parser.getNumberOfSyntaxErrors() > 0:
        print("syntax errors")
    else:
        vinterp = mainVisitor()
        vinterp.visit(tree)

if __name__ == '__main__':
    main(sys.argv)