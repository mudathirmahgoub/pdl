grammar Pdl;

// pdl.parser rules

pdl : kripkeFrame? formula;

kripkeFrame : states propositionMeaning* programMeaning* ;

states : 'K' '=' LeftCurlyBracket Identifier (',' Identifier)* RightCurlyBracket ;

propositionMeaning : 'm' LeftParenthesis Identifier RightParenthesis '='
                       LeftCurlyBracket Identifier? (',' Identifier)*  RightCurlyBracket;

programMeaning : 'm' LeftParenthesis Identifier RightParenthesis '='
                       LeftCurlyBracket pair? (',' pair)*  RightCurlyBracket ;

pair : LeftParenthesis Identifier ',' Identifier RightParenthesis ;


formula : falsity
          | truth
          | atomicFormula
          | LeftParenthesis formula RightParenthesis
          | Not formula // negation
          | LeftSquareBracket program RightSquareBracket formula // necessity
          | LeftAngle program RightAngle formula // possibility
          | formula And formula
          | formula Or formula
          | formula RightArrow formula // implication
          | formula LeftRightArrow formula // equivalence
          | hoarePartialCorrectness ;


hoarePartialCorrectness : LeftCurlyBracket formula RightCurlyBracket program LeftCurlyBracket formula RightCurlyBracket ;

falsity : '0' ;

truth : '1' ;

atomicFormula : Identifier;

program : | skip
          | fail
          | alternativeGuardedCommand
          | iterativeGuardedCommand
          | atomicProgram
          | iteProgram
          | whileProgram
          | repeatProgram
          | program Star // iteration
          | program Semicolon program // composition
          | program Union program // choice
          | LeftParenthesis program RightParenthesis
          | formula QuestionMark // test;

skip : Skip ;

fail : Fail ;

atomicProgram : Identifier;

alternativeGuardedCommand : If guardedCommand (Bar guardedCommand)* Fi ;

iterativeGuardedCommand : Do guardedCommand (Bar guardedCommand)* Od ;

guardedCommand : formula RightArrow program ;

iteProgram : If formula Then program Else program ;

whileProgram : While formula Do program ;

repeatProgram : Repeat program Until formula ;

// lexer rules

Star : '*' ;

Semicolon : ';' ;

QuestionMark : '?' ;

Bar : '|';

Skip : 'skip' ;

Fail : 'fail' ;

If : 'if';

Fi : 'fi' ;

Do : 'do' ;
 
Od : 'od' ;

Then : 'then' ;

Else : 'else' ;

While : 'while';

Repeat : 'repeat' ;

Until : 'until' ; 

Union : '∪' | 'union' ;

Or : 'or' | '∨' ;

And : 'and' | '∧';

Not : 'not' | '¬';

LeftParenthesis : '(' ;

RightParenthesis : ')' ;

LeftSquareBracket : '[';

RightSquareBracket : ']';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

LeftAngle : '<';

RightAngle : '>';

Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Integer : Digit+ ;

RightArrow : '->' | '→';

LeftRightArrow : '<->' | '↔' ;

Digit : '0'..'9' ;

Whitespace :  [ \t\r\n]+ -> skip ;