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
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
 
        String[] parts = scanner.nextLine().split(" "); //Turns a user input string "2 3 4 5" into an array of ints [2,3,4,5]
        int[] nums = new int[parts.length];
        for(int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        
        MultiplicationFlashCards cards = new MultiplicationFlashCards(nums);   
        
        String command = "Y";
        while(command.toLowerCase().equals("y")){ //Game continues if the deck is not empty and user has not quit
            if(!cards.nextCard()) {
                System.out.println("Congratulations! You finished the deck!"); //This was the last card. No point asking if user wants to continue since they finished the deck
                break; 
            }   
            System.out.println("Score = " + cards.getScore());
            System.out.println("Next? (Y or N)");
            command = scanner.next();
            while(!command.toLowerCase().equals("y") && !command.toLowerCase().equals("n")){ // If user gives a invalid input. User will be prompted to do it again until they give a proper input
                System.out.println("Sorry, that's not a valid input. Please try again");
                command = scanner.next();
            }
        }
        System.out.println("You've got a score of " + cards.getScore() + " so far");
    }  
}
