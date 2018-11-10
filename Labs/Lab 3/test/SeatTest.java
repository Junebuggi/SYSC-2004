/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bailey

 */
public class SeatTest {
    
    Seat    seat1, seat2;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
	seat1 = new Seat(1, 125.0);
	seat2 = new Seat(2, 50.0);
        
    }

    @Test
    public void testCreateSeat()
{
	assertEquals(1, seat1.getNumber());
	assertEquals(125.0, seat1.getPrice(), 1.25);		
	assertEquals(false, seat1.isBooked());
	assertEquals(2, seat2.getNumber());
	assertEquals(50.0, seat2.getPrice(), 0.5);
	assertEquals(false, seat2.isBooked());
	}
    @Test
    public void testBooking()
	{
	assertEquals(true, seat1.book());
	assertEquals(true, seat1.isBooked());
	assertEquals(false, seat1.book());
	assertEquals(true, seat1.isBooked());
	}
    @Test
    public void testCancelBooking()
    {
	assertEquals(false, seat1.cancelBooking());
	assertEquals(true, seat1.book());
	assertEquals(true, seat1.cancelBooking());
	assertEquals(false, seat1.isBooked());
	assertEquals(false, seat1.cancelBooking());
	assertEquals(false, seat1.isBooked());
    }
    
    @Test
    public void testtoString()
    {
        
	assertEquals("Seat 1 (125.0,false)", seat1.toString());
        seat1.book();
        assertEquals("Seat 1 (125.0,true)", seat1.toString());
	
    }
}
