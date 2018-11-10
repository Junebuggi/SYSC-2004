package lab1;

/**
 *
 * @title Lab 3 - Objective 3
 */

import java.util.Date;
import java.util.Random;

public class Lab1_3 {
    
    public static int NUM_RECTANGLES = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Rectangle r1 = new Rectangle(10,20);
        
        System.out.println("Rectangle r1 ("+r1.getLength()+","+r1.getWidth()+")");
        System.out.println("\tArea = " + r1.area());
          // Notice the use of the tab character \t
          
        // Task 1 : On the next line, print out the perimeter, similarly tabbed
        System.out.println("\tPerimeter = " + r1.perimeter());
        
        
        // Task 2: Create a second rectangle called r2 with length = 20, width=10.
        
        Rectangle r2 = new Rectangle(20, 10);        
        
        //  DO NOT CHANGE THE FOLLOWING CODE
        
        Rectangle rectangles[] = new Rectangle[NUM_RECTANGLES];
        Random randomGenerator = new Random();
        int width, length;
        for (int i=0; i< rectangles.length; i++)
        {
            width = randomGenerator.nextInt(49) + 1;
            length = randomGenerator.nextInt(49) + 1;
            rectangles[i] = new Rectangle(length, width);
        }
        
        // Task 3 : Print out all randomly generated rectangles, one per line.
        //   Each line should print EXACTLY: r[i] = (w,l)
        for(int i = 0; i < rectangles.length; i++){
            System.out.println("r[" + i + "] = (" + rectangles[i].getLength() + ", " + rectangles[i].getWidth() + ")");
        }
        
        // Task 4 : Search and print out the information for the rectangle with
        //   the largest area

        int max = rectangles[0].area();
        for(int i = 1 ; i < rectangles.length; i++){
            if(max < rectangles[i].area()){
                max = rectangles[i].area();
            }
            }
        System.out.println("The largest area is: " + max);
        
        
        // Task 5 : Search and print out the information for the rectangle with
        //   the shortest perimeter
        int min = rectangles[0].area();
        for(int i = 1 ; i < rectangles.length; i++){
            if(min > rectangles[i].area()){
                min = rectangles[i].area();
            }
            }
        System.out.println("The smallest area is: " + min);
        
        Random myRandomGenerator = new Random(9 * 24 * 1999);
    
        int[] arr;
        arr = new int[2000];
        
        for (int i = 0; i < 2000 ; i++){
            arr[i] = myRandomGenerator.nextInt(26) + 65;
        }
        
        int maxR = arr[0];
        int minR = arr[0];
        double sum = arr[0];
        for (int i = 1; i < 2000 ; i++){
            if(maxR < arr[i]){ maxR = arr[i];}
            if(minR > arr[i]){minR = arr[i];}
            sum =+ arr[i];
        }
        System.out.println("Max: " + maxR + "\nMin: " + minR + "\nAverage: " + sum / 2000.0);
        
        
        int stringLength = myRandomGenerator.nextInt(100) + 1;
        
        byte myBytes[] = new byte[stringLength];
        
        for (int i = 0; i < myBytes.length; i++){
            myBytes[i] = (byte) (myRandomGenerator.nextInt(26) + 65);
        }
        
        String s1 = new String(myBytes);
        System.out.println(s1);
        System.out.println(s1.toLowerCase());
        
        Date today = new Date();
        
        System.out.println(today);
        
        
        
    
    
    
    }
    
  

    
}
    
    
