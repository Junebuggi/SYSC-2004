
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author emmaboulay
 */
public class Circle extends Shape {
    private final int radius;
    
    public Circle(Point origin, int radius){
        super(origin);
        this.radius = radius;
    }
    
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        gc.fillOval(origin.getX(), origin.getY(), radius, radius);
        
    }
}
