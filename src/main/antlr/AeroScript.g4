grammar AeroScript;

@header {
package no.uio.aeroscript.antlr;
}

// Whitespace and comments added
WS           : [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT      : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;

LCURL   : '{';
RCURL   : '}';
LSQUARE : '[';
RSQUARE : ']';
LPAREN  : '(';
RPAREN  : ')';

NEG     : '--';
SEMI    : ';';
COMMA   : ',';
GREATER : '>';

PLUS    : '+';
MINUS   : '-';
TIMES   : '*';

// Define all the elements of the language for the various keywords that you need
RANDOM  : 'random';
POINT   : 'point';

// Keywords
ID: [a-zA-Z_]+; // Allow underscore in ID
NUMBER: [0-9]+('.'[0-9]+)?;

// Entry point
program : COMMENT ; // Placeholder
execution : COMMENT ; // Placeholder

// Statements
statement   : COMMENT ; // Placeholder

expression : NEG expression |
             expression TIMES expression |
             expression (PLUS | MINUS) expression |
             RANDOM range? |
             POINT point |
             NUMBER |
             LPAREN expression RPAREN;

point : LPAREN expression COMMA expression RPAREN;
range : LSQUARE expression COMMA expression RSQUARE;