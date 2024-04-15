import sys
from antlr4 import *
from pjpLexer import pjpLexer
from pjpParser import pjpParser
from pjpVisitor import pjpVisitor
from pjpImplVisitor import pjpImplVisitor

#na priste: unifikace int na float
#visitor je obecnejsi
#enum na type int, float, error nebo flag na to, ze je to error a pak vracet None
#udelat tabulku symbolu, treba viceurovnovy slovnik, vlozeni a vyber, kontrola zda uz je tam
#v typove kontrola vypsat chyby, jet postupne, ne vsechny najednou, radek a sloupec
#Token vracet s radkem a sloupcem, adresovat na symbol
#vzit tabulku symbolu a upravit
#je to na webu


#pridat ternarni operator if

#vylepsit gramatiku

def pjp(argv):
    input_stream = FileStream(argv[1])
    lexer = pjpLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = pjpParser(stream)
    tree = parser.prog()

    if parser.getNumberOfSyntaxErrors() > 0:
        print("syntax errors")
    else:
        vinterp = pjpImplVisitor()
        vinterp.visit(tree)

if __name__ == '__main__':
    pjp(sys.argv)
    