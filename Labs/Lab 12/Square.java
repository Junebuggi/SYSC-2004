package Lab8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mark
 */
public abstract class Square{
    private String name;
    private int number;
    
    public Square(String name, int number){
        this.name = name;
        this.number = number;
    }
    public String getName(){
        return this.name;   
    }
    
    public int getNumber(){
        return this.number;
    }
    public abstract void landOn(Player p) throws Exception;
}
