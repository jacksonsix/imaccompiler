grammar Lispdebug;
file: expr+;
expr : open expr*  end;
open : '(' INT  ID  ;
end : INT ')';
INT : [0-9]+;
ID :[A-Za-z]+
   | '+'
   |'-'
   |'*'
   |'/'
   |'='
   | '>'
   |'<'
   ;
WS : [ \t\r\n]+ -> skip;