grammar pjp;

prog: (statement)+ EOF;

variables: VARIABLE;

statement: SEMICOLON
    | assignmentTypeStatement
    | expression SEMICOLON
    | readStatement
    | writeStatement
    | block
    | ifStatement
    | whileStatement
    | forStatement
    | assignmentStatement
    ;

assignmentTypeStatement: TYPE variables (ASSIGN expression)? (COMMA variables (ASSIGN expression)?)* SEMICOLON | TYPE variables ASSIGN (PLUS | MINUS | TIMES | DIVIDE | MOD) expression SEMICOLON;
assignmentStatement: variables (ASSIGN variables)* ASSIGN expression SEMICOLON | variables ASSIGN (PLUS | MINUS | TIMES | DIVIDE | MOD) expression SEMICOLON;
readStatement: READ variables (COMMA variables)* SEMICOLON;
writeStatement: WRITE expression (COMMA expression)* SEMICOLON;
block: LBRACE statement* RBRACE;
ifStatement: IF LPAREN expression RPAREN statement (ELSE statement)?;
whileStatement: WHILE LPAREN expression RPAREN statement;
forStatement: FOR LPAREN expression SEMICOLON expression SEMICOLON expression RPAREN statement;

expression: MINUS expression
    | ((TYPE)+ expression ASSIGN)+ expression expression | expression '?' expression ':' expression
    | STRING DOT STRING
    | INTEGER
    | FLOAT
    | STRING
    | BOOLEAN
    | variables
    | LPAREN expression RPAREN
    | expression PLUS expression
    | expression MINUS expression
    | expression TIMES expression
    | expression DIVIDE expression
    | expression MOD expression
    | expression EQ expression
    | expression NEQ expression
    | expression LT expression
    | expression LEQ expression
    | expression GT expression
    | expression GEQ expression
    | expression AND expression
    | expression OR expression 
    | NOT expression
    ;

literals: INTEGER | FLOAT | STRING | BOOLEAN;
DOT: '.';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDE: '/';
MOD: '%';

AND: '&&';
OR: '||';
EQ: '==';
NEQ: '!=';
LT: '<';
LEQ: '<=';
GT: '>';
GEQ: '>=';
NOT: '!';

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
ASSIGN: '=';

IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
READ: 'read';
WRITE: 'write';
INCREMENT: '++';
DECREMENT: '--';
SEMICOLON: ';';
COMMA: ',';
TYPE: 'int' | 'float' | 'string' | 'bool';

INTEGER: [0-9]+;
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' ~'"'* '"';
BOOLEAN: 'true' | 'false';

WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT_LINE: '/*' .*? '*/' -> skip;

VARIABLE: [a-zA-Z_]+;