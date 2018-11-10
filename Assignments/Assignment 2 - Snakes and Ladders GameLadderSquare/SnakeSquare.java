/**
 * Models a Snake Square in a game of Snakes and Ladders
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class SnakeSquare extends SorLSquare {
	
	/**
	 * @param number The square on the board
	 * @param endSquare The end square on the board
	 */
	public SnakeSquare(int number, int endSquare) {
		super(number, endSquare);
		if(getNumber() < getEndSquare())
			throw new IllegalArgumentException ("endSquare cannot be greater than the square itself");
	}
	
	/**
	 *  Returns the square the player will land on, which is also the endSquare
	 *  @return endSqaure
	 */
	@Override
	public int landOn() {
		System.out.println("Oh no!"); //The player has landed on a snake :(
		return super.landOn();
	}
	
	/**
	 * @return String representation of the square
	 */
	@Override
	public String toString() {
		String s = "";
		return s + getNumber() + "-" + getEndSquare();
	}
}

