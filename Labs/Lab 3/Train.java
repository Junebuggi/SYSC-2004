public class Train
{
    public static void main(String[] args)
    {
        Car cars[];
        
        int maximumNumberOfCars = 10;
        int currentNumberOfBusinessCars = 2;
        int currentNumberOfEconomyCars = 4;
        int currentNumberOfCars = currentNumberOfBusinessCars + currentNumberOfEconomyCars;

        if ((currentNumberOfBusinessCars + currentNumberOfEconomyCars)> maximumNumberOfCars) 
               throw new IllegalArgumentException("The train cannot have more cars than it can physically pull");
        
        // TBD
        // A train can only pull so many cars, as given by "maximumNumberOfCar".
        // Use this argument to initialize an array of the biggest number of cars possible.
        cars = new Car[maximumNumberOfCars];
        for(int i = 0; i < currentNumberOfCars; i++){
            if(i < currentNumberOfBusinessCars){cars[i] = new Car(1 + i, true);}
            else{cars[i] = new Car(1+ i, false);}
        }
        for(int i = 0; i < currentNumberOfCars; i++){
            System.out.println(cars[i].toString());
        }
            
        }
}

                
        // TBD
        // Then, add cars to this train, 
        // as per requested by "currentNumberOfBusinessCars" and "currentNumberOfEconomyCars
        

        // TBD: Print out the train
        
        

 
       

