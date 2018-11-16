
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author emmaboulay
 */
public class MonopolyGame extends Application implements Observer {

    private int rounds;
    private Board board;
    private Random dice;
    private ArrayList<Player> players;
    private HashMap<String, TextField> playersTFs;

    public MonopolyGame() {
        rounds = 0;
        board = new Board();
        dice = new Random();
        players = new ArrayList<>();
        playersTFs = new HashMap<>();
    }

    public void addPlayer(String name) {
        Player p = new Player(name, board.startingSquare());
        players.add(p);
        p.addObserver(this);
    }

    private void playRound() {
        rounds++;
        players.forEach((Player player) -> {
            int roll = dice.nextInt(12) + 1;
            try {
                board.getNextSquare(player.getLocation(), roll).landOn(player);
                if (rounds > 10) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Monopoly Game");
                    alert.setHeaderText("Game Over");
                    alert.setContentText("Player " + getWinner() + " wins!");
                    alert.showAndWait();
                    System.exit(0);
                }
            } catch (BankruptException ex) {
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Monopoly Game");
                alert.setHeaderText("Game Over");
                alert.setContentText("Player " + getWinner() + " wins!\nPlayer " + player.getName() + " is bankrupt!");
                alert.showAndWait();
                System.exit(0);
            }
        });
    }
    private String getWinner() {
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).netWorth() > players.get(i - 1).netWorth()) {
                winner = players.get(i);
            }
        }
        return winner.getName();
    }
    @Override
    public void start(Stage primaryStage) {

        Pane root = new VBox();
        Pane branch = new HBox();

        MonopolyGame game = new MonopolyGame();
                Button button = new Button("Roll");
        button.setOnAction(event -> {
            game.playRound();
        });

        branch.getChildren().add(button);
        root.getChildren().add(branch);
        game.addPlayer("Purple");
        game.addPlayer("Red");
        for (int i = 0; i < game.players.size(); i++) {
            TextField tf = new TextField(game.players.get(i).toString());
            tf.setEditable(false);
            tf.setPrefWidth(200);
            game.playersTFs.put(game.players.get(i).getName(), tf);
            Pane playersbox = new HBox();
            playersbox.getChildren().add(new Label(game.players.get(i).getName()));
            playersbox.getChildren().add(game.playersTFs.get(game.players.get(i).getName()));
            root.getChildren().add(playersbox);
        }

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Monopoly");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void update(Observable o, Object arg) {
        Player p = (Player) o;
        String name = p.getName();
        playersTFs.get(name).setText(p.toString());
    }
}
