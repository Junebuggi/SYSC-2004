
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author emmaboulay
 */
public abstract class Shape {
    protected Point origin;
    public Shape(Point o){
        this.origin = o;
    }
    public abstract void draw(GraphicsContext gc);
}
