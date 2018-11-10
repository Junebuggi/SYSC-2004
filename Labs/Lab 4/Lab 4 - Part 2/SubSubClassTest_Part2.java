package lab4Part2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
//import static org.junit.Assert.*;

/**
 *
 * @author schr
 */
public class SubSubClassTest_Part2 {
    
    public SubSubClassTest_Part2() {
    }
    
    @Test
    public void testConstructorChains()  {
        MyClass object = new MyClass(5);
        SubClass subObject = new SubClass(6,7);
        SubSubClass subSubObject = new SubSubClass (8,9,10);
        
        Assert.assertEquals("a = 5", object.toString());
        Assert.assertEquals("a = 6 b = 7", subObject.toString());
        Assert.assertEquals("a = 8 b = 9 c = 10", subSubObject.toString());
        
        Assert.assertEquals(5, object.getA());
        Assert.assertEquals(12, subObject.getA());
        Assert.assertEquals(160, subSubObject.getA());
       
        Assert.assertEquals(7, subObject.getB());
        Assert.assertEquals(90, subSubObject.getB());
        
        Assert.assertEquals(10, subSubObject.getC());
        
        // Assert.assertEquals(7, object.getB());
        // Assert.assertEquals(7, subObject.getC());
    }
    
    
}
    
   
