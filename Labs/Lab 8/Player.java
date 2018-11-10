package Lab8;
import java.util.ArrayList;

/**
 * Models a player in a simulated game of Monopoly.
 * 
 * @author D.L. Bailey, SCE, Carleton University 
 * @version 1.03 March 26, 2006
 * @version 2018 - Adapted by Schramm
 */
public class Player implements Comparable 
{
    /** This player's name. */
    private String name;
    
    /** The square where this player is located. */
    private Square location;
    
    /** The amount of money this player has. */
    private int cash;    
       
    /**
     * Constructs a new player with the specified name. The player is
     * placed in the board's starting square.
     */
    public Player(String name, Square startSquare)
    {
        this.name = name;
        this.cash = 1500;
        location = startSquare; 
    }
  
    public Square getLocation( ) { 
        return this.location;
    }
    
    public void setLocation(Square newLocation)
    {
        location = newLocation;
    }
    
    /**
     * Returns this player's net worth.
     */
    public int netWorth()
    {
        /* Currently, a player's net worth is the player's cash-on-hand.
         * Eventually, it will include the worth of any properties the player
         * owns.
         */
        return cash;
    }

    /**
     * Increases the amount of money held by this Player by the specified
     * amount.
     */
    public void increaseCash(int amount)
    {
        cash += amount;
    }

    /**
     * Reduces the amount of money held by this Player by the specified
     * amount.
     */    
    public void decreaseCash(int amount)
    {
        cash -= amount;
    }
    
    @Override
    public int compareTo(Object o) {
        if(o == null) throw new NullPointerException();
        if (this.getClass() != o.getClass()) throw new ClassCastException();
        Player p = (Player) o;
        if (this.cash == p.cash) return 0;
        if(this.cash > p.cash) return 1;
        return -1;
    }
}
