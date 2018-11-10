package lab4Part2;

public class SubSubClass extends SubClass{

	private int c;
	
	public SubSubClass(int a, int b, int c) {
		super(a,b);
		this.c = c;	
	}
	
	public int getC() {
		return this.c;
	}
	
	public int getA() {
		return super.getA() * this.c;
	}
	
	public int getB() {
		return super.getB() * this.c;
	}
	
	public String toString() {
		return super.toString() + " c = " + c;
	}
}
