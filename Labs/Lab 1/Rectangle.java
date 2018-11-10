package lab1;

/**
 * 
 * @title Rectangle for Lab 1
 */
public class Rectangle {
    
    private int length;
    private int width;
    
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    
    public int getLength() { return this.length; }
    public int getWidth()  { return this.width; }
    public int perimeter() { return (2*this.length) + (2* this.width); }
    public int area() { return this.length * this.width; }
    
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Rectangle r = (Rectangle)other;
        return (length == r.length && width == r.width);
    }

}
