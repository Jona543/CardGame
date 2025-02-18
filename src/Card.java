public class Card {
    // unicode chars - spade: 2660, heart: 2665, clubs: 2663, diamond: 2666
    private final char suit;
    private final String symbol;
    private final int value;

    public Card(char suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return (this.symbol + " of " + this.suit);
    }
}
