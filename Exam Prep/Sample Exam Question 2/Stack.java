
/**
 *
 * @author emmaboulay
 */
public class Stack {
    private static final int LIMIT= 3;
    private Object[] stack;
    private int top;
   
    public Stack(){
        stack = new Object[LIMIT];
        top = 0;
    }

    public void push(Object o) throws StackOverFlowException{
        if(top == LIMIT)
            throw new StackOverFlowException("Stack if full!", o);
        else
            stack[top++] = o; //access at top then increment

    }
    public Object pop() throws StackUnderFlowException{
        if (top == 0)
            throw new StackUnderFlowException("Stack is empty!");
        else
            return stack[--top];
    }
}
