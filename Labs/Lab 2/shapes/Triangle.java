/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author emmaboulay
 */
public class Triangle {
    private double base;
    private double height;
    
    public Triangle(double base, double height){
        if (base <= 0.0 || height <= 0.0)
           throw new IllegalArgumentException ("Shape's dimensions must be positive values");
        this.base = base;
        this.height = height;
    }
    
    public double getBase(){ return base;}
    public double getHeight(){ return height;}
    public double perimeter(){return base + Math.sqrt((base * base) + (4 * height * height));}
    public double area(){return 0.5 * base * height;}
    
    @Override
    public String toString() { 
        return "b=" + this.base + " x h=" + this.height;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Triangle b = (Triangle)other;
        return ((Math.abs(base - b.base) < 0.001) && 
                (Math.abs(height - b.height) < 0.001));
    } 

  }
            
            
 
