import java.io.IOException;
import java.util.Scanner;
/**
 * An implementation of a language flashCard application that cycles through all
 * the cards until user answers all correctly or quits the game
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class LanguageFlashCardApplication {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the filename containing your flashcards? Exact letters!");
     
        LanguageFlashCards cards = new LanguageFlashCards(scanner.next());
        
        String command = "Y";
        while(command.toLowerCase().equals("y")){ //Game continues if the deck is not empty and user has not quit
            if(!cards.nextCard()) {
                System.out.println("Congratulations! You finished the deck!");//This was the last card. No point asking if user wants to continue since they finished the deck
                break; 
            }   
            System.out.println("Score = " + cards.getScore());
            System.out.println("Next? (Y or N)");
            command = scanner.next();
            while(!command.toLowerCase().equals("y") && !command.toLowerCase().equals("n")){ // If user gives a invalid input. User will be prompted to do it again until they give a proper input
                System.out.println("Sorry, that's not a valid input. Please enter Y or N");
                command = scanner.next();
            }
        }
        System.out.println("You've got a score of " + cards.getScore() + " so far");
    }
}
