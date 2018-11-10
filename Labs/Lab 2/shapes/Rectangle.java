package shapes;

public class Rectangle {
    
    private double length;
    private double width;
    
    public Rectangle(double length, double width){
        if (length <= 0.0 || width <= 0.0)
           throw new IllegalArgumentException ("Shape's dimensions must be positive values");
        this.length = length;
        this.width = width;
    }
    
    public double getLength() { return this.length; }
    public double getWidth()  { return this.width; }
    public double perimeter() { return (2*this.length) + (2* this.width); }
    public double area() { return this.length * this.width; }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Rectangle r = (Rectangle)other;
        return ((Math.abs(length - r.length)< 0.001) && 
                (Math.abs(width-r.width)< 0.001));
    } 
    
    @Override
    public String toString() { 
        return "l=" + this.length + " x w=" + this.width;
    }

}