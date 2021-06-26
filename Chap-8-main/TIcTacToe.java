import java.util.*;
public class TIcTacToe
{
   
    public TIcTacToe()
    {
        Scanner console=new Scanner(System.in);
        System.out.print("Row number?: ");
        int row=console.nextInt();
        System.out.print("Column number?: ");
        int col=console.nextInt();
        System.out.print("Number in a row to win?: ");
        int numInRow=console.nextInt();
        System.out.print("Max number of pieces on the board per player?: ");
        int maxPieces=console.nextInt();
        System.out.print("Number of players?: ");
        int players=console.nextInt();
        Board table=new Board(row,col,numInRow,maxPieces,players);
        
    }

    
}
