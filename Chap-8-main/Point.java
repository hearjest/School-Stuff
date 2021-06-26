
public class Point
{
    private int x;
    private int y;
    public Point()
    {
        this(0,0);
    }
    // -------------------------------------------------------------------------------------
    public Point(int x, int y){
        setLocation(x,y);
    }
    // -------------------------------------------------------------------------------------
    public int getX(){
        return this.x;
    }
    // -------------------------------------------------------------------------------------
    public int getY(){
        return this.y;
    }
    // -------------------------------------------------------------------------------------
    public void setX(int x){
        this.x=x;
    }
    // -------------------------------------------------------------------------------------
    public void setY(int y){
        this.y=y;
    }
    // -------------------------------------------------------------------------------------
    public int quadrant(){
        if(this.x>0&&this.y>0){
            return 1;
        }else if(this.x<0&&this.y>0){
            return 2;
        }else if(this.x<0&&this.y<0){
            return 3;
        }else{
            return 4;
        }
    }
    // -------------------------------------------------------------------------------------
    public void flip(){
        int reference=this.x;
        this.x=this.y*-1;
        this.y=reference*-1;
    }
    // -------------------------------------------------------------------------------------
    public int manhattanDistance(Point other){
        int diffInX=Math.abs(this.x-other.getX());
        int diffInY=Math.abs(this.y-other.getY());
        return diffInX + diffInY;
    }
    // -------------------------------------------------------------------------------------
    public boolean isVertical(Point other){
        if(this.x==other.getX()){
            return true;
        }else{
            return false;
        }
    }
    // -------------------------------------------------------------------------------------
    public double slope(Point other){
        if(this.x==other.getX()){
            throw new IllegalArgumentException("X values can't be the same");
        }
        return ((this.y-other.getY())/(this.x-other.getX()));
    }
    // -------------------------------------------------------------------------------------
    public double slope(Point p1, Point p2){
        if(p1.getX()==p2.getX()){
            throw new IllegalArgumentException("X values can't be the same");
        }
        return ((p1.getY()-p2.getY())/(p1.getX()-p2.getX()));
    }
    // -------------------------------------------------------------------------------------
    public boolean isCollinear(Point p2, Point p3){
        double slope1=slope(p2);
        slope1=(((int)(slope1*1000))/1000.0);
        double slope2=slope(p2,p3);
        slope2=(((int)(slope2*1000))/1000.0);
        System.out.println(slope1 + " | " +slope2);
        if(slope1==slope2){
            System.out.print("True");
            return true;
        }
        System.out.print("False");
        return false;
    }
    // -------------------------------------------------------------------------------------
    public double distance(Point other){
        return Math.sqrt(Math.pow((other.getX()-this.x),2)+Math.pow((other.getY()-this.y),2));
    }
    // -------------------------------------------------------------------------------------
    public void translate(int x, int y){
        //this.x+=x;
        //this.y+=y;
        setLocation(getX()+x,getY()+y);
    }
    // -------------------------------------------------------------------------------------
    public double distanceFromOrigin(){ 
        return Math.sqrt(x * x + y * y); 
    }
    // -------------------------------------------------------------------------------------
    public String toString(){
        return "( "+this.x+" , "+this.y+" )";
    }
    
    public void setLocation(int x,int y){
        setX(x);
        setY(y);
    }
    // -------------------------------------------------------------------------------------
}
