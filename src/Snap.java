import java.util.Scanner;

public class Snap extends CardGame {

    Card[] deck = new Card[52];

    public Snap() {
    System.out.println(deck);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snap! Press Enter to Begin...");
        scanner.nextLine();
        shuffleDeck();
        dealCard();
        System.out.println("Press Enter For Next Card...");
        scanner.nextLine();
//        for (int i = 1; i < deckOfCards.size(); i++) {
//            System.out.println("Next card is : " + deckOfCards.get(i));
//            if (deckOfCards.get(i).getSuit() == )
//        }



    }
}
