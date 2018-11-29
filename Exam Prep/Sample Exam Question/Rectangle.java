
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private int length;
    private int height;
    
    public Rectangle(Point origin, int l, int h){
        super(origin);
        this.length = l;
        this.height = h;
                
    }
    
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        gc.fillRect(origin.getX(), origin.getY(), length, height);
        }
}