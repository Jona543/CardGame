
public class WinTimer extends Snap implements Runnable {
            @Override
            public void run() {
                snap = scanner1.nextLine();
                System.out.println(playerTwo.getName() + ", your card is the " + deck[1] + " Type snap to win!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("Too slow! " + playerOne.getName() + " wins! Game Over");
                scanner1.close();
                System.exit(0);
            }
        }





