package shapesTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import shapes.Triangle;

/**
 *
 * @author Schramm
 */
public class TriangleTest {
    
    public TriangleTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testConstructor() {
      Triangle r = new Triangle(5.0,6.0);
      assertEquals(5.0, r.getBase(), 0.001);
      assertEquals(6.0, r.getHeight(), 0.001);
    }
    
    @Test
    public void testConstructorNegativeBase() {
        try {
            Triangle r = new Triangle(-5,6);
            fail();
        } catch (IllegalArgumentException e) { }

    }
    @Test
    public void testConstructorNegativeHeight() {
        try {
            Triangle r = new Triangle(5,0);
            fail();
        } catch (IllegalArgumentException e) { }

    }
    
    @Test
    public void testPerimeter() {
        Triangle r = new Triangle(5.0 ,6.0);
        // Using https://math.stackexchange.com/questions/80397/can-we-find-the-perimeter-of-a-triangle-given-only-its-base-and-height
        double expected  = (6.0*6.0*4.0) + (5.0*5.0);
        expected = Math.sqrt(expected) + 5.0;
        assertEquals( expected, r.perimeter(), 0.001);
    }
    
     @Test
    public void testArea() {
        Triangle r = new Triangle(5.0 ,6.0);
        assertEquals(0.5*5.0*6, r.area(), 0.001);
    }
    
    @Test
    public void testToString() {
        Triangle r = new Triangle(5.0, 6.0);
        assertEquals ("b=5.0 x h=6.0", r.toString());
    }
}
