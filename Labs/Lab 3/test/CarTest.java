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
 * @author Schramm
 */
public class CarTest {
    
    @Test
    public void testCreateBusinessCar()
    {
        Car aCar = new Car(1385, true);
        
        /* Verify that the car has the right number of seats. */
        assertEquals(Car.BUSINESS_SEATS, aCar.getNumberOfSeats());
        
        /* Verify that each seat has the correct number and price and availability */
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            // assertEquals(i+1, aCar.getSeatNumber(i));   // Not provided by API
            //                                            // Can check it through bookNextSeat()
            assertEquals(Car.BUSINESS_SEAT_COST, aCar.getCost(i), 0.001);
            assertEquals(false, aCar.isBooked(i));
        }
    }
    
    @Test
    public void testCreateEconomyCar()
    {
        Car aCar = new Car(1400, false);
        
        /* Verify that the car has the right number of seats  */        
        assertEquals(Car.ECONOMY_SEATS, aCar.getNumberOfSeats());
        
        /* Verify that each seat has the correct number and price and availability */       
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            // assertEquals(i+1, aCar.getSeatNumber(i))); // Not provided by API
            //                                            // Can check it through bookNextSeat()
            assertEquals(Car.ECONOMY_SEAT_COST, aCar.getCost(i), 0.001);
            assertEquals(false, aCar.isBooked(i));
        }
    }    
    
    @Test
    public void testID()
    {
         Car aCar;
         aCar= new Car(1385, true);
         assertEquals(1385, aCar.getId());
         aCar = new Car(1400, false);
         assertEquals(1400, aCar.getId());
    }
    
    @Test
    public void testtoString()
    {
         Car aCar;
         aCar= new Car(1385, true);
         assertEquals("Car 1385 : 30 free, $125.0", aCar.toString());
    }
    
    @Test
    public void testIsBusinessClass()
    {
         Car aCar;
         aCar = new Car(1385, true);
         assertTrue(aCar.isBusinessClass());
         aCar = new Car(1400, false);
         assertFalse(aCar.isBusinessClass()); 
    }
    
    @Test
    public void testBookNextSeat()
    {
        Car aCar;
        aCar = new Car(1234, true);
        
        /* Verify that no seats are booked. */
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            assertFalse(aCar.isBooked(i));
        }        
        
        /* Verify that the seats are booked consecutively,
         * starting with Seat #1.
         */
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            assertNotNull(aCar.bookNextSeat());
                // TBD Should actually check full String representation of ticket.
            assertTrue(aCar.isBooked(i));
        }
        
        /* Try to book a seat now that all the seats have been booked. */
        assertEquals(aCar.bookNextSeat(),null);
    }
    
    @Test
    public void testCancelSeat()
    {
        Car aCar;
        aCar = new Car(1234, true);
        
        /* Cancel seat 0. cancelSeat() should return false, as there
         * is no seat 0.
         */
        assertFalse(aCar.cancelSeat(0));
        
        /* Try cancelling a seat whose number is one higher than 
         * the highest valid seat number. cancelSeat() should 
         * return false.
         */
        assertFalse(aCar.cancelSeat(aCar.getNumberOfSeats() + 1));
        
        /* Try cancelling all the seats in the car, even though 
         * they haven't been booked. cancelSeat() should 
         * return false.
         */
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            assertFalse(aCar.cancelSeat(i+1));
        }
        
        /* Book all the seats */
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            aCar.bookNextSeat();
        }  
        
        /* Try cancelling all the seats in the car.
         */
        for (int i = 0; i < aCar.getNumberOfSeats(); i++) {
            assertTrue(aCar.cancelSeat(i+1));
        }        
    }      
}
