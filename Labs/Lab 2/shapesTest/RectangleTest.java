package shapesTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import shapes.Rectangle;

/**
 *
 * @author Schramm
 */
public class RectangleTest {
    
    public RectangleTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testConstructor() {
      Rectangle r = new Rectangle(5.0,6.0);
      assertEquals(5.0, r.getLength(), 0.001);
      assertEquals(6.0, r.getWidth(), 0.001);
    }
    
    @Test
    public void testConstructorNegativeLength() {
        try {
            Rectangle r = new Rectangle(-5,6);
            fail();
        } catch (IllegalArgumentException e) { }

    }
    @Test
    public void testConstructorNegativeWidth() {
        try {
            Rectangle r = new Rectangle(5,0);
            fail();
        } catch (IllegalArgumentException e) { }

    }
    
    @Test
    public void testPerimeter() {
        Rectangle r = new Rectangle(5.0 ,6.0);
        assertEquals( 22.0, r.perimeter(), 0.001);
    }
    
     @Test
    public void testArea() {
        Rectangle r = new Rectangle(5.0 ,6.0);
        assertEquals( 30.0, r.area(), 0.001);
    }
    
    @Test
    public void testToString() {
        Rectangle r = new Rectangle(5.0, 6.0);
        assertEquals ("l=5.0 x w=6.0", r.toString());
    }
}
