/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmaboulay
 */

import java.util.Random;
import shapes.Circle;


public class Lab2c {
    
    
    public static void main(String args[]) {
        Circle[] circles = new Circle[10];
        Random randomGenerator = new Random();
        int radius;
        
        for (int i = 0; i < 10; i++){
            radius = randomGenerator.nextInt(90) + 1;
            circles[i] = new Circle(radius);
        }
        
        for (int i = 0; i < 10; i++){
            System.out.println("Circle " + i + "(" + circles[i].getRadius() + ") : Area = " + circles[i].area() + ", Perimeter = " + circles[i].perimeter());
        
        }
        
        
        
}
    
    
    
}
