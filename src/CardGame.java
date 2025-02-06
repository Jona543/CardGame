import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        System.out.println(deckOfCards);
    }

    public void dealCard() {
        System.out.println("Top Card Is : " + deckOfCards.get(0));
    }

    public void sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparingInt(Card::getValue));
    }

    public void sortDeckIntoSuits() {
        ArrayList<Card> sortedIntoHearts = new ArrayList<>();
        ArrayList<Card> sortedIntoDiamonds = new ArrayList<>();
        ArrayList<Card> sortedIntoClubs = new ArrayList<>();
        ArrayList<Card> sortedIntoSpades = new ArrayList<>();

        deckOfCards.forEach(card -> {
            if (card.getSuit() == '\u2660'){
            sortedIntoSpades.add(card);
        } else if (card.getSuit() == '\u2665'){
            sortedIntoHearts.add(card);
        } else if (card.getSuit() == '\u2666'){
            sortedIntoDiamonds.add(card);
        } else if (card.getSuit() == '\u2663'){
            sortedIntoClubs.add(card);
        }
        });

        sortedIntoClubs.sort(Comparator.comparingInt(Card::getValue));
        sortedIntoSpades.sort(Comparator.comparingInt(Card::getValue));
        sortedIntoHearts.sort(Comparator.comparingInt(Card::getValue));
        sortedIntoDiamonds.sort(Comparator.comparingInt(Card::getValue));

        ArrayList sortedIntoDecks = new ArrayList();

        sortedIntoDecks.addAll(sortedIntoHearts);
        sortedIntoDecks.addAll(sortedIntoDiamonds);
        sortedIntoDecks.addAll(sortedIntoClubs);
        sortedIntoDecks.addAll(sortedIntoSpades);

        deckOfCards = sortedIntoDecks;
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }
}
