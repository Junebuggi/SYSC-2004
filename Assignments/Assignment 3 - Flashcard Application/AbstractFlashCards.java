import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
/**
 * Models a deck of flashcards and allows for the implementation of a 
 * variety of flashcards (eg. languages, math)
 * 
 * @author emmaboulay
 * @version 1.0
 */
public abstract class AbstractFlashCards {
    private HashMap<String, String> flashCards; // contains original complete deck of flashcards. With the question as the key and the answer as the value
    private ArrayList<String> unansweredCards; // a randomly-ordered copy of all questions
    private int score;
    private Scanner scanner;
    private Random random;
    /**
     * Initializes all necessary variables to begin constructing a deck of flashCards 
     */
    public AbstractFlashCards(){
        this.flashCards = new HashMap<>();
        this.unansweredCards = new ArrayList<>();
        this.score = 0; 
        this.scanner = new Scanner(System.in);
        this.random = new Random(new Date().hashCode());
    }
    /**
     * Puts a (question,answer) entry into the flashCards hashmap
     * @param question A string representation of the question
     * @param answer  A string representation of the answer
     */
    protected void addCard(String question, String answer){
        flashCards.put(question, answer);
        
    }
    /**
     * Does not alter the existing flashCards. Instead it is used to
     * re-shuffle the entire deck, meaning it clears out unansweredCards
     * and creates a new random ordering of the questions and sets score to 0
     */
    public void reset(){
        this.score = 0;
        unansweredCards.clear();
        ArrayList<String> temp = new ArrayList<>();  
        flashCards.keySet().forEach((key) -> { 
            temp.add(key); // creates a temporary arraylist consisting of every question in flashCards
        }); 
        while(!temp.isEmpty()){ //removes a random question from temp and appends it to the end of the now empty unansweredCards until temp is empty
           unansweredCards.add(temp.remove(random.nextInt(temp.size()))); 
        }
        System.out.println(unansweredCards);
    }
    /**
     * @return true if there are any remaining unasweredCards 
     */ 
    public boolean hasNext(){
        return !(unansweredCards.isEmpty());
    }
    /**
     * Prints the next unansweredCard and reads in the user's answer. If
     * the answer is correct, the card is removed from unansweredCards,
     * the user's score increases, and the method returns true. If the answer
     * is incorrect, the card is re-inserted at a random place in unansweredCards
     * and the method returns true
     * @return true if the deck still has unansweredCards remaining
     */
    public boolean nextCard(){
        String question = unansweredCards.remove(0);
        System.out.println(question);
        String guess = scanner.next();
        if(guess.equals(flashCards.get(question))){ //true if your answer is equal to the flashcard's answer
            ++score;
            System.out.println("You're correct!");
        }
        else{
            System.out.println("Sorry, please try again");
            unansweredCards.add(random.nextInt(unansweredCards.size()),question);  //the question is re-inserted at a random location in the deck
            System.out.println(unansweredCards);
        }
        return hasNext();
    }
    /**
     * Returns an integer representation of player's current score
     * @return player's score
     */
    public int getScore(){
        return this.score;
    }
}
