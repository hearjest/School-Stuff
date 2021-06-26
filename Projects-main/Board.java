import java.util.*;
public class Board
{
    Scanner console=new Scanner(System.in);
    private int NUM_ROWS;
    private int NUM_COLS;
    private int NUM_IN_A_ROW;
    private int NUM_ON_BOARD;
    private int NUM_PLAYERS;
    private String field[][];
    private Player[] players;
    public Board(int NUM_ROWS,int NUM_COLS,int NUM_IN_A_ROW, int NUM_ON_BOARD,int NUM_PLAYERS)
    {
        this.NUM_ROWS=NUM_ROWS;
        this.NUM_COLS=NUM_COLS;
        this.NUM_IN_A_ROW=NUM_IN_A_ROW;
        this.NUM_ON_BOARD=NUM_ON_BOARD;
        this.NUM_PLAYERS=NUM_PLAYERS;
        field=new String[NUM_ROWS][NUM_COLS];
        players=new Player[NUM_PLAYERS];
        String name;
        String symbol;
        for(int i=0;i<NUM_PLAYERS;i++){
            System.out.print("This player's name?: ");
            name=console.next();
            System.out.print("This player's symbol?: ");
            symbol=console.next();
            players[i]=new Player(name,symbol);
        }
        System.out.println("\n\n");
        playGame();
    }

    /*
    To do list:
    - figure out how to check for wins
    - Finish the damn thing
     */

    private void playGame(){
        boolean somebodyHasNotWon=true;
        int row,col,curr=0;
        int winCount=0;
        while(somebodyHasNotWon){
            if(curr==players.length){
                curr=0;
            }
            if(NUM_ON_BOARD==players[curr].getNumOnBoard()){
                row=players[curr].removeOldestRow();
                col=players[curr].removeOldestCol();
                this.field[row][col]=null;
            }
            row=-1;
            col=-1;
            while(this.notValidPosition(row,col)){
                System.out.println(players[curr].toString());
                System.out.print("Please choose a row: ");
                row=console.nextInt();
                System.out.print("Please choose a column: ");
                col=console.nextInt();
            }
            players[curr].addPosition(row,col);

            field[row][col]=players[curr].getSymbol();
            if(players[curr].getNumOnBoard()>=NUM_IN_A_ROW){
                //Checking for horizontal win
                boolean test=true;
                for(int i=0;(i<field.length-1)&&test;i++){
                    if(field[row][i]==players[curr].getSymbol()){

                        winCount++; 
                        if(field[row][i+1]!=players[curr].getSymbol()){
                            test=false;
                        }
                        if(i+1==field[row].length-1&&field[row][i+1]==players[curr].getSymbol()){
                            winCount++;
                        }
                    }
                }
                if(winCount>=NUM_IN_A_ROW){
                    somebodyHasNotWon=false;

                }
                winCount=0;
                test=true;
                //Checking for vertical win

                for(int k=0;(k<field[row].length-1)&&test;k++){
                    if(field[k][col]==players[curr].getSymbol()){
                        winCount++;
                        if(field[k+1][col]!=players[curr].getSymbol()){
                            test=false;

                        }
                        if(k+1==field[row].length-1&&field[k+1][col]==players[curr].getSymbol()){
                            winCount++;
                        }
                    }
                }
                if(winCount>=NUM_IN_A_ROW){
                    somebodyHasNotWon=false;
                }
                winCount=0;
                //Checking for forward-diag win
                test=true;
                for(int i=players[curr].getLowestRow(),j=players[curr].getLeftmostCol();i>0&&test&&j<field[0].length;i--,j++){
                    if(field[i][j]==players[curr].getSymbol()){
                        winCount++;
                    }else{
                        test=false;
                    }

                }
                if(winCount>=NUM_IN_A_ROW){
                    somebodyHasNotWon=false;
                }
                winCount=0;
                test=true;
                //Checking for backward-diag win
                for(int i=players[curr].getHighestRow(),j=players[curr].getLeftmostCol();i<field.length&&j<field[0].length&&test;i++,j++){
                    if(field[i][j]==players[curr].getSymbol()){
                        winCount++;
                    }else{
                        test=false;
                    }
                }
                if(winCount>=NUM_IN_A_ROW){
                    somebodyHasNotWon=false;
                }
            }
            //Check win, but how? Recursion? 

            curr++;
            System.out.println(this.toString());
        }

        System.out.println(players[curr-1].toString()+"\n Victory!");
    }

    private boolean notValidPosition(int row, int col){
        return !((row>=0&&row<NUM_ROWS)&&(col>=0&&col<NUM_COLS)&&(field[row][col]==(null)));
    }

    public int getInARow(){
        return NUM_IN_A_ROW;
    }

    public int getOnBoard(){
        return NUM_ON_BOARD;
    }

    public String toString(){//Need to fix for when values on board
        String board="";
        String line="";
        String values="";
        for(int i=0;i<NUM_COLS;i++){
            line+=" ___ ";
        }
        for(int i=0;i<NUM_ROWS;i++){
            board+=line+"\n"+"|";
            for(int j=0;j<NUM_COLS;j++){
                if(field[i][j]==null){
                    values="   | ";
                }else{
                    values=" "+field[i][j]+" | ";
                }
                board+=values;
            }
            board+="\n";
        }
        board+=line;
        return board;
    }

}
