package _Part1_InheritanceAndClassObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author schr
 */
public class SubSubClassTest {
    
    public SubSubClassTest() {
    }
    
    @Test
    public void testConstructorChains() throws MalformedURLException  {
        
        MyClass object = new MyClass(5, "MyClass");
        SubClass subObject = new SubClass(6,7, "SubClass", new Integer(55));
        SubSubClass subSubObject = new SubSubClass (8,9,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
              
        Assert.assertEquals(5, object.getA());
        Assert.assertEquals(12, subObject.getA());
        Assert.assertEquals(160, subSubObject.getA());
       
        Assert.assertEquals(7, subObject.getB());
        Assert.assertEquals(90, subSubObject.getB());
        
        Assert.assertEquals(10, subSubObject.getC());
        
        // Assert.assertEquals(7, object.getB());
        // Assert.assertEquals(7, subObject.getC());
    }
    
    @Test
    public void testtoStringChains() throws MalformedURLException  {
        
        MyClass object = new MyClass(5, "MyClass");
        SubClass subObject = new SubClass(6,7, "SubClass", new Integer(55));
        SubSubClass subSubObject = new SubSubClass (8,9,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
        Assert.assertEquals("a = 5 MyClass", object.toString());
        Assert.assertEquals("a = 6 SubClass / b = 7 55", subObject.toString());
        Assert.assertEquals("a = 8 SubSubClass / b = 9 77 / c = 10 http://www.google.com", subSubObject.toString());
        
    }
    
    @Test
    public void testEqualsChains() throws MalformedURLException {
        
        MyClass object = new MyClass(5, "MyClass");
        SubClass subObject = new SubClass(6,7, "SubClass", new Integer(55));
        SubSubClass subSubObject = new SubSubClass (8,9,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
 
        MyClass object1 = new MyClass(5, "MyClass");
        SubClass subObject1 = new SubClass(6,7, "SubClass", new Integer(55));
        SubSubClass subSubObject1 = new SubSubClass (8,9,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
            
        MyClass object2 = new MyClass(9, "MyClass");
        SubClass subObject2 = new SubClass(6,7, "SubClass", new Integer(85));
        SubSubClass subSubObject2 = new SubSubClass (8,0,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
        
        
        Assert.assertFalse(object.equals(null));  // Null            
        Assert.assertTrue(object.equals(object));  // Reflexive  
        Assert.assertTrue(object.equals(object1));  // Deep  
        Assert.assertTrue(object1.equals(object));  // Symmetric to previous     
        
        Assert.assertFalse(subObject.equals(null));  // Null            
        Assert.assertTrue(subObject.equals(subObject));  // Reflexive  
        Assert.assertTrue(subObject.equals(subObject1));  // Deep  
        Assert.assertTrue(subObject1.equals(subObject));  // Symmetric to previous     

        Assert.assertFalse(subSubObject.equals(null));  // Null            
        Assert.assertTrue(subSubObject.equals(subSubObject));  // Reflexive  
        Assert.assertTrue(subSubObject.equals(subSubObject1));  // Deep  
        Assert.assertTrue(subSubObject1.equals(subSubObject));  // Symmetric to previous     
        
        Assert.assertFalse(subSubObject.equals(object));             
        Assert.assertFalse(subObject.equals(subSubObject));  
        Assert.assertFalse(subSubObject.equals(object1));  
        Assert.assertFalse(object1.equals(subSubObject1));                                     
                        
                        
                        
    }
    
}
