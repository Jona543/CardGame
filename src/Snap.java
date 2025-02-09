import java.util.Scanner;

public class Snap extends CardGame {

    Card[] deck = new Card[52];

    public Snap() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snap! Press Enter to Begin...");
        scanner.nextLine();

        shuffleDeck();
        for (int i = 0; i < 52; i++){
            deck[i] = deckOfCards.get(i);
        }
        System.out.println("Your card is the " + deck[0]);
        System.out.println("Press Enter For Next Card...");
        scanner.nextLine();

        for (int i = 1; i < deck.length; i++) {
            if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {
                System.out.println("Snap! Your card is the " + deck[i] + " Game Over");
                scanner.close();
                break;
            } else {
                System.out.println("Your next card is the " + deck[i]);
                scanner.nextLine();
            }
        }
    }
}
