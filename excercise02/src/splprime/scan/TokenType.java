package splprime.scan;

public enum TokenType {
    // **Single-character tokens**
    LEFT_PAREN, RIGHT_PAREN,  // ( )
    LEFT_BRACE, RIGHT_BRACE,  // { }
    SEMICOLON,                // ;

    // **Operators (one or two characters)**
    PLUS, MINUS, STAR, SLASH, // + - * /
    EQUAL, EQUAL_EQUAL,       // = ==
    BANG_EQUAL,               // !=
    GREATER, GREATER_EQUAL,   // > >=
    LESS, LESS_EQUAL,         // < <=

    // **Literals**
    IDENTIFIER,   // Variable names (x, x1)
    STRING,       // "hello, world!"
    NUMBER,       // 15, 3.14
    COMMA,        // ,

    // **Keywords**
    TRUE, FALSE,   // true, false
    AND, OR,       // and, or
    VAR, PRINT,    // var, print
    IF, ELSE,      // if, else
    WHILE,         // while

    // **End of File (EOF)**
    EOF            // Special token to indicate the end of input
}

