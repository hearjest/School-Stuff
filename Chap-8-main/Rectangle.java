import java.util.*;
public class Rectangle{
    Point topLeft=new Point(0,0);
    int width;
    int height;
    public Rectangle(int x, int y, int width, int height){
        if(width<0||height<0){
            throw new IllegalArgumentException();
        }
        topLeft.setX(x);
        topLeft.setY(y);
        this.width=width;
        this.height=height; 
    } 

    public Rectangle(Point p, int width, int height){
        topLeft.setX(p.getX());
        topLeft.setY(p.getY());
        this.width=width;
        this.height=height;
    }

    public Rectangle intersection(Rectangle other){
        //Check if rect1 and rect2 intersect, else return rectangle with width and height 0
        //Check if either of the rectangles are FULLY contained in one other, return smaller rect if so
        //Check if they intersect, return rectangle made by both rectangles
        int newX,newY,newWidth,newHeight;

        if(topLeft.getX()+width<other.getX()||topLeft.getX()+width>other.getX()+other.getWidth()||
        topLeft.getY()-height>other.getY()||topLeft.getY()<other.getY()-other.getHeight()){
            newX=0; 
            newY=0; 
            newWidth=0;
            newHeight=0;
        }else{
            newX=Math.max(topLeft.getX(),other.getX());
            newWidth=Math.min(topLeft.getX()+width,other.getX()+other.getWidth())-newX;
            newY=Math.min(topLeft.getY(),other.getY());
            newHeight=newY-Math.max(topLeft.getY()-height,other.getY()-other.getHeight());
        }

        return new Rectangle(newX,newY,newWidth,newHeight);//CHANGE
    }

    public Rectangle union(Rectangle other){
        int newX=Math.min(topLeft.getX(),other.getX());//Calculate topLeft
        int newY=Math.min(topLeft.getY(),other.getY());//^^^^^^^^^^^^^^^^^

        int newWidth=Math.abs(Math.abs(newX)-Math.abs(Math.max(topLeft.getX()+this.width,other.getX()+other.getWidth())));
        int newHeight=Math.abs(Math.abs(newY)-Math.abs(Math.max(topLeft.getY()+this.height,other.getY()+other.getHeight())));
        System.out.println(newX+"\n"+newY+"\n"+newWidth+"\n"+newHeight);
        return new Rectangle(newX,newY,newWidth,newHeight);
    }

    public boolean contains(int x, int y){
        if(x>=topLeft.getX()&&x<=topLeft.getX()+width){
            if(y<=topLeft.getY()&&y>=topLeft.getY()-height){
                return true;
            }
        }
        return false;
    }

    public boolean contains(Point p){
        return this.contains(p.getX(),p.getY());
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getX(){
        return topLeft.getX();
    }

    public int getY(){
        return topLeft.getY();
    }

    public String toString(){
        return ("Rectangle[x=" + topLeft.getX() + ", y=" + topLeft.getY() +", width=" + width +", height=" +height +"]");
    }

    /*

    //Check if intersection
    if(topLeft.x<=other.getX()&&topLeft.x+width>=other.getX()||topLeft.x<=other.getX()+other.getWidth()&&topLeft.x+width>=other.getX()+other.getWidth()){
    if(topLeft.y>=other.getY()&&topLeft.y-height<=other.getY()){//Contains top left of other
    newY=other.getY();
    if(this.contains(other.getX(),other.getY()-other.getHeight())){//Contains entire other Y
    newX=other.getX(); 
    newHeight=other.getHeight();
    newWidth=Math.abs(topLeft.x)+width-Math.abs(newX);
    }else{//Only contains partial y
    newX=topLeft.x;
    newHeight=Math.abs(Math.abs(other.getY())-Math.abs(Math.abs(topLeft.y)-height));
    if(topLeft.x>=other.getX()){
    newWidth=topLeft.x;

    }else{
    newWidth=(Math.abs(other.getX())+other.getWidth())-topLeft.x;
    }
    }

    }else if(topLeft.y>=other.getY()-other.getHeight()&&topLeft.y-height<=other.getY()-other.getHeight()){

    }else if(topLeft.y<=other.getY()&&topLeft.y-height>=other.getY()||topLeft.y<=other.getY()-other.getHeight()&&topLeft.y-height>=other.getY()-other.getHeight()){

    }
    } 

    
    if(this.contains(other.getX(),other.getY())||this.contains(other.getX()+other.getWidth(),other.getY())|| 
    this.contains(other.getX(),other.getY()-other.getHeight())||
    this.contains(other.getX()+other.getWidth(),other.getY()-other.getHeight())){
    System.out.println("y");
    newX=Math.max(topLeft.x,other.getX());
    newWidth=Math.min(topLeft.x+width,other.getX()+other.getWidth())-newX;
    newY=Math.min(topLeft.y,other.getY());
    newHeight=newY-Math.max(topLeft.y-height,other.getY()-other.getHeight());
    }
     */
}
