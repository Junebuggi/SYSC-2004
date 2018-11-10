package lab4Part2;

public class SubClass extends MyClass {
	private int b;

	public SubClass(int a, int b) {
		super(a);
		this.b = b;
	}
	public int getB() {
		return this.b;
	}
	
	
	public int getA() {
		return 2 * super.getA();
	}
	
	public String toString() {
		return super.toString() + " b = " + b;
	}

}
