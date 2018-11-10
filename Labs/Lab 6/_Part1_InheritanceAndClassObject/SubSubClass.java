package _Part1_InheritanceAndClassObject;

import java.net.URL;

public class SubSubClass extends SubClass{

	private int c;
	private URL cOther;
	
	public SubSubClass(int a, int b, int c, String str, Integer bWrapper, URL cOther) {
		super(a,b, str, bWrapper);
		this.c = c;	
		this.cOther = cOther;
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
		return super.toString() + " / c = " + c + " " + cOther.toString();
	}

	public boolean eqauls(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		SubSubClass c = (SubSubClass) o;
		if(super.equals(c) && this.c == c.c && c.cOther.equals(c.cOther)) return true;
		return false;
	}
}
