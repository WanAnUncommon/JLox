/**
 * Token
 *
 * @author WanAn
 */
class Token {
    // 类型
    final TokenType type;
    // 词素（符号）
    final String lexeme;
    // 词素对应的字面量
    final Object literal;
    // 行号
    final int line;

    public Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
