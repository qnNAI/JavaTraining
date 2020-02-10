package by.training.task01.beans;

public class Symbol implements Component {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
        symbol = '\u0000'; // null character
    }

    public void setContent(String content) {
        if (content != null && !content.isEmpty()) {
            symbol = content.charAt(0);
        }
    }

    public String getContent() {
        return String.valueOf(symbol);
    }
}
