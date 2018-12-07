/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmaboulay
 */
public class StackOverFlowException extends Exception{
    private Object o;
    
    public StackOverFlowException(){
        this(null, null); // or this(null);
    }
    public StackOverFlowException(String msg){
        this(msg, null);
    }
    
    public StackOverFlowException(String msg, Object o){
        super(msg);
        this.o = o;   
    }
}
