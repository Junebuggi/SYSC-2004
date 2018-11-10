/**
 * Car models car in a passenger train.
 *
 * @author L.S. Marshall, SCE
 * @version 1.01 October 9, 2007
 * @version 1.2 January 2018 - printTicket now returns String, method uses getId() convention
 */

public class Car
{
    /** This car's identifier. */
    private int id;
   
    /**
     * true == this car is a business-class car,
     * false == this car is an economy-class car.
     */
    private boolean businessClass;
    
    public static final double BUSINESS_SEAT_COST = 125.0;
    public static final double ECONOMY_SEAT_COST = 50.0;    
  
    /** The number of seats in a car. */
    public static final int ECONOMY_SEATS = 40;
    public static final int BUSINESS_SEATS = 30;    
   
    /** The list of this car's seats. */
    private Seat[] seats;
   
    /**
     * Constructs a new Car object with the specified id.
     * If parameter isBusinessClass is true, the car is a business-class
     * car. If parameter isBusinessClass is false, the car is an
     * economy-class car.
     */
    public Car(int carId, boolean isBusinessClass)
    {
       id = carId;
       businessClass = isBusinessClass;
       if(isBusinessClass == true){seats = new Seat[BUSINESS_SEATS];}
       else{seats = new Seat[ECONOMY_SEATS];}
       double cost;
       if(isBusinessClass == true){cost = BUSINESS_SEAT_COST;}
       else{cost = ECONOMY_SEAT_COST;}
       for(int i = 1; i <= seats.length; i++){seats[i-1] = new Seat( i, cost);}
    }
       

    public int getNumberOfSeats() {
        if(businessClass == true){return BUSINESS_SEATS;}
       else{return ECONOMY_SEATS;}
    }
    public double getCost(int seatNo) { 
        return seats[0].getPrice();
    }
    public boolean isBooked(int seatNo) { return seats[seatNo].isBooked(); } 
    
    public int getNumberofFreeSeats() { 
        int freeSeats = seats.length;
        for(int i = 0; i < seats.length; i++){
            if(seats[i].isBooked() == true){ --freeSeats;}
        }
	return freeSeats;
    }
    /** 
     * Returns true if this is a business-class car,
     * false if this is an economy-class car.
     * @return
     */
    public boolean isBusinessClass()
    {
        return businessClass;
    }
 
    /**
     * Returns the id of this car.
     */
    public int getId()
    {
        return id;
    }
  
    /**
     * This method is called when the specified seat has been booked,
     * to print a ticket for that seat.
     * @return Returns a string representation of the ticket
     */
    private String printTicket(int seatNo)
    {
	
        return "Car: " + id + "\nSeatNo: " + (seatNo + 1);
    }   
 
    /**
     * Attempts to book a seat. If successful, this method prints a 
     * String containing the ticket
     * If no seats are available, this method returns null.
     * Throws IllegalStateException if internal inconsistency found.
     * (exception optional)
     */
    public String bookNextSeat()
    {
        for(int i = 0; i < seats.length; ){
            if(seats[i].isBooked() == false){
                seats[i].book();
                System.out.println(printTicket(i));
                return printTicket(i);
            }
            i++;
        }   
        return null;
        
    }

    /** 
     * Cancels the booking for the specified seat, which must be between
     * 1 and the maximum number of seats in the car.
     * If the seat number is valid and if the seat has been reserved, this
     * method cancels the booking for that seat and returns true. 
     * If the seat number is not valid, this method returns false. 
     * If the seat number is valid, but the seat has not been reserved, 
     * this method returns false.
     * Throws IllegalStateException if internal inconsistency found.
     * (exception optional)
     * @param seatNo
     * @return 
     */
    public boolean cancelSeat(int seatNo)
    {
        if(seatNo <= 0 || seatNo > getNumberOfSeats()){
            return false;
        }
           
        
        if(seats[seatNo-1].isBooked() == true){
            seats[seatNo-1].cancelBooking();
            return true;
        }
        
            return false;
        
	
    }    
    
    @Override
    public String toString() {
	return "Car " + id +" : " + getNumberofFreeSeats() + " free, $" + getCost(1);
    }
}
