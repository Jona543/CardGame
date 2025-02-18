import java.util.Scanner;

public class Snap extends CardGame {

    Card[] deck = new Card[52];
    Scanner scanner = new Scanner(System.in);
    int players;
    String playerOneName;
    String playerTwoName;
    Player playerOne;
    Player playerTwo;
    String snap;

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
        class CustomThread extends Thread {
            final String playerOneName;
            final String playerTwoName;
            public CustomThread(String playerOneName, String playerTwoName) {
                this.playerOneName = playerOneName;
                this.playerTwoName = playerTwoName;
            }
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Too slow, " + playerOneName + " wins");
                    System.exit(0);
                } catch (InterruptedException e) {
                    System.exit(0);
                }
            }
        }
        System.out.println(playerOne.getName() + ", your first card is " + deck[0]);
        scanner.nextLine();
        System.out.println(playerTwo.getName() + ", your first card is " + deck[1]);
        if (deck[0].getSymbol().equals(deck[1].getSymbol())) {
            System.out.println("type snap to win");
            CustomThread customThread = new CustomThread(playerOneName, playerTwoName);
            customThread.start();
            snap = scanner.nextLine();
            if (snap.equalsIgnoreCase("SNAP")){
                customThread.interrupt();
                System.out.println(playerTwoName + " wins! Game Over");
                System.exit(0);
                scanner.close();
            } else {
                customThread.interrupt();
                System.out.println("Too slow! " + playerOne.getName() + " wins! Game Over");
                System.exit(0);
            }
        }
    }

    public void drawTwoPlayerCards() {
        class CustomThread extends Thread {
            final String playerOneName;
            final String playerTwoName;
            public CustomThread(String playerOneName, String playerTwoName) {
                this.playerOneName = playerOneName;
                this.playerTwoName = playerTwoName;
            }
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Too slow, " + playerOneName + " wins");
                    System.exit(0);
                } catch (InterruptedException e) {
                    System.exit(0);
                }
            }
        }
        for (int i = 2; i < deck.length; i++) {
            if (i % 2 == 0) {
                if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {System.out.println(playerOneName + ", your card is the " + deck[i] + " Type snap to win!");
                    CustomThread customThread = new CustomThread(playerOneName, playerTwoName);
                    customThread.start();
                    snap = scanner.nextLine();
                    if (snap.equalsIgnoreCase("SNAP")){
                        customThread.interrupt();
                        System.out.println(playerOne.getName() + " wins! Game Over");
                    } else {
                        customThread.interrupt();
                        System.out.println("Too slow, " + playerTwo.getName() + " wins!");
                    }
                    break;
                } else {
                    System.out.println(playerOne.getName() + ", your next card is " + deck[i]);
                    scanner.nextLine();
                }
            } else {
                if (deck[i - 1].getSymbol().equals(deck[i].getSymbol())) {
                    System.out.println(playerTwoName + ", your card is the " + deck[i] + " Type snap to win!");
                    CustomThread customThread = new CustomThread(playerOneName, playerTwoName);
                    customThread.start();
                    snap = scanner.nextLine();
                    if (snap.equalsIgnoreCase("SNAP")){
                        customThread.interrupt();
                        System.out.println(playerTwoName + " wins! Game Over");
                    } else {
                        customThread.interrupt();
                        System.out.println("Too slow, " + playerOneName + " wins!");
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
