public class PointMain_CLIENT
{
    public static void main()
    {
        // A program that deals with points. 
        // First version, to accompany Point class with state only. 
        // create two Point objects.
        // Pg 523:
       // Point p1 = new Point(); 
       // p1.x = 7; 
       // p1.y = 2; 
   Point p1 = new Point(-7,2); 

      //  Point p2 = new Point(); 
        //p2.x = 4; 
        //p2.y = 3; 
        Point p2 = new Point(4,3);     

        // print out each point's values - 
        //   NOTE:  This compiles/works ONLY when x & y are declared PUBLIC!
        System.out.println("Each Point's values:");
        System.out.println("p1.x = " + p1.getX() + "   p1.y = " + p1.getY());
        System.out.println("p2.x = " + p2.getX() + "   p2.y = " + p2.getY());  
        System.out.println();    

        // print out each point's hexadecimal memory address/address
        // of where it is located in RAM (random access memory)
        System.out.println("Each Point's hexadecimal memory address:");
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);    
        System.out.println();

        p1.translate(1,1);
        p2.translate(-1,-1);
        System.out.println("Each Point's values:");
        System.out.println("p1.x = " + p1.getX() + "   p1.y = " + p1.getY());
        System.out.println("p2.x = " + p2.getX() + "   p2.y = " + p2.getY());  
        System.out.println(); 

        System.out.println("P1 distance from origin = " + p1.distanceFromOrigin() );
        System.out.println("P2 distance from origin = " + p2.distanceFromOrigin() );        

        System.out.println("\n");
        System.out.println("p1.toString() = " + p1.toString());
        System.out.println("p2.toString() = " + p2.toString());    
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);          

        // Pg 566 Exercise #1: Tell what Quadrant the points are in.
        System.out.println("\n");    
        System.out.println("p1 lies in Quadrant " + p1.quadrant());
        System.out.println("p2 lies in Quadrant " + p2.quadrant());

        // Pg 566 Exercise #2: Flip the X and Y coordinates in each point.
        p1.flip();
        p2.flip();
        // Output the results
        System.out.println("\n");    
        System.out.println("p1 FLIPED = " + p1);
        System.out.println("p2 FLIPED = " + p2);        

               
        // Pg 526: translate each point to a new location 
        p1.translate(11,6);
        p2.translate(1,7);
        // print the points again
        System.out.println("p1 after translate(11,6) = " + "(" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("p2 after translate(1,7) = " + "(" + p2.getX() + ", " + p2.getY() + ")");

        // Pg 530: print each point and its distance from the origin
        System.out.println("p1 = " + p1);
        System.out.println("Distance from origin = " + p1.distanceFromOrigin());
        System.out.println("p2 = " + p2);
        System.out.println("Distance from origin = " + p2.distanceFromOrigin());
        System.out.println();

        // Pg 531: Printing out the Points via our "USER Defined" toString() method    
        System.out.println("p1 = " + p1.toString());
        System.out.println("p2 = " + p2);    

        // Pg 543 continued:
        // print each point and its distance from the origin 
        System.out.println("p1 is (" + p1.getX() + ", " + p1.getY() + ")"); 
        double dist1 = Math.sqrt(p1.getX() * p1.getX() + p1.getY() * p1.getY()); 
        System.out.println("distance from origin = " + dist1);      
        System.out.println("p2 is (" + p2.getX() + ", " + p2.getY() + ")"); 
        double dist2 = Math.sqrt(p2.getX() * p2.getX() + p2.getY() * p2.getY()); 
        System.out.println("distance from origin = " + dist2); 
        System.out.println();         

        // Pg 566 Exercise #1: Tell what Quadrant the points are in.
        System.out.println("\n");    
        System.out.println("p1 lies in Quadrant " + p1.quadrant());
        System.out.println("p2 lies in Quadrant " + p2.quadrant());

        // Pg 566 Exercise #2: Flip the X and Y coordinates in each point.
        p1.flip();
        p2.flip();
        // Output the results
        System.out.println("\n");    
        System.out.println("p1 FLIPED = " + p1);
        System.out.println("p2 FLIPED = " + p2);

        // Pg 566 Exercise #3: MahattanDistance
        System.out.println("Pg 566 Exercise #3: MahattanDistance \n");
        System.out.println("The Manhattan Distance between " + p1
            + " and " + p2 + " = " + p1.manhattanDistance(p2));

        // Pg 566 Exercise #4: isVerticle
        System.out.println("Pg 566 Exercise #4: isVerticle \n");
        System.out.println(" p1.isVerticle(p2): " + p1
            + " and " + p2 + " = " + p1.isVertical(p2));        

        // Pg 566 Exercise #5: slope
        System.out.println("Pg Exercise #5: slope \n");
        System.out.println(" p1.slope(p2): " + p1
            + " and " + p2 + " = " + p1.slope(p2));               

        // Pg 566 Exercise #6: isCollinear
        p1.setX(1);
        p1.setY(1);
        p2.setX(5);
        p2.setY(5);  
        Point p3 = new Point();
        p3.setX(10);
        p3.setY(10);        
        System.out.println("Pg Exercise #6: isCollinear\n");
        System.out.println(" p1.isCollinear(p2,p3): " + p1
            + " and " + p2 + " and " + p3 + " = " + p1.isCollinear(p2,p3)); 

        // Pg 565 Self Check #10: distance
        System.out.println("Pg 565 Self Check #10: distance \n");
        System.out.println(" p1.distance(p2): " + p1
            + " and " + p2 + " = " + p1.distance(p2));         


    }  // main
}  // PointMain_CLIENT
