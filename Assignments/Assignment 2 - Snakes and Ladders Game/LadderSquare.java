/**
 * Models a Ladder Square in a game of Snakes and Ladders
 * @author emmaboulay
 * @version 1.0
 */
public class LadderSquare extends SorLSquare {
	
	/**
	 * @param number The square on the board
	 * @param endSquare The end square on the board
	 */
	public LadderSquare(int number, int endSquare) {
		super(number, endSquare);
		if(getNumber() > getEndSquare())
			throw new IllegalArgumentException ("endSquare cannot be less than the square itself");
	}
	
	/**
	 *  Returns the square the player will land on, which is also the endSquare
	 *  @return endSqaure
	 */
	@Override
	public int landOn() {
		System.out.println("Super!"); //The player has landed on a ladder :)
		return super.landOn();
	}
	
	/**
	 * @return String representation of the square
	 */
	@Override
	public String toString() {
		String s = "";
		return s + getNumber() + "+" + getEndSquare();
	}
}
		
		/* Why equals() method is NOT necessary for the LadderSquare and SnakeSquare Class:
		
		1. The constructor for LadderSquare throws an IllegalArgumentException when number > endSqaure
		   and the opposite Exception is thrown for SnakeSquare. So it is not possible for instances of SnakeSquare 
		   and LadderSquare to have the same variables. Even if there was no exception they don't share the same class
		   so the super class's equals method would return false
		   
		2. Even though comparing instances of SnakeSquares and LadderSquares is futile. When the two subclasses inherits its Super class's 
		   (SorLSquare) equals() method to compare instances of SnakeSquare (or LadderSquare) and SorLSquare with the
		   same instance variables it will return false since they don't share the same class --> if(getClass() != o.getClass()) return false;
		   However, if we comment out checking if they belong to the same class this returns true:
		   				
		   						SnakeSquare s1 = new SnakeSquare (2, 1);
								SorLSquare s2 = new SorLSquare(2, 1);
								System.out.println(s1.equals(s2));
		   
		3. Comparing instances of SnakeSquare (or LadderSquare) and SorLSquare with the same 'number' instance variable returns false for the same
		   reasons as SorLSquare (not the same class!)
		   
		4. What about when we want to compare two instances of SnakeSquare (or LadderSquare) with the same instance variables. Since the SnakeSquare class
		   does not have its own equals() method, the method from its superclass (SorLSquare) is used. The following lines of code below return true:
		   						
		   						SnakeSquare s1 = new SnakeSquare (2, 1);
								SnakeSquare s2 = new SnakeSquare (2, 1); 
								System.out.println(s1.equals(s2));     // prints true
								
		   And when the instance variables are not the same it returns false (as to be expected)
		   
		   						SnakeSquare s1 = new SnakeSquare (2, 1);
								SnakeSquare s2 = new SnakeSquare (3, 1);
								System.out.println(s1.equals(s2));     // prints false
								
			The results are the same when the tests are repeated with the LadderSquare class
			
		** For these reasons I believe that the equals() method for the LadderSquare and SnakeSquare class is not necessary since all cases are covered
		   with the super class's (SorLSquare) equals() method as demonstrated above.
			
	}*/
	
	
	
