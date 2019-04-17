grammar pdl;

// parser rules

pdl : formula;

formula :   falsity | truth | Identifier |
            necessity | possibility |
            implication | equivalence | or | and | negation |
            falsity | truth ;

necessity : '[' program ']' formula ;

possibility : '<' program '>' formula ;

implication : formula RightArrow formula ;

equivalence : formula LeftRightArrow formula ;

or : formula Or formula ;

and : formula And formula ;

negation : Not formula ;

falsity : '0' ;

truth : '1' ;


program : Identifier | sequence | choice | iteration | test ;

sequence : program ';' program ;

choice : program UNION program ;

iteration : program '*';

test : formula '?';

// lexer rules
Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Integer : Digit+ ;

RightArrow : '->';

LeftRightArrow : '<->' ;

Union : '∪' | 'union' ;

Digit : '0'..'9' ;

Whitespace :  [ \t\r\n]+ -> skip ;