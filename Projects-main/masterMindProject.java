import java.util.*;
public class masterMindProject
{

    public masterMindProject()
    {
        Scanner console=new Scanner(System.in);
        System.out.println("Welcome to MasterMind. You have ten guesses");
        System.out.println("There are 6 colors to guess");
        System.out.println("The combo is made of any of the four colors");
        System.out.println("The combo may contain duplicate colors");
        System.out.println("K=Black,B=Blue,Y=Yellow,W=White,R=Red,G=Green");
        game(console);                    
    }

    public static String[] generateCombo(){
        Random r=new Random();
        String[] ComboArray=new String[4];
        for(int i=0;i<4;i++){
            int ran=r.nextInt(6)+1;
            if(ran==1){
                ComboArray[i]="K";
            }else if(ran==2){
                ComboArray[i]="B";
            }else if(ran==3){
                ComboArray[i]="Y";
            }else if(ran==4){
                ComboArray[i]="W";
            }else if(ran==5){
                ComboArray[i]="R";
            }else if(ran==6){
                ComboArray[i]="G";
            }
        }

        return ComboArray;
    }

    public static void game(Scanner console){
        boolean victory=false;
        int k=1;
        String[] AnswerArray=generateCombo();
        
        System.out.println(Arrays.toString(AnswerArray));
        
        System.out.println("\n   Guess Array \t XO Array");

        while(k!=11&&!victory){
            System.out.print((k+".)" + " "));
            String[] Guesses=new String[4];
            for(int i=0;i<4;i++){
                String next=console.next();
                Guesses[i]=next;
            }
            System.out.print("\t\t  ");
            victory=checkColors(AnswerArray,Guesses);
            if(victory){
                System.out.println("Congrats you won! It took you " + k +" tries!");
            }else if(k==10){
                System.out.println();
                System.out.println("Sorry, you lost, the code was " 
                    + Arrays.toString(AnswerArray));
                k++;
            }else{
                k++;
            }
        }
    }

    public static boolean checkColors(String[] answer,String[] guess){
        int xCount=1;
        int oCount=1;
        String[] copyAnswer=Arrays.copyOf(answer,4);
        for(int i=0;i<guess.length;i++){
            guess[i]=guess[i].toUpperCase();
        }

        if(Arrays.equals(copyAnswer,guess)){
            return true;
        }

        for(int i=0;i<copyAnswer.length;i++){
            if(copyAnswer[i].equalsIgnoreCase(guess[i])){
                xCount++;
                copyAnswer[i]="no";
                guess[i]="on";
            }
        }
        Arrays.sort(guess);
        for(int i=0;i<guess.length-1;i++){
            if(guess[i].equalsIgnoreCase(guess[i+1])){
                guess[i]="whatever";
            }
        }

        for(int i=0;i<copyAnswer.length;i++){
            for(int j=0;j<copyAnswer.length;j++){
                if(copyAnswer[i].equalsIgnoreCase(guess[j])){
                    oCount++;
                }
            }
        }

        for(int i=1;i<xCount;i++){
            System.out.print("X");
        }
        for(int i=1;i<oCount;i++){
            System.out.print("O");
        }
        System.out.println();
        return false;
    }
}

