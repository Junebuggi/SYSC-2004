import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Models a set of flashcards used to study languages
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class LanguageFlashCards extends AbstractFlashCards{
    private final static String COMMA_DELIMITER = ",";
    private String filename;
    /**
     * Cards are read in from a user inputed file 
     * @param filename A string representation of the filename
     * @throws IOException 
     */
    public LanguageFlashCards(String filename) throws IOException{
        super(); // Initializes all variables in the super class
        this.filename = filename;
        BufferedReader reader = null;
        try {
            FileReader file = new FileReader(filename);
            reader = new BufferedReader(file);
            String line = reader.readLine();
            line = reader.readLine();     //The first line is the headings, which are not needed so we skip that line
            
            while( line != null){
                String[] column = line.split(COMMA_DELIMITER); //splits each line into two parts: question (column[0]) and answer (column[1])
                super.addCard(column[0], column[1]);
                line = reader.readLine();  // reads the next line
            }
            super.reset(); //Shuffle the deck
        }
        catch(IOException ee) {
            System.out.println("File not found");
        }
        finally {
            try {
                reader.close();
            }
            catch(IOException ie) {
                System.out.println("Error occured while closing the BufferedReader");
            }
        }
    }
}


