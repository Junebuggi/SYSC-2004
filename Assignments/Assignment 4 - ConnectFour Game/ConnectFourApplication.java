
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * A ConnectFour Application that is implemented using a GUI
 *
 * @author emmaboulay
 * @version 1.0
 */
public class ConnectFourApplication extends Application implements Observer {

    public static final int NUM_COLUMNS = 8;
    public static final int NUM_ROWS = 8;
    public static final int NUM_TO_WIN = 4;
    public static final int BUTTON_SIZE = 45; //A button size of 20 was recommended in the UML but made the grid unpleasant 
    private ConnectButton[][] buttons;
    private TextField top;
    private Point location;

    /**
     * Builds the GUI and populates the view and hooks up the handlers for the
     * ConnectFour game.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        ConnectFourEnum initialTurn;
        //Randomly selects which player to start first
        if (Math.random() < 0.5) {
            initialTurn = ConnectFourEnum.BLACK;
        } else {
            initialTurn = ConnectFourEnum.RED;
        }

        ConnectFourGame gameEngine = new ConnectFourGame(NUM_ROWS, NUM_COLUMNS, NUM_TO_WIN, initialTurn);
        gameEngine.addObserver(this);
        buttons = new ConnectButton[NUM_ROWS][NUM_COLUMNS];
        BorderPane root = new BorderPane();
        GridPane board = new GridPane();
        top = new TextField(gameEngine.getTurn() + " begins.");
        top.setEditable(false);
        root.setCenter(board);
        root.setTop(top);
        EventHandler<ActionEvent> cbHandler = new ButtonHandler();
        Button takeTurn = new Button("Take My Turn");
        root.setBottom(takeTurn);

        takeTurn.setOnAction((ActionEvent event) -> {
            if (location == null) { //A try-catch previously wrapped .takeTurn() but an if == null was chosen instead since catching a NullPointerException can lead to future bugs
                System.out.println("You must first select a square to place your checker!");
            } else {
                gameEngine.takeTurn((int) location.getX(), (int) location.getY());

                if (gameEngine.getGameState() != ConnectFourEnum.IN_PROGRESS) {
                    String notification; //An alert notification is going to be shown. The specifics depends if there's a winner or a tie
                    if (gameEngine.getGameState() == ConnectFourEnum.DRAW) {
                        notification = "It's a Draw!";
                    } else {
                        notification = gameEngine.getGameState() + " WINS!";
                    }
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("ConnectFour Game");
                    alert.setHeaderText("Game Over");
                    alert.setContentText(notification);
                    alert.showAndWait();
                    gameEngine.reset(gameEngine.getTurn()); //The game has ended. The board is reset for the next match
                    top.setText(gameEngine.getTurn() + " begins.");
                }
            }

        });

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                buttons[i][j] = new ConnectButton("EMPTY", NUM_ROWS - 1 - i, j); //Row parameter of the button must be inverted
                buttons[i][j].setMinHeight(BUTTON_SIZE);
                buttons[i][j].setOnAction(cbHandler);
                board.add(buttons[i][j], j, i);
            }
        }

        Scene scene = new Scene(root, 510, 425);
        primaryStage.setTitle("ConnectFour");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Updates the GUI whenever a checker is placed in the takeTurn or reset
     * method in the ConnectFourGame class
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        ConnectMove move = (ConnectMove) arg;
        if (move.getColour() == ConnectFourEnum.EMPTY) {
            buttons[NUM_ROWS - move.getRow() - 1][move.getColumn()].setStyle(null); //Returns buttons to default setting after reset
            buttons[NUM_ROWS - move.getRow() - 1][move.getColumn()].setText("" + move.getColour());
            buttons[NUM_ROWS - move.getRow() - 1][move.getColumn()].setDisable(false);
        } else {
            buttons[NUM_ROWS - move.getRow() - 1][move.getColumn()].setText("" + move.getColour());
            buttons[NUM_ROWS - move.getRow() - 1][move.getColumn()].setDisable(true);
            System.out.println("Checker dropped");

            //An additional feature of changing the colour of the button to model the checker dropped has been added for user-functionality
            buttons[NUM_ROWS - move.getRow() - 1][move.getColumn()].setStyle("-fx-background-color:" + move.getColour() + "; -fx-text-fill: #FFFFFF");

            if (move.getColour() == ConnectFourEnum.BLACK) {
                top.setText("It's RED's turn");
            } else {
                top.setText("It's BLACKS's turn");
            }
        }
    }

    /**
     * Handler for the ConnectButtons
     */
    class ButtonHandler implements EventHandler<ActionEvent> {

        /**
         * Stores the row and column of the latest ConnnectButton clicked in a
         * Point variable
         *
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            ConnectButton b = (ConnectButton) event.getSource();
            System.out.println(b.toString());
            location = new Point(b.getRow(), b.getColumn());

        }
    }
}
