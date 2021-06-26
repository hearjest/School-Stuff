import java.util.Scanner;
public class MemoryMatch
{

    public MemoryMatch()
    {
        final int NUM_PAIRS = 4;
        final int NUM_PLAYERS=2;
        int board[] = new int[NUM_PAIRS*2+1];  // ignore the ZERO element spot
        boolean printElement[] = new boolean[NUM_PAIRS*2+1];  // defaulted all to 'false'
        int temp, position1=0, position2=0,i;
        // fill board will fill with [1,1,2,2,3,3,4,4]
        int k=1;
        for (i=1; i<=NUM_PAIRS*2; i+=2)
        {
            board[i] = k;
            board[i+1] = k; 
            k++;
        }
        // shuffle the board 1000 times
        for (i=1; i<=1000; i++)
        {   // pick 2 random positions to swap
            position1 = (int) (Math.random() * (board.length-1) + 1);
            position2 = (int) (Math.random() * (board.length-1) + 1);   

            temp = board[position1];
            board[position1] = board[position2];
            board[position2] = temp;
        }
        // System.out.print("SHUFFLED:");         
        for (i=1; i<board.length; i++)
        {
            System.out.print(board[i] + "  " );
        }
        // Print out 'board' via 'printElement'
        /*for (i=1; i<board.length; i++)
        {
        if (printElement[i]==true)  // || i==guess1 || i==guess2)
        System.out.print(board[i] +  "  ");
        else
        System.out.print(" * ");
        }*/
        
        //Work Begins HERE
        int name1Score=0,name2Score=0;
        boolean matchStreak=true;
        Scanner console=new Scanner(System.in);
        String names[]=new String[NUM_PLAYERS];
        int scores[]=new int[NUM_PLAYERS];
        System.out.println();
        for(int j=1;j<=NUM_PLAYERS;j++){
            System.out.print("What is player#" + j+"'s name?: ");
            names[j-1]=console.nextLine();
        }

        System.out.println("\nLet's begin the game!\n");
        while(!checkWin(scores,NUM_PAIRS)){
            for(k=0;k<names.length;k++){
                System.out.println();
                boolean match=game(board,printElement,names,scores,console,names[k]);
                
                if(match){ 
                    scores[k]++;
                    matchStreak=true;
                    System.out.println("\n" +names[k]+" gets to match again\n");
                    while(matchStreak){
                        matchStreak=game(board,printElement,names,scores,console,names[k]);
                        if(matchStreak){
                            scores[k]++;
                        }

                        if(checkWin(scores,NUM_PAIRS)){
                            System.out.println("\nGame End");
                            matchStreak=false;
                        }else if(matchStreak){
                            System.out.println("\nMatch! You get to go again!\n");
                        }
                    }

                }else{
                    System.out.println("No match!");
                }
                if(checkWin(scores,NUM_PAIRS)){
                    break;
                }
                System.out.println("\nNext player's turn!\n");
            } 
        }
        int highestScore=0;
        String winners="";
        int countTies=0;
        for(k=0;k<names.length;k++){
            System.out.println("Player "+ (k+1) + " : " + names[k] + "\t"+"Score: " + scores[k]);
            if(highestScore<scores[k]){
                highestScore=scores[k];
            }
        }
        for(k=0;k<names.length;k++){
            if(scores[k]==highestScore){
                winners+=names[k]+" ";
                countTies++;
            }
        }
        if(countTies>1){
            System.out.println("There's a tie between: " + winners);
        }else{
             System.out.println("Victory belongs to: " +winners);
        }
    }

    public static boolean checkWin(int scores[],int maxScore){
        int sum=0;
        for(int n:scores){
            sum+=n;
        }
        return sum==maxScore;
    }

    public static boolean game(int board[],boolean printElement[],String names[],int scores[],Scanner console,String name){
        int turn=1;
        int position1=0;
        int position2=0;
        printBoardAndChoice(board,printElement,names,scores);

        while(turn<3){
            
            System.out.print(name + ", what is choice#"+turn+"?: ");
            if(turn==1){
                position1=console.nextInt();
                while(printElement[position1]){
                    System.out.println("Not valid, enter again: ");
                    position1=console.nextInt();
                }
                printElement[position1]=true;
            }else{
                position2=console.nextInt();
                while(position2==position1||printElement[position2]){
                    System.out.println("Not valid, enter again: ");
                    position2=console.nextInt();
                }
                printElement[position2]=true;
            }
            System.out.println("\n_______________________________________");
            turn++; 
            printBoardAndChoice(board,printElement,names,scores);
        } 
        if(board[position1]!=board[position2]){
            printElement[position1]=false;
            printElement[position2]=false;
        }
        return board[position1]==board[position2];
    }

    public static void printBoardAndChoice(int board[],boolean printElement[],String names[], int scores[]){
        for(int i=0;i<names.length;i++){
            System.out.println("Player "+ (i+1) + " : " + names[i] + "\t Score: " + scores[i]);
        }

        for (int i=1; i<board.length; i++)//Print Board
        {
            System.out.print(i + "  " );
        }  
        System.out.println();
        for (int i=1; i<board.length; i++)//Print Matches
        {
            if (printElement[i]==true){  // || i==guess1 || i==guess2)
                System.out.print(board[i]+"  ");
            }else{
                System.out.print("*  "); 
            }
        }
        System.out.println();
    }

}

