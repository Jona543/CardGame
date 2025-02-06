import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    char[] suit = {'\u2660', '\u2665', '\u2666', '\u2663'};
    String[] symbol = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public CardGame() {
        for (int i = 0; i < suit.length; i++){
            for (int j = 0; j < symbol.length; j++){
            Card card = new Card(suit[i], symbol[j], value[j]);
            deckOfCards.add(card);
            }
        }
    }

    public void getDeck() {
        deckOfCards.forEach(card -> card.describeCard(card.symbol, card.suit));
    }

    public void dealCard() {
        int index = (int)(Math.random() * deckOfCards.size());
        System.out.println("Random Card Is : " + deckOfCards.get(index));
    }

    public void sortDeckInNumberOrder() {
        Collections.sort(deckOfCards);
    }

    public void sortDeckIntoSuits() {

    }

    public void shuffleDeck() {

    }
}
