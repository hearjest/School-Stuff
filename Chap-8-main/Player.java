import java.util.*;
public class Player
{
    private String name;
    private String symbol;
    Queue rowPosition=new LinkedList<Integer>();
    Queue colPosition=new LinkedList<Integer>();
    //Two queues for which row and column?
    public Player(String name,String symbol)
    {
        this.name=name;
        this.symbol=symbol;
    }
    
    public int getNumOnBoard(){
        return this.rowPosition.size();
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public void addPosition(int row,int col){
        rowPosition.add(row);
        colPosition.add(col);
    }
    
    public int rowPlace(){
        return (int)rowPosition.peek();
    }
    
    public int colPlace(){
        return (int)colPosition.peek();
    }
    
    public int removeOldestRow(){
        return (int)rowPosition.remove();
    }
    
    public int removeOldestCol(){
        return (int)colPosition.remove();
    }
    
    public int getLowestRow(){
        int max=0;
        for(int i=0;i<rowPosition.size();i++){
            if(max<(int)rowPosition.peek()){
                max=(int)rowPosition.peek();
            }
            rowPosition.add(rowPosition.remove());
        }
        return max;
    }
    
    public int getHighestRow(){
        int min=(int)rowPosition.peek();
        for(int i=0;i<rowPosition.size();i++){
            if(min>(int)rowPosition.peek()){
                min=(int)rowPosition.peek();
            }
            rowPosition.add(rowPosition.remove());
        }
        return min;
    }
    
    public int getLeftmostCol(){
        int min=(int)colPosition.peek();
        for(int i=0;i<colPosition.size();i++){
            if(min>(int)colPosition.peek()){
                min=(int)colPosition.peek();
            }
            colPosition.add(colPosition.remove());
        }
        return min;
    }
    
    public String toString(){
        return "Name: " + name +"\nSymbol: " + symbol;
    }
    
    

    
}
