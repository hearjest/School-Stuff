public class Rectangle_CLIENT
{
    
    public static void main()
    {
    Rectangle r1, r2;
    Point p1, p2;
        
        System.out.println(">>>>>>>>>>>>> r1 <<<<<<<<<<<<");
        r1 = new Rectangle(3,15,5,9);       
        System.out.println("r1.getHeight() = " + r1.getHeight());
        System.out.println("r1.getWidth() = " + r1.getWidth());        
        System.out.println("r1.getX() = " + r1.getX());
        System.out.println("r1.getY() = " + r1.getY());        
        System.out.println("r1.toString() = " + r1.toString());

        System.out.println("\n");
        System.out.println(">>>>>>>>>>>>> r2 <<<<<<<<<<<<");
        r2 = new Rectangle(new Point(5,5),7,3);        
        System.out.println("r2.getHeight() = " + r2.getHeight());
        System.out.println("r2.getWidth() = " + r2.getWidth());        
        System.out.println("r2.getX() = " + r2.getX());
        System.out.println("r2.getY() = " + r2.getY());        
        System.out.println("r2 = " + r2);
         
        System.out.println("\n");
        System.out.println(">>>>>>>>>>>>> contains <<<<<<<<<<<<");
        System.out.println("r1.contains(5,10) = " + r1.contains(5,10));
        System.out.println("r1.contains(new Point(7,7)) = " + r1.contains(new Point(7,7)));
        System.out.println("r1.contains(5,3) = " + r1.contains(5,3));
        System.out.println("r1.contains(new Point(7,2)) = " + r1.contains(new Point(7,2)));
        
        System.out.println("\n");
        System.out.println(">>>>>>>>>>>>> union <<<<<<<<<<<<");        
        Rectangle r3 = r1.union(r2);
        System.out.println("r1.union(r2): \n" + r3);
        
        System.out.println("\n");
        System.out.println(">>>>>>>>>>>>> intersection <<<<<<<<<<<<");   
        System.out.println("r1.intersection(r2) = " + r1.intersection(r2));
        System.out.println("r1.intersection(new Rectangle(10,17,14,4)) = " + r1.intersection(new Rectangle(10,17,14,4)));        
        
        
    }  // main
   
}  // Rectangle_CLIENT
