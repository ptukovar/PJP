grammar pjp;

prog: (statement)+ EOF;

type: 'int' | 'float' | 'string' | 'bool';              

variables: VARIABLE                                                                         #var
        ;

literals: INTEGER                                                                           #int
        | FLOAT                                                                             #float
        | STRING                                                                            #string
        | BOOLEAN                                                                           #bool
        ;

statement: SEMICOLON                                                                        #empty
        | type variables (COMMA variables)* SEMICOLON                                       #declaration                             
        | expression SEMICOLON                                                              #expr                              
        | READ variables (COMMA variables)* SEMICOLON                                       #read      
        | WRITE expression (COMMA expression)* SEMICOLON                                    #write  
        | LBRACE statement* RBRACE                                                          #block                                        
        | IF LPAREN expression RPAREN statement (ELSE statement)?                           #if                     
        | WHILE LPAREN expression RPAREN statement                                          #while                               
        | FOR LPAREN expression SEMICOLON expression SEMICOLON expression RPAREN statement  #for                                    
        ;

expression: literals                                                                        #literal
        | variables                                                                         #variable
        | expression AND expression                                                         #and
        | expression OR expression                                                          #or
        | expression op=(EQ | NEQ ) expression                                              #eqneq
        | expression op=(LT | GT) expression                                                #ltgt
        | expression op=(TIMES | DIVIDE | MOD) expression                                   #muldivmod
        | expression op=(PLUS | MINUS) expression                                           #addsub
        | variables EQ expression                                                           #assign
        | NOT expression                                                                    #not
        | LPAREN expression RPAREN                                                          #paren
        | MINUS expression                                                                  #minus
        | expression QUESTION expression DOUBLEDOT expression                               #ternary
        ;


EQ: '=';
NEQ: '!=';
LT: '<';
GT: '>';
MOD: '%';
TIMES: '*';
DIVIDE: '/';
PLUS: '+';
MINUS: '-';
QUESTION: '?';
DOUBLEDOT: ':';
AND: '&&';
OR: '||';
NOT: '!';

SEMICOLON: ';';
COMMA: ',';
READ: 'read';
WRITE: 'write';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';

VARIABLE: [a-zA-Z] [a-zA-Z0-9]*;
INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' ~'"'* '"';
BOOLEAN: 'true' | 'false';
WS: [ \t\n\r]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;