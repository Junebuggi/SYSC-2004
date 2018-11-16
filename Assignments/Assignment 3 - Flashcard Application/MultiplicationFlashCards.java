/**
 * Models a set of flashCards used to study 12 times tables
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class MultiplicationFlashCards extends AbstractFlashCards{
    /**
     * Creates a set of 12 flashCards for the multiplier's times table
     * @param multiplier The times table we want to study
     */
    public MultiplicationFlashCards(int multiplier){
        this(new int[]{multiplier}); //Uses constructor chaining to pass an integer array (of size one) containing the integer value multiplier
    }
    /**
     * Creates a set of 12 flashCards for each multiplier's times tables in the given array
     * @param multiplier An integer array representation the times tables we want to study
     */
    public MultiplicationFlashCards(int[] multiplier){
        super(); // Initializes all variables in the super class
        for(int j = 0; j < multiplier.length ; j++){
            for(int i = 1; i <= 12; i++ ){
                String key = "" + multiplier[j] + " * " + i;
                String value = "" + multiplier[j] * i;
                super.addCard(key,value);
            } 
        }
        super.reset(); // Shuffle the deck for a random order
    }
}
