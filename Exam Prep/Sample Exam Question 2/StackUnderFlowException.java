
/**
 *
 * @author emmaboulay
 */

 public class StackUnderFlowException extends Exception{
    public StackUnderFlowException(){
        this(null);
    }
    public StackUnderFlowException(String msg){
        super(msg);
    }
}
