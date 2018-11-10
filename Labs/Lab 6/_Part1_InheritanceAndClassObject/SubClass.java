package _Part1_InheritanceAndClassObject;

public class SubClass extends MyClass {
	private int b;
	private Integer bWrapper;

	public SubClass(int a, int b, String str, Integer bWrapper) {
		super(a, str);
		this.b = b;
		this.bWrapper = bWrapper;
		
	}
	public int getB() {
		return this.b;
	}
	
	public int getA() {
		return 2 * super.getA();
	}
	
	public String toString() {
		return super.toString() + " / b = " + b + " " + bWrapper.toString();
	}
	
	public boolean eqauls(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		SubClass c = (SubClass) o;
		if(super.equals(c) && this.b == c.b && bWrapper.equals(c.bWrapper)) return true;
		return false;
	}
}
