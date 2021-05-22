grammar Grammar;

program: block;

block: ( (stat|function)? NEWLINE )*;

stat: PRINT ID                              #print
    | READ ID                               #read
    | PRINT STRING                          #printString
    | REPEAT repetitions '{' block '}'      #repeat
    | IF equal '{' blockif  '}'             #if
    // TODO: dodać if - else if - else
    | ID '()'                               #call
    | id                                    #statId
    | id EQ val                             #assign
    | id EQ expr                            #assign
    | 'string' ID EQ STRING                 #newString
    | arrayType ID EQ '[' (number)* ']'     #newArray
    | ID ID EQ ID '(' (val)* ')'            #newStruct
    | ID '{' NEWLINE (type ID NEWLINE)* '}' #defStruct;

function: FUNCTION name '{' fblock '}';

val: number                                 #numb
    | ID '[' INT ']'                        #arrElem
    | TOINT val                             #toInt
    | TOFLOAT val                           #toFloat
    | ID                                    #valId;

expr: val PLUS val                          #plus
    | val MINUS val                         #minus
    | val MUL val                           #mul
    | val DIV val                           #div;

number: INT                                 #int
    | FLOAT                                 #float;

id: type ID                                 #newVar
    | ID                                    #var;

type: 'int'
    | 'float';

arrayType: 'int[]'
    | 'float[]';

repetitions: INT
    | ID;

blockif: block;

equal: ID '==' INT;
// TODO: porównanie do czegokolwiek innego niż int???

name: ID;

fblock: ( stat? NEWLINE )*;

STRUCT: 'struct';

FUNCTION: 'def';

REPEAT: 'repeat';

IF:	'if';

PRINT: 'print';

READ: 'read';

TOINT: '(int)';

TOFLOAT: '(float)';

PLUS: '+';

MINUS: '-';

MUL: '*';

DIV: '/';

EQ: '=';

FLOAT: '-'?'0'..'9'+'.''0'..'9'+;

INT: '-'?'0'..'9'+;

ID: ('a'..'z'|'A'..'Z'|'0'..'9'|'.')+;

STRING: '"'[a-zA-Z ]+'"';

NEWLINE: '\r'? '\n';

WS:   (' '|'\t')+ -> skip;