package lab4Part2;
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Schramm
*/

public class Lab4 {
   
   public static void main(String args[]) {
       
       MyClass object = new MyClass(5);
       SubClass subObject = new SubClass(6,7);
       SubSubClass subSubObject = new SubSubClass (8,9,10);
       
       System.out.println("object : " + object);
       System.out.println("subObject : " + subObject);
       System.out.println("subSubObject : " + subSubObject);
       
       
       int value;
       
       value = object.getA();
       value = subObject.getA();
       value = subSubObject.getA();
       // value = + object.getB();   Can't look "down"
       value = subObject.getB();
       value = subSubObject.getB();
       
       // value = object.getB();       Can't look "down"
       // value = subObject.getC(); Can't look "down"
       value = subSubObject.getC();
                               
       
  
   }
   
}

