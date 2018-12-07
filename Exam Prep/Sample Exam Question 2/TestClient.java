
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmaboulay
 */
public class TestClient {
    
    public static void main(String[] args) {

        try {
            Stack s = new Stack();
            
            s.push(1);
            s.push(2);
            int i = (int) s.pop();
            
            
            System.out.println(i);
        } catch (StackOverFlowException e1) {}
          catch (StackUnderFlowException e2) {}
        
    }
}
