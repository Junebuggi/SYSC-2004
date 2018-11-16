
package lab9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author emmaboulay
 */


public class Lab9_PartB extends Application {
    final int NUM_BUTTONS = 10;
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new VBox();
        Pane topBranch = new HBox();
        Pane bottomBranch = new HBox();
        Scene scene = new Scene(root,300,250);
        TextField tf = new TextField("");
        tf.setEditable(false);
        EventHandler<ActionEvent> sharedHandler = new Lab9Handler(tf);
        Button b[] = new Button[NUM_BUTTONS];
        for(int i = 0; i < b.length; i++){
            b[i] = new Button("" + i);
            b[i].setOnAction(sharedHandler);
            topBranch.getChildren().add(b[i]);
        }
        root.getChildren().add(topBranch);
        bottomBranch.getChildren().add(tf);
        Button reset = new Button("Reset");
        reset.setOnAction(sharedHandler);
        bottomBranch.getChildren().add(reset);
        root.getChildren().add(bottomBranch);
         
        primaryStage.setTitle("Lab9b");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}
class Lab9Handler implements EventHandler<ActionEvent> {
    private final TextField numberField;
    public Lab9Handler(TextField numberfield){
        numberField = numberfield;
    }
    @Override
    public void handle(ActionEvent event){
      Button b = (Button) event.getSource();
      if(b.getText().equals("Reset")){
          numberField.clear();
          return;
      }
        numberField.setText(numberField.getText() + b.getText());
    } 
}