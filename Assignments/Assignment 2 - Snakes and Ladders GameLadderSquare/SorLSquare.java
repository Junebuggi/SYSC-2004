/**
 * Models a Snake or Ladder square in the game of Snakes and Ladders
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class SorLSquare extends SnLSquare {
	
	private int endSquare;
	
	/**
	 * @param number The square on the board
	 * @param endSquare The end square on the board
	 */
	public SorLSquare(int number, int endSquare) {
		super(number);
		if(number == endSquare)
			throw new IllegalArgumentException ("endSquare cannot be the same as the square itself");
		this.endSquare = endSquare;
	}
	
	/**
	 * @return The endSquare of the Snake or Ladder square
	 */
	public int getEndSquare() {
		return this.endSquare;
	}
	
	/** 
	 * Returns the square the player will land on, which is also the endSquare
	 *  @return endSqaure
	 */
	@Override
	public int landOn() {
		return this.endSquare;
	}
	
	/**
	 * Overrides toString() in the SnLSquare class
	 * @return String representation of the square
	 */
	@Override
	public String toString() {
		
		return super.toString() + ":" + this.endSquare;
	}
	
	/**
	 * Overrides equals() to compare two SorLSquare objects
	 * @param o The object we want to compare with
	 * @return True if the object o is equivalent to this SorLSquare object
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		SorLSquare s = (SorLSquare) o;
		if (!super.equals(s)) return false;
		if(this.endSquare == s.getEndSquare()) return true;
		return false;
	}
}
