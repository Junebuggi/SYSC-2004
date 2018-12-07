
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author emmaboulay
 */
public class ShapeDataBase extends Observable {

    private ArrayList<Shape> db;

    public ShapeDataBase() {
        db = new ArrayList<>();
    }

    public void addShape(Shape s) {

        db.add(s);
        setChanged();
        notifyObservers(s);

    }
}
