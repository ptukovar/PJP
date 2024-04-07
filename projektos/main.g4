grammar main;

prog: statement+ EOF;

statement: SEMICOLON
        | typeKeyword VARIABLE (COMMA VARIABLE)* SEMICOLON
        | expression SEMICOLON
        | READ VARIABLE (COMMA VARIABLE)* SEMICOLON
        | WRITE expressionList SEMICOLON
        | '{' statement* '}'
        | IF '(' expression ')' statement (ELSE statement)?
        | WHILE '(' expression ')' statement
        | FOR '(' expression SEMICOLON condition SEMICOLON expression ')' statement 
        ;

expressionList: expression (SEMICOLON expression)* ;

expression: VARIABLE
        | '(' expression ')'
        | literal
        | prefix=SUB expression
        | prefix=NEG expression
        | expression op=(MULT | DIV | MOD) expression
        | expression op=(ADD | SUB | DOT) expression
        | expression op=(EQ | NE | LT | GT | LE | GE) expression
        | expression op=(AND | OR) expression
        | <assoc=right> VARIABLE '=' expression
        ;

literal: INT | FLOAT | STRING | BOOLEAN;

SEMICOLON: ';';
COMMA: ',';

// Literals
VARIABLE: [a-zA-Z] ([a-zA-Z0-9]*)? ;

// Data types
INT: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' .*? '"'; 
BOOLEAN: 'true' | 'false';

// Keywords
typeKeyword: INT_KEYWORD 
        | FLOAT_KEYWORD 
        | STRING_KEYWORD 
        | BOOLEAN_KEYWORD
        ; 

condition: expression;

INT_KEYWORD: 'int';
FLOAT_KEYWORD: 'float';
STRING_KEYWORD: 'string';
BOOLEAN_KEYWORD: 'boolean';

// Operators
MULT: '*';
DIV: '/';
MOD: '%';
ADD: '+';
SUB: '-';
LT: '<';
GT: '>';
LE: '<=';
GE: '>=';
EQ: '==';
NE: '!=';
AND: '&&';
OR: '||';
NEG: '!';
DOT: '.';

COMMENT: '/*' .*? '*/' -> skip;
COMMENT_LINE: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

READ: 'read';
WRITE: 'write';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';