import java.util.Scanner;
/**
 * An implementation of a multiplication flashCard application that cycles through all
 * the cards until user answers all correctly or quits the game
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class MultiplicationFlashCardApplication {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
 
        String[] parts = scanner.nextLine().split(" "); //Turns a string "2 3 4 5" into an array of ints [2,3,4,5]
        int[] nums = new int[parts.length];
        for(int i = 0; i < parts.length; i++) {
        nums[i] = Integer.parseInt(parts[i]);
        }
        
        MultiplicationFlashCards cards = new MultiplicationFlashCards(nums);   
        cards.reset();
        
        String next = "Y";
         while(cards.hasNext() && (next.equals("Y") || next.equals("y"))){
            cards.nextCard();
            System.out.println("Next? (Y or N)");
            next = scanner.next();
        }
        System.out.println("You've got a score of " + cards.getScore() + " so far");
    }
    
 
    
}
