package splprime.scan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static splprime.SplPrime.error;

public class Scanner {

	// In and output
	private final String source;
	private final List<Token> tokens = new ArrayList<>();
    private int current = 0;
	private int line = 1;

	public Scanner(String source) {
		this.source = source;
	}

	// Scan tokens
	public List<Token> scanTokens() {

		while (!isAtEnd()) {
            int start = current;
			char c = advance();

			switch (c) {
				// **Single-character tokens**
				case '(': tokens.add(new Token(TokenType.LEFT_PAREN, String.valueOf(c), null, line)); break;
				case ')': tokens.add(new Token(TokenType.RIGHT_PAREN, String.valueOf(c), null, line)); break;
				case '{': tokens.add(new Token(TokenType.LEFT_BRACE, String.valueOf(c), null, line)); break;
				case '}': tokens.add(new Token(TokenType.RIGHT_BRACE, String.valueOf(c), null, line)); break;
				case ';': tokens.add(new Token(TokenType.SEMICOLON, String.valueOf(c), null, line)); break;
				// **Operators (one or two characters)**
				case '+': tokens.add(new Token(TokenType.PLUS, String.valueOf(c), null, line)); break;
				case '-': tokens.add(new Token(TokenType.MINUS, String.valueOf(c), null, line)); break;
				case '*': tokens.add(new Token(TokenType.STAR, String.valueOf(c), null, line)); break;
				case '/':
					if (match('/')) {  // Handle single-line comments
						while (peek() != '\n' && !isAtEnd()) advance();
					} else {
						tokens.add(new Token(TokenType.SLASH, String.valueOf(c), null, line));
					}
					break;
				case '=':
					if (match('=')) {
						tokens.add(new Token(TokenType.EQUAL_EQUAL, "==", null, line));
					} else {
						tokens.add(new Token(TokenType.EQUAL, "=", null, line));
					}
					break;
				case '!':
					if (match('=')) {
						tokens.add(new Token(TokenType.BANG_EQUAL, "!=", null, line));
					}
					break;
				case '>':
					if (match('=')) {
						tokens.add(new Token(TokenType.GREATER_EQUAL, ">=", null, line));
					} else {
						tokens.add(new Token(TokenType.GREATER, ">", null, line));
					}
					break;

				case '<':
					if (match('=')) {
						tokens.add(new Token(TokenType.LESS_EQUAL, "<=", null, line));
					} else {
						tokens.add(new Token(TokenType.LESS, "<", null, line));
					}
					break;
				// 	**Keywords**
				case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g':
				case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n':
				case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u':
				case 'v': case 'w': case 'x': case 'y': case 'z':
				case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G':
				case 'H': case 'I': case 'J': case 'K': case 'L': case 'M': case 'N':
				case 'O': case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U':
				case 'V': case 'W': case 'X': case 'Y': case 'Z': case '_':
					while (isAlpha(peek())) advance();

					String lexeme = source.substring(start, current);
					TokenType type = keywords.get(lexeme);
					if (type == null) {
						type = TokenType.IDENTIFIER;
						tokens.add(new Token(type, lexeme, lexeme, line));
						break;
					}
					tokens.add(new Token(type, lexeme, null, line));
					break;
				// **Literals**
				case ',':
					tokens.add(new Token(TokenType.COMMA, String.valueOf(c), null, line));
				case '"':
					while (peek() != '"' && !isAtEnd()) advance();
					if (isAtEnd()) {
						error(line, "Unterminated string.");
					}
					advance();
					String value = source.substring(start + 1, current - 1);
					tokens.add(new Token(TokenType.STRING, value, value, line));
					break;
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
					while (isNumeric(peek())) advance();

					// Check for decimal number
					if (peek() == '.') {
						advance();
						while (isNumeric(peek())) advance();
					}
					String lexemeNumeric = source.substring(start, current);
					TokenType typeNumeric = TokenType.NUMBER;
					tokens.add(new Token(typeNumeric, lexemeNumeric, lexemeNumeric, line));
					break;
				case '\n':
					line++;
					break;
				case ' ': case '\r': case '\t': //Ignore spaces
					break;
				default:
					error(line, "Unexpected character: " + c);
			}
		}
		return tokens;
	}

	private boolean isNumeric(char c) {
		return (c >= '0' && c <= '9');
	}

	private boolean isAlpha(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
	}

	private char advance() {
		return source.charAt(current++);
	}

	private boolean match(char expected) {
		if (isAtEnd()) {
			return false;
		}
		if (source.charAt(current) != expected) {
			return false;
		}
		current++;
		return true;
	}

	private char peek() {
		if (isAtEnd()) {
			return '\0';
		}
		return source.charAt(current);
	}

	private boolean isAtEnd() {
		return current == source.length();
	}

	private static final Map<String, TokenType> keywords;
	static {
		keywords = new HashMap<>();
		keywords.put("true", TokenType.TRUE);
		keywords.put("false", TokenType.FALSE);
		keywords.put("and", TokenType.AND);
		keywords.put("or", TokenType.OR);
		keywords.put("var", TokenType.VAR);
		keywords.put("print", TokenType.PRINT);
		keywords.put("if", TokenType.IF);
		keywords.put("else", TokenType.ELSE);
		keywords.put("while", TokenType.WHILE);
	}


}
