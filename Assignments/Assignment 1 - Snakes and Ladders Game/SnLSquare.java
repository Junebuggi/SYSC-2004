/**
 * Models a square in the game of Snakes and Ladders
 * 
 * @author EmmaBoulay
 * @version 1.0
 */
public class SnLSquare {
	
	private int number;
	
	/**
	 * @param number The position of the square on the board
	 */
	public SnLSquare(int number) {
		this.number = number;
	}
	
	/**
	 * @return The number of the square on the board
	 */
	public int getNumber(){
		return this.number;	
	}
	
	/**
	 * @return The square the player lands on 
	 */
	public int landOn() {
		return this.number;
	}
	
	/**
	 * Overrides toString() in Object 
	 * @return A String representation of the square
	 */
	@Override
	public String toString() {
		String s = "";
		return s + this.number;
	}
	
	/**
	 * Overrides equals() to compare two SnLSquare objects
	 * @param o The object we want to compare with
	 * @return True if the object o is equivalent to this SnLSquare object
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) return true; // they point to the same object
		if(o == null) return false; // o is a null pointer
		if(getClass() != o.getClass()) return false;
		SnLSquare s = (SnLSquare) o; 
		if(s.getNumber() == this.number) return true;
		return false;			
	}
}
