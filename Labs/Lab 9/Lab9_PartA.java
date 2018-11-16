
package lab9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
/**
 *
 * @author emmaboulay
 */


public class Lab9_PartA extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new HBox();
        Scene scene = new Scene(root,300,250);
        EventHandler<ActionEvent> sharedHandler = new ButtonHandler();
        Button tf[] = new Button[10];
        for(int i = 0; i < tf.length; i++){
            tf[i] = new Button("" + i);
            tf[i].setOnAction(sharedHandler);
            root.getChildren().add(tf[i]);
        }
        
        
        primaryStage.setTitle("Lab9a");
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
class ButtonHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event){
        System.out.println("ActionEvent " + event.getSource());
    }

    
}
