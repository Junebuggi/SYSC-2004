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
public class IncomeTaxSquare extends Square{
    private int maximumTax;
    public IncomeTaxSquare(int maxTax){
        super("Income Tax", maxTax);
        this.maximumTax = 200;
    }
    
    @Override
    public void landOn(Player p){
        p.setLocation(this);
        int income = p.netWorth() / 10;
        if(income < maximumTax) p.decreaseCash(income);
        else p.decreaseCash(maximumTax);
                
    }
    

    
}
