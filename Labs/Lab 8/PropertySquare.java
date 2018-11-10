/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

/**
 *
 * @author mark
 */
public class PropertySquare extends Square {
    private int price;
    private int rent;
    private Player owner;
    
    public PropertySquare(String name, int number, int price, int rent){
        super(name, number);
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }
    @Override
    public void landOn(Player p) throws Exception{
        p.setLocation(this);
        if(owner == null) {
            if(p.netWorth() >= this.price){
                p.decreaseCash(price);
                this.owner = p;
                return;
            }
            else {return;}
        }   
   
        if(this.rent > p.netWorth()) {
            owner.increaseCash(p.netWorth());
            p.decreaseCash(p.netWorth());
            throw new Exception("Player is out of money");
        }
        else{
            p.decreaseCash(rent);
            owner.increaseCash(rent);
        }
        
               
    }
    
}
