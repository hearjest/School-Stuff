 


/**
 * Building Java Programs
 * 2nd Edition
 * Chapter 8
 * Line: Pg 569 Exercise #14-17   
 */

// Represents a line segment between two Points.
public class Line
{
 // >>>>>> Declare your 2 Points here <<<<<<<
    Point p1;
    Point p2;
    // -------------- CONSTRUCTORS ----------------------------
    // Default - NO argument constructor
    public Line()
    {
        p1=new Point();
        p2=new Point();
    }
    // FIRST way that constructs a new Line given the X and Y values.
    // Assign p1 and p2 here.
    public Line(int x1, int y1, int x2, int y2) 
    {
         p1=new Point(x1,y1);
         p2=new Point(x2,y2);
    }
    // SECOND way Constructs a new Line that contains the given two Points.
    public Line(Point p1, Point p2) 
    {
        this.p1=new Point(p1.getX(),p1.getY());
        this.p2=new Point(p2.getX(),p2.getY());
    }


    /*
    // SECOND way that constructs a new Line given the X and Y values.
    // Call Line(Point, Point) via the 'this' ptr.
    public Line(int x1, int y1, int x2, int y2) 
    {
        this(new Point(x1, y1), new Point(x2, y2));
    }
    */
    
    // --------------------- ACCESSOR Methods ----------------
    // Returns this Line's first endpoint.
    public Point getP1() 
    {
        return p1;
    }   
    // Returns this Line's second endpoint.
    public Point getP2()
    {       
        return p2;
    }
    
    // ------------------------- Helper Methods -------------------
    // Returns true if the given point is collinear with this Line.
    public boolean isCollinear(Point p) 
    {
        // basic case: all points have same x or y value
        // >>>>>>> YOUR CODE HERE <<<<<<<<
        if((this.p1.getX()==p.getX()&&this.p1.getX()==this.p2.getX()
        ||this.p1.getY()==p.getY()&&this.p1.getY()==this.p2.getY())){
            return true;
        }
    
        // complex case: compare slopes
        double slope1 = getSlope(p1,p);   
        double slope2 = getSlope(p2,p); 
      
         return (round(slope1, 4) == round(slope2, 4));

    }   
    public double getSlope()
    {
        return getSlope(p1,p2);
    }
    public double getSlope(Point p1, Point p2)
    {
       return ((double)p2.getY()-p1.getY())/((double)p2.getX()-p1.getX());
    }    
    // Rounds the given value to 4 digits after the decimal.
    public static double round(double value, int places) 
    {
        double pow10 = Math.pow(10, places);
        return Math.round(value * pow10) / pow10;
    }
    
    
    // ------------------------ TO STRING --------------------------
    // Returns a String representation of this Line, such as "[(-2, 3), (4, 7)]".
    public String toString() 
    {
         return "[ (" + p1.getX() + ", " + p1.getY() + "), (" + p2.getX() + ", " + p2.getY() + ") ]";
    }
} // Line
