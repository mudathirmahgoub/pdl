grammar pdl;

// parser rules

pdl : formula;

formula : equivalence | implication | or | and | subformula;

subformula : falsity | truth | Identifier |
             necessity | possibility  | negation |
             '(' formula ')';

necessity : '[' program ']' subformula ;

possibility : '<' program '>' subformula ;

implication : subformula RightArrow formula ;

equivalence : subformula LeftRightArrow formula ;

or : subformula Or formula ;

and : subformula And formula ;

negation : Not formula ;

falsity : '0' ;

truth : '1' ;


program : subprogram  | sequence | choice | iteration | test ;

subprogram : Identifier; // ToDo: review precedence

sequence : subprogram ';' program ;

choice : subprogram Union program ;

iteration : subprogram '*';

test : subformula '?';


// lexer rules

Union : '∪' | 'union' ;

Or : 'or' | '∨' ;

And : 'and' | '∧';

Not : 'not' | '¬';

Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Integer : Digit+ ;

RightArrow : '->' | '→';

LeftRightArrow : '<->' | '↔' ;

Digit : '0'..'9' ;

Whitespace :  [ \t\r\n]+ -> skip ;