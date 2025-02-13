import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    Card[] deck = new Card[52];
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    int players = 0;
    String playerOneName = null;
    String playerTwoName = null;
    Player playerOne = null;
    Player playerTwo = null;
    String snap = null;
    WinTimer winTimer = new WinTimer();
    Thread myThread = new Thread(winTimer);

    public Snap() {

        selectNumberOfPlayers();
        players = scanner.nextInt();

        if (players == 2) {
            selectPlayerNames();
            makeDeck();
            drawFirstCard();

            scanner.nextLine();
            drawTwoPlayerCards();

        } else if (players == 1) {

            scanner.nextLine();
            makeDeck();
            drawOnePlayerCard();

        }
        // is there a way to make the thread go back to the top of the game if it gets through the whole deck and no pairs have occurred? I.e. shuffle the deck again then go through the whole process again
    }

    public void selectNumberOfPlayers() {

        System.out.println("Welcome to Snap! Press Enter to Begin...");
        scanner.nextLine();
        String newLine = System.lineSeparator();
        System.out.println("If you would like to play with 2 players," + newLine + "please type 2 then press enter to begin," + newLine + "otherwise type 1 then press enter");

    }

    public void selectPlayerNames() {
        System.out.print("Welcome to two player snap! Player one please enter your name: ");
        playerOneName = scanner.next();
        System.out.print("Player two please enter your name: ");
        playerTwoName = scanner.next();
        scanner.nextLine();

        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
        System.out.print(playerOne.getName() + ", it's your turn first, please take turns pressing enter");
        scanner.nextLine();
    }

    public void makeDeck() {
        shuffleDeck();
        for (int i = 0; i < 52; i++) {
            deck[i] = deckOfCards.get(i);
        }
    }

    public void drawFirstCard() {
        System.out.println(playerOne.getName() + ", your first card is " + deck[0]);
        scanner.nextLine();
        System.out.println(playerTwo.getName() + ", your first card is " + deck[1]);
        if (deck[0].getSymbol().equals(deck[0].getSymbol())) {

                    myThread.start();

                    if (snap.equals("snap")){
                        System.out.println(playerTwo.getName() + " wins! Game Over");
                        System.exit(0);
                        scanner.close();
                    }
//                System.exit(0);


        }
    }

    public void drawTwoPlayerCards() {
        for (int i = 2; i < deck.length; i++) {
            if (i % 2 == 0) {
                if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {System.out.println(playerOne.getName() + ", your card is the " + deck[i] + " Type snap to win!");
                    snap = scanner.nextLine();
                    if (snap.equals("snap")){
                        System.out.println(playerOne.getName() + " wins! Game Over");
                    } else {
                        System.out.println("Too slow, " + playerTwo.getName() + " wins!");
                    }
                    break;
                } else {
                    System.out.println(playerOne.getName() + ", your next card is " + deck[i]);
                    scanner.nextLine();
                }
            } else {
                if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {
                    System.out.println(playerTwo.getName() + ", your card is the " + deck[i] + " Type snap to win!");
                    snap = scanner.nextLine();
                    if (snap.equals("snap")){
                        System.out.println(playerTwo.getName() + " wins! Game Over");
                    } else {
                        System.out.println("Too slow, " + playerOne.getName() + " wins!");
                    }
                    break;
                } else {
                    System.out.println(playerTwo.getName() + ", your next card is " + deck[i]);
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
    }

    public void drawOnePlayerCard() {
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
