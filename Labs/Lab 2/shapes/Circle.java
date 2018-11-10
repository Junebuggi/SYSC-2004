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
public class Circle {
    
    private double radius;
    
    public Circle(double radius){
        if (radius <= 0.0)
           throw new IllegalArgumentException ("Shape's dimensions must be positive values");
        this.radius = radius;
    }
    
    public double perimeter( ){return 2.0 * radius * Math.PI;}
    public double area(){return Math.PI * radius * radius;}
    public double getRadius(){return radius;}
    
    @Override
    public String toString() { 
        return "r=" + this.radius;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Circle c = (Circle)other;
        return (Math.abs(this.radius - c.radius) < 0.001);
    } 

  }

