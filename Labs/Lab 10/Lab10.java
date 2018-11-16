/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 *
 * @author emmaboulay
 */
public class Lab10 extends Application implements Observer{
    public final int X_DIMENSION = 250;
    public final int Y_DIMENSION = 350;
    private Car car;
    private GraphicsContext gc;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        car = new Car(Color.DEEPPINK, X_DIMENSION, Y_DIMENSION, 50);
        Canvas canvas = new Canvas(X_DIMENSION, Y_DIMENSION);
        gc = canvas.getGraphicsContext2D();
        
        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        Button button = new Button("Drive Car");
        root.setBottom(button);
        EventHandler<ActionEvent> sharedHandler = new ButtonHandler();
        button.setOnAction(sharedHandler);
        car.addObserver(this);
        
        Scene scene = new Scene(root, X_DIMENSION, Y_DIMENSION + 30);
        
        primaryStage.setTitle("Lab10");
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
        Car c = (Car) o;
        Color colour = c.getColour();
        Point location = c.getLocation();
        gc.setFill(colour);
        gc.fillOval(location.x, location.y, 8, 8);
        
      
        gc.setLineWidth(5);
        gc.setStroke(colour);
        gc.strokeLine(c.getLocation(1).x, c.getLocation(1).y, location.x, location.y);
   
           
    
}
class ButtonHandler implements EventHandler<ActionEvent> {

    public ButtonHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        car.drive();
    }
    
}
}
