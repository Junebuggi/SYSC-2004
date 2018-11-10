package assignment1_Dice;

import java.util.Date;
import java.util.Random;
/**
 *
 * @author emmaboulay
 */

public class Dice{
       //Declares an instance variable 'die' that is a reference to an array of ints            	
    private int[] die;
       //Declares an instance variable 'random' that is a reference to a random number generator
       //random instance variable is now initialized to a new random number generator
    private Random random;
    
    public Dice(){	
        this(2);
        random = new Random(new Date().hashCode());
        roll(); //Initializes all die in array
    }
    
    public Dice(int numDice){
        if (numDice < 1) 
            throw new IllegalArgumentException ("Invalid number. Number of dice must be greater than 0");

        // Die instance variable is now initialized to an array of numDice ints
       this.die = new int[numDice];
       random = new Random(new Date().hashCode());
       roll(); //Initializes all die in array 
       
    }
    
    //Rolls all of the dice at once and returns their total value
    public int roll(){
        int sum = 0;
        for(int i = 0; i < this.die.length ; i++ ){  // Goes through array of die and randomly assigns a number from 1 to 6 by invoking the private method rollDie()
            this.die[i] = rollDie();
            sum += this.die[i];                      // Sums up
        } 
        return sum;
    }
    
    //Rolls a single die and ensures that the number rolled is [1,6]
    private int rollDie(){
        return this.random.nextInt(6) + 1;
    }
    
    //Returns a defensive copy of an array of all the individual die-values 
    public int[] getDieValues(){
        int[] defensiveDie = new int[this.die.length];
        for(int i = 0; i < this.die.length; i++) {	//Copies (not aliases) each value from the die array into the defensiveDie array
        	defensiveDie[i] = this.die[i];
        }
        return defensiveDie;
    }
    
    //Returns true if there are any double-values amongst the die-values
    public boolean hasDoubles(){
        int n = this.die.length;
        //Use the Bubble Sort technique to order array
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (this.die[j] > this.die[j+1])
                {
                    // swap temp and die[i]
                    int temp = this.die[j];
                    this.die[j] = this.die[j+1];
                    this.die[j + 1] = temp;
                }
        //Loop returns true if element i and i+1 are the same
        for (int i = 0; i < n - 1; i++){
            if(this.die[i] == this.die[i + 1]) { 
                return true;
            }
        }
        return false;
    }
    
    @Override
    //Returns a space-separated list of all the individual die-values
    public String toString(){
        String str = ""; 
        for (int i = 0; i < this.die.length; i++){
            str += this.die[i] + " ";
        }
        return str;
    }
    
}
