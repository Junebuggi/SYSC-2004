package assignment1_Dice;

public class DiceClient {
    public static void main(String[] args){
        int one = 0,  two = 0, three = 0, four = 0, five = 0, six = 0;
        double avg, stdDev;
        Dice dice = new Dice();  //Constructs a pair of dice
        int sum = 0;
        double[] allRolls = new double[4000];  //Array of 4000 to store the value of each roll
        
        for(int i = 0; i < 2000; i++){
            sum += dice.roll();    //Sum of all rolls
            allRolls[i] = dice.getDieValues()[0];
            allRolls[3999 - i] = dice.getDieValues()[1];
            for(int j = 0; j < 2; j++){
                switch (dice.getDieValues()[j]) {
                    case 1:
                        ++one;
                        break;
                    case 2:
                        ++two;
                        break;
                    case 3:
                        ++three;
                        break;
                    case 4:
                        ++four;
                        break;
                    case 5:
                        ++five;
                        break;
                    case 6:
                        ++six;
                        break;
                    default:
                        break;
                }
            }
        }
        avg = sum / 4000.0;
        double sumDiffsSquared = 0.0;
        for(int i = 0; i < 4000; i++){
            sumDiffsSquared += Math.pow((allRolls[i] - avg), 2.0);
            
        }
        stdDev = Math.sqrt(sumDiffsSquared / 4000.0);
        String repeated = new String();
        
        System.out.println("The average roll was " + avg);
        System.out.println("The standard deviation of the rolls was " + stdDev);
        System.out.println("The histogram of the rolls is:");
        System.out.print("1(" + one + ") :");
        for(int i = 0; i < one/10; i++){repeated += "*";}
        System.out.println(repeated); repeated = "";
        System.out.print("2(" + two + ") :");
        for(int i = 0; i < two/10; i++){repeated += "*";}
        System.out.println(repeated); repeated = "";
        System.out.print("3(" + three + ") :");
        for(int i = 0; i < three/10; i++){repeated += "*";}
        System.out.println(repeated); repeated = "";
        System.out.print("4(" + four + ") :");
        for(int i = 0; i < four/10; i++){repeated += "*";}
        System.out.println(repeated); repeated = "";
        System.out.print("5(" + five + ") :");
        for(int i = 0; i < five/10; i++){repeated += "*";}
        System.out.println(repeated); repeated = "";
        System.out.print("6(" + six + ") :");
        for(int i = 0; i < six/10; i++){repeated += "*";}
        System.out.println(repeated);
    
    }
}

