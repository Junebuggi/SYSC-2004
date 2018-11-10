package _Part1_InheritanceAndClassObject;

public class MyClass {
	private int a;
	private String aString;
	
	public MyClass(int a, String str) {
		this.a = a;
		this.aString = str;
		
	}
	
	public int getA() {
		return this.a;
	}
	
	public String toString() {
		return "a = " + a + " " + aString;
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		MyClass myClass = (MyClass) o;
		if(this.a == myClass.a && this.aString.equals(myClass.aString)) return true;
		
		return false;
	}
}
