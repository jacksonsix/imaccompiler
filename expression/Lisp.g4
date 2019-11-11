grammar Lisp;
file: expr+;
expr:    define                 #define_expr
       | defineproc             #define_proc 
       | ifexpr                 #if_expr
	   | lambda                 #lambda_expr
	   | begin                  #begin_expr
	   | self                   #self_expr
	   | compound               #compound_expr
	   | setexpr                #set_expr
	   | letexpr                #let_expr
	   | condexpr               #cond_expr
	   ;
	   
define : '('  'define'   ID  expr ')' ;
defineproc : '('  'define'  '(' ID formalParas? ')'  expr+ ')';
setexpr : '('  'set!'   ID  expr ')' ;
ifexpr: '('  'if' expr   expr    expr ')';
lambda: '(' 'lambda' '(' formalParas?  ')'  expr* ')';
begin: '(' 'begin'  expr+ ')';
self: ID                        #self_id 
     | INT                      #self_int
     | FLOAT                    #self_float
	 ;
compound: '(' op  args? ')';
op: expr          #lambda_comp
   | ID           #proc_name_comp
   | SPECIAL      #proc_num_comp
   ;
   
letexpr: '(' 'let'  '('  pair+  ')'  expr+ ')'  ;
pair: '('  ID  expr ')';
condexpr: '(' 'cond'  switchexpr+  elsego ')';
switchexpr: expr expr;

elsego: '(' 'else' expr ')';

args: expr ( expr)*;
formalParas: formalPara ( formalPara)* ;
formalPara: ID;
	 
ID: ID_LETTER (ID_LETTER | DIGIT)*;
fragment ID_LETTER: [A-Za-z_!];

    
INT : DIGIT+;
FLOAT: '.' DIGIT+
     | DIGIT+ '.' DIGIT*
     ;
fragment DIGIT:[0-9];
LINE_COMMENT: ';'  .*? '\n'  ->skip;
STRING: '"' (ESC | .)*? '"';
fragment ESC: '\\' [btnr"\\];
 
SPECIAL : '+' 
        | '-'
        | '*'
        | '/'
        | '='
        ;
WS : [ \t\r\n]+ -> skip;