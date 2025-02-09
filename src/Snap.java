import java.util.Scanner;

public class Snap extends CardGame {

    Card[] deck = new Card[52];

    public Snap() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snap! Press Enter to Begin...");
        scanner.nextLine();
        System.out.println("If you would like to play with 2 players, please type 2 then press enter to begin, otherwise just press enter ");
        int players = scanner.nextInt();

        if (players == 2){
            System.out.print("Welcome to two player snap! Player one please enter your name: ");
            String playerOneName = scanner.next();
            System.out.print("Player two please enter your name: ");
            String playerTwoName = scanner.next();
            scanner.nextLine();

            Player playerOne = new Player(playerOneName);
            Player playerTwo = new Player(playerTwoName);
            System.out.print(playerOne.getName() + ", it's your turn first, please take turns pressing enter");
            scanner.nextLine();

            shuffleDeck();
            for (int i = 0; i < 52; i++){
                deck[i] = deckOfCards.get(i);
            }

            System.out.println(playerOne.getName() + ", your first card is " + deck[0]);
            scanner.nextLine();
            System.out.println(playerTwo.getName() + ", your first card is " + deck[1]);
            if (deck[0].getSymbol().equals(deck[1].getSymbol())){
                System.out.println(playerTwo.getName() + " wins! Your card is the " + deck[1] + " Game Over");
                scanner.close();
            }
            scanner.nextLine();

            for (int i = 2; i < deck.length; i++){
                boolean winner = false;
                if (winner){
                    scanner.close();
                }
                if (i % 2 == 0){
                    if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {
                        System.out.println(playerOne.getName() + " wins! Your card is the " + deck[i] + " Game Over");
                        winner = true;
                        break;
                    } else {
                        System.out.println(playerOne.getName() + ", your next card is " + deck[i]);
                        scanner.nextLine();
                    }
                } else {
                    if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {
                        System.out.println(playerTwo.getName() + " wins! Your card is the " + deck[i] + " Game Over");
                        winner = true;
                        break;
                    } else {
                        System.out.println(playerTwo.getName() + ", your next card is " + deck[i]);
                        scanner.nextLine();
                    }

                }
            }

        }

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
