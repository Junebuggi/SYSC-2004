


import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author emmaboulay
 */
public class Car extends Observable{
    private javafx.scene.paint.Color colour;
    private ArrayList<java.awt.Point> locations;
    private java.util.Random random;
    private int xLimit;
    private int yLimit;
    private int step;
    
    public Car(Color colour, int xLimit, int yLimit, int step){
        this.colour = colour;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
        this.step = step;
        this.random = new Random();
        this.locations = new ArrayList<>();
        Point initial = new Point(random.nextInt(xLimit),random.nextInt(yLimit));
        locations.add(0,initial);
                
    }
    public Point getLocation(){
        Point copy = new Point(locations.get(0));
        return copy;

    }
    public Point getLocation(int index){
        Point copy = new Point(locations.get(index));
        return copy;
        
    }
    public Color getColour(){
        return colour;
    }
    public void drive(){
        int num = random.nextInt(2*step) - step;
        Point copy = new Point(getLocation());
        copy.translate(num, num);
        if(copy.getX() < 0 || copy.getX() > xLimit || copy.getY() < 0 || copy.getY() > yLimit){
            copy.setLocation(random.nextInt(xLimit),random.nextInt(yLimit));
        }
        locations.add(0, copy);
        setChanged();
        notifyObservers();
    }

    
    
}
