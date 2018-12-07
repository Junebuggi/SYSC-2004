
import java.awt.Point;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author emmaboulay
 */
public class SampleExamQ extends Application implements Observer{
    private GraphicsContext gc;
  
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(300, 250);
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        ShapeDataBase database = new ShapeDataBase();
        database.addObserver(this);
        HBox bottom = new HBox();
        Random random = new Random();
        Button newCircle = new Button("New Circle");
        Button newRectangle = new Button("Rectangle");
        
        newCircle.setOnAction((ActionEvent event) -> {
            int a = random.nextInt(250);
            int b = random.nextInt(250);
            int c = random.nextInt(75)+5;
            database.addShape(new Circle(new Point(a,b), c));
        });
        
        newRectangle.setOnAction((ActionEvent event) -> {
            int a = random.nextInt(250);
            int b = random.nextInt(250);
            int c = random.nextInt(120);
            int d = random.nextInt(75)+5;
            database.addShape(new Rectangle(new Point(a,b), c, d));
        });
        
        bottom.getChildren().addAll(Arrays.asList(newCircle, newRectangle));
        root.setBottom(bottom);
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Sample Exam Question!");
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
        Shape s = (Shape) arg;
        s.draw(gc);
        
    }
    
}
