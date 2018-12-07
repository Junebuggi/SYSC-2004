
import java.util.Scanner;

/**
 * A Model of a Connect-Four test client. Players take turns starting a game. In
 * each turn, one checker is dropped into an empty location that is either at
 * the bottom of the grid or is above another checker
 *
 * @author emmaboulay
 * @version 1.0
 */
public class ConnectFourTestClient {

    /**
     * @param args unused
     */
    public static void main(String args[]) {
        ConnectFourGame game = new ConnectFourGame(ConnectFourEnum.BLACK);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(game.toString());
            System.out.println(game.getTurn() + ": Where do you want to drop your checker? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            game.takeTurn(row, column);

        } while (game.getGameState() == ConnectFourEnum.IN_PROGRESS);
        if(game.getGameState() == ConnectFourEnum.DRAW)
            System.out.println("It's a Draw!");
        else
            System.out.println(game.getGameState() + " WINS!");
    }
}
