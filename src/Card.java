public class Card {
    // unicode chars - spade: 2660, heart: 2665, clubs: 2663, diamond: 2666
    public char suit;
    public String symbol;
    private int value;

    public Card(char suit, String symbol, int value) {
//        System.out.println(symbol + " of " + suit);
//        System.out.println(card);
    }

    public void describeCard(String symbol, char suit) {
        System.out.println(symbol + " of " + suit);
    }

    public String toString() {
        return (symbol + " of " + suit).toString();
    }




}
