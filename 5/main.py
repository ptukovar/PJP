import sys
from antlr4 import *
from pjpLexer import pjpLexer
from pjpParser import pjpParser
from pjpVisitor import pjpVisitor
from pjpImplVisitor import pjpImplVisitor
from virtualMachine import virtualMachine

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
        file = open("output.txt", "w")
       
        happened = 0
        for i in range(len(vinterp.machineCode)):
            if happened == 1:
                happened = 0
                continue
            if vinterp.machineCode[i] == 'uminus':
                vinterp.machineCode[i] = vinterp.machineCode[i+1]
                vinterp.machineCode[i+1] = 'uminus'
                happened = 1

        for i in range(len(vinterp.machineCode)):
            if vinterp.machineCode[i] == 'pop' and 'load' in vinterp.machineCode[i-1] and 'save' in vinterp.machineCode[i-2] and 'save' in vinterp.machineCode[i+1] and 'load' in vinterp.machineCode[i+2]:
                for j in range(i, len(vinterp.machineCode)-1):
                    vinterp.machineCode[j] = vinterp.machineCode[j+1]
                vinterp.machineCode.pop()
                break
                
                


        for line in vinterp.machineCode:
            file.write(str(line) + '\n')
        virtualMachine(vinterp.machineCode).run(vinterp.machineCode)

if __name__ == '__main__':
    pjp(sys.argv)
    