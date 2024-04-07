grammar pjp;

prog: statement+ EOF;

literals: INTEGER | FLOAT | STRING | BOOLEAN;

variables: VARIABLE;

statement: SEMICOLON
    | TYPE variables (COMMA variables)* SEMICOLON
    | expression SEMICOLON
    | readStatement
    | writeStatement
    | block
    | ifStatement
    | whileStatement
    | forStatement
    ;

readStatement: READ variables (COMMA variables)* SEMICOLON;
writeStatement: WRITE expression (COMMA expression)* SEMICOLON;
block: LBRACE statement* RBRACE;
ifStatement: IF LPAREN condition RPAREN statement (ELSE statement)?;
whileStatement: WHILE LPAREN condition RPAREN statement;
forStatement: FOR LPAREN expression SEMICOLON condition SEMICOLON expression RPAREN statement;

expression: INTEGER
    | FLOAT
    | STRING
    | BOOLEAN
    | variables
    | expression PLUS expression
    | expression MINUS expression
    | expression TIMES expression
    | expression DIVIDE expression
    | expression MOD expression
    ;

condition: expression EQ expression
    | expression NEQ expression
    | expression LT expression
    | expression LEQ expression
    | expression GT expression
    | expression GEQ expression
    | expression AND expression
    | expression OR expression
    | NOT condition
    ;

SEMICOLON: ';';
COMMA: ',';
TYPE: 'int' | 'float' | 'string' | 'bool';
VARIABLE: [a-zA-Z_][a-zA-Z0-9_]*;

INTEGER: [0-9]+;
FLOAT: [0-9]+'.'[0-9]+;
STRING: '"' ~'"'* '"';
BOOLEAN: 'true' | 'false';

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

IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
READ: 'read';
WRITE: 'write';

WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT_LINE: '/*' .*? '*/' -> skip;