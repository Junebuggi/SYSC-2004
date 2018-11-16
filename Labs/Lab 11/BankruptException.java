
/**
 *
 * @author emmaboulay
 */
public class BankruptException extends Exception {
    private int deficit;
    public BankruptException(int deficit){
        this.deficit = deficit;
    }
    public int getDeficit(){
        return this.deficit;
    }
    
}
