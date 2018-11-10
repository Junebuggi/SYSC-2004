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
        cards.reset(); // Shuffle the deck to begin
        String next = "Y";
        
        while(cards.hasNext() && (next.equals("Y") || next.equals("y"))){
            cards.nextCard();
            System.out.println("Next? (Y or N)");
            next = scanner.next();
        }
        System.out.println("You've got a score of " + cards.getScore() + " so far");
    }  
}
