/**
 * Seat models a seat in a car in a passeger train.
 *
 * @author D.L. Bailey, SCE
 * @version 1.00 January 28, 2007
 * @version January 2018 - Added toString()
 */
public class Seat
{
    private int number;     // the seat's number
    private boolean booked; // has this seat has been reserved?
    private double price;   // the cost of a ticket for this seat, in dollars

    /**
     * Constructs a new Seat with the specified seat number and
     * ticket price.
     */
    public Seat(int seatNo, double cost)
    {
        booked = false;
        number = seatNo;
        price = cost;
    }

    /**
     * Returns the cost of purchasing a ticket for this Seat.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns this seat's number.
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Returns true if someone has purchased a ticket
     * for this this Seat.
     */
    public boolean isBooked()
    {
        return booked;
    }

    /**
     * If this seat is available, books it and returns true.
     * If the seat is not available, returns false.
     */
    public boolean book() 
    {
        if (!booked) {
            booked = true;
            return true;
        }
        return false;
    }

    /**
     * If this seat is booked, cancels the booking and returns true.
     * If the seat was not booked, returns false.
     */
    public boolean cancelBooking() 
    {
        if (booked) {
            booked = false;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        
        if(booked == false){return "Seat " + number + " (" + price + ",false)";}
        else{return "Seat " + number + " (" + price + ",true)";}
}
    public static void main(String[] args) { 
        Seat seat5 = new Seat(5, 25.00);
        int number = seat5.getNumber();
        double price = seat5.getPrice();
        boolean booked = seat5.isBooked();
        
        System.out.println(seat5.toString());
        
        booked = seat5.book();
        booked = seat5.isBooked();
        System.out.println(booked);   // true: the seat is booked (reserved)
        
        booked = seat5.isBooked();
        System.out.println(booked);  // true: the seat is still booked (reserved)
        
        
        booked = seat5.cancelBooking();
        System.out.println(booked); //true: the seat was canclled properly 

        booked = seat5.isBooked();  //false: the seat is not booked anymore
        System.out.println(booked);
        
        
        
        
    }
}
