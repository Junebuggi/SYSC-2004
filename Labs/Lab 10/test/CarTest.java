import java.awt.Point;
import javafx.scene.paint.Color;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author schramm
 */
public class CarTest {
    
    public final static int MAX_X = 1000;
    public final static int MAX_Y = 1000;
    public final static int STEP = 200;
    
    @Test
    public void testConstructor() {
        Car c = new Car(Color.AQUA,MAX_X,MAX_Y,STEP);
        assertEquals(Color.AQUA, c.getColour());
        assertNotEquals(null, c.getLocation());
        try {
            c.getLocation(1);
            fail();
        } catch (IndexOutOfBoundsException e) { }
    }
    @Test
    public void testDefensiveGetLocation() {
        Car c = new Car(Color.AQUA,MAX_X,MAX_Y,STEP); 
        Point p1 = c.getLocation();  // Don't know what it is, because random
        Point p2 = c.getLocation();  // Although, should be equal but not ==
        assertEquals(p1,p2);
        assertFalse(p1==p2);
    }
    @Test
    public void testDefensiveGetLocationIndex() {
        Car c = new Car(Color.AQUA,MAX_X,MAX_Y,STEP); 
        Point p1 = c.getLocation(0);  // Don't know what it is, because random
        Point p2 = c.getLocation(0);  // Although, should be equal but not ==
        assertEquals(p1,p2);
        assertFalse(p1==p2);
    }
    
    @Test
    public void testDrive() {
        Car c = new Car(Color.AQUA,MAX_X,MAX_Y,STEP); 
        Point initial = c.getLocation();  // Don't know what it is, because random
        c.drive();
        Point after = c.getLocation();
        Point shuffledInitial = c.getLocation(1);
        assertNotEquals(initial,after);
        assertEquals(initial,shuffledInitial);
        assertFalse(initial==shuffledInitial);  // Really redundant, from testDefensiveGetLocationIndex()
        assertTrue(initial.getX()<=MAX_X && initial.getX()>=0);
        assertTrue(initial.getY()<=MAX_X && initial.getY()>=0);        
        assertTrue(after.getX()<=MAX_X && after.getX()>=0);
        assertTrue(after.getY()<=MAX_X && after.getY()>=0); 
        assertTrue(shuffledInitial.getX()<=MAX_X && shuffledInitial.getX()>=0);
        assertTrue(shuffledInitial.getY()<=MAX_X && shuffledInitial.getY()>=0);
        assertTrue(Math.abs(initial.getX()-after.getX())<=STEP);
        assertTrue(Math.abs(initial.getY()-after.getY())<=STEP);
        // Could continue and verify that steps are not fixed, but random.
    }  

        /*
        
        Point location = new Point( locations.get(0));
        location.translate(random.nextInt(step*2)-step, random.nextInt(step*2)-step);
        if (location.getX() > xLimit || location.getX() < 0 ||
                location.getY() > yLimit || location.getY() < 0 ) {
            location.setLocation( random.nextInt(xLimit), random.nextInt(yLimit));
        }
        locations.add(0, location);
        this.setChanged();
        this.notifyObservers(this);
*/
  
}
