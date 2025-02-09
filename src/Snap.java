import java.util.Scanner;

public class Snap extends CardGame {

    Card[] deck = new Card[52];

    public Snap() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snap! Press Enter to Begin...");
        scanner.nextLine();
        String newLine = System.lineSeparator();
        System.out.println("If you would like to play with 2 players," + newLine + "please type 2 then press enter to begin," + newLine + "otherwise type 1 then press enter");
        int players = scanner.nextInt();

        if (players == 2) {
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
            for (int i = 0; i < 52; i++) {
                deck[i] = deckOfCards.get(i);
            }
            System.out.println(playerOne.getName() + ", your first card is " + deck[0]);
            scanner.nextLine();
            System.out.println(playerTwo.getName() + ", your first card is " + deck[1]);
            if (deck[0].getSymbol().equals(deck[1].getSymbol())) {
                System.out.println(playerTwo.getName() + ", your card is the " + deck[1] + " Type snap to win!");
                String snap = scanner.nextLine();
//                scanner.wait(2000); how to allow the user 2 seconds to type in snap before the else statement occurs and the other player wins
                if (snap.equals("snap")){
                    System.out.println(playerTwo.getName() + " wins! Game Over");
                    scanner.nextLine();
                    scanner.close();
                    // error after game finishes 'exception in thread "main"'
                } else {
                    System.out.println("Too slow, " + playerOne.getName() + " wins!");
                    scanner.close();
                }
            }
            scanner.nextLine();

            for (int i = 2; i < deck.length; i++) {
                boolean winner = false;
                if (winner) {
                    scanner.close();
                }
                if (i % 2 == 0) {
                    if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {System.out.println(playerOne.getName() + ", your card is the " + deck[i] + " Type snap to win!");
                        String snap = scanner.nextLine();
//                scanner.wait(2000); how to allow the user 2 seconds to type in snap before the else statement occurs and the other player wins
                        if (snap.equals("snap")){
                            System.out.println(playerOne.getName() + " wins! Game Over");
                        } else {
                            System.out.println("Too slow, " + playerTwo.getName() + " wins!");
                        }

                        winner = true;
                        break;
                    } else {
                        System.out.println(playerOne.getName() + ", your next card is " + deck[i]);
                        scanner.nextLine();
                    }
                } else {
                    if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {
                        System.out.println(playerTwo.getName() + ", your card is the " + deck[i] + " Type snap to win!");
                        String snap = scanner.nextLine();
//                scanner.wait(2000); how to allow the user 2 seconds to type in snap before the else statement occurs and the other player wins
                        if (snap.equals("snap")){
                            System.out.println(playerTwo.getName() + " wins! Game Over");
                        } else {
                            System.out.println("Too slow, " + playerOne.getName() + " wins!");
                        }
                        winner = true;
                        break;
                    } else {
                        System.out.println(playerTwo.getName() + ", your next card is " + deck[i]);
                        scanner.nextLine();
                    }

                }
            }
        } else if (players == 1) {

            scanner.nextLine();

            shuffleDeck();
            for (int i = 0; i < 52; i++) {
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

        // is there a way to make the thread go back to the top of the game if it gets through the whole deck and no pairs have occurred? I.e. shuffle the deck again then go through the whole process again
    }
}
