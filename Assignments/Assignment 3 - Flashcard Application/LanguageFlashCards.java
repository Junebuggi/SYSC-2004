import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
        super();
        this.filename = filename;
        try {
            FileReader file = new FileReader(filename);
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            line = reader.readLine();     //The first line is the headings, which are not needed
      
            while( line != null){
                String[] column = line.split(COMMA_DELIMITER);
                super.addCard(column[0], column[1]);
                line = reader.readLine();
            }
            try { 
                reader.close();
            } catch (IOException e){
            }
        }   catch (FileNotFoundException e) {
        }     
    }
        
        
        
    }

